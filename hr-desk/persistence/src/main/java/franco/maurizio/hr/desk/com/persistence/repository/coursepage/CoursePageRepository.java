package franco.maurizio.hr.desk.com.persistence.repository.coursepage;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.CoursePage;

/**
 * @author TraianC - Milano Centauri Academy III
 * @author giacomo
 * @author
 * 
 */

@Repository
public interface CoursePageRepository extends JpaRepository<CoursePage, Long>, CoursePageRepositoryCustom {

	List<CoursePage> findByFileName(String fileName);

	List<CoursePage> findByTitle(String title);

	CoursePage findByCode(String code);

	@Transactional
	@Modifying
	@Query("UPDATE CoursePage c SET c.title = :title, c.bodyText = :bodyText, c.fileName = :fileName, c.code = :code, c.opened_by = :openedBy, c.created_datetime = :createdDatetime, c.statusOpen = :statusOpen WHERE c.id = :id")
	void updateCoursePage(@Param("id") long id, @Param("title") String title, @Param("bodyText") String bodyText,
			@Param("fileName") String fileName, @Param("code") String code, @Param("openedBy") long openedBy,
			@Param("createdDatetime") LocalDateTime createdDatetime, @Param("statusOpen") boolean statusOpen);

}
