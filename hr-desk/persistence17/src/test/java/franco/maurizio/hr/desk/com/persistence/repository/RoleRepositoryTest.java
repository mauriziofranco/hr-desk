package franco.maurizio.hr.desk.com.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.persistence.entity.Role;
/**
 * @author anna
 * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class RoleRepositoryTest extends AbstractRepositoryTest  {

	private static final Logger logger = LoggerFactory.getLogger(RoleRepositoryTest.class);
	
	/**
	 * Provides to clean role table and all(previously) referenced tables:
	 * user, candidate and employee.
     * in order to be able to execute tests.
     * Execute clean before and after each test
     */
	@BeforeAll
	@AfterAll
	public void initializeRoleTests () {
		logger.info("RoleRepositoryTest.initializeRoleTests - START");		
		roleRepository.deleteAll();
		logger.info("RoleRepositoryTest.initializeRoleTests - END");
	}

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * role table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("RoleRepositoryTest.testSelectAllFilled() - START");
		getFakeRole();
		assertTrue(roleRepository.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * roles' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info("RoleRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(roleRepository.count()==0);
    }

	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("RoleRepositoryTest.testInsert() - START");
		assertTrue(roleRepository.count()==0);
		getFakeRole();
		assertTrue(roleRepository.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("RoleRepositoryTest.testSelectById() - START");
		Role currentRole = getFakeRole();
		assertTrue(roleRepository.findById(currentRole.getId()).isPresent());		
	}
	
	/**
     * testSelectByLevel() method tests if the method selectByLevel()
     * really works
     */
	@Test
	public void testSelectByLevel() {
		logger.info("RoleRepositoryTest.testSelectByLevel() - START");
		Role currentRole = getFakeRole();
		assertTrue(roleRepository.findByLevel(currentRole.getLevel())!=null);
		logger.info("RoleRepositoryTest.testSelectByLevel() - END");
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("RoleRepositoryTest.testUpdate() - START");
		Role currentRole = getFakeRole();
		currentRole.setLabel("developer");
		roleRepository.save(currentRole);
		assertTrue(roleRepository.findById(currentRole.getId()).isPresent());	
		assertTrue((roleRepository.findById(currentRole.getId()).get().getLabel().equals("developer")));
	}

	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("RoleRepositoryTest.testDeleteById() - START");
		Role currentRole = getFakeRole();
    	assertTrue(roleRepository.count()==1);
    	roleRepository.deleteById(currentRole.getId());
    	assertTrue(roleRepository.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("RoleRepositoryTest.testDeleteAll() - START");
		getFakeRole();
    	assertTrue(roleRepository.count()==1);
    	roleRepository.deleteAll();
		assertTrue(roleRepository.count()==0);
		logger.info("RoleRepositoryTest.testDeleteAll() - END");
	}
}