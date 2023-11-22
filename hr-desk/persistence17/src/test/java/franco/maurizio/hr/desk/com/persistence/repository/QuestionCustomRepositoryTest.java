package franco.maurizio.hr.desk.com.persistence.repository;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.entity.custom.QuestionCustom;

/**
 * Unit test for QuestionCustomRepository
 * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class QuestionCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(QuestionCustomRepositoryTest.class);	

    /**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated
     * question' table after survey and survey question are filled
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		SurveyQuestion insertedSurveyQuestion = getFakeSurveyQuestion();
		logger.info(" DEBUG -> questionRepository.findBySurveyId ");
		List<QuestionCustom> questionCustomList = questionRepository.findBySurveyId(insertedSurveyQuestion.getSurveyId());
		assertTrue(questionCustomList.size()==1);
		logger.info(" END -> selectAllFilled() ");
    }
    
}