/**
 * 
 */
package franco.maurizio.hr.desk.com.persistence.repository;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.persistence.entity.CandidateStates;


/**
 * @author Sebastiano Varchetta
 *
* @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class CandidateStatesRepositoryTest extends AbstractRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateStatesRepositoryTest.class);
	@Autowired
	private CandidateStatesRepository csr;
	
	@BeforeAll
	@AfterAll
    public void initializeCandidateStatesRepositoryTest() {
    	logger.info("CandidateStatesRepositoryTest.initializeCandidateStateTest - START");    	
    	csr.deleteAll();
		logger.info("CandidateStatesRepositoryTest.initializeCandidateStateTest - END");
    }
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("CandidateStatesRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeCandidateStates();
    	assertTrue(csr.count() == 1);
    	logger.info("CandidateStatesRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("CandidateStatesRepositoryTest.testSelectAllEmpty() - START");    	
		assertTrue(csr.count()==0);
		logger.info("CandidateStatesRepositoryTest.testSelectAllEmpty() - END");
    }
	
	@Test
	public void testInsert() {
    	logger.info("CandidateStatesRepositoryTest.testInsert() - START");    	
		assertTrue(csr.count()==0);
		getFakeCandidateStates();
		assertTrue(csr.count()==1);
		logger.info("CandidateStatesRepositoryTest.testInsert() - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("CandidateStatesRepositoryTest.testSelectById() - START");    	
    	CandidateStates currentCandidateStates = getFakeCandidateStates();
		assertTrue(csr.findById(currentCandidateStates.getId()).isPresent());	
		logger.info("CandidateStatesRepositoryTest.testSelectById() - END");
	}
	
	@Test
	public void testSelectByRoleId() {
    	logger.info("CandidateStateRepositoryTest.testSelectByRoleId() - START");
    	CandidateStates currentCandidateStates = getFakeCandidateStates();
    	assertTrue(csr.findByRoleId(currentCandidateStates.getRoleId())!=null);	
		logger.info("CandidateStateRepositoryTest.testSelectByRoleId() - END");
	}
	
	@Test
	public void testSelectByStatusCode() {
    	logger.info("CandidateStateRepositoryTest.testSelectByStatusCode() - START");
    	CandidateStates currentCandidateStates = getFakeCandidateStates();
    	assertTrue(csr.findByStatusCode(currentCandidateStates.getStatusCode())!=null);	
		logger.info("CandidateStateRepositoryTest.testSelectByStatusCode() - END");
	}
	
	@Test
	public void testSelectByStatusLabel() {
    	logger.info("CandidateStateRepositoryTest.testSelectByStatusLabel() - START");
    	CandidateStates currentCandidateStates = getFakeCandidateStates();
    	assertTrue(csr.findByStatusLabel(currentCandidateStates.getStatusLabel())!=null);	
		logger.info("CandidateStateRepositoryTest.testSelectByStatusLabel() - END");
	}
	
	@Test
	public void testStatusDescription() {
    	logger.info("CandidateStateRepositoryTest.testSelectByStatusDescription() - START");
    	CandidateStates currentCandidateStates = getFakeCandidateStates();
    	assertTrue(csr.findByStatusDescription(currentCandidateStates.getStatusDescription())!=null);	
		logger.info("CandidateStateRepositoryTest.testSelectByStatusDescription() - END");
	}
	
	@Test
	public void testStatusColor() {
    	logger.info("CandidateStateRepositoryTest.testSelectByStatusColor() - START");
    	CandidateStates currentCandidateStates = getFakeCandidateStates();
    	assertTrue(csr.findByStatusColor(currentCandidateStates.getStatusColor())!=null);	
		logger.info("CandidateStateRepositoryTest.testSelectByStatusColor() - END");
	}
	
	
	
	
}
