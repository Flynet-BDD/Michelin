package polytech.michelin.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import polytech.michelin.entity.EvaluationEntity;
import polytech.michelin.entity.RestaurantEntity;
import polytech.michelin.repository.EvaluationRepository;

@Service
@RequiredArgsConstructor
public class EvaluationService
{
    private final EvaluationRepository evaluationRepository;

    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluation(int restaurantId, String evaluateur , String messageDuCommentaire, int note) 
    {
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity nouvelleEvaluation = EvaluationEntity.builder().evaluateur(evaluateur).commentaire(messageDuCommentaire).note(note).restaurant(restaurant).build();

        return this.evaluationRepository.save(nouvelleEvaluation);
    }

    public void deleteEvaluation(int evaluationId)
    {
        evaluationRepository.deleteById(evaluationId);
    }
}
