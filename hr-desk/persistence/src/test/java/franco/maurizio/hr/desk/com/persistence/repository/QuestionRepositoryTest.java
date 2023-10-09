package franco.maurizio.hr.desk.com.persistence.repository;

import static org.junit.Assert.assertTrue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;

/**
 * Unit test for QuestionRepository class.
 * 
 * @author daniele piccinni
 * @author anna
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(QuestionRepositoryTest.class);
	
	@Autowired
	private QuestionRepository qr;
	@Autowired
	private SurveyQuestionRepository sqr;

	/**
	 * Provides to clean question table and all(previously) referenced tables:
	 * surveyquestion.
     * in order to be able to execute tests.
     * Execute clean before and after each test
     */
	@Before
	@After
	public void initializeQuestionTests () {
		logger.info("QuestionRepositoryTest.initializeQuestionTests - START");
		sqr.deleteAll();
		qr.deleteAll();
		logger.info("QuestionRepositoryTest.initializeQuestionTests - END");
	}
	
	/**
	 * Test for method selectAll with filled table
	 */
	@Test
    public void testSelectAllFilled(){
		logger.info("QuestionRepositoryTest.testSelectAllFilled() - START");
		getFakeQuestion();
		assertTrue(qr.count() == 1);
    }

	/**
	 * Test for method selectAll with empty table
	 */
	@Test
    public void testSelectAllEmpty(){
		logger.info("QuestionRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(qr.count()==0);
    }

	/**
	 * Test for method insert
	 */
	@Test
	public void testInsert() {
		logger.info("QuestionRepositoryTest.testInsert() - START");
		assertTrue(qr.count()==0);
		getFakeQuestion();
		assertTrue(qr.count()==1);
	}
	
	/**
	 * Test for method selectById
	 */
	@Test
	public void testSelectById() {
		logger.info("QuestionRepositoryTest.testSelectById() - START");
		
		Question currentQuestion = getFakeQuestion();
		assertTrue(qr.findById(currentQuestion.getId()).isPresent());		
	}

	/**
	 * Test for method update
	 */
	@Test
	public void testUpdate() {
		logger.info("QuestionRepositoryTest.testUpdate() - START");
		Question currentQuestion = getFakeQuestion();
		currentQuestion.setLabel("question's developer");
		qr.save(currentQuestion);
		assertTrue(qr.findById(currentQuestion.getId()).isPresent());	
		assertTrue((qr.findById(currentQuestion.getId()).get().getLabel().equals("question's developer")));
	}
	
	/**
	 * Test for method deleteById
	 */
	@Test
	public void testDeleteById() {
		logger.info("QuestionRepositoryTest.testDeleteById() - START");
		Question currentQuestion = getFakeQuestion();
    	assertTrue(qr.count()==1);
    	qr.deleteById(currentQuestion.getId());
    	assertTrue(qr.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("QuestionRepositoryTest.testDeleteAll() - START");
		getFakeQuestion();
    	assertTrue(qr.count()==1);
    	qr.deleteAll();
		assertTrue(qr.count()==0);
		logger.info("QuestionRepositoryTest.testDeleteAll() - END");
	}


}
