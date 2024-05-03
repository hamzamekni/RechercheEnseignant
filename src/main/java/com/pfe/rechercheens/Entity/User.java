package com.pfe.rechercheens.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @Email
    private String email;

    @NonNull
    private String password;

    private int phone;

    @ManyToOne
    private Role role;

    @OneToOne
    private Adress adress;

    private boolean enabled;
    private long resetToken;


}
