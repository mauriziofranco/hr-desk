package franco.maurizio.hr.desk.com.persistence.entity.custom;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;

import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;

/**
 * The persistent class for the surveyreplies database table.
 * @author marcof
 *
 */
public class SurveyReplyCustom extends CeReProAbstractEntity {

	private LocalDate date;
	private long number;
	
	public SurveyReplyCustom (LocalDate date, long number) {
		this.date = date ;
		this.number = number ;
	}
	public SurveyReplyCustom () {}
	
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the number
	 */
	public long getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(long number) {
		this.number = number;
	}

	public String toString() {
		/* Method to transform my list of SQL objects into a string */
		StringBuilder sb = new StringBuilder();
		sb.append("# date: ").append(date);
		sb.append(" - number: ").append(number);
		return sb.toString();
	}

}