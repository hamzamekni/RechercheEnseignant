package com.pfe.rechercheens.Entity;

import com.pfe.rechercheens.Entity.Enumirator.Statut_Demande;
import com.pfe.rechercheens.Entity.Enumirator.Type_Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemandeDeCour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long demandeDeCour_Id;
    @NonNull
    private String titre_demande;
    @NonNull
    private String detail_demande;
    @NonNull
    private String locale;
    @NonNull
    private Float prix_max;
    @NonNull
    private Float prix_min;

    @OneToOne
    private Adress adress;
    @Enumerated(EnumType.STRING)
    private Statut_Demande statutDemande;

}
