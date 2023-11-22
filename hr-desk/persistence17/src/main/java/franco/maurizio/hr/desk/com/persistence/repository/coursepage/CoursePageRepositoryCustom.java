package franco.maurizio.hr.desk.com.persistence.repository.coursepage;

import java.util.List;

import franco.maurizio.hr.desk.com.persistence.entity.custom.CoursePageCustom;

/**
 * CoursePageRepositoryCustom
 * 
 * CoursePage table repository custom methods declaration
 * 
 * @author maurizio.franco@ymail.com
 *
 */


public interface CoursePageRepositoryCustom {
	
	
	List<CoursePageCustom> findAllCustom();
	
//	CoursePageCustom findById();
	
	
}
