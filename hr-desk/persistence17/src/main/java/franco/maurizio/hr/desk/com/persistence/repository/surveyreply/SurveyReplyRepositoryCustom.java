package franco.maurizio.hr.desk.com.persistence.repository.surveyreply;


import java.time.LocalDate;

/**
 * SurveyReplyRepositoryCustom
 * 
 * Provides signs for custom implementation methods
 *
 */
public interface SurveyReplyRepositoryCustom  {

	long getSurveyReplyCountForDay(LocalDate day) ;
	
}
