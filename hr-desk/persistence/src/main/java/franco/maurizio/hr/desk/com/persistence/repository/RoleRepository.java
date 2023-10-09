package franco.maurizio.hr.desk.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.Role;

/**
 * Provides a repository for the Role entity
 * 
 * @author Centauri Academy
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByLevel(int level);

}
