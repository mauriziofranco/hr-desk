package franco.maurizio.hr.desk.com.unit.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
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
import franco.maurizio.hr.desk.com.backend.CandidateSurveyTokenController;
import franco.maurizio.hr.desk.com.persistence.entity.CandidateSurveyToken;
import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;
import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;

/*
 * 
 * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CeReProBackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CandidateSurveyTokenControllerTest {

	public static final Logger logger = LoggerFactory.getLogger(CandidateSurveyTokenControllerTest.class);

	@Spy
	private CandidateSurveyTokenController candidateSurveyTokenController;

	@Mock
	private CandidateSurveyTokenRepository candidateSurveyTokenRepository;

	@BeforeEach
	public void setup() {
		candidateSurveyTokenController = new CandidateSurveyTokenController();
		ReflectionTestUtils.setField(candidateSurveyTokenController, "candidateSurveyTokenRepository",
				candidateSurveyTokenRepository);
	}

	@Test
	public void testListAllUsers() {

		List<CandidateSurveyToken> usersurveytokenList = new ArrayList<CandidateSurveyToken>();
		usersurveytokenList.add(new CandidateSurveyToken());
		when(this.candidateSurveyTokenRepository.findAll()).thenReturn(usersurveytokenList);
		ResponseEntity<List<CandidateSurveyToken>> responseEntity = this.candidateSurveyTokenController.listAllQuestions();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1, responseEntity.getBody().size());

	}

	@Test
	public void testGetUserSurveyTokenById() {
		CandidateSurveyToken testUserSurveyToken = new CandidateSurveyToken(10L, 1L, 1L, "tester", null, false);
		Optional<CandidateSurveyToken> currOpt = Optional.of(testUserSurveyToken);
		when(this.candidateSurveyTokenRepository.findById(10L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.candidateSurveyTokenController
				.getCandidateSurveyTokenById(10L);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1, ((CandidateSurveyToken) responseEntity.getBody()).getCandidateId().longValue());
		assertEquals(1, ((CandidateSurveyToken) responseEntity.getBody()).getSurveyId().longValue());
		assertEquals("tester", ((CandidateSurveyToken) responseEntity.getBody()).getGeneratedToken());
		assertEquals(null, ((CandidateSurveyToken) responseEntity.getBody()).getExpirationDateTime());
		assertEquals(false, ((CandidateSurveyToken) responseEntity.getBody()).isExpired());

	}

	@Test
	public void testInsertUserSurveyTokenSuccessfully() {
		CandidateSurveyToken testUserSurveyToken = new CandidateSurveyToken(10L, 1L, 1L, "tester",
				LocalDateTime.now().plusHours(10), false);
		when(this.candidateSurveyTokenRepository.save(testUserSurveyToken)).thenReturn(testUserSurveyToken);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.candidateSurveyTokenController
				.createCandidateSurveyToken(testUserSurveyToken);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(10, ((CandidateSurveyToken) responseEntity.getBody()).getId().longValue());
		assertEquals(1, ((CandidateSurveyToken) responseEntity.getBody()).getSurveyId().longValue());
		assertEquals(1, ((CandidateSurveyToken) responseEntity.getBody()).getCandidateId().longValue());
	}

	@Test
	public void testDeleteUserSurveyTokenSuccessfully() {
		CandidateSurveyToken testUserSurveyToken = new CandidateSurveyToken(10L, 1L, 1L, "tester", null, false);
		Optional<CandidateSurveyToken> currOpt = Optional.of(testUserSurveyToken);
		when(this.candidateSurveyTokenRepository.findById(10L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.candidateSurveyTokenController
				.deleteUserSurveyToken(10L);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}

//	@Test
//	public void testUpdateUserSurveyTokenSuccessfully() {
//		CandidateSurveyToken testUserSurveyToken = new CandidateSurveyToken (10L,1L,1L,"tester", null ) ;
//		Optional<CandidateSurveyToken> currOpt = Optional.of(testUserSurveyToken) ;
//		when(this.usersurveytokenRepository.findById(100L)).thenReturn(currOpt);
//		testUserSurveyToken.setDescription("testerUPDATED");
//		ResponseEntity<CeReProAbstractEntity> responseEntity = this.candidateSurveyTokenController.updateUserTokenSurvey(10L, testUserSurveyToken);
//		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//		assertEquals("testerUPDATED", ((CandidateSurveyToken)responseEntity.getBody()).getDescription());
//	}

	@AfterEach
	public void teardown() {
		candidateSurveyTokenController = null;
	}
}
