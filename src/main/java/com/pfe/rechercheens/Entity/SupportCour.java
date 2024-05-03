package com.pfe.rechercheens.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportCour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supportCour_Id;
    @NonNull
    private String signe_cours;
    @NonNull
    private String type_cours;
    @ManyToOne
    private DemandeDeCour demandeDeCour;
}
