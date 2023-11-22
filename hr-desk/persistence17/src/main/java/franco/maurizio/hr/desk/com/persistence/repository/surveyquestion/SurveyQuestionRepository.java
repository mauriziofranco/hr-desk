package franco.maurizio.hr.desk.com.persistence.repository.surveyquestion;
/**
 * 
 * @author anna
 * @author m.franco@proximainformatica.com
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;

/**
 * Provides a repository for the SurveyQuestion entity
 * 
 * @author Centauri Academy
 *
 */
@Repository
public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> , SurveyQuestionRepositoryCustom {

	SurveyQuestion findBySurveyIdAndQuestionId(long surveyId, long questionId);
	List<SurveyQuestion> findBySurveyId(long surveyId);
	List<SurveyQuestion> findByQuestionId(long questionId);
	
	List<SurveyQuestion> findBySurveyIdOrderByPositionAsc(long surveyId);
	
}