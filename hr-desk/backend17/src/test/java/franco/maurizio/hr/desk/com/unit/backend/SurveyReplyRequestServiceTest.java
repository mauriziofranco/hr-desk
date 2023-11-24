/**
 * 
 */
package franco.maurizio.hr.desk.com.unit.backend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import franco.maurizio.hr.desk.com.CeReProBackendApplication;
import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.rest.request.SingleQuestionReplyRequest;
import franco.maurizio.hr.desk.com.service.QuestionService;
import franco.maurizio.hr.desk.com.service.SurveyReplyRequestService;

/**
 * @author Marco Fulgosi
 *
  * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CeReProBackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyReplyRequestServiceTest {
	
	public static final Logger logger = LoggerFactory.getLogger(SurveyReplyRequestServiceTest.class);

	@Spy
	private SurveyReplyRequestService surveyReplyRequestService;
	@Mock
	private QuestionRepository questionRepository;
	
	@Mock
	QuestionService questionService ;
	
	@BeforeEach
	public void setup() {
		surveyReplyRequestService = new SurveyReplyRequestService();
		/* setta nellistanza del controllore dove ci sta il field che si chiama tra le "" l'istanza survreorep:  */
		ReflectionTestUtils.setField(surveyReplyRequestService, "questionRepository", questionRepository);
	}
	
//	@AfterEach
//	public void teardown() {
//		surveyReplyRequestController = null;
//	}
	
	@Test
	public void testPointsCalculatorSuccessfully() {
		logger.info(" # testPointsCalculatorSuccessfully() - START");
		Question question = new Question();
		question.setLabel("testLabel");
		question.setCansa(true);
		question.setCansb(true);
		question.setCansc(true);
		question.setCansd(true);
		question.setCanse(true);
		question.setCansf(true);
		question.setCansg(true);
		question.setCansh(true);
		question.setId(1000L);
		
		SingleQuestionReplyRequest testsqr = new SingleQuestionReplyRequest();
		testsqr.setCansa(true);
		testsqr.setCansb(true);
		testsqr.setCansc(true);
		testsqr.setCansd(true);
		testsqr.setCanse(true);
		testsqr.setCansf(true);
		testsqr.setCansg(true);
		testsqr.setCansh(true);
		testsqr.setQuestionId(1000L);
		List<SingleQuestionReplyRequest> answers = new ArrayList<SingleQuestionReplyRequest>();
		answers.add(testsqr);
		
		when(this.questionRepository.getById(question.getId())).thenReturn(question);
		
		String punteggio = surveyReplyRequestService.calculateScore(answers);
		logger.info(" # # punteggio totalizzato: "+ punteggio);
		
		Long punteggioMAX = 8L*surveyReplyRequestService.getCorrect();
		logger.info(" # # punteggio massimo: "+ punteggioMAX);
		
		assertTrue((""+punteggioMAX).equals(punteggio));
		logger.info(" # testPointsCalculatorSuccessfully() - END");
	}
	
	@Test
	public void testPointsCalculatorWrongAnswer() {
		logger.info(" # testPointsCalculatorWrongAnswer() - START");
		Question question = new Question();
		question.setLabel("testLabel");
		question.setCansa(true);
		question.setCansb(true);
		question.setCansc(true);
		question.setCansd(true);
		question.setCanse(true);
		question.setCansf(true);
		question.setCansg(true);
		question.setCansh(true);
		question.setId(1000L);
		
		SingleQuestionReplyRequest testsqr = new SingleQuestionReplyRequest();
		testsqr.setCansa(true);
		testsqr.setCansb(true);
		testsqr.setCansc(true);
		testsqr.setCansd(true);
		testsqr.setCanse(false);
		testsqr.setCansf(true);
		testsqr.setCansg(true);
		testsqr.setCansh(true);
		testsqr.setQuestionId(question.getId());
		List<SingleQuestionReplyRequest> answers = new ArrayList<SingleQuestionReplyRequest>();
		answers.add(testsqr);
		
		when(this.questionRepository.getById(question.getId())).thenReturn(question);
		
		String punteggio = surveyReplyRequestService.calculateScore(answers);
		logger.info(" # # punteggio totalizzato: "+ punteggio);
		
		Long punteggioMAX = 8L*surveyReplyRequestService.getCorrect();
		logger.info(" # # punteggio massimo: "+ punteggioMAX);
		
		assertTrue(!(""+punteggioMAX).equals(punteggio));
		logger.info(" # testPointsCalculatorWrongAnswer() - END");
	}
	
	@Test
	public void testPointsCalculatorALLWrongAnswers() {
		logger.info(" # testPointsCalculatorALLWrongAnswers() - START");
		Question question = new Question();
		question.setLabel("testLabel");
		question.setCansa(true);
		question.setCansb(true);
		question.setCansc(true);
		question.setCansd(true);
		question.setCanse(true);
		question.setCansf(true);
		question.setCansg(true);
		question.setCansh(true);
		question.setId(1000L);
		
		SingleQuestionReplyRequest testsqr = new SingleQuestionReplyRequest();
		testsqr.setCansa(false);
		testsqr.setCansb(false);
		testsqr.setCansc(false);
		testsqr.setCansd(false);
		testsqr.setCanse(false);
		testsqr.setCansf(false);
		testsqr.setCansg(false);
		testsqr.setCansh(false);
		testsqr.setQuestionId(question.getId());
		List<SingleQuestionReplyRequest> answers = new ArrayList<SingleQuestionReplyRequest>();
		answers.add(testsqr);
		
		when(this.questionRepository.getById(question.getId())).thenReturn(question);
		
		String punteggio = surveyReplyRequestService.calculateScore(answers);
		logger.info(" # # punteggio totalizzato: "+ punteggio);
		
		assertTrue("-8".equals(punteggio));
		logger.info(" # testPointsCalculatorALLWrongAnswers() - END");
	}
	
}