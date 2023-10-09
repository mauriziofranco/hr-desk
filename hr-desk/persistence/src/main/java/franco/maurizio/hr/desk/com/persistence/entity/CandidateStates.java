/**
 * 
 */
package franco.maurizio.hr.desk.com.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * Provides candidate_states table mapping
 * 
 * @author maurizio.franco@ymail.com
 * 
 */

@Entity
@Table(name = "candidate_states")
public class CandidateStates extends CeReProAbstractEntity {
	
	public final static int DEFAULT_INSERTING_STATUS_CODE = 100 ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Long id;
	
	@NotNull(message="error.candidatestates.roleid.notnull")
	@Min(value=1, message="error.candidatestates.roleid.min")
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	@NotNull(message="error.candidatestates.statuscode.notnull")
	@Column(name = "STATUS_CODE")
	private int statusCode;
	
	
	@Column(name = "STATUS_LABEL")
	@Length(max = 100, message = "error.statuslabel.length")
	private String statusLabel;
	
	@Column(name = "STATUS_DESCRIPTION")
	@Length(max = 300, message = "error.statusdescription.length")
	private String  statusDescription;
	
	@Column(name = "STATUS_COLOR")
	@Length(max = 7, message = "error.statuscolor.length")
	private String statusColor;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusLabel
	 */
	public String getStatusLabel() {
		return statusLabel;
	}

	/**
	 * @param statusLabel the statusLabel to set
	 */
	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	/**
	 * @return the statusDescription
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * @param statusDescription the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 * @return the statusColor
	 */
	public String getStatusColor() {
		return statusColor;
	}

	/**
	 * @param statusColor the statusColor to set
	 */
	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}

	@Override
	public String toString() {
		return "CandidateStates [id=" + id + ", roleId=" + roleId + ", statusCode=" + statusCode + ", statusLabel="
				+ statusLabel + ", statusDescription=" + statusDescription + ", statusColor=" + statusColor + "]";
	}
    
}
