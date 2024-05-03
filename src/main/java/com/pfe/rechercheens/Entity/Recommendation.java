package com.pfe.rechercheens.Entity;

import com.pfe.rechercheens.Entity.Enumirator.Recommendation_Score;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;

    @NonNull
    private String recommandation;

    @Enumerated(EnumType.STRING)
    private Recommendation_Score recommendationScore;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Etudiant etudiant;

}
