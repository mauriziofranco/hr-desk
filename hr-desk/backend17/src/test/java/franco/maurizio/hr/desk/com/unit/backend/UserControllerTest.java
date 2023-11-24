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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import franco.maurizio.hr.desk.com.CeReProBackendApplication;
import franco.maurizio.hr.desk.com.backend.UserController;
import franco.maurizio.hr.desk.com.persistence.entity.CandidateSurveyToken;
import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;
import franco.maurizio.hr.desk.com.persistence.entity.Role;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyReply;
import franco.maurizio.hr.desk.com.persistence.entity.User;
import franco.maurizio.hr.desk.com.persistence.repository.RoleRepository;
import franco.maurizio.hr.desk.com.persistence.repository.UserRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyreply.SurveyReplyRepository;
import franco.maurizio.hr.desk.com.service.UserService;

/**
 * Unit test for UserController
 * 
 * @author joffre
   * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = CeReProBackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes = CeReProBackendApplication.class)
public class UserControllerTest {

	public static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

	@Spy
	private UserService userService;
	@Spy
	private UserController userController;
	@Mock
	private UserRepository userRepository;
	@Mock
	private RoleRepository roleRepository;
	@Mock
	private CandidateSurveyTokenRepository candidateSurveyTokenRepository;
	@Mock
	private SurveyReplyRepository surveyReplyRepository;

	/**
	 * setup method prepares an instance of UserController and injects the mock
	 * UserRepository,RoleRepository (foreign key (role) references roles(level)),
	 * CandidateRepository, EmployeeRepository, etc... (foreign key (user_id)
	 * references users(id)) using Spring’s ReflectionTestUtils utility class by
	 * calling its setField method.
	 */
	@BeforeEach
	public void setup() {
		userController = new UserController();
		ReflectionTestUtils.setField(userController, "userRepository", userRepository);
		ReflectionTestUtils.setField(userController, "roleRepository", roleRepository);
		ReflectionTestUtils.setField(userController, "userService", userService);
		ReflectionTestUtils.setField(userService, "userRepository", userRepository);
	}

	/**
	 * testListAllUsers() method tests if the method getUsers() is really able to
	 * select all tuples from the users' table
	 */
	@Test
	public void testListAllUsers() {

		logger.info("testListAllUsers()  ---------------------- START");
		List<User> userList = new ArrayList<User>();
		userList.add(new User());

		when(this.userRepository.findAll()).thenReturn(userList);
		ResponseEntity<List<User>> responseEntity = this.userController.getUsers();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1, responseEntity.getBody().size());
		logger.info("testListAllUsers()  ---------------------- END");
	}

	/**
	 * testGetUserById() method tests if the method getUserById() is really able to
	 * select a tuple from the users' table based on the Id passed as parameter
	 */
	@Test
	public void testGetUserById() {

		logger.info("testGetUserById()  ---------------------- START");
		User user = new User();
		user.setId(100L);
		user.setEmail("pippo@prova.com");
		user.setPassword("pippo");
		user.setFirstname("pippo");
		user.setLastname("prova");
		user.setRegdate(LocalDateTime.now());
		user.setRole(10);

		Optional<User> currOpt = Optional.of(user);
		when(this.userRepository.findById(100L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.userController.getUserById(100L);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("pippo@prova.com", ((User) responseEntity.getBody()).getEmail());
		assertEquals("pippo", ((User) responseEntity.getBody()).getPassword());
		assertEquals("pippo", ((User) responseEntity.getBody()).getFirstname());
		logger.info("testGetUserById()  ---------------------- END");
	}

	/**
	 * testInsertUserSuccesfully() method tests if the method createUser() is really
	 * able to create a new tuple in the users' table
	 */
	@Test
	public void testInsertUserSuccesfully() {

		logger.info("testInsertUserSuccesfully()  ---------------------- START");
		User user = new User();
		user.setId(100L);
		user.setEmail("pippo@prova.com");
		user.setPassword("pippo");
		user.setFirstname("pippo");
		user.setLastname("prova");
		user.setRole(10);

		when(this.roleRepository.findByLevel(user.getRole())).thenReturn(new Role());
		Optional<User> optUser = Optional.ofNullable(null);
		when(this.userRepository.findByEmail(user.getEmail())).thenReturn(optUser);
		when(this.userRepository.save(user)).thenReturn(user);
		ResponseEntity<CeReProAbstractEntity> responseEntity = userController.createUser(user);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("pippo@prova.com", ((User) responseEntity.getBody()).getEmail());
//		assertEquals("$2a$10$/dkQriasnwbmhxzdjDw.YO9WdTBwJHoPDhhWrceWTcZXfsVwtQEhC", ((User) responseEntity.getBody()).getPassword());
		assertEquals("pippo", ((User) responseEntity.getBody()).getFirstname());
		assertEquals("prova", ((User) responseEntity.getBody()).getLastname());
		assertEquals(10, ((User) responseEntity.getBody()).getRole());
		logger.info("testInsertUserSuccesfully()  ---------------------- END");
	}

	/**
	 * testInsertUserKOForEmail() method tests if the method createUser() is really
	 * able for CONSTRAINT uniqueEmail UNIQUE (email)
	 * 
	 */
	@Test
	public void testInsertUserKOForEmail() {

		logger.info("testInsertUserKOForEmail()  ---------------------- START");
		User user = new User();
		user.setId(100L);
		user.setEmail("pippo@prova.com");
		user.setPassword("pippo");
		user.setFirstname("pippo");
		user.setLastname("prova");
		user.setRegdate(LocalDateTime.now());
		user.setRole(10);

		when(this.roleRepository.findByLevel(user.getRole())).thenReturn(new Role());
		Optional<User> optUser = Optional.ofNullable(user);
		when(this.userRepository.findByEmail(user.getEmail())).thenReturn(optUser);
		ResponseEntity<CeReProAbstractEntity> responseEntity = userController.createUser(user);

		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		logger.info("testInsertUserKOForEmail()  ---------------------- END");
	}

	/**
	 * testInsertUserKOForRole() method tests if the method createUser() is really
	 * able for foreign key (role) references roles(level)
	 * 
	 */
	@Test
	public void testInsertUserKOForRole() {

		logger.info("testInsertUserKOForRole()  ---------------------- START");
		User user = new User();
		user.setId(100L);
		user.setEmail("pippo@prova.com");
		user.setPassword("pippo");
		user.setFirstname("pippo");
		user.setLastname("prova");
		user.setRegdate(LocalDateTime.now());
		user.setRole(10);

		when(this.roleRepository.findByLevel(user.getRole())).thenReturn(null);
		ResponseEntity<CeReProAbstractEntity> responseEntity = userController.createUser(user);

		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		logger.info("testInsertUserKOForRole()  ---------------------- END");
	}

	/**
	 * testUpdateUserSuccessfully() method tests if the method updateUser() is
	 * really able to update fields in the users' table
	 */
	@Test
	public void testUpdateUserSuccessfully() {

		logger.info("testUpdateUserSuccessfully()  ---------------------- START");
		User user = new User();
		user.setId(100L);
		user.setEmail("pippo@prova.com");
		user.setPassword("pippo");
		user.setFirstname("pippo");
		user.setLastname("prova");
		user.setRegdate(LocalDateTime.now());
		user.setRole(10);

		Optional<User> currOpt = Optional.of(user);
		when(this.roleRepository.findByLevel(user.getRole())).thenReturn(new Role());
		when(this.userRepository.findById(100L)).thenReturn(currOpt);
		user.setPassword("pippoUPDATED");
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.userController.updateUser(100L, user);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("pippoUPDATED", ((User) responseEntity.getBody()).getPassword());
		logger.info("testUpdateUserSuccessfully()  ---------------------- END");
	}

	/**
	 * testUpdateUserKOForRole() method tests if the method udateUser() is really
	 * able for foreign key (role) references roles(level)
	 * 
	 */
	@Test
	public void testUpdateUserKOForRole() {

		logger.info("testUpdateUserKOForRole()  ---------------------- START");
		User user = new User();
		user.setId(100L);
		user.setEmail("pippo@prova.com");
		user.setPassword("pippo");
		user.setFirstname("pippo");
		user.setLastname("prova");
		user.setRegdate(LocalDateTime.now());
		user.setRole(10);

		Optional<User> currOpt = Optional.of(user);
		when(this.roleRepository.findByLevel(user.getRole())).thenReturn(null);
		when(this.userRepository.findById(100L)).thenReturn(currOpt);
		user.setPassword("pippoUPDATED");
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.userController.updateUser(100L, user);

		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		logger.info("testUpdateUserKOForRole()  ---------------------- END");
	}

	/**
	 * testDeleteUserSuccessfully() method tests if the method deleteUser() is
	 * really able to delete a tuple in the users' table based on the Id passed as
	 * parameter
	 */
	@Test
	public void testDeleteUserSuccessfully() {

		logger.info("testDeleteUserSuccessfully()  ---------------------- START");
		User user = new User();
		user.setId(100L);
		user.setEmail("pippo@prova.com");
		user.setPassword("pippo");
		user.setFirstname("pippo");
		user.setLastname("prova");
		user.setRegdate(LocalDateTime.now());
		user.setRole(10);

		Optional<User> currOpt = Optional.of(user);

		List<CandidateSurveyToken> userSurveyTokenList = new ArrayList<CandidateSurveyToken>();
		List<SurveyReply> surveyReplyList = new ArrayList<SurveyReply>();

		when(this.userRepository.findById(100L)).thenReturn(currOpt);
//		when(this.candidateRepository.findByUserId(100L)).thenReturn(candidateList);
		when(this.candidateSurveyTokenRepository.findByCandidateId(100L)).thenReturn(userSurveyTokenList);
		when(this.surveyReplyRepository.findByCandidateId(100L)).thenReturn(surveyReplyList);

		ResponseEntity<CeReProAbstractEntity> responseEntity = this.userController.deleteUser(100L);
		logger.info("testDeleteUserSuccessfully()  ---------------------- END");
	}

	

	/**
	 * teardown() method sets userController to null
	 */
	@AfterEach
	public void teardown() {
		userController = null;
	}

}