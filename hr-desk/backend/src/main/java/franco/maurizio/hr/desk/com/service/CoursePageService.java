package franco.maurizio.hr.desk.com.service;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import franco.maurizio.hr.desk.com.backend.CandidateSurveyTokenController;
import franco.maurizio.hr.desk.com.mail.manager.MailUtility;
import franco.maurizio.hr.desk.com.persistence.entity.CoursePage;
import franco.maurizio.hr.desk.com.persistence.entity.PositionUserOwner;
import franco.maurizio.hr.desk.com.persistence.entity.User;
import franco.maurizio.hr.desk.com.persistence.entity.custom.CoursePageCustom;
import franco.maurizio.hr.desk.com.persistence.repository.PositionUserOwnerRepository;
import franco.maurizio.hr.desk.com.persistence.repository.UserRepository;
import franco.maurizio.hr.desk.com.persistence.repository.coursepage.CoursePageRepository;
import franco.maurizio.hr.desk.com.persistence.repository.coursepage.CoursePageRepositoryCustom;
import franco.maurizio.hr.desk.com.service.exception.PositionCodeNotFoundException;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class CoursePageService {
	public static final Logger logger = LoggerFactory.getLogger(CoursePageService.class);
	
	@Value("${app.runtime.environment}")
	private String runtimeEnvironment ;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CoursePageRepository coursePageRepository;

//	@Autowired
//	private CoursePageRepositoryCustom coursePageRepositoryCustom;

	@Autowired
	PositionUserOwnerRepository positionUserOwnerRepository;

	@Autowired
	UserRepository userRepository;

	public CoursePageCustom insertCoursePageCustom(CoursePageCustom cpc) {
		CoursePage cp = new CoursePage();
		cp.setBodyText(cpc.getBodyText());
		cp.setCode(cpc.getCode());
		cp.setFileName(cpc.getFileName());
		cp.setTitle(cpc.getTitle());
		cp.setOpened_by(cpc.getOpened_by());
		cp.setCreated_datetime(LocalDateTime.now());
		CoursePage dbcp = coursePageRepository.save(cp);
		cpc.setId(cp.getId());
		PositionUserOwner puo = new PositionUserOwner();
		puo.setCoursePageId(dbcp.getId());
		puo.setUserId(cpc.getUserId());
		positionUserOwnerRepository.save(puo);
		User u = userRepository.getById(cpc.getUserId());
		cpc.setCoursePageOwnerFirstname(u.getFirstname());
		cpc.setCoursePageOwnerLastname(u.getLastname());
		User u2 = userRepository.getById(cpc.getOpened_by());
		cpc.setCoursePageFirstNameOpenedBy(u2.getFirstname());
		cpc.setCoursePageLastNameOpenedBy(u2.getLastname());
		boolean value = sendEmail(u2.getFirstname(), u2.getLastname(), u.getEmail(), cp.getTitle(), cpc.getCode());
		logger.info("SEND EMAIL END" + value);
		return cpc;
	}

	public boolean sendEmail(String firstname, String lastname, String email, String title, String positionCode) {
		logger.info("sendEmail - START - firstname={}, lastname={}, email={}, title={}, positionCode={}", firstname, lastname, email, title, positionCode);
		boolean value = false;
		String[] emails = new String[1]; 
		emails[0] = email;
		try {
			String messageBody = messageSource.getMessage("mail.coursepage.messageBody",null, Locale.getDefault());
			messageBody = messageBody.replaceAll("XYZ", firstname + " " + lastname);
			messageBody = messageBody.replaceAll("ABC", title);
			String link = messageSource.getMessage("mail.coursepage.link",null, Locale.getDefault());
			link = link.replaceAll("YYY", runtimeEnvironment);
			link = link.replaceAll("ABC", positionCode);
			String subject = messageSource.getMessage("mail.coursepage.subject",null, Locale.getDefault());
			String signature = messageSource.getMessage("mail.coursepage.signature",null, Locale.getDefault());
			String message = messageBody + link + signature;
			logger.info("sendEmail - DEBUG - emails={}, subject={}, message={}", emails, subject, message);
			value = MailUtility.sendSimpleMailWithDefaultCcAndCcn(emails, subject, message);
			logger.info("sendEmail - DEBUG - value={}"); 
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return value;
		}
	}

	public CoursePage getCoursePageByCode(String code) {
		return coursePageRepository.findByCode(code);
	}

	public List<CoursePageCustom> getAllCoursePageCustom() {

		List<CoursePageCustom> coursePageFilled = coursePageRepository.findAllCustom();

		for (CoursePageCustom c : coursePageFilled) {

			logger.info("--------------------------------" + c);
		}

//		Collections.sort(coursePageFilled, new Comparator<CoursePageCustom>() {
//			public int compare(CoursePageCustom c1, CoursePageCustom c2) {
//				return (int) (c1.getId() - c2.getId());
//			}
//		});

		return coursePageFilled;
	}
	
	public CoursePageCustom getCoursePageCustomById(Long id) {
		CoursePage coursePage = coursePageRepository.getById(id);
		PositionUserOwner userOwner = positionUserOwnerRepository.findByCoursePageId(coursePage.getId()).get();
		User u = userRepository.getById(userOwner.getUserId());
		User u2 = userRepository.getById(coursePage.getOpened_by());
		CoursePageCustom coursePageCustom = new CoursePageCustom();
		coursePageCustom.setId(coursePage.getId());
		coursePageCustom.setTitle(coursePage.getTitle());
		coursePageCustom.setCode(coursePage.getCode());
		coursePageCustom.setBodyText(coursePage.getBodyText());
		coursePageCustom.setFileName(coursePage.getFileName());
		coursePageCustom.setOpened_by(coursePage.getOpened_by());
		coursePageCustom.setCreated_datetime(coursePage.getCreated_datetime());
		coursePageCustom.setCoursePageOwnerFirstname(u.getFirstname());
		coursePageCustom.setCoursePageOwnerLastname(u.getLastname());
		coursePageCustom.setCoursePageFirstNameOpenedBy(u2.getFirstname());
		coursePageCustom.setCoursePageLastNameOpenedBy(u2.getLastname());
		return coursePageCustom;
	}
	
	public CoursePageCustom updateCoursePageCustom(Long id,CoursePageCustom coursePageCustom) {
		logger.info("updateCoursePageCustom START - ");
		CoursePage coursePage = coursePageRepository.getById(id);
		PositionUserOwner userOwner = positionUserOwnerRepository.findByCoursePageId(coursePage.getId()).get();
		logger.info("updateCoursePageCustom get id UserOwner - " +coursePageCustom.getUserId());
		userOwner.setUserId(coursePageCustom.getUserId());
		positionUserOwnerRepository.deleteById(userOwner.getId());
		logger.info("updateCoursePageCustom delete UserOwner - " +userOwner);
		User u = userRepository.getById(userOwner.getUserId());
		User u2 = userRepository.getById(coursePage.getOpened_by());
//		coursePage.setId(coursePageCustom.getId());
//		coursePage.setTitle(coursePageCustom.getTitle());
//		coursePage.setCode(coursePageCustom.getCode());
//		coursePage.setBodyText(coursePageCustom.getBodyText());
//		coursePage.setFileName(coursePageCustom.getFileName());
//		coursePage.setOpened_by(coursePageCustom.getOpened_by());
//		coursePage.setCreated_datetime(coursePageCustom.getCreated_datetime());
//		coursePage.setStatusOpen(coursePageCustom.getStatusOpen());
		logger.info("START UPDATE ID : " + coursePageCustom.getId());
		coursePageRepository.updateCoursePage(coursePageCustom.getId(),
				coursePageCustom.getTitle(), 
				coursePageCustom.getBodyText(), 
				coursePageCustom.getFileName(),
				coursePageCustom.getCode(), 
				coursePageCustom.getOpened_by(),
				coursePageCustom.getCreated_datetime(),
				coursePageCustom.getStatusOpen());
//		coursePageCustom.setId(coursePage.getId());
//		coursePageCustom.setTitle(coursePage.getTitle());
//		coursePageCustom.setCode(coursePage.getCode());
//		coursePageCustom.setBodyText(coursePage.getBodyText());
//		coursePageCustom.setFileName(coursePage.getFileName());
//		coursePageCustom.setOpened_by(coursePage.getOpened_by());
//		coursePageCustom.setCreated_datetime(coursePage.getCreated_datetime());
//		coursePageCustom.setStatusOpen(coursePage.getStatusOpen());
		coursePageCustom.setCoursePageOwnerFirstname(u.getFirstname());
		coursePageCustom.setCoursePageOwnerLastname(u.getLastname());
		coursePageCustom.setCoursePageFirstNameOpenedBy(u2.getFirstname());
		coursePageCustom.setCoursePageLastNameOpenedBy(u2.getLastname());
		logger.info("updateCoursePageCustom save New UserOwner - " +userOwner);
		positionUserOwnerRepository.save(userOwner);
		
		logger.info("updateCoursePageCustom END - ");
		return coursePageCustom;
	}
	
	
	
//	public List<CoursePageCustom> getAllCoursePageCustomByDate() {
//	    List<CoursePageCustom> coursePageFilled = coursePageRepositoryCustom.findAllCustom();
//	    Collections.sort(coursePageFilled, new Comparator<CoursePageCustom>() {
//	        public int compare(CoursePageCustom c1, CoursePageCustom c2) {
//	            return c2.getCreated_datetime().compareTo(c1.getCreated_datetime());
//	        }
//	    });
//	    return coursePageFilled;
//	}

	/**
	 * Check if course_code exists into coursePage table If no, provides a default
	 * value.
	 * 
	 * @return a String representative of a valid position code
	 */
	public String checkCoursePageCode(String code) throws PositionCodeNotFoundException {
		logger.info("checkCoursePageCode START - code: " + code);
		if ((code == null) || (code.trim().length() == 0)) {
			throw new PositionCodeNotFoundException("Position code not found for given code: " + code) ;
		} else {
			CoursePage current = coursePageRepository.findByCode(code);
			if (current != null)
				return current.getCode();
			else
				throw new PositionCodeNotFoundException("Position code not found for given code: " + code) ;
		}
	}

	/**
	 * Try to delete all entities from course page table
	 */
	public void deleteAll() {
		logger.debug("deleteAll - START");
		coursePageRepository.deleteAll();
	}

}
