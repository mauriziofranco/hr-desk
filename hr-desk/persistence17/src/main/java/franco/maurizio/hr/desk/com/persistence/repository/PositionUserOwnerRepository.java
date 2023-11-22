package franco.maurizio.hr.desk.com.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.PositionUserOwner;

/**
 * 
 * @author m.peruzza@proximanetwork.it
 *
 */

@Repository
public interface PositionUserOwnerRepository extends JpaRepository<PositionUserOwner, Long>{
	
	
	Optional <PositionUserOwner> findByCoursePageId(long course_page_id);

}
