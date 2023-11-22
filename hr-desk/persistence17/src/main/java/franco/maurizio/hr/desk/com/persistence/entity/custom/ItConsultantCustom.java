package franco.maurizio.hr.desk.com.persistence.entity.custom;

import java.time.LocalDate;

import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;

/**
 * @author m.franco
 *
 */
public class ItConsultantCustom extends CeReProAbstractEntity {

	private Long id;
	private Long userId;
	private String domicileCity;
	private String domicileStreetName;
	private String domicileHouseNumber;
	private String studyQualification;
	private Boolean graduate;
	private Boolean highGraduate;
	private Boolean stillHighStudy;
	private String mobile;
	private String cvExternalPath;
	private String email;
	private String firstname;
	private String lastname;
	private LocalDate dateOfBirth;
	private String imgpath;

	public ItConsultantCustom() {

	}

	public ItConsultantCustom(Long id, Long userId, String domicileCity, String domicileStreetName,
			String domicileHouseNumber, String studyQualification, Boolean graduate, Boolean highGraduate,
			Boolean stillHighStudy, String mobile, String cvExternalPath, String email, String firstname,
			String lastname, LocalDate dateOfBirth, String imgpath) {
		this.id = id;
		this.userId = userId;
		this.domicileCity = domicileCity;
		this.domicileStreetName = domicileStreetName;
		this.domicileHouseNumber = domicileHouseNumber;
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
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the domicileCity
	 */
	public String getDomicileCity() {
		return domicileCity;
	}

	/**
	 * @param domicileCity
	 *            the domicileCity to set
	 */
	public void setDomicileCity(String domicileCity) {
		this.domicileCity = domicileCity;
	}

	/**
	 * @return the domicileStreetName
	 */
	public String getDomicileStreetName() {
		return domicileStreetName;
	}

	/**
	 * @param domicileStreetName
	 *            the domicileStreetName to set
	 */
	public void setDomicileStreetName(String domicileStreetName) {
		this.domicileStreetName = domicileStreetName;
	}

	/**
	 * @return the domicileHouseNumber
	 */
	public String getDomicileHouseNumber() {
		return domicileHouseNumber;
	}

	/**
	 * @param domicileHouseNumber
	 *            the domicileHouseNumber to set
	 */
	public void setDomicileHouseNumber(String domicileHouseNumber) {
		this.domicileHouseNumber = domicileHouseNumber;
	}

	/**
	 * @return the studyQualification
	 */
	public String getStudyQualification() {
		return studyQualification;
	}

	/**
	 * @param studyQualification
	 *            the studyQualification to set
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
	 * @param graduate
	 *            the graduate to set
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
	 * @param highGraduate
	 *            the highGraduate to set
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
	 * @param stillHighStudy
	 *            the stillHighStudy to set
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
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the cvExternalPath
	 */
	public String getCvExternalPath() {
		return cvExternalPath;
	}

	/**
	 * @param cvExternalPath
	 *            the cvExternalPath to set
	 */
	public void setCvExternalPath(String cvExternalPath) {
		this.cvExternalPath = cvExternalPath;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}

	/**
	 * @param imgpath
	 *            the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	/**
	 * Provides a full debug of the entity
	 * @return a string representation of the entity
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" -- userId: ").append(userId);
		sb.append(" -- domicile_city: ").append(domicileCity);
		sb.append(" -- domicile_street_name: ").append(domicileStreetName);
		sb.append(" -- domicile_house_number: ").append(domicileHouseNumber);
		sb.append(" -- study_qualification: ").append(studyQualification);
		sb.append(" -- graduate: ").append(graduate);
		sb.append(" -- high_graduate: ").append(highGraduate);
		sb.append(" -- still_high_study: ").append(stillHighStudy);
		sb.append(" -- mobile: ").append(mobile);
		sb.append(" -- cv_external_path: ").append(cvExternalPath);
		sb.append(" - firstname: ").append(firstname);
		sb.append(" - lastname:  ").append(lastname);
		sb.append(" - date of birth: ").append(dateOfBirth);
		sb.append(" - image path: ").append(imgpath);	
		return sb.toString();
	}

}
