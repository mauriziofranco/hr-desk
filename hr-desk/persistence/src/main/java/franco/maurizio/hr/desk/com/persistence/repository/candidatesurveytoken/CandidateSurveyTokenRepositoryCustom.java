package franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import franco.maurizio.hr.desk.com.persistence.entity.custom.CandidateSurveyTokenCustom;

/**
 * CandidateSurveyTokenRepositoryCustom
 * 
 * Provides signs for custom implementation methods
 * 
 * @author maurizio.franco@ymail.com
 */
public interface CandidateSurveyTokenRepositoryCustom  {

	List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyToken() ;
	
//	Page<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExpiredPaginated(Pageable info, Boolean situation);
	
	List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenActive () ;
	
	List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExecuted () ;
	
	List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExpiredAndNotExecuted () ;

}
