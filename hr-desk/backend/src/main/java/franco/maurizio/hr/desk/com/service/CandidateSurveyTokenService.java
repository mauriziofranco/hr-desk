/**
 * 
 */
package franco.maurizio.hr.desk.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;

/**
 * @author m.franco
 */
@Service
public class CandidateSurveyTokenService {

	public static final Logger logger = LoggerFactory.getLogger(CandidateSurveyTokenService.class);

	@Autowired
	private CandidateSurveyTokenRepository candidateSurveyTokenRepository;
	
	/**
	 * Provides to delete all entities from CandidateSurveyTokens table
	 */
	public void deleteAll() {
		logger.debug("deleteAll - START");
		candidateSurveyTokenRepository.deleteAll();
	}

}
