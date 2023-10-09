package franco.maurizio.hr.desk.com.persistence.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import franco.maurizio.hr.desk.com.persistence.entity.custom.SurveyQuestionCustom;
import franco.maurizio.hr.desk.com.persistence.repository.SurveyRepository;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;

/**
 * Unit test for SurveyQuestionCustomRepository
 * @author joffre
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyQuestionCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(SurveyQuestionCustomRepositoryTest.class);
	
	@Autowired
	private SurveyQuestionRepository surveyQuestionRepository;
	@Autowired
	private SurveyRepository surveyRepository;	
	@Autowired
	private QuestionRepository questionRepository;
	
    /**
     * prepareDB method prepares the database in order to test
     * CandidateRepository's methods
     */
	@Before
	@After
	public void prepareDB () {
		logger.info(" START -> prepareDB() ");
		surveyQuestionRepository.deleteAll();
		surveyRepository.deleteAll();
		questionRepository.deleteAll();
		logger.info(" END -> prepareDB() ");
	}

    /**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated
     * surveyQuestion' table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		getFakeSurveyQuestion();
		
		List<SurveyQuestionCustom> SurveyQuestionCustomList = surveyQuestionRepository.getAllCustomSurveyQuestion();
		for (SurveyQuestionCustom current : SurveyQuestionCustomList) logger.info("current surveyQuestionCustom: " + current.toString());
		assertTrue(surveyQuestionRepository.getAllCustomSurveyQuestion().size() == 1);
		logger.info(" END -> selectAllFilled() ");
    }
    
}