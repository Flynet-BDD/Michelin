package services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import polytech.michelin.exception.ValeurIncorrecte;
import polytech.michelin.repository.EvaluationRepository;
import polytech.michelin.service.EvaluationService;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EvaluationServiceTest 
{
    @InjectMocks
    private EvaluationService evaluationService;

    @Mock
    private EvaluationRepository evaluationRepository;

    @Test()
    public void shouldThrowValeurIncorrecte()
    {
        assertThrows(ValeurIncorrecte.class, () -> this.evaluationService.addEvaluation(99, "Etchebest", "Miam", 3));
    }
}
