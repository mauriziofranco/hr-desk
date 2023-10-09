/**
 * 
 */
package franco.maurizio.hr.desk.com.persistence.entity.custom;

import franco.maurizio.hr.desk.com.persistence.entity.CoursePage;

/**
 * @author m.peruzza@proximanetwork.it
 *
 */

public class CoursePageCustom extends CoursePage {
	
	private Long userId ;
	
	private String coursePageOwnerFirstname ;
	
	private String coursePageOwnerLastname ;
	
	private String coursePageFirstNameOpenedBy;
	
	private String coursePageLastNameOpenedBy;
		
	public CoursePageCustom() {
		super();
	}
	
	public CoursePageCustom(Long id, String bodyText, String fileName, String title, String code,Long opened_by) {
		super(id, bodyText, fileName, title, code,opened_by);
	}

	public CoursePageCustom(Long id, String bodyText, String fileName, String title, String code, Long userId,
			String coursePageOwnerFirstname, String coursePageOwnerLastname,Long opened_by,String coursePageFirstNameOpenedBy,
			String coursePageLastNameOpenedBy) {
		super(id, bodyText, fileName, title, code,opened_by);
		this.userId = userId;
		this.coursePageOwnerFirstname = coursePageOwnerFirstname;
		this.coursePageOwnerLastname = coursePageOwnerLastname;
		this.coursePageFirstNameOpenedBy = coursePageFirstNameOpenedBy;
		this.coursePageLastNameOpenedBy = coursePageLastNameOpenedBy;
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
	 * @return the coursePageOwnerFirstname
	 */
	public String getCoursePageOwnerFirstname() {
		return coursePageOwnerFirstname;
	}

	/**
	 * @param coursePageOwnerFirstname the coursePageOwnerFirstname to set
	 */
	public void setCoursePageOwnerFirstname(String coursePageOwnerFirstname) {
		this.coursePageOwnerFirstname = coursePageOwnerFirstname;
	}

	/**
	 * @return the coursePageOwnerLastname
	 */
	public String getCoursePageOwnerLastname() {
		return coursePageOwnerLastname;
	}

	/**
	 * @param coursePageOwnerLastname the coursePageOwnerLastname to set
	 */
	public void setCoursePageOwnerLastname(String coursePageOwnerLastname) {
		this.coursePageOwnerLastname = coursePageOwnerLastname;
	}

	public String getCoursePageFirstNameOpenedBy() {
		return coursePageFirstNameOpenedBy;
	}

	public void setCoursePageFirstNameOpenedBy(String coursePageFirstNameOpenedBy) {
		this.coursePageFirstNameOpenedBy = coursePageFirstNameOpenedBy;
	}

	public String getCoursePageLastNameOpenedBy() {
		return coursePageLastNameOpenedBy;
	}

	public void setCoursePageLastNameOpenedBy(String coursePageLastNameOpenedBy) {
		this.coursePageLastNameOpenedBy = coursePageLastNameOpenedBy;
	}

	@Override
	public String toString() {
		return "CoursePageCustom [userId=" + userId + ", coursePageOwnerFirstname=" + coursePageOwnerFirstname
				+ ", coursePageOwnerLastname=" + coursePageOwnerLastname + ", getId()=" + getId() + ", getBodyText()="
				+ getBodyText() + ", getFileName()=" + getFileName() + ", getTitle()=" + getTitle() + ", getCode()="
				+ getCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
