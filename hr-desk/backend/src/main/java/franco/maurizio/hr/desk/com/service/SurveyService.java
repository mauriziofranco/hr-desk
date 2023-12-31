/**
 * 
 */
package franco.maurizio.hr.desk.com.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;
import franco.maurizio.hr.desk.com.rest.response.ResponseInterview;
import franco.maurizio.hr.desk.com.rest.response.ResponseQuestion;

/**
 * @author Marco Fulgosi
 *
 */
@Service 
public class SurveyService {
	public static final Logger log = LoggerFactory.getLogger(SurveyService.class);
	
	@Autowired
	private SurveyQuestionRepository surveyQuestionRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	/** 
	 * This method create a list of ResponseQuestion starting from the questions list whit the same surveyId 
	 * @deprecated -->nextly to remove 
	 */
	public List<ResponseQuestion> getAllResponseQuestionBySurveyId(long surveyId) {
		List<SurveyQuestion> listaSurveyQuestion = surveyQuestionRepository.findBySurveyId(surveyId);
		List<ResponseQuestion> listaResponseQuestion = new ArrayList<ResponseQuestion>();
		for (SurveyQuestion k : listaSurveyQuestion ) {
			
			ResponseQuestion rq = new ResponseQuestion();
			Question q = questionRepository.getById(k.getQuestionId());
			// TODO change getOne with findById....
			rq.setId(q.getId());
			rq.setLabel(q.getLabel());
			rq.setDescription(q.getDescription());
			rq.setAnsa(q.getAnsa());
			rq.setAnsb(q.getAnsb());
			rq.setAnsc(q.getAnsc());
			rq.setAnsd(q.getAnsd());
			rq.setAnse(q.getAnse());
			rq.setAnsf(q.getAnsf());
			rq.setAnsg(q.getAnsg());
			rq.setAnsh(q.getAnsh());
			
			listaResponseQuestion.add(rq);
			//TODO: extract in order by POSITION!!!!
		}
		return listaResponseQuestion;
	}
	
	/** 
	 * This method create a list of ResponseQuestion starting from the questions list whit the same surveyId 
	 * 
	 */
	public List<ResponseQuestion> getAllRelatedQuestionsBySurveyIdOrderedByPosition(long surveyId) {
		List<SurveyQuestion> listaSurveyQuestion = surveyQuestionRepository.findBySurveyIdOrderByPositionAsc(surveyId);
		List<ResponseQuestion> listaResponseQuestion = new ArrayList<ResponseQuestion>();
		for (SurveyQuestion k : listaSurveyQuestion ) {
			
			ResponseQuestion rq = new ResponseQuestion();
			Question q = questionRepository.getById(k.getQuestionId());
			// TODO change getOne with findById....
			rq.setId(q.getId());
			rq.setLabel(q.getLabel());
			rq.setDescription(q.getDescription());
			rq.setAnsa(q.getAnsa());
			rq.setAnsb(q.getAnsb());
			rq.setAnsc(q.getAnsc());
			rq.setAnsd(q.getAnsd());
			rq.setAnse(q.getAnse());
			rq.setAnsf(q.getAnsf());
			rq.setAnsg(q.getAnsg());
			rq.setAnsh(q.getAnsh());
			rq.setPosition(k.getPosition());
			listaResponseQuestion.add(rq);
			//TODO: extract in order by POSITION!!!!
		}
		return listaResponseQuestion;
	}
	
}
