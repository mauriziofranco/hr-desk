package franco.maurizio.hr.desk.com.persistence.entity.custom;

import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;

/**
 * 
 * ListedCandidateCustom is the custom class that used to provide list of objects in the different candidates lists visualization.
 * 
 * @author m.franco
 *
 */
public class ListedCandidateCustom extends CeReProAbstractEntity {

	protected Long id;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String candidateStatusColor;
	protected String candidateSatusLabel;
	protected String imgpath;
	protected String cvExternalPath;
	protected Long insertedBy;
	protected String insertedByFirstname;
	protected String insertedByLastname;	

	public ListedCandidateCustom() {

	}
	
	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param candidateStatusColor
	 * @param candidateSatusLabel
	 * @param imgpath
	 * @param cvExternalPath
	 * @param insertedBy
	 * @param insertedByFirstname
	 * @param insertedByLastname
	 */
	public ListedCandidateCustom(Long id, String firstname, String lastname, String email, String candidateStatusColor,
			String candidateSatusLabel, String imgpath, String cvExternalPath, Long insertedBy,
			String insertedByFirstname, String insertedByLastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.candidateStatusColor = candidateStatusColor;
		this.candidateSatusLabel = candidateSatusLabel;
		this.imgpath = imgpath;
		this.cvExternalPath = cvExternalPath;
		this.insertedBy = insertedBy;
		this.insertedByFirstname = insertedByFirstname;
		this.insertedByLastname = insertedByLastname;
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
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
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the candidateStatusColor
	 */
	public String getCandidateStatusColor() {
		return candidateStatusColor;
	}

	/**
	 * @param candidateStatusColor the candidateStatusColor to set
	 */
	public void setCandidateStatusColor(String candidateStatusColor) {
		this.candidateStatusColor = candidateStatusColor;
	}

	/**
	 * @return the candidateSatusLabel
	 */
	public String getCandidateSatusLabel() {
		return candidateSatusLabel;
	}

	/**
	 * @param candidateSatusLabel the candidateSatusLabel to set
	 */
	public void setCandidateSatusLabel(String candidateSatusLabel) {
		this.candidateSatusLabel = candidateSatusLabel;
	}

	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}

	/**
	 * @param imgpath the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	/**
	 * @return the cvExternalPath
	 */
	public String getCvExternalPath() {
		return cvExternalPath;
	}

	/**
	 * @param cvExternalPath the cvExternalPath to set
	 */
	public void setCvExternalPath(String cvExternalPath) {
		this.cvExternalPath = cvExternalPath;
	}

	/**
	 * @return the insertedBy
	 */
	public Long getInsertedBy() {
		return insertedBy;
	}

	/**
	 * @param insertedBy the insertedBy to set
	 */
	public void setInsertedBy(Long insertedBy) {
		this.insertedBy = insertedBy;
	}

	/**
	 * @return the insertedByFirstname
	 */
	public String getInsertedByFirstname() {
		return insertedByFirstname;
	}

	/**
	 * @param insertedByFirstname the insertedByFirstname to set
	 */
	public void setInsertedByFirstname(String insertedByFirstname) {
		this.insertedByFirstname = insertedByFirstname;
	}

	/**
	 * @return the insertedByLastname
	 */
	public String getInsertedByLastname() {
		return insertedByLastname;
	}

	/**
	 * @param insertedByLastname the insertedByLastname to set
	 */
	public void setInsertedByLastname(String insertedByLastname) {
		this.insertedByLastname = insertedByLastname;
	}

	@Override
	public String toString() {
		return "ListedCandidateCustom [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", candidateStatusColor=" + candidateStatusColor + ", candidateSatusLabel="
				+ candidateSatusLabel + ", imgpath=" + imgpath + ", cvExternalPath=" + cvExternalPath + ", insertedBy="
				+ insertedBy + ", insertedByFirstname=" + insertedByFirstname + ", insertedByLastname="
				+ insertedByLastname + "]";
	}

}
