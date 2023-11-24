package franco.maurizio.hr.desk.com.persistence.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.persistence.entity.Candidate;
import franco.maurizio.hr.desk.com.persistence.entity.custom.CandidateCustom;
import franco.maurizio.hr.desk.com.persistence.entity.custom.ListedCandidateCustom;

/**
 * Unit test for CandidateCustomRepository
* @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CandidateCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CandidateCustomRepositoryTest.class);
    
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
		logger.info(" testSelectById -> {}", currentCandidate);
		CandidateCustom currentCandidateCustom = candidateRepository.getSingleCustomCandidate(currentCandidate.getId());
		logger.info("current candidate custom  " + currentCandidateCustom);
		assertTrue( currentCandidateCustom != null ); 
		logger.info(" END -> selectById() ");
    }
	
	/**
	 * Commented because getAllCustomCandidatesPaginated no more used or used by the Backoffice Application just dismissed
	 * 
	 * 
     * testSelectAllFullAndRightOrdered() method tests if the method getAllCustomCandidatesPaginated() return the full list of the candidates in the correct order by candidacy time!!!!
     * really returns items in the right order
     *      
     */
//	@Test
//    public void testSelectAllFullAndRightOrdered(){
//		logger.info(" START -> selectAllEmpty() ");
//		assertTrue(candidateRepository.count()==0);
//		LocalDateTime ldtNow = LocalDateTime.now();
//		getFakeCandidateByCandidacyTime(ldtNow);
//		assertTrue(candidateRepository.count()==1);
//		LocalDateTime ldtYesterday = LocalDateTime.now().minusDays(1);
//		getFakeCandidateByCandidacyTime(ldtYesterday);
//		assertTrue(candidateRepository.count()==2);
//		Page<CandidateCustom>  currentPage = candidateRepository.getAllCustomCandidatesPaginated(PageRequest.of(0, 10));
//		assertTrue(currentPage.getTotalElements()==2);
//		CandidateCustom first = currentPage.getContent().get(0);
//		logger.info(" DEBUG - first.getId().longValue(): " + first.getId().longValue() + " - candidacyTime:"  );
//		CandidateCustom second = currentPage.getContent().get(1);
//		logger.info(" DEBUG - second.getId().longValue(): " + second.getId().longValue() + " - candidacyTime:" );
//		assertTrue(first.getId().longValue()>second.getId().longValue());
//		logger.info(" END -> testSelectAllFullAndRightOrdered() ");
//    }
	
	
	/**
	 * 
     * This method tests the getAllCustomCandidatesPaginatedByCourseCode(Pageable info, String courseCode) method called by 
     * the frontend to list candidates.
     * It tests normal functionality and that the candidates list is ordered by the candidacy_date_time
     * 
     * @author maurizio.franco
     */
	@Test
    public void testSelectAllCandidatesPaginatedByCourseCode(){
		logger.info("START --> testSelectAllCandidatesPaginatedByCourseCode() ");
		assertTrue(candidateRepository.count()==0);
		String courseCode = getFakeCoursePage().getCode();
		LocalDateTime ldtNow = LocalDateTime.now();
		getFakeCandidateByCandidacyTimeAndCourseCode(ldtNow, courseCode);
		assertTrue(candidateRepository.count()==1);
		LocalDateTime ldtYesterday = LocalDateTime.now().minusDays(1);
		getFakeCandidateByCandidacyTimeAndCourseCode(ldtYesterday, courseCode);
		assertTrue(candidateRepository.count()==2);
		Page<ListedCandidateCustom>  currentPage = candidateRepository.getAllCustomCandidatesPaginatedByCourseCode(PageRequest.of(0, 10), courseCode);
		assertTrue(currentPage.getTotalElements()==2);
		ListedCandidateCustom first = currentPage.getContent().get(0);
		logger.info(" DEBUG - first.getId().longValue(): " + first.getId().longValue() + " - candidacyTime:"  );
		ListedCandidateCustom second = currentPage.getContent().get(1);
		logger.info(" DEBUG - second.getId().longValue(): " + second.getId().longValue() + " - candidacyTime:" );
		assertTrue(first.getId().longValue()<second.getId().longValue());
		logger.info(" END --> testSelectAllCandidatesPaginatedByCourseCode() ");
    }

	@Test
	public void  getCandidateCountWithRegdateInPeriodOfToday() {
		logger.info("getCandidateCountWithRegdateInPeriodOfToday - START");
		LocalDate date = LocalDate.now();
		LocalDateTime startLDT = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0, 0);
		LocalDateTime endLDT = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 23, 59, 59);
