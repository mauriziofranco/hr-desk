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

import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.repository.SurveyRepository;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;

/**
 * @author anna
 * 
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyQuestionRepositoryTest extends AbstractRepositoryTest {
	public static final Logger logger = LoggerFactory.getLogger(SurveyQuestionRepositoryTest.class);
	private SurveyQuestionRepositoryTest surveyQuestionJpaRepository;

	@Autowired
	private SurveyQuestionRepository sqr;	
	@Autowired
	private SurveyRepository sr;	
	@Autowired
	private QuestionRepository qr;
	
	/**
     * initializeUserTests() method inserts a new Role
     * in order to be able to insert a new Role
     */
	@Before
	@After
    public void prepareDB() {
    	logger.info("SurveyQuestionTest.initializeSurveyQuestionTests - START");	
		sqr.deleteAll();
		sr.deleteAll();
		qr.deleteAll();	
		logger.info("SurveyQuestionRepositoryTest.initializeSurveyQuestionTests - END");
    }
	
	 /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * candidates' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info(" START -> selectAllEmpty() ");
		assertTrue(sqr.count()==0);
		logger.info(" END -> selectAllEmpty() ");
    }
    
    /**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
    public void testSelectById(){
		logger.info(" START -> selectById() ");
		SurveyQuestion currentSQ = getFakeSurveyQuestion();
		assertTrue(sqr.findById(currentSQ.getId()).isPresent());
		logger.info(" END -> selectById() ");
    }
    
    /**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
    public void testInsert(){
		logger.info(" START -> insert() ");
		assertTrue(sqr.count()==0);
		getFakeSurveyQuestion();
		assertTrue(sqr.count()==1);
		logger.info(" END -> insert() ");
    }
    
    /**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
    public void testUpdate(){
		logger.info("SurveyQuestionRepositoryTest.testUpdate() START -> update() ");
		SurveyQuestion currentSQ = getFakeSurveyQuestion();
    	currentSQ.setPosition(100L);
		sqr.save(currentSQ);
		assertTrue(sqr.findById(currentSQ.getId()).isPresent());	
		assertTrue((sqr.findById(currentSQ.getId()).get().getPosition()==(100L)));
		logger.info(" END -> update() ");
    }
    
    /**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
    public void testDeleteAll(){
		logger.info(" START -> deleteAll() ");
		getFakeSurveyQuestion();
    	assertTrue(sqr.count()==1);
    	sqr.deleteAll();
		assertTrue(sqr.count()==0);
		logger.info(" END -> deleteAll() ");
    }
    
    /**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
    public void testDeleteById(){
		logger.info(" START -> deleteById() ");
		SurveyQuestion currentSQ = getFakeSurveyQuestion();
    	assertTrue(sqr.count()==1);
    	sqr.deleteById(currentSQ.getId());
    	assertTrue(sqr.count()==0);
		logger.info(" END -> deleteById() ");
    }
	
   

    /**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated
     * candidates' table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		getFakeSurveyQuestion();
		assertTrue(sqr.count() == 1);
		logger.info(" END -> selectAllFilled() ");
    }

	
}
