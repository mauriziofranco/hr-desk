package franco.maurizio.hr.desk.com.persistence.repository;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.User;

/**
 * UserRepository
 * 
 * @author joffre
 * @author anna
 * @author maurizio.franco@ymail.com
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	List <Optional <User>> findByRole(int role);
	
	@Transactional
	@Modifying
	@Query("UPDATE User SET enabled = :enabled WHERE id = :id")
	int updateEnabledById(@Param("id") long id, @Param("enabled") boolean enabled);

}