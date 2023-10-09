/**
 * 
 */
package franco.maurizio.hr.desk.com.persistence.entity.custom;

import java.time.LocalDateTime;

/**
 * 
 * 
 * Class that maps the user survey token single row output in UserSurveyToken
 * frontend table list
 * 
 * 
 * @author joffre
 *
 */
public class UserSurveyTokenCustom {

	private Long id;
	private Long userId;
	private String firstname;
	private String lastname;
	private String email;
	private Long surveyId;
	private String surveyLabel;
	private LocalDateTime expirationdate;
	private String generatedtoken;
	private boolean expired;

	public UserSurveyTokenCustom() {

	}

	public UserSurveyTokenCustom(Long id, Long userId, Long surveyId, String generatedtoken,
			LocalDateTime expirationdate, Boolean expired, String surveyLabel, String firstname, String lastname,
			String email) {
		this.id = id;
		this.userId = userId;
		this.surveyId = surveyId;
		this.generatedtoken = generatedtoken;
		this.expirationdate = expirationdate;
		this.expired = expired;
		this.surveyLabel = surveyLabel;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public UserSurveyTokenCustom(Long id, Long userId, Long surveyId, LocalDateTime expirationdate, String surveyLabel,
			String firstname, String lastname, String email) {
		this.id = id;
		this.userId = userId;
		this.surveyId = surveyId;
		this.expirationdate = expirationdate;
		this.surveyLabel = surveyLabel;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * @return the expirationdate
	 */
	public LocalDateTime getExpirationdate() {
		return expirationdate;
	}

	/**
	 * @param expirationdate the expirationdate to set
	 */
	public void setExpirationdate(LocalDateTime expirationdate) {
		this.expirationdate = expirationdate;
	}

	/**
	 * @return the generatedtoken
	 */
	public String getGeneratedtoken() {
		return generatedtoken;
	}

	/**
	 * @param generatedtoken the generatedtoken to set
	 */
	public void setGeneratedtoken(String generatedtoken) {
		this.generatedtoken = generatedtoken;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" -- userId: ").append(userId);
		sb.append(" - firstname: ").append(firstname);
		sb.append(" - lastname:  ").append(lastname);
		sb.append(" - email:  ").append(email);
		sb.append(" - surveyId:  ").append(surveyId);
		sb.append(" - surveyLabel:  ").append(surveyLabel);
		sb.append(" - expirationdate:  ").append(expirationdate);
		sb.append(" - generatedtoken:  ").append(generatedtoken);
		sb.append(" - expired:  ").append(expired);

		return sb.toString();
	}
}