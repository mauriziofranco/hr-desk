package franco.maurizio.hr.desk.com.backend;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import franco.maurizio.hr.desk.com.persistence.entity.custom.CoursePageCustom;
import franco.maurizio.hr.desk.com.service.CoursePageService;

/**
 * 
 * 
 * @author 
 *
 */

@RestController
@RequestMapping("/api/v1/coursepagecustom")
public class CoursePageCustomController {
	
	public static final Logger logger = LoggerFactory.getLogger(CoursePageCustomController.class);

	@Autowired
	private CoursePageService coursePageService;

	@GetMapping("/")
	public ResponseEntity<List<CoursePageCustom>> listAllCoursePageCustom() {
		
		List<CoursePageCustom> coursePages = coursePageService.getAllCoursePageCustom();
		for (CoursePageCustom current : coursePages) {
			logger.info(current.toString());
		}

		if (coursePages.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(coursePages, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CoursePageCustom> getCoursePageCustomById(@PathVariable final Long id) {
		CoursePageCustom coursePages = coursePageService.getCoursePageCustomById(id);
		

		if (coursePages == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(coursePages, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CoursePageCustom> updateCoursePageCustomById(@PathVariable final Long id,@RequestBody CoursePageCustom coursePageCustom) {
		CoursePageCustom coursePageC = coursePageService.updateCoursePageCustom(id, coursePageCustom);
		
		if (coursePageC == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(coursePageC, HttpStatus.OK);
	}
	
//	@GetMapping("/bydate/")
//	public ResponseEntity<List<CoursePageCustom>> listAllCoursePageCustomByDate() {
//		
//		List<CoursePageCustom> coursePages = coursePageService.getAllCoursePageCustomByDate();
//		for (CoursePageCustom current : coursePages) {
//			logger.info(current.toString());
//		}
//
//		if (coursePages.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//		return new ResponseEntity<>(coursePages, HttpStatus.OK);
//	}
	
}
