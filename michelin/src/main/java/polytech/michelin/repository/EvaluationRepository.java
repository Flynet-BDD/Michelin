package polytech.michelin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polytech.michelin.entity.EvaluationEntity;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer>
{
    
}
