package com.pfe.rechercheens.Auth.DTO;

import com.pfe.rechercheens.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private String messageResponse;
    private Role role;
    private String email;
}
