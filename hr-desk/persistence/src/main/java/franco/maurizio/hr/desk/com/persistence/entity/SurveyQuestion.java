package franco.maurizio.hr.desk.com.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * 
 * @author anna
 *
 */
@Entity
@Table( name = "surveyquestions" )
public class SurveyQuestion extends CeReProAbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Long id;
	
	@NotNull(message="error.surveyquestion.surveyid.notnull")
	@Min(value=1, message="error.surveyquestion.surveyid.min")
	@Column(name = "survey_id")
	private Long surveyId;
	
	@NotNull(message="error.surveyquestion.questionid.notnull")
	@Min(value=1, message="error.surveyquestion.questionid.min")
	@Column(name = "question_id")
	private Long questionId;
	
	@Min(value=1, message="error.surveyquestion.position.min" )
	@Column(name = "position")
	private Long position;

	//costruttore vuoto
	public SurveyQuestion() {
		
	}
	public SurveyQuestion(Long id, Long surveyId, Long questionId, Long position) {
		this.id = id;
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.position = position;
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
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the position
	 */
	public Long getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Long position) {
		this.position = position;
	}
	/**
	 * Provides a full debug of the Entity
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append("surveyId: ").append(surveyId);
		sb.append("questionId: ").append(questionId);
		sb.append("position: ").append(position);
		return sb.toString();
	}

}
