package polytech.michelin.dto;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import polytech.michelin.entity.EvaluationEntity;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EvaluationDto 
{
    @JsonProperty("id")
    private int id;

    @JsonProperty("evaluateur")
    @Size(max = 50)
    private String evaluateur;

    @JsonProperty("commentaire")
    @Size(max = 255)
    private String commentaire;

    @JsonProperty("note")
    private int note;

    public static EvaluationDto fromEntity(EvaluationEntity entity) 
    {
        return EvaluationDto.builder().id(entity.getId()).evaluateur(entity.getEvaluateur()).commentaire(entity.getCommentaire()).note(entity.getNote()).build();
    }
}
