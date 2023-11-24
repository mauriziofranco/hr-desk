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
import franco.maurizio.hr.desk.com.backend.SurveyController;
import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;
import franco.maurizio.hr.desk.com.persistence.entity.Survey;
import franco.maurizio.hr.desk.com.persistence.repository.SurveyRepository;

/*
 *  * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CeReProBackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyControllerTest {

	public static final Logger logger = LoggerFactory.getLogger(SurveyControllerTest.class);

	@Spy
	private SurveyController surveyController;
	@Mock
	private SurveyRepository surveyRepository;

	@BeforeEach
	public void setup() {
		surveyController = new SurveyController();
		ReflectionTestUtils.setField(surveyController, "surveyRepository", surveyRepository);
	}

	@Test
	public void testListAllUsers() {
		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList.add(new Survey());
		when(this.surveyRepository.findAll()).thenReturn(surveyList);
		ResponseEntity<List<Survey>> responseEntity = this.surveyController.listAllSurvey();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1, responseEntity.getBody().size());
	}

	@Test
	public void testGetSurveyById() {
		Survey testSurvey = new Survey(100L, "ciao", 20L,"ciao ciao ciao");
		Optional<Survey> currOpt = Optional.of(testSurvey) ;
		when(this.surveyRepository.findById(100L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.surveyController.getSurveyById(100L);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("ciao", ((Survey)responseEntity.getBody()).getLabel());
		assertEquals("ciao ciao ciao", ((Survey)responseEntity.getBody()).getDescription());
		
	}
	
	@Test
	public void testInsertSurveySuccessfully() {
		Survey testSurvey = new Survey(100L, "ciao", 20L,"ciao ciao ciao");
		when(this.surveyRepository.save(testSurvey)).thenReturn(testSurvey);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.surveyController.createSurvey(testSurvey);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("ciao", ((Survey)responseEntity.getBody()).getLabel());
		assertEquals("ciao ciao ciao", ((Survey)responseEntity.getBody()).getDescription());
	}
	
	@Test
	public void testDeleteRoleSuccessfully() {
		Survey testSurvey = new Survey(100L, "ciao", 20L,"ciao ciao ciao");
		Optional<Survey> currOpt = Optional.of(testSurvey) ;
		when(this.surveyRepository.findById(100L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.surveyController.deleteSurvey(100L);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdateRoleSuccessfully() {
		Survey testSurvey = new Survey(100L, "ciao", 20L,"ciao ciao ciao");
		Optional<Survey> currOpt = Optional.of(testSurvey) ;
		when(this.surveyRepository.findById(100L)).thenReturn(currOpt);
		testSurvey.setDescription("testerUPDATED");
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.surveyController.updateSurvay(100L, testSurvey);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("testerUPDATED", ((Survey)responseEntity.getBody()).getDescription());
	}
	
	
	@AfterEach
	public void teardown() {
		surveyController = null;
	}

//	@Test
//	public void getAll() {
//
//		logger.info("Test-getAll() ---- Start");
//		RestTemplate restTemplate = new RestTemplate();
//
//		String USER_REGISTRATION_BASE_URL = "http://localhost:8080/api/v1/user/";
//
//		List users = restTemplate.getForObject(USER_REGISTRATION_BASE_URL, List.class);
//		logger.info("users size = " + users.size());
//
//		assertTrue(users.size() == 0);
//		logger.info("Test-getAll() ---- End");
//	}
}
