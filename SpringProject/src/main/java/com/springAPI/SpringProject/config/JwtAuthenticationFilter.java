package com.springAPI.SpringProject.config;

import com.springAPI.SpringProject.repository.UtilisateurRepository;
import com.springAPI.SpringProject.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final HandlerExceptionResolver handlerExceptionResolver;

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final UtilisateurRepository utilisateurRepository;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UserDetailsService userDetailsService,
            HandlerExceptionResolver handlerExceptionResolver,
            UtilisateurRepository utilisateurRepository
    ) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.handlerExceptionResolver = handlerExceptionResolver;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {


        final String authHeader = request.getHeader("Authorization");


        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            final String jwt = authHeader.substring(7);
            final String userName = jwtService.extractUsername(jwt);
            final Date issuedAt = jwtService.extractIssuedAt(jwt);

            System.out.println("Extracted Username: " + userName); // Debug
            System.out.println("Extracted issuedAt: " + issuedAt);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (userName != null && authentication == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);

                // Récupérer lastLogout depuis la base de données (exemple)

                Instant lastLogout = utilisateurRepository.findLastLogoutByUsername(userName);
                if (jwtService.isTokenValid(jwt, userDetails, lastLogout)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    System.out.println("Authentication successful for user: " + userName); // Debug
                }
                else {
                    System.out.println("Invalid token");
                }
            }

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            handlerExceptionResolver.resolveException(request, response, null, exception);
            System.out.println("Exception during filter: " + exception.getMessage()); // Debug
        }
    }
}
