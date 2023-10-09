package franco.maurizio.hr.desk.com.persistence.repository.surveyquestion;
/**
 * 
 * @author joffre
 *
 */
import java.util.List;

import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.custom.SurveyQuestionCustom;

/**
 * 
 * Provides a repository interface to provides other methods signatures to SurveyQuestion repository
 * 
 * @author Centauri Academy
 *
 */
@Repository
public interface SurveyQuestionRepositoryCustom {

	List<SurveyQuestionCustom> getAllCustomSurveyQuestion() ;
	
}