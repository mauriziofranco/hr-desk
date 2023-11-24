package franco.maurizio.hr.desk.com.unit.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.CeReProBackendApplication;
import franco.maurizio.hr.desk.com.persistence.entity.CoursePage;
import franco.maurizio.hr.desk.com.persistence.repository.coursepage.CoursePageRepository;
import franco.maurizio.hr.desk.com.service.CoursePageService;

/**
  * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CeReProBackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CoursePageServiceTest {

	public static final Logger logger = LoggerFactory.getLogger(CoursePageServiceTest.class);

//	@TestConfiguration
//    static class CoursePageServiceTestContextConfiguration {
//  
//        @Bean
//        CoursePageService coursePageService() {
//            return new CoursePageService();
//        }
//    }
 
    @Autowired
    private CoursePageService coursePageService;
 
    @MockBean
    private CoursePageRepository coursePageRepository;
 
    private final String TEST_CODE = "test_code" ;
    
    @BeforeEach
    public void initialize() {
        CoursePage currentEntity = new CoursePage();
        currentEntity.setCode(TEST_CODE);
     
        Mockito.when(coursePageRepository.findByCode(TEST_CODE))
          .thenReturn(currentEntity);
    }
    
    @Test
    public void whenValidCode_thenCoursePageShouldBeFound() {
    	CoursePage currentEntity = coursePageService.getCoursePageByCode(TEST_CODE);
      
        assertThat(currentEntity.getCode()).isEqualTo(TEST_CODE);
     }
}
