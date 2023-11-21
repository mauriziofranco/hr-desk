package franco.maurizio.hr.desk.com.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Question
 * 
 * This is the entity that maps table questions.
 * 
 * @author daniele piccinni
 * @author maurizio.franco@ymail.com
 *
 */

@Entity
@Table(name = "questions")
public class Question extends CeReProAbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "error.question.label.notnull")
	@Length(min = 3, max = 500, message = "error.question.label.length")
	private String label;

	@Length(max = 3000, message = "error.question.description.length")
	private String description;

	@Length(max = 250, message = "error.question.answer.length")
	private String ansa;

	@Length(max = 250, message = "error.question.answer.length")
	private String ansb;

	@Length(max = 250, message = "error.question.answer.length")
	private String ansc;

	@Length(max = 250, message = "error.question.answer.length")
	private String ansd;

	@Length(max = 250, message = "error.question.answer.length")
	private String anse;

	@Length(max = 250, message = "error.question.answer.length")
	private String ansf;

	@Length(max = 250, message = "error.question.answer.length")
	private String ansg;

	@Length(max = 250, message = "error.question.answer.length")
	private String ansh;

	private Boolean cansa;
	private Boolean cansb;
	private Boolean cansc;
	private Boolean cansd;
	private Boolean canse;
	private Boolean cansf;
	private Boolean cansg;
	private Boolean cansh;

	@Length(max = 3000, message = "error.question.fullanswer.length")
//	@Column(name = "full_answer")
	private String fullAnswer;

////	costruttori
	public Question(Long id, String label, String description, String ansa, Boolean cansa) {
		this();
		this.id = id;
		this.label = label;
		this.description = description;
		this.ansa = ansa;
		this.cansa = cansa;
	}

	public Question(Long id, String label, String description) {
		this();
		this.id = id;
		this.label = label;
		this.description = description;
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
	public Question(Long id,
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
			@Length(max = 3000, message = "error.question.fullanswer.length") String fullAnswer) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.ansa = ansa;
		this.ansb = ansb;
		this.ansc = ansc;
		this.ansd = ansd;
		this.anse = anse;
		this.ansf = ansf;
		this.ansg = ansg;
		this.ansh = ansh;
		this.cansa = cansa;
		this.cansb = cansb;
		this.cansc = cansc;
		this.cansd = cansd;
		this.canse = canse;
		this.cansf = cansf;
		this.cansg = cansg;
		this.cansh = cansh;
		this.fullAnswer = fullAnswer;
	}

	public Question(long id, String label) {
		this();
		this.id = id;
		this.label = label;
	}

	public Question(String label) {
		this();
		this.label = label;
	}

	public Question() {

	}

	// getters and setters
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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ansa
	 */
	public String getAnsa() {
		return ansa;
	}

	/**
	 * @param ansa the ansa to set
	 */
	public void setAnsa(String ansa) {
		this.ansa = ansa;
	}

	/**
	 * @return the ansb
	 */
	public String getAnsb() {
		return ansb;
	}

	/**
	 * @param ansb the ansb to set
	 */
	public void setAnsb(String ansb) {
		this.ansb = ansb;
	}

	/**
	 * @return the ansc
	 */
	public String getAnsc() {
		return ansc;
	}

	/**
	 * @param ansc the ansc to set
	 */
	public void setAnsc(String ansc) {
		this.ansc = ansc;
	}

	/**
	 * @return the ansd
	 */
	public String getAnsd() {
		return ansd;
	}

	/**
	 * @param ansd the ansd to set
	 */
	public void setAnsd(String ansd) {
		this.ansd = ansd;
	}

	/**
	 * @return the anse
	 */
	public String getAnse() {
		return anse;
	}

	/**
	 * @param anse the anse to set
	 */
	public void setAnse(String anse) {
		this.anse = anse;
	}

	/**
	 * @return the ansf
	 */
	public String getAnsf() {
		return ansf;
	}

	/**
	 * @param ansf the ansf to set
	 */
	public void setAnsf(String ansf) {
		this.ansf = ansf;
	}

	/**
	 * @return the ansg
	 */
	public String getAnsg() {
		return ansg;
	}

	/**
	 * @param ansg the ansg to set
	 */
	public void setAnsg(String ansg) {
		this.ansg = ansg;
	}

	/**
	 * @return the ansh
	 */
	public String getAnsh() {
		return ansh;
	}

	/**
	 * @param ansh the ansh to set
	 */
	public void setAnsh(String ansh) {
		this.ansh = ansh;
	}

	/**
	 * @return the cansa
	 */
	public Boolean getCansa() {
		return cansa;
	}

	/**
	 * @param cansa the cansa to set
	 */
	public void setCansa(Boolean cansa) {
		this.cansa = cansa;
	}

	/**
	 * @return the cansb
	 */
	public Boolean getCansb() {
		return cansb;
	}

	/**
	 * @param cansb the cansb to set
	 */
	public void setCansb(Boolean cansb) {
		this.cansb = cansb;
	}

	/**
	 * @return the cansc
	 */
	public Boolean getCansc() {
		return cansc;
	}

	/**
	 * @param cansc the cansc to set
	 */
	public void setCansc(Boolean cansc) {
		this.cansc = cansc;
	}

	/**
	 * @return the cansd
	 */
	public Boolean getCansd() {
		return cansd;
	}

	/**
	 * @param cansd the cansd to set
	 */
	public void setCansd(Boolean cansd) {
		this.cansd = cansd;
	}

	/**
	 * @return the canse
	 */
	public Boolean getCanse() {
		return canse;
	}

	/**
	 * @param canse the canse to set
	 */
	public void setCanse(Boolean canse) {
		this.canse = canse;
	}

	/**
	 * @return the cansf
	 */
	public Boolean getCansf() {
		return cansf;
	}

	/**
	 * @param cansf the cansf to set
	 */
	public void setCansf(Boolean cansf) {
		this.cansf = cansf;
	}

	/**
	 * @return the cansg
	 */
	public Boolean getCansg() {
		return cansg;
	}

	/**
	 * @param cansg the cansg to set
	 */
	public void setCansg(Boolean cansg) {
		this.cansg = cansg;
	}

	/**
	 * @return the cansh
	 */
	public Boolean getCansh() {
		return cansh;
	}

	/**
	 * @param cansh the cansh to set
	 */
	public void setCansh(Boolean cansh) {
		this.cansh = cansh;
	}

	/**
	 * @return the fullAnswer
	 */
	public String getFullAnswer() {
		return fullAnswer;
	}

	/**
	 * @param fullAnswer the fullAnswer to set
	 */
	public void setFullAnswer(String fullAnswer) {
		this.fullAnswer = fullAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", label=" + label + ", description=" + description + ", ansa=" + ansa + ", ansb="
				+ ansb + ", ansc=" + ansc + ", ansd=" + ansd + ", anse=" + anse + ", ansf=" + ansf + ", ansg=" + ansg
				+ ", ansh=" + ansh + ", cansa=" + cansa + ", cansb=" + cansb + ", cansc=" + cansc + ", cansd=" + cansd
				+ ", canse=" + canse + ", cansf=" + cansf + ", cansg=" + cansg + ", cansh=" + cansh + ", fullAnswer="
				+ fullAnswer + "]";
	}

}
