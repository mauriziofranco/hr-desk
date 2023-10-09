/**
 * 
 */
package franco.maurizio.hr.desk.com.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import franco.maurizio.hr.desk.com.persistence.entity.CandidateStates;

/**
 * 
 * @author Sebastiano Varchetta
 */
public interface CandidateStatesRepository extends JpaRepository<CandidateStates, Long>{
		CandidateStates findByRoleId(Long id);
		CandidateStates findByStatusCode(int statusCode);
		CandidateStates findByStatusLabel(String statusLabel);
		CandidateStates findByStatusDescription(String statusDescription);
		CandidateStates findByStatusColor(String statusColor);
		
}
