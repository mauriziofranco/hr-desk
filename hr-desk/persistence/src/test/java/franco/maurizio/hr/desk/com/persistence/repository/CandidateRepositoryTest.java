package franco.maurizio.hr.desk.com.persistence.repository;

import static org.junit.Assert.assertTrue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import franco.maurizio.hr.desk.com.persistence.entity.Candidate;
import franco.maurizio.hr.desk.com.persistence.repository.CandidateStatesRepository;
import franco.maurizio.hr.desk.com.persistence.repository.RoleRepository;
import franco.maurizio.hr.desk.com.persistence.repository.UserRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidate.CandidateRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;
import franco.maurizio.hr.desk.com.persistence.repository.coursepage.CoursePageRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyreply.SurveyReplyRepository;

/**
 * Unit test for CandidateRepository
 * @author giacomo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CandidateRepositoryTest.class);
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private CoursePageRepository cpr;
	@Autowired
	private CandidateStatesRepository csr;
	@Autowired
	private CandidateSurveyTokenRepository cstr;
	@Autowired
	private SurveyReplyRepository srr;
	
    /**
     * prepareDB method prepares the database in order to test
     * CandidateRepository's methods
     */
	@Before
	@After
	public void prepareDB () {
		logger.info(" START -> prepareDB() ");
		candidateRepository.deleteAll();
		srr.deleteAll();
		cstr.deleteAll();
		cpr.deleteAll();
		csr.deleteAll();
		ur.deleteAll();
		rr.deleteAll();
		logger.info(" END -> prepareDB() ");
	}

    /**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated
     * candidates' table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		getFakeCandidate();
		assertTrue(candidateRepository.count() == 1);
		logger.info(" END -> selectAllFilled() ");
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * candidates' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info(" START -> selectAllEmpty() ");
		assertTrue(candidateRepository.count()==0);
		logger.info(" END -> selectAllEmpty() ");
    }
    
    /**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
    public void testSelectById(){
		logger.info(" START -> selectById() ");
		Candidate currentCandidate = getFakeCandidate();
		assertTrue(candidateRepository.findById(currentCandidate.getId()).isPresent());
		logger.info(" END -> selectById() ");
    }
    
    /**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
    public void testInsert(){
		logger.info(" START -> insert() ");
		assertTrue(candidateRepository.count()==0);
		getFakeCandidate();
		assertTrue(candidateRepository.count()==1);
		logger.info(" END -> insert() ");
    }
    
    /**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
    public void testUpdate(){
		logger.info(" START -> update() ");
    	Candidate currentCandidate = getFakeCandidate();
		currentCandidate.setCvExternalPath("newPath");
		candidateRepository.save(currentCandidate);
		assertTrue(candidateRepository.findById(currentCandidate.getId()).isPresent());	
		assertTrue((candidateRepository.findById(currentCandidate.getId()).get().getCvExternalPath().equals("newPath")));
		logger.info(" END -> update() ");
    }
    
    /**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
    public void testDeleteAll(){
		logger.info(" START -> deleteAll() ");
		getFakeCandidate();
    	assertTrue(candidateRepository.count()==1);
    	candidateRepository.deleteAll();
		assertTrue(candidateRepository.count()==0);
		logger.info(" END -> deleteAll() ");
    }
    
    /**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
    public void testDeleteById(){
		logger.info(" START -> deleteById() ");
		Candidate currentCandidate = getFakeCandidate();
    	assertTrue(candidateRepository.count()==1);
    	candidateRepository.deleteById(currentCandidate.getId());
    	assertTrue(candidateRepository.count()==0);
		logger.info(" END -> deleteById() ");
    }
	

}
