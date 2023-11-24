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
import franco.maurizio.hr.desk.com.backend.RoleController;
import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;
import franco.maurizio.hr.desk.com.persistence.entity.Role;
import franco.maurizio.hr.desk.com.persistence.repository.RoleRepository;
import franco.maurizio.hr.desk.com.service.RoleService;
/*
* @author maurizio.franco@ymail.com
*/
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CeReProBackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class RoleControllerTest {

	public static final Logger logger = LoggerFactory.getLogger(RoleControllerTest.class);

	@Spy
	private RoleController roleController;
	@Mock
	private RoleRepository roleRepository;
	@Mock
	private RoleService roleService;

	@BeforeEach
	public void setup() {
		roleController = new RoleController();
		ReflectionTestUtils.setField(roleController, "roleRepository", roleRepository);
		ReflectionTestUtils.setField(roleController, "roleService", roleService);
	}

	@Test
	public void testListAllRoles() {
		logger.info("testListAllRoles - START");
		List<Role> roleList = new ArrayList<Role>();
		roleList.add(new Role());
		when(this.roleService.getAll()).thenReturn(roleList);
		ResponseEntity<List<Role>> responseEntity = this.roleController.getRoles();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1, responseEntity.getBody().size());
		logger.info("testListAllRoles - END");
	}

	@Test
	public void testGetRoleById() {
		Role testRole = new Role (100L, "test", "tester", 100) ;
		Optional<Role> currOpt = Optional.of(testRole) ;
		when(this.roleRepository.findById(100L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.roleController.getRoleById(100L);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(100, ((Role)responseEntity.getBody()).getLevel());
		assertEquals("tester", ((Role)responseEntity.getBody()).getDescription());
		assertEquals("test", ((Role)responseEntity.getBody()).getLabel());
	}
	
	@Test
	public void testInsertRoleSuccessfully() {
		Role testRole = new Role (100L, "test", "tester", 100) ;
		when(this.roleService.insert(testRole)).thenReturn(testRole);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.roleController.createRole(testRole);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(100, ((Role)responseEntity.getBody()).getLevel());
		assertEquals("tester", ((Role)responseEntity.getBody()).getDescription());
		assertEquals("test", ((Role)responseEntity.getBody()).getLabel());
	}
	
	@Test
	public void testDeleteRoleSuccessfully() {
		Role testRole = new Role (100L, "test", "tester", 100) ;
		Optional<Role> currOpt = Optional.of(testRole) ;
		when(this.roleRepository.findById(100L)).thenReturn(currOpt);
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.roleController.deleteRole(100L);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdateRoleSuccessfully() {
		Role testRole = new Role (100L, "test", "tester", 100) ;
		Optional<Role> currOpt = Optional.of(testRole) ;
		when(this.roleRepository.findById(100L)).thenReturn(currOpt);
		testRole.setDescription("testerUPDATED");
		ResponseEntity<CeReProAbstractEntity> responseEntity = this.roleController.updateRole(100L, testRole);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("testerUPDATED", ((Role)responseEntity.getBody()).getDescription());
	}
	
	@AfterEach
	public void teardown() {
		roleController = null;
	}

}
