package franco.maurizio.hr.desk.com.persistence.repository;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import franco.maurizio.hr.desk.com.persistence.entity.User;

/**
 * 
 * Provides a repository test class to test user repository methods
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * user table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("UserRepositoryTest.testSelectAllFilled() - START");
		getFakeUser();
		assertTrue(userRepository.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * users' table
     */
	@Test
    public void testSelectAllEmpty(){	
		logger.info("UserRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(userRepository.count()==0);
    }
   
	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("UserRepositoryTest.testInsert() - START");
		assertTrue(userRepository.count()==0);
		getFakeUser();
		assertTrue(userRepository.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("UserRepositoryTest.testSelectById() - START");
		User currentUser = getFakeUser();
		assertTrue(userRepository.findById(currentUser.getId()).isPresent());		
	}
	
	/**
	 * testSelectByRole() method tests if the emthod findByRole() really works
	 */
	@Test
	public void testSelectByRole() {
		logger.info("UserRepositoryTest.testSelectByRole() - START");
		User currentUser = getFakeUser();
		assertTrue(userRepository.findByRole(currentUser.getRole()).size() > 0);
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("UserRepositoryTest.testUpdate() - START");
		User currentUser = getFakeUser();
		currentUser.setPassword("pippopippo");
		userRepository.save(currentUser);
		assertTrue(userRepository.findById(currentUser.getId()).isPresent());	
		assertTrue(userRepository.findById(currentUser.getId()).get().getPassword().equals("pippopippo"));
	}
	
	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("UserRepositoryTest.testDeleteById() - START");
		User currentUser = getFakeUser();
    	assertTrue(userRepository.count()==1);
    	userRepository.deleteById(currentUser.getId());
    	assertTrue(userRepository.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("UserRepositoryTest.testDeleteAll() - START");
		getFakeUser();
    	assertTrue(userRepository.count()==1);
    	userRepository.deleteAll();
		assertTrue(userRepository.count()==0);
		logger.info("UserRepositoryTest.testDeleteAll() - END");
	}
	
	/**
     * testPageSelectAllFilled() method tests if the method selectAll() 
     * with pageable option
     * is really able to select all tuples from a populated
     * user table
     */
	@Test
    public void testPageSelectAllFilled(){
		logger.info("UserRepositoryTest.testPageSelectAllFilled() - START");
		getFakeUser();
		Page<User> currentPage = userRepository.findAll(PageRequest.of(0, 5, Sort.Direction.ASC, "email"));
		assertTrue(currentPage.getNumberOfElements() == 1);
    }
	
	/**
     * testPageSelectAllFilledFail() method tests if the method selectAll() 
     * with pageable option
     * is really able to select all tuples from a populated
     * user table
     */
	@Test
    public void testPageSelectAllFilledFail(){
		logger.info("UserRepositoryTest.testPageSelectAllFilledFail() - START");
		getFakeUser();
		Page<User> currentPage = userRepository.findAll(PageRequest.of(1, 5, Sort.Direction.ASC, "email"));
		assertTrue(currentPage.getNumberOfElements() == 0);
    }
	
	/*
	 * testUpdateEnabled() method tests if the method updateEnabledById(lon id, booloean enabled)
	 * is really able to update the user "enabled" property value
	 */
	@Test
	public void testUpdateEnabledById() {
		logger.info("UserRepositoryTest.testUpdateEnabledById() - START");
		User currentUser=getFakeUser();
		logger.info("UserRepositoryTest.testUpdateEnabledById() - DEBUG - before update, currentUser.isEnabled(): " + currentUser.isEnabled());
		boolean valueToSet = !currentUser.isEnabled();
		int rowUpdated = userRepository.updateEnabledById(currentUser.getId(), valueToSet);
		assertTrue(rowUpdated==1);
		assertTrue( userRepository.findById(currentUser.getId()).get().isEnabled()==valueToSet);
	}
}