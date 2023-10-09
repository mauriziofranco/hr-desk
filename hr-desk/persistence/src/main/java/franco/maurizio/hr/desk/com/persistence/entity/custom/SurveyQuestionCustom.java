package franco.maurizio.hr.desk.com.persistence.entity.custom;


/**
 * 
 * Class that maps the survey question single row output in SurveyQuestion
 * frontend table list
 * 
 * @author joffre
 *
 */
public class SurveyQuestionCustom  {

	
	private Long id;
	private String surveyLabel;
	private String questionLabel;
	private Long surveyId;
	private Long questionId;
	private Long position;

	public SurveyQuestionCustom() {
		
	}
	public SurveyQuestionCustom(Long id, Long surveyId, Long questionId, Long position, String surveyLabel, String questionLabel) {
		this.id = id;
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.position = position;
		this.surveyLabel = surveyLabel;
		this.questionLabel = questionLabel;
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
	 * @return the questionLabel
	 */
	public String getQuestionLabel() {
		return questionLabel;
	}
	/**
	 * @param questionLabel the questionLabel to set
	 */
	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}
	/**
	 * Provides a full debug of the Entity
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append("surveyLabel: ").append(surveyLabel);
		sb.append("questionLabel: ").append(questionLabel);
		sb.append("surveyId: ").append(surveyId);
		sb.append("questionId: ").append(questionId);
		sb.append("position: ").append(position);
		return sb.toString();
	}

}
