package franco.maurizio.hr.desk.com.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author m.peruzza@proximanetwork.it
 *
 */

@Entity
@Table(name = "positionuserowner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PositionUserOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "error.positionuserowner.course_page_id.notnull")
	@Column(name = "course_page_id")
	private Long coursePageId;
	
	@NotNull(message = "error.positionuserowner.user_id.notnull")
	@Column(name = "user_id")
	private Long userId;

//	public PositionUserOwner(@NotNull(message = "error.positionuserowner.course_page_id.notnull") Long coursePageId,
//			@NotNull(message = "error.positionuserowner.user_id.notnull") Long userId) {
//		super();
//		this.coursePageId = coursePageId;
//		this.userId = userId;
//	}

//	public PositionUserOwner() {
//		super();
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Long getCoursePageId() {
//		return coursePageId;
//	}
//
//	public void setCoursePageId(Long coursePageId) {
//		this.coursePageId = coursePageId;
//	}
//
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
	
}
