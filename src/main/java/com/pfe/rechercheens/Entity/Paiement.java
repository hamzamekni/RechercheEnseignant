package com.pfe.rechercheens.Entity;

import com.pfe.rechercheens.Entity.Enumirator.Statut_Paiement;
import com.pfe.rechercheens.Entity.Enumirator.Type_Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paiementId;

    @NonNull
    private String Signe_Paiement;

    @NonNull
    private Float Montant_Paiement;

    @NonNull
    private LocalDateTime jour_Paiement = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Statut_Paiement statut_paiement;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Etudiant etudiant;

}
