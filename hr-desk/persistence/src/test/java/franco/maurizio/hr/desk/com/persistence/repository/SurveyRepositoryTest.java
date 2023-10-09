package franco.maurizio.hr.desk.com.persistence.repository;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import franco.maurizio.hr.desk.com.persistence.entity.Survey;
import franco.maurizio.hr.desk.com.persistence.repository.SurveyRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidate.CandidateRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyreply.SurveyReplyRepository;

/**
 * 
 * @author anna
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyRepositoryTest extends AbstractRepositoryTest {


		private static final Logger logger = LoggerFactory.getLogger(SurveyRepositoryTest.class);
		@Autowired
		private SurveyRepository sr;
		@Autowired
		private CandidateRepository cr;
		@Autowired
		private CandidateSurveyTokenRepository cstr;
		@Autowired
		private SurveyQuestionRepository sqr;
		@Autowired
		private SurveyReplyRepository srr;
		
		/**
	     * initializeUserTests() method inserts a new Role
	     * in order to be able to insert a new Role
	     */
		@Before
		@After
	    public void initializeSurveyTests() {
	    	
	    	logger.info("SurveyRepositoryTest.initializeSurveyTests - START");    	
	    	cstr.deleteAll();
			sqr.deleteAll();
			srr.deleteAll();
			sr.deleteAll();
			cr.deleteAll();
			logger.info("SurveyRepositoryTest.initializeSurveyTests - END");
	    }

		/**
	     * testSelectAllFilled() method tests if the method selectAll()
	     * is really able to select all tuples from a populated(with one entity)
	     * user table
	     */
		@Test
	    public void testSelectAllFilled(){
			logger.info("SurveyRepositoryTest.testSelectAllFilled() - START");
			getFakeSurvey();
			assertTrue(sr.count() == 1);
	    }
	    
	    /**
	     * testSelectAllEmpty() method tests if the method selectAll()
	     * is really able to select all tuples from a empty
	     * users' table
	     */
		@Test
	    public void testSelectAllEmpty(){
			logger.info("SurveyRepositoryTest.testSelectAllEmpty() - START");
			assertTrue(sr.count()==0);
	    }
	   
		/**
	     * testInsert() method tests if the method insert()
	     * really works
	     */
		@Test
		public void testInsert() {
			logger.info("SurveyRepositoryTest.testInsert() - START");
			assertTrue(sr.count()==0);
			getFakeSurvey();
			assertTrue(sr.count()==1);
			logger.info(" END survey -> insert() ");
		}

		/**
	     * testSelectById() method tests if the method selectById()
	     * really works
	     */
		@Test
		public void testSelectById() {
			logger.info("SurveyRepositoryTest.testSelectById() - START");
			Survey currentSurvey = getFakeSurvey();
			assertTrue(sr.findById(currentSurvey.getId()).isPresent());		
		}
		
		/**
	     * testUpdate() method tests if the method update()
	     * really works
	     */
		@Test
		public void testUpdate() {
			logger.info("SurveyRepositoryTest.testUpdate() - START");
			Survey currentSurvey = getFakeSurvey();
			currentSurvey.setLabel("ciao");
			sr.save(currentSurvey);
			assertTrue(sr.findById(currentSurvey.getId()).isPresent());	
			assertTrue(sr.findById(currentSurvey.getId()).get().getLabel().equals("ciao"));
		}
		
		/**
	     * testDeleteById() method tests if the method deleteById()
	     * really works
	     */
		@Test
		public void testDeleteById() {
			logger.info("SurveyRepositoryTest.testDeleteById() - START");
			Survey currentSurvey = getFakeSurvey();
	    	assertTrue(sr.count()==1);
	    	sr.deleteById(currentSurvey.getId());
	    	assertTrue(sr.count()==0);
		}
		
		/**
	     * testDeleteAll() method tests if the method deleteAll()
	     * really works
	     */
		@Test
		public void testDeleteAll () {
			logger.info("SurveyRepositoryTest.testDeleteAll() - START");
			getFakeSurvey();
	    	assertTrue(sr.count()==1);
	    	sr.deleteAll();
			assertTrue(sr.count()==0);
			logger.info("SurveyRepositoryTest.testDeleteAll() - END");
		}

	}
