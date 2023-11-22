/**
 * 
 */
package franco.maurizio.hr.desk.com.persistence.entity.custom;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 
 * Class that maps the candidate survey token single row output in CandidateSurveyToken
 * frontend table list
 * 
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class CandidateSurveyTokenCustom {

	private Long id;
	private Long candidateId;
	private String firstname;
	private String lastname;
	private String email;
	private Long surveyId;
	private String surveyLabel;
	private LocalDateTime expirationDateTime;
	private String generatedToken;
	private boolean expired;
	private Long surveyReplyId;
	private String urlPdf;
	
	/**
	 * @param id
	 * @param candidateId
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param surveyId
	 * @param surveyLabel
	 * @param expirationDateTime
	 * @param generatedToken
	 * @param expired
	 * Long surveyReplyId;
	private String urlPdf
	 */
	public CandidateSurveyTokenCustom(Long id, Long candidateId, String firstname, String lastname, String email,
			Long surveyId, String surveyLabel, LocalDateTime expirationDateTime, String generatedToken,
			boolean expired, 
			Long surveyReplyId,
	String urlPdf) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.surveyId = surveyId;
		this.surveyLabel = surveyLabel;
		this.expirationDateTime = expirationDateTime;
		this.generatedToken = generatedToken;
		this.expired = expired;
		this.surveyReplyId = surveyReplyId;
		this.urlPdf = urlPdf;
	}
	
	/**
	 * @param id
	 * @param candidateId
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param surveyId
	 * @param surveyLabel
	 * @param expirationDateTime
	 * @param generatedToken
	 * @param expired
	 */
	public CandidateSurveyTokenCustom(Long id, Long candidateId, String firstname, String lastname, String email,
			Long surveyId, String surveyLabel, LocalDateTime expirationDateTime, String generatedToken,
			boolean expired) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.surveyId = surveyId;
		this.surveyLabel = surveyLabel;
		this.expirationDateTime = expirationDateTime;
		this.generatedToken = generatedToken;
		this.expired = expired;
	}

	/**
	 * @param id
	 * @param candidateId
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param surveyId
	 * @param surveyLabel
	 * @param expirationDateTime
	 * @param expired
	 */
	public CandidateSurveyTokenCustom(Long id, Long candidateId, String firstname, String lastname, String email,
			Long surveyId, String surveyLabel, LocalDateTime expirationDateTime, boolean expired) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.surveyId = surveyId;
		this.surveyLabel = surveyLabel;
		this.expirationDateTime = expirationDateTime;
		this.expired = expired;
	}

	/**
	 * 
	 */
	public CandidateSurveyTokenCustom() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	 * @return the candidateId
	 */
	public Long getCandidateId() {
		return candidateId;
	}

	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the surveyId
	 */
	public Long getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the surveyLabel
	 */
	public String getSurveyLabel() {
		return surveyLabel;
	}

	/**
	 * @param surveyLabel the surveyLabel to set
	 */
	public void setSurveyLabel(String surveyLabel) {
		this.surveyLabel = surveyLabel;
	}

	/**
	 * @return the expirationDateTime
	 */
	public LocalDateTime getExpirationDateTime() {
		return expirationDateTime;
	}

	/**
	 * @param expirationDateTime the expirationDateTime to set
	 */
	public void setExpirationDateTime(LocalDateTime expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}

	/**
	 * @return the generatedToken
	 */
	public String getGeneratedToken() {
		return generatedToken;
	}

	/**
	 * @param generatedToken the generatedToken to set
	 */
	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}

	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	/**
	 * @return the surveyReplyId
	 */
	public Long getSurveyReplyId() {
		return surveyReplyId;
	}

	/**
	 * @param surveyReplyId the surveyReplyId to set
	 */
	public void setSurveyReplyId(Long surveyReplyId) {
		this.surveyReplyId = surveyReplyId;
	}

	/**
	 * @return the urlPdf
	 */
	public String getUrlPdf() {
		return urlPdf;
	}

	/**
	 * @param urlPdf the urlPdf to set
	 */
	public void setUrlPdf(String urlPdf) {
		this.urlPdf = urlPdf;
	}

	@Override
	public String toString() {
		return "CandidateSurveyTokenCustom [id=" + id + ", candidateId="
				+ candidateId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", surveyId=" + surveyId
				+ ", surveyLabel=" + surveyLabel + ", expirationDateTime="
				+ expirationDateTime + ", generatedToken=" + generatedToken
				+ ", expired=" + expired + ", surveyReplyId=" + surveyReplyId
				+ ", urlPdf=" + urlPdf + "]";
	}

}