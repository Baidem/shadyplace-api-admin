package com.shadyplace.apiadmin.controllers;

import com.shadyplace.apiadmin.config.JwtTokenUtils;
import com.shadyplace.apiadmin.models.request.AuthRequest;
import com.shadyplace.apiadmin.models.responses.JwtResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin // debug angular
@RestController
@RequestMapping("/api/security")
@Tag(name = "Login to", description = "Get the token")
public class SecutityController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtils jwtTokenUtils;

    @PostMapping("/auth")
    public ResponseEntity<JwtResponse> authentication(@RequestBody AuthRequest authenticationRequest) throws Exception{
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtils.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("User Disabled", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
