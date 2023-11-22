package franco.maurizio.hr.desk.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.Survey;


/**
 * Provides a repository for the Survey entity
 * 
 * @author Centauri Academy
 *
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
	
	

}