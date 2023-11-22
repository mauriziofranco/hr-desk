package franco.maurizio.hr.desk.com.persistence.entity.custom;

import java.time.LocalDate;

/**
 * @author m.franco
 *
 */
public class CandidateCustom extends ListedCandidateCustom {

	private String domicileCity;
	private String studyQualification;
	private Boolean graduate;
	private Boolean highGraduate;
	private Boolean stillHighStudy;
	private String mobile;
	private LocalDate dateOfBirth;
	private String courseCode;
	private String note;
	private String label;
	private Long candidateStatusCode;


	public CandidateCustom() {

	}

	public CandidateCustom(Long id, 
			               String domicileCity, 
			               String studyQualification,
			               Boolean graduate, 
			               Boolean highGraduate,
			               Boolean stillHighStudy, 
			               String mobile, 
			               String cvExternalPath, 
			               String email, 
			               String firstname,
			               String lastname, 
			               LocalDate dateOfBirth, 
			               String imgpath, 
			               String courseCode, 
			               String note,
			               String label,
			               Long candidateStatusCode,
			               String candidateStatusColor,
			               String candidateSatusLabel) {
		this.id = id;
		this.domicileCity = domicileCity;
		this.studyQualification = studyQualification;
		this.graduate = graduate;
		this.highGraduate = highGraduate;
		this.stillHighStudy = stillHighStudy;
		this.mobile = mobile;
		this.cvExternalPath = cvExternalPath;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.imgpath = imgpath;
		this.courseCode = courseCode;
		this.note = note;
		this.label = label;
		this.candidateStatusCode=candidateStatusCode;
		this.candidateStatusColor=candidateStatusColor;
		this.candidateSatusLabel=candidateSatusLabel;
	}

	/**
	 * @return the domicileCity
	 */
	public String getDomicileCity() {
		return domicileCity;
	}

	/**
	 * @param domicileCity the domicileCity to set
	 */
	public void setDomicileCity(String domicileCity) {
		this.domicileCity = domicileCity;
	}

	/**
	 * @return the studyQualification
	 */
	public String getStudyQualification() {
		return studyQualification;
	}

	/**
	 * @param studyQualification the studyQualification to set
	 */
	public void setStudyQualification(String studyQualification) {
		this.studyQualification = studyQualification;
	}

	/**
	 * @return the graduate
	 */
	public Boolean getGraduate() {
		return graduate;
	}

	/**
	 * @param graduate the graduate to set
	 */
	public void setGraduate(Boolean graduate) {
		this.graduate = graduate;
	}

	/**
	 * @return the highGraduate
	 */
	public Boolean getHighGraduate() {
		return highGraduate;
	}

	/**
	 * @param highGraduate the highGraduate to set
	 */
	public void setHighGraduate(Boolean highGraduate) {
		this.highGraduate = highGraduate;
	}

	/**
	 * @return the stillHighStudy
	 */
	public Boolean getStillHighStudy() {
		return stillHighStudy;
	}

	/**
	 * @param stillHighStudy the stillHighStudy to set
	 */
	public void setStillHighStudy(Boolean stillHighStudy) {
		this.stillHighStudy = stillHighStudy;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
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
	 * @return the candidateStatusCode
	 */
	public Long getCandidateStatusCode() {
		return candidateStatusCode;
	}

	/**
	 * @param candidateStatusCode the candidateStatusCode to set
	 */
	public void setCandidateStatusCode(Long candidateStatusCode) {
		this.candidateStatusCode = candidateStatusCode;
	}

	@Override
	public String toString() {
		return "CandidateCustom [domicileCity=" + domicileCity + ", studyQualification=" + studyQualification
				+ ", graduate=" + graduate + ", highGraduate=" + highGraduate + ", stillHighStudy=" + stillHighStudy
				+ ", mobile=" + mobile + ", dateOfBirth=" + dateOfBirth + ", courseCode=" + courseCode + ", note="
				+ note + ", label=" + label + ", candidateStatusCode=" + candidateStatusCode + "]";
	}

	
	
}
