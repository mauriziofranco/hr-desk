package franco.maurizio.hr.desk.com.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * @author TraianC - Milano Centauri Academy III
 * @author giacomo
 * 
 */

@Entity
@Table(name ="coursepage")

public class CoursePage extends CeReProAbstractEntity {
	
	public final static String GENERIC_CANDIDATURE_CODE = "MIGEN01" ;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	protected Long id;
	
	@Length(max = 1000, message = "error.coursepage.title.length")
	@Column(name ="title")
	protected String title;
	
	@NotEmpty(message = "error.coursepage.bodyText.empty")
	@Length(max = 50000, message = "error.coursepage.bodyText.length")
	@Column(name ="body_text")
	protected String bodyText;
	
	@Length(max = 300, message = "error.coursepage.fileName.length")
	@Column(name ="file_name")
	protected String fileName;
	
	@Length(max = 50, message = "error.coursepage.code.length")
	@Column(name ="code")
	protected String code;
	
	@Column(name ="opened_by")
	protected Long opened_by;
	
	@Column(name="created_datetime")
	private LocalDateTime created_datetime;
	
	@Column(name="status_open")
	private Boolean statusOpen;

	public CoursePage(Long id, String bodyText, String fileName, String title,Long opened_by) {
		this.id = id;
		this.bodyText = bodyText;
		this.title=title;
		this.fileName = fileName;
		this.opened_by = opened_by;
		this.created_datetime = LocalDateTime.now();
	}
	
	public CoursePage(Long id, String bodyText, String fileName, String title, String code,Long opened_by) {
		this.id = id;
		this.bodyText = bodyText;
		this.title=title;
		this.fileName = fileName;
		this.code = code;
		this.opened_by = opened_by;
		this.created_datetime = LocalDateTime.now();
	}
	
	public CoursePage(String bodyText, String fileName, String title,Long opened_by) {
		this.bodyText = bodyText;
		this.fileName = fileName;
		this.title=title;
		this.opened_by = opened_by;
		this.created_datetime = LocalDateTime.now();
	}

	public CoursePage() {
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
	 * @return the bodyText
	 */
	public String getBodyText() {
		return bodyText;
	}

	/**
	 * @param bodyText the bodyText to set
	 */
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public Long getOpened_by() {
		return opened_by;
	}

	public void setOpened_by(Long opened_by) {
		this.opened_by = opened_by;
	}

	public LocalDateTime getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(LocalDateTime created_datetime) {
		this.created_datetime = created_datetime;
	}
	
	public Boolean getStatusOpen() {
		return statusOpen;
	}

	public void setStatusOpen(Boolean statusOpen) {
		this.statusOpen = statusOpen;
	}

	@Override
	public String toString() {
		return "CoursePage [id=" + id + ", title=" + title + ", bodyText=" + bodyText + ", fileName=" + fileName
				+ ", code=" + code + ", opened_by=" + opened_by + ", created_datetime=" + created_datetime + "]";
	}

}
