package franco.maurizio.hr.desk.com.persistence.repository;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.persistence.entity.SurveyReply;
/**
 * 
 * @author anna
 * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SurveyReplyRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(SurveyReplyRepositoryTest.class);

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * SurveyReply table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("SurveyReplyRepositoryTest.testSelectAllFilled() - START");
		getFakeSurveyReply();
		assertTrue(surveyReplyRepository.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * SurveyReplys' table
     */
	@Test
    public void testSelectAllEmpty(){
		
		logger.info("SurveyReplyRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(surveyReplyRepository.count()==0);
    }
   
	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("SurveyReplyRepositoryTest.testInsert() - START");
		assertTrue(surveyReplyRepository.count()==0);
		getFakeSurveyReply();
		assertTrue(surveyReplyRepository.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("SurveyReplyRepositoryTest.testSelectById() - START");
	//	SurveyReply currentSurveyReply = surveyReplyRepository.save(getFakeSurveyReply());
		SurveyReply currentSurveyReply = getFakeSurveyReply();
		assertTrue(surveyReplyRepository.findById(currentSurveyReply.getId()).isPresent());		
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("SurveyReplyRepositoryTest.testUpdate() - START");
		SurveyReply currentSurveyReply = getFakeSurveyReply();
		currentSurveyReply.setAnswers("pippopippo");
		surveyReplyRepository.save(currentSurveyReply);
		assertTrue(surveyReplyRepository.findById(currentSurveyReply.getId()).isPresent());	
		assertTrue(surveyReplyRepository.findById(currentSurveyReply.getId()).get().getAnswers().equals("pippopippo"));
	}
	
	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("SurveyReplyRepositoryTest.testDeleteById() - START");
		SurveyReply currentSurveyReply = getFakeSurveyReply();
    	assertTrue(surveyReplyRepository.count()==1);
    	surveyReplyRepository.deleteById(currentSurveyReply.getId());
    	assertTrue(surveyReplyRepository.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll() {
		logger.info("SurveyReplyRepositoryTest.testDeleteAll() - START");
		getFakeSurveyReply();
    	assertTrue(surveyReplyRepository.count()==1);
    	surveyReplyRepository.deleteAll();
		assertTrue(surveyReplyRepository.count()==0);
		logger.info("SurveyReplyRepositoryTest.testDeleteAll() - END");
	}
	
	/**
     * testGetSurveyReplyCountForDay()() method tests if the method getSurveyReplyCountForDay()
     * really works
     */

	@Test
	public void testGetSurveyReplyCountForDay() {
		logger.info("SurveyReplyRepositoryTest.testGetSurveyReplyCountForDay() - START");
		getFakeSurveyReply();
		assertTrue(surveyReplyRepository.getSurveyReplyCountForDay(LocalDate.now())==1);
		logger.info("SurveyReplyRepositoryTest.testGetSurveyReplyCountForDay() - END");
	}
	
	
}