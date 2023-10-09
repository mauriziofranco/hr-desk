package franco.maurizio.hr.desk.com.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * The persistence entity class for the candidatesurveytokens database table
 * 
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Entity
@Table( name = "candidatesurveytokens" )
public class CandidateSurveyToken extends CeReProAbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "error.candidatesurveytokens.candidateId.empty")	
	private Long candidateId ;
	
	@NotNull(message = "error.candidatesurveytokens.candidateId.empty")
	private Long surveyId ;
	
	@Size(max = 50)
	private String generatedToken ;
	
	private LocalDateTime expirationDateTime ;
	
	private boolean expired;
	
	/**
	 * @param id
	 * @param candidateId
	 * @param surveyId
	 * @param generatedToken
	 * @param expirationDateTime
	 * @param expired
	 */
	public CandidateSurveyToken(Long id,
			@NotNull(message = "error.candidatesurveytokens.candidateId.empty") Long candidateId,
			@NotNull(message = "error.candidatesurveytokens.candidateId.empty") Long surveyId,
			@Size(max = 50) String generatedToken, LocalDateTime expirationDateTime, boolean expired) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.surveyId = surveyId;
		this.generatedToken = generatedToken;
		this.expirationDateTime = expirationDateTime;
		this.expired = expired;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getGeneratedToken() {
		return generatedToken;
	}

	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}

	public LocalDateTime getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(LocalDateTime expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public CandidateSurveyToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CandidateSurveyToken [id=" + id + ", candidateId=" + candidateId + ", surveyId=" + surveyId
				+ ", generatedToken=" + generatedToken + ", expirationDateTime=" + expirationDateTime + ", expired="
				+ expired + "]";
	}
	
	
	
}
