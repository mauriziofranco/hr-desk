package franco.maurizio.hr.desk.com.persistence.repository;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.persistence.entity.custom.CandidateSurveyTokenCustom;
import franco.maurizio.hr.desk.com.persistence.repository.candidate.CandidateRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyreply.SurveyReplyRepository;

/**
 * Unit test for CandidateSurveyTokenCustomRepository
* @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CandidateSurveyTokenCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CandidateSurveyTokenCustomRepositoryTest.class);
	
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private SurveyRepository sr;
	@Autowired
	private SurveyQuestionRepository sqr;
	@Autowired
	private CandidateSurveyTokenRepository candidateSurveyTokenRepository;
	@Autowired
	private CandidateRepository cr;
	@Autowired
	private CandidateStatesRepository csr;
	@Autowired
	private SurveyReplyRepository srr;
	
    

    /**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated
     * candidates' table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");		
		logger.info(" START -> selectAllFilled() ");
//		getFakeCandidateSurveyToken();
		getFakeSurveyReply();
		System.out.println(" ------------------------- BELLA -----------------------");
		List<CandidateSurveyTokenCustom> candidateSurveyTokenCustomList = candidateSurveyTokenRepository.getAllCustomCandidateSurveyToken();
		for (CandidateSurveyTokenCustom current : candidateSurveyTokenCustomList) logger.info("current userSurveyTokenCustom: " + current.toString());
		assertTrue(candidateSurveyTokenCustomList.size() == 1);
//		assertTrue(true);
		logger.info(" END -> selectAllFilled() ");
    }
}
