package franco.maurizio.hr.desk.com.persistence.entity.custom;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import franco.maurizio.hr.desk.com.persistence.entity.Question;

/**
 * 
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class QuestionCustom extends Question {

	private Long position;
	

	public QuestionCustom() {

	}

	/**
	 * @param id
	 * @param label
	 * @param description
	 * @param ansa
	 * @param ansb
	 * @param ansc
	 * @param ansd
	 * @param anse
	 * @param ansf
	 * @param ansg
	 * @param ansh
	 * @param cansa
	 * @param cansb
	 * @param cansc
	 * @param cansd
	 * @param canse
	 * @param cansf
	 * @param cansg
	 * @param cansh
	 * @param fullAnswer
	 */
	public QuestionCustom(long id,
			@NotNull(message = "error.question.label.notnull") @Length(min = 3, max = 500, message = "error.question.label.length") String label,
			@Length(max = 3000, message = "error.question.description.length") String description,
			@Length(max = 250, message = "error.question.answer.length") String ansa,
			@Length(max = 250, message = "error.question.answer.length") String ansb,
			@Length(max = 250, message = "error.question.answer.length") String ansc,
			@Length(max = 250, message = "error.question.answer.length") String ansd,
			@Length(max = 250, message = "error.question.answer.length") String anse,
			@Length(max = 250, message = "error.question.answer.length") String ansf,
			@Length(max = 250, message = "error.question.answer.length") String ansg,
			@Length(max = 250, message = "error.question.answer.length") String ansh, Boolean cansa, Boolean cansb,
			Boolean cansc, Boolean cansd, Boolean canse, Boolean cansf, Boolean cansg, Boolean cansh,
			@Length(max = 3000, message = "error.question.fullanswer.length") String fullAnswer,
			Long position) {
		super(id, label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg, ansh, cansa, cansb, cansc, cansd, canse, cansf, cansg, cansh, fullAnswer);		
		this.position=position;
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

	@Override
	public String toString() {
		return "QuestionCustom [getId()=" + getId() + " position=" + position + ", getLabel()=" + getLabel()
				+ ", getDescription()=" + getDescription() + ", getAnsa()=" + getAnsa() + ", getAnsb()=" + getAnsb()
				+ ", getAnsc()=" + getAnsc() + ", getAnsd()=" + getAnsd() + ", getAnse()=" + getAnse() + ", getAnsf()="
				+ getAnsf() + ", getAnsg()=" + getAnsg() + ", getAnsh()=" + getAnsh() + ", getCansa()=" + getCansa()
				+ ", getCansb()=" + getCansb() + ", getCansc()=" + getCansc() + ", getCansd()=" + getCansd()
				+ ", getCanse()=" + getCanse() + ", getCansf()=" + getCansf() + ", getCansg()=" + getCansg()
				+ ", getCansh()=" + getCansh() + ", getFullAnswer()=" + getFullAnswer() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
