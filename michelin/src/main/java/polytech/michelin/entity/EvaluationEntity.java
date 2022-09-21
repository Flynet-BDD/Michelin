package polytech.michelin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evaluation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationEntity 
{
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "evaluateur", columnDefinition = "varchar(50)")
    private String evaluateur;

    @Column(name = "commentaire", columnDefinition = "varchar(255)")
    private String commentaire;

    @Column(name = "note")
    private int note;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantEntity restaurant;
}
