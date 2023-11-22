package franco.maurizio.hr.desk.com.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


/**
 * 
 * Provides a survey representation.
 * It contains informations about title(label), description and end-time-survey(expressed in minutes) 
 * @author maurizio
 *
 */
@Entity
@Table(name = "surveys")
public class Survey extends CeReProAbstractEntity {

//	attributi
	
	@Id //specifies that this field is a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "error.survey.label.null")
	@NotEmpty(message = "error.survey.label.empty")
	@Column(name = "label")
	private String label;
	
	@Column(name = "time")
	private Long time;

	@Length(max = 100, message = "error.survey.description.length")
	@Column(name = "description")
	private String description;

	public Survey(Long id, String label, Long time, String description) {
		this.id = id;
		this.label = label;
		this.description = description;
		this.time = time;
	}
	
	public Survey(String label, Long time, String description) {
		this.label = label;
		this.description = description;
		this.time = time;
	}

	public Survey() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" - label: ").append(label);
		sb.append(" - time: ").append(time);
		sb.append(" - description: ").append(description);
		return sb.toString();
	}

}
