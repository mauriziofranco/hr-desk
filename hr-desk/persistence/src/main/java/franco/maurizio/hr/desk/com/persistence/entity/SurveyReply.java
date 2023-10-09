package franco.maurizio.hr.desk.com.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the surveyreplies database table.
 * @author marcof
 *
 */

@Entity
@Table( name = "surveyreplies" )
public class SurveyReply extends CeReProAbstractEntity {

	/* ATTRIBUTI */
	@Id // specifca che fa riferimento ad un id, quindi un parametro che non sar� ripetuto nella tabella
	@GeneratedValue(strategy=GenerationType.IDENTITY) // ie auto increment
	private long id;
	
	@Column (name="survey_id") // specifico il nome della colonna a cui fa riferimeto questo oggetto, se i nomi coincidono non serve
	@NotNull(message = "error.surveyId.empty")
	private long surveyId;
	
	@Column (name="candidate_id") 
	@NotNull(message = "surveyreply.error.candidateId.empty")
	private long candidateId;
	
	@Column (name="starttime")
//	@NotNull(message = "error.starttime.empty")
	private LocalDateTime starttime;
	
	@Column (name="endtime")
//	@NotNull(message = "error.endtime.empty")
	private LocalDateTime endtime;
	
	@Column (name="answers")
	private String answers;
	
	@Column (name="pdffilename")
	private String pdffilename;
	
	@Column (name="points")
	private String points;
	
	@Column (name="generated_token")
	private String generated_token;
	/**
	 * @return the generated_token
	 */
	public String getGenerated_token() {
		return generated_token;
	}
	/**
	 * @param generated_token the generated_token to set
	 */
	public void setGenerated_token(String generated_token) {
		this.generated_token = generated_token;
	}
	/**
	 * @return the id
	 */
	
	/* METODI */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the surveyId
	 */
	public long getSurveyId() {
		return surveyId;
	}
	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}
	
	/**
	 * @return the starttime
	 */
	public LocalDateTime getStarttime() {
		return starttime;
	}
	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}
	/**
	 * @return the endtime
	 */
	public LocalDateTime getEndtime() {
		return endtime;
	}
	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(LocalDateTime endtime) {
		this.endtime = endtime;
	}
	/**
	 * @return the answers
	 */
	public String getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	/**
	 * @return the pdffilename
	 */
	public String getPdffilename() {
		return pdffilename;
	}
	/**
	 * @param pdffilename the pdffilename to set
	 */
	public void setPdffilename(String pdffilename) {
		this.pdffilename = pdffilename;
	}
	/**
	 * @return the points
	 */
	public String getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(String points) {
		this.points = points;
	}
	/**
	 * @return the candidateId
	 */
	public long getCandidateId() {
		return candidateId;
	}
	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	@Override
	public String toString() {
		return "SurveyReply [id=" + id + ", surveyId=" + surveyId + ", candidateId=" + candidateId + ", starttime="
				+ starttime + ", endtime=" + endtime + ", answers=" + answers + ", pdffilename=" + pdffilename
				+ ", points=" + points + "]";
	}

}