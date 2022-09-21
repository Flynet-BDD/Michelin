package polytech.michelin.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant")
public class RestaurantEntity 
{
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom", columnDefinition = "varchar(90)")
    private String nom;

    @Column(name = "adresse", columnDefinition = "varchar(255)")
    private String adresse;

    //Une évaluation concerne un unique restaurant
    //Un restaurant possède plusieurs évaluations
    @OneToMany(mappedBy = "restaurant") 
    private List<EvaluationEntity> evaluations;
}
