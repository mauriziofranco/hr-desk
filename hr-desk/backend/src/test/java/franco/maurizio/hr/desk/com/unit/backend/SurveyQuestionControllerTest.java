package franco.maurizio.hr.desk.com.unit.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import franco.maurizio.hr.desk.com.CeReProBackendApplication;
import franco.maurizio.hr.desk.com.backend.SurveyQuestionController;
import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;
import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.entity.Survey;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.repository.SurveyRepository;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;

/*
 * 
  * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CeReProBackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyQuestionControllerTest {

	public static final Logger logger = LoggerFactory.getLogger(SurveyQuestionControllerTest.class);

	@Spy
	private SurveyQuestionController sqController;
	@Mock
	private SurveyQuestionRepository sqRepository;
	@Mock
	private SurveyRepository sRepository;
	@Mock
	private QuestionRepository qRepository;

	@BeforeEach
	public void setup() {
		sqController = new SurveyQuestionController();
		ReflectionTestUtils.setField(sqController, "sqRepository", sqRepository);
		ReflectionTestUtils.setField(sqController, "sRepository", sRepository);
		ReflectionTestUtils.setField(sqController, "qRepository", qRepository);
	}

	@Test
	public void testListAllUsers() {
		List<SurveyQuestion> roleList = new ArrayList<SurveyQuestion>();
		roleList.add(new SurveyQuestion());
		when(this.sqRepository.findAll()).thenReturn(roleList);
		ResponseEntity<List<SurveyQuestion>> responseEntity = this.sqController.listAllSurveyQuestion();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1, responseEntity.getBody().size());
	}

	
	@Test
	public void testInsertSurveyQuestionSuccessfully() {
		SurveyQuestion testSQ = new SurveyQuestion (100L,4L, 40L, 5L);
		Survey testSurvey = new Survey(4L, "ciao", 20L, "ciao ciao ciao");
		Question testQuestion = new Question (40L, "test", "tester", "ansa test", true) ;

		Optional<Survey> survey = Optional.of(testSurvey);
		Optional<Question> question = Optional.of(testQuestion);
	
		when(sqRepository.findBySurveyIdAndQuestionId(4L, 40L)).thenReturn(null);
		when(sRepository.findById(4L)).thenReturn(survey);
		when(qRepository.findById(40L)).thenReturn(question);
		when(this.sqRepository.save(testSQ)).thenReturn(testSQ);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.sqController.createSQ(testSQ);
		
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(4, ((SurveyQuestion)responseEntity.getBody()).getSurveyId().longValue());
		assertEquals(40, ((SurveyQuestion)responseEntity.getBody()).getQuestionId().longValue());
		assertEquals(5, ((SurveyQuestion)responseEntity.getBody()).getPosition().longValue());
	}
	@Test
	public void testGetSurveyQuestionById() {
		SurveyQuestion testSQ = new SurveyQuestion(100L,4L, 40L, 5L) ;
		Optional<SurveyQuestion> currOpt = Optional.of(testSQ) ;
		when(this.sqRepository.findById(100L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.sqController.getSurveyQuestionById(100L);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(4, ((SurveyQuestion)responseEntity.getBody()).getSurveyId().longValue());
		assertEquals(40, ((SurveyQuestion)responseEntity.getBody()).getQuestionId().longValue());
		assertEquals(5, ((SurveyQuestion)responseEntity.getBody()).getPosition().longValue());
	}
	
	@Test
	public void testUpdateSurveyQuestionSuccessfully() {
		SurveyQuestion testSQ = new SurveyQuestion (100L,4L, 40L, 5L) ;
		Optional<SurveyQuestion> currOpt = Optional.of(testSQ) ;
		when(this.sqRepository.findById(100L)).thenReturn(currOpt);
		testSQ.setPosition(20L);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.sqController.updateSQ(100L, testSQ);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(20L, ((SurveyQuestion)responseEntity.getBody()).getPosition().longValue());
	}
	
	
	@Test
	public void testDeleteSurveyQuestionSuccessfully() {
		SurveyQuestion testSQ = new SurveyQuestion (100L,4L, 40L, 5L) ;
		Optional<SurveyQuestion> currOpt = Optional.of(testSQ) ;
		when(this.sqRepository.findById(100L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.sqController.deleteSurveyQuestion(100L);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}
	
	
	@AfterEach
	public void teardown() {
		sqController = null;
	}
}
