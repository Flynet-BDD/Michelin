package polytech.michelin.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import polytech.michelin.dto.EvaluationDto;
import polytech.michelin.service.EvaluationService;

@RestController
@RequiredArgsConstructor
public class EvaluationController 
{
    private final EvaluationService evaluationService;

    @PostMapping("restaurant/{restaurantId}/evaluation")
    public @ResponseBody EvaluationDto addEvaluation(@Valid @RequestBody EvaluationDto dto, @PathVariable int restaurantId)
    {
        return EvaluationDto.fromEntity(this.evaluationService.addEvaluation(restaurantId, dto.getEvaluateur(), dto.getCommentaire(), dto.getNote()));
    }

    @DeleteMapping("/evaluation/{id}")
    public void deleteEvaluation(@PathVariable int id)
    {
        evaluationService.deleteEvaluation(id);
    } 
}
