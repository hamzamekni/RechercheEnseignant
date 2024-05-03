package com.pfe.rechercheens.Entity;

import com.pfe.rechercheens.Entity.Enumirator.Statut_Etude_Presentiel;
import com.pfe.rechercheens.Entity.Enumirator.Type_Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @NonNull
    private Float Montant_NonPaye;

    @Enumerated(EnumType.STRING)
    private Statut_Etude_Presentiel statut_etude_presentiel;

    @NonNull
    private String Detail_Etude_Presentiel;

    private int Numbero;

    @NonNull
    private String Detail_Enseigant;

    @ManyToOne
    private DemandeDeCour DemandeDeCour_Teacher;

    @OneToMany(mappedBy = "teacher")
    private List<Paiement> paiement;



}