//		Timestamp start = Timestamp.valueOf(startLDT);
//		Timestamp end = Timestamp.valueOf(endLDT);
		this.getFakeCandidate();
		logger.info("getCandidateCountWithRegdateInPeriodOfToday - DEBUG - ur.getUserRegdateInPeriod(start, end): " + candidateRepository.getCandidateCountWithRegdateInPeriod(startLDT, endLDT));
//		logger.info("getUserRegistratedTodayTest - DEBUG - ur.getUserRegdateInPeriod(start, end): " + ur.getUserRegdateInPeriodSQL(start, end));		
		assertEquals(candidateRepository.getCandidateCountWithRegdateInPeriod(startLDT, endLDT), 1l);
		logger.info("getCandidateCountWithRegdateInPeriodOfToday - END");
	}
//	
//	@Test
//	public void  getUserRegistratedYesterdayTest() {
//		logger.info("getUserRegistratedToday()  ---------------------- START");
//		LocalDate date = LocalDate.now();
//		date = date.minusDays(1);
//		LocalDateTime start = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0, 0);
//		LocalDateTime end = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 23, 59, 59);
//		Long objL = 1L;
//		long l = objL;
//		
//		when(this.userRepository.getUserRegdateInPeriod(start, end )).thenReturn(l);
//		ResponseEntity<Long> responseEntity = this.userController.getUserRegistratedYesterday();
//		Assert.assertEquals( HttpStatus.OK, responseEntity.getStatusCode());
//		assertTrue(((Long)responseEntity.getBody()).equals(l));
//		logger.info("getUserRegistratedToday()  ---------------------- end");
//	}
//	
//	@Test
//	public void getUserRegistratedLastSevenDaysTest() {
//		logger.info("getUserRegistratedLastSevenDays()  ---------------------- START");
//		LocalDate date = LocalDate.now();
//		LocalDateTime start = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0, 0);
//		LocalDateTime end = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 23, 59, 59);
//		Long objL = 1L;
//		long l = objL;
//		
//		when(this.userRepository.getUserRegdateInPeriod(start, end)).thenReturn(l);
//		ResponseEntity<Long> responseEntity = this.userController. getUserRegistratedLastSevenDays();
//		Assert.assertEquals( HttpStatus.OK, responseEntity.getStatusCode());
//		assertTrue(((Long)responseEntity.getBody()).equals(l));	
//		logger.info("getUserRegistratedLastSevenDays()  ---------------------- end");
//	}
//	@Test
//	public void  getUserRegistratedLastWeekTest() {
//		logger.info("getUserRegistratedLastWeek()  ---------------------- START");
//		LocalDate date = LocalDate.now();
//		date = date.minusDays(7);
//		LocalDateTime start = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0, 0);
//		LocalDateTime end = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 23, 59, 59);
//		Long objL = 1L;
//		long l = objL;	
//		when(this.userRepository.getUserRegdateInPeriod(start, end)).thenReturn(l);
//		ResponseEntity<Long> responseEntity = this.userController.getUserRegistratedLastWeek();
//		Assert.assertEquals( HttpStatus.OK, responseEntity.getStatusCode());
//		assertTrue(((Long)responseEntity.getBody()).equals(l));
//		logger.info("getUserRegistratedLastWeek()  ---------------------- end");
//	}
}
