package franco.maurizio.hr.desk.com.persistence.repository.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.Question;

/**
 * QuestionRepository with SpringBoot
 * 
 * It allows the management of the question table, through insert, delete,
 * update and insert question
 * 
 * @author daniele piccinni
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>, QuestionRepositoryCustom {
	List<Question> findByLabel(String label);
	
	
}
