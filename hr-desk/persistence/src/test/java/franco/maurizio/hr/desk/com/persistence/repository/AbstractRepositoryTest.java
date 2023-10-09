package franco.maurizio.hr.desk.com.persistence.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import franco.maurizio.hr.desk.com.persistence.entity.Candidate;
import franco.maurizio.hr.desk.com.persistence.entity.CandidateStates;
import franco.maurizio.hr.desk.com.persistence.entity.CandidateSurveyToken;
import franco.maurizio.hr.desk.com.persistence.entity.CoursePage;
import franco.maurizio.hr.desk.com.persistence.entity.PositionUserOwner;
import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.entity.Role;
import franco.maurizio.hr.desk.com.persistence.entity.Survey;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyReply;
import franco.maurizio.hr.desk.com.persistence.entity.User;
import franco.maurizio.hr.desk.com.persistence.repository.CandidateStatesRepository;
import franco.maurizio.hr.desk.com.persistence.repository.PositionUserOwnerRepository;
import franco.maurizio.hr.desk.com.persistence.repository.RoleRepository;
import franco.maurizio.hr.desk.com.persistence.repository.SurveyRepository;
import franco.maurizio.hr.desk.com.persistence.repository.UserRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidate.CandidateRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;
import franco.maurizio.hr.desk.com.persistence.repository.coursepage.CoursePageRepository;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyreply.SurveyReplyRepository;

/**
 * @author maurizio.franco@ymail.com
 * @author anna
 * @author Daniele Piccinni
 */
public abstract class AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(AbstractRepositoryTest.class);

	@Autowired
	protected RoleRepository roleRepository;
	@Autowired
	protected UserRepository userRepository;
	@Autowired
	protected CandidateRepository candidateRepository;
	@Autowired
	protected QuestionRepository questionRepository;
	@Autowired
	protected SurveyRepository surveyRepository;
	@Autowired
	protected SurveyReplyRepository surveyReplyRepository;
	@Autowired
	protected CandidateSurveyTokenRepository candidateSurveyTokenRepository;
	@Autowired
	protected SurveyQuestionRepository surveyQuestionRepository;
	@Autowired
	protected CoursePageRepository coursePageRepository;
	@Autowired
	protected PositionUserOwnerRepository positionUserOwnerRepository;
	@Autowired
	protected CandidateStatesRepository candidateStatesRepository;
	
	/**
	 * Provides to clean tables in order to execute single integration tests
     * Execute table cleaning before and after each test
     */
	@Before
	@After
	public void prepareDB () {
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");
		logger.info(" START -> prepareDB() ");
		surveyReplyRepository.deleteAll();
		surveyQuestionRepository.deleteAll();
		candidateSurveyTokenRepository.deleteAll();		
		surveyRepository.deleteAll();
		candidateRepository.deleteAll();
		positionUserOwnerRepository.deleteAll();
		coursePageRepository.deleteAll();
		userRepository.deleteAll();
		candidateStatesRepository.deleteAll();
		roleRepository.deleteAll();
		logger.info(" END -> prepareDB() ");
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");
		logger.info("############################");		
	}
	
	protected Role getFakeRole() {
		return getFakeRole(100);
	}

	protected Role getFakeRole(int level) {
		Role role = new Role();
		role.setLabel("admin");
		role.setDescription("administrator");
		role.setLevel(level);
		Role roles = roleRepository.findByLevel(level);
		if (roles == null) {
			roleRepository.save(role);
		}
		return role;
	}

	protected User getFakeUser() {

		return getFakeUser(100);
	}

	protected User getFakeUser(int level) {
		User testUser = new User();
		int random = (int) (Math.random() * 10000);
		testUser.setEmail(random + "pippo@prova.com");
		testUser.setPassword("pippo");
		testUser.setFirstname("pippo");
		testUser.setLastname("prova");
		testUser.setRegdate(LocalDateTime.now());
		testUser.setRole(getFakeRole(level).getLevel());
		userRepository.save(testUser);
		return testUser;
	}

	protected Candidate getFakeCandidate() {
		logger.info("getFakeCandidate - START");
		long insertedBy = getFakeUser(Role.HR_LEVEL).getId();
		String code = getFakeCoursePage().getCode();
		long candidateStateCode=getFakeCandidateStates().getStatusCode();
		//Candidate testCandidate = new Candidate(userId, code,candidateStatesId);
		LocalDateTime regdate = LocalDateTime.now();
		String firstname = "Test_Firstname" ;
		String lastname = "Test_Lasstname" ;
		String email = "test@email.com" ;
		LocalDateTime candidacyDateTime = LocalDateTime.now();
		Candidate testCandidate = new Candidate(code, candidateStateCode, email, firstname, lastname, regdate, insertedBy, candidacyDateTime);
		candidateRepository.save(testCandidate);
		return testCandidate;
	}
	
//	protected Candidate getFakeCandidateByCandidacyTimeAndCourseCode(LocalDateTime ldt, String courseCode) {
//		long userId = getFakeUser(Role.JAVA_COURSE_CANDIDATE_LEVEL).getId();
//		long candidateStatesId=getFakeCandidateStates().getId();
//		Candidate testCandidate = new Candidate(userId, courseCode, candidateStatesId);
//		testCandidate.setCandidacyDateTime(ldt);
//		candidateRepository.save(testCandidate);
//		return testCandidate;
//	}
	
	protected Candidate getFakeCandidateByCandidacyTimeAndCourseCode(LocalDateTime ldt, String courseCode) {
		logger.info("getFakeCandidateByCandidacyTimeAndCourseCode - START");
		Candidate testCandidate = getFakeCandidate();
		testCandidate.setCourseCode(courseCode);
		testCandidate.setCandidacyDateTime(ldt);
		candidateRepository.save(testCandidate);
		return testCandidate;
	}
	
	protected Survey getFakeSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setDescription("ciccioBello");
		testSurvey.setTime(20L);
		testSurvey.setLabel("pelleDiPesca");
		surveyRepository.save(testSurvey);
		return testSurvey;
	}

	protected Question getFakeQuestion() {
		Question testQuestion = new Question("FakeQuestion");
		questionRepository.save(testQuestion);
		return testQuestion;
	}
	
	protected SurveyQuestion getFakeSurveyQuestion() {
		long questionId = getFakeQuestion().getId();
		long surveyId = getFakeSurvey().getId();
		SurveyQuestion testSQ = new SurveyQuestion();
		testSQ.setSurveyId(surveyId);
		testSQ.setQuestionId(questionId);
		surveyQuestionRepository.save(testSQ);
		return testSQ;
	}
	
	

	protected SurveyReply getFakeSurveyReply() {
		SurveyReply testSR = new SurveyReply();
		testSR.setCandidateId(getFakeCandidate().getId());
		testSR.setSurveyId(getFakeSurvey().getId());
		testSR.setStarttime(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		testSR.setEndtime(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		testSR.setAnswers("qualcosa");
		testSR.setPdffilename("qualcosa");
		testSR.setPoints("bravo");
		testSR.setGenerated_token(getFakeCandidateSurveyToken().getGeneratedToken());
		surveyReplyRepository.save(testSR);
		return testSR;
	}	
	
//	protected CandidateSurveyToken getFakeCandidateSurveyToken() {
//		CandidateSurveyToken testCST = new CandidateSurveyToken();
//		List<Candidate> candidates = candidateRepository.findAll();
//		if (candidates.isEmpty())
//			testCST.setCandidateId(getFakeCandidate().getId());
//		else
//			testCST.setCandidateId(candidates.get(0).getId());
//		testCST.setSurveyId(getFakeSurvey().getId());
//		testCST.setExpirationDateTime(LocalDateTime.now());
//		candidateSurveyTokenRepository.save(testCST);
//		return testCST;
//	}
	
	protected CandidateSurveyToken getFakeCandidateSurveyToken() {
		logger.info("getFakeCandidateSurveyToken - START");
		CandidateSurveyToken testCST = new CandidateSurveyToken();
		logger.info("getFakeCandidateSurveyToken - getting all candidates...");
		List<Candidate> candidates = candidateRepository.findAll();
		logger.info("getFakeCandidateSurveyToken - got " + candidates.size() + " candidates...");
		if (candidates.isEmpty())
			testCST.setCandidateId(getFakeCandidate().getId());
		else
			testCST.setCandidateId(candidates.get(0).getId());
		testCST.setSurveyId(getFakeSurvey().getId());
		testCST.setGeneratedToken("WI9DKPJE");
		testCST.setExpirationDateTime(LocalDateTime.now());
		candidateSurveyTokenRepository.save(testCST);
		return testCST;
	}

	protected CoursePage getFakeCoursePageWithCode(String code) {
		CoursePage testCoursePage = new CoursePage();
		int random = (int) (Math.random() * 10000);
		testCoursePage.setTitle("Fake title " + random);
		testCoursePage.setBodyText("FakeBodyText " + random);
		testCoursePage.setFileName("FakeFileName " + random);
		testCoursePage.setCode(code);
		testCoursePage.setStatusOpen(true);
		testCoursePage.setCreated_datetime(LocalDateTime.now());
		testCoursePage.setOpened_by(getFakeUser().getId());
		coursePageRepository.save(testCoursePage);
		return testCoursePage;
	}

	protected CoursePage getFakeCoursePage() {
		int random = (int) (Math.random() * 10000);
		return getFakeCoursePageWithCode("FakeFileName " + random);
	}
	
	protected PositionUserOwner getFakePositionUserOwner() {
		User testUser = getFakeUser(50);
		CoursePage testCoursePage = getFakeCoursePage();
		PositionUserOwner testPositionUserOwner = new PositionUserOwner();
		testPositionUserOwner.setCoursePageId(testCoursePage.getId());
		testPositionUserOwner.setUserId(testUser.getId());
		positionUserOwnerRepository.save(testPositionUserOwner);
		return testPositionUserOwner;
		
	}

	protected CandidateSurveyToken getFakeUserTokenSurveyExpired() {
		logger.info("getFakeCandidateSurveyToken - START");
		CandidateSurveyToken testCST = new CandidateSurveyToken();
		logger.info("getFakeCandidateSurveyToken - getting all candidates...");
		List<Candidate> candidates = candidateRepository.findAll();
		logger.info("getFakeCandidateSurveyToken - got " + candidates.size() + " candidates...");
		if (candidates.isEmpty())
			testCST.setCandidateId(getFakeCandidate().getId());
		else
			testCST.setCandidateId(candidates.get(0).getId());
		testCST.setSurveyId(getFakeSurvey().getId());
//		testUST.setGeneratedtoken("AAABBBCCCC");
		testCST.setExpirationDateTime(LocalDateTime.now());
		testCST.setExpired(true);
		candidateSurveyTokenRepository.save(testCST);
		return testCST;
	}
	
	protected CandidateStates getFakeCandidateStates() {
		CandidateStates  csTest = new CandidateStates();
		List<Role> roles = roleRepository.findAll();
		if(roles.isEmpty()) {
			csTest.setRoleId(getFakeRole().getId());
		}
		else {
			csTest.setRoleId(roles.get(0).getId());
		}
		csTest.setStatusCode((int)getRandomLongBetweenLimits());
		csTest.setStatusLabel("a status label");
		csTest.setStatusDescription("a status description");
		csTest.setStatusColor("#FF0000");
		candidateStatesRepository.save(csTest);
		return csTest;
	}
	
	protected CandidateStates getFakeCandidateStatesWithDefaultStatusCode() {
		CandidateStates  csTest = new CandidateStates();
		List<Role> roles = roleRepository.findAll();
		if(roles.isEmpty()) {
			csTest.setRoleId(getFakeRole().getId());
		}
		else {
			csTest.setRoleId(roles.get(0).getId());
		}
		csTest.setStatusCode(CandidateStates.DEFAULT_INSERTING_STATUS_CODE);
		csTest.setStatusLabel("a status label");
		csTest.setStatusDescription("a status description");
		csTest.setStatusColor("#FF0000");
		candidateStatesRepository.save(csTest);
		return csTest;
	}
	
	
	public long getRandomLongBetweenLimits () {
		long leftLimit = 100L;
	    long rightLimit = 1000L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    logger.trace("getRandomLongBetweenLimits GENERATED: " + generatedLong);
		return generatedLong ;
	}
}
