package centauri.academy.cerepro.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.entity.custom.QuestionCustom;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class QuestionService {

	public static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	QuestionRepository questionRepository;

	/**
	 * Provides list of question entities from repository
	 * 
	 * @return List<Question>, list of Question entity objects
	 */
	public List<Question> getAll() {
		logger.info("getAll - START");
		List<Question> items = questionRepository.findAll();
		logger.info("getAll - END - returning " + items.size() + " roles.");
		return items;
	}

	/**
	 * Provides list of question custom entities from survey id given
	 * 
	 * @return List<QuestionCustom>, list of QuestionCustom objects
	 */
	public List<QuestionCustom> getAllQuestionCustomListFromSurveyId(long surveyId) {
		logger.info("getAllQuestionCustomListFromSurveyId - START");
		List<QuestionCustom> items = questionRepository.findBySurveyId(surveyId);
		logger.info("getAllQuestionCustomListFromSurveyId - END - returning " + items.size() + " roles.");
		return items;
	}
	
	/**
	 * Provides to insert given question entity 
	 * 
	 * @return entity, Question entity just inserted
	 */
	public Question insert(Question entity) {
		logger.info("insert - START - entity: {}", entity);
		try {
			//change validateQuestion implementation!!!!!!
			Question currentQuestion = validateQuestion(new Question(), entity);
			Question insertedEntity = questionRepository.save(currentQuestion);
			logger.info("insert - END - returning inserted entity: {}" + insertedEntity);
			return insertedEntity;
		} catch (Exception e) {
			return null ;
		}
	}
	
	/**
	 * 
	 * In case of insert Ansa, Ansb, Ansc, ecc. could be null, so Exception is returned back...
	 * 
	 * @param currentQuestion is the question that will be returned with updated values
	 * @param question is where values are taken to update currentQuestion
	 * 
	 */
	private Question validateQuestion(Question currentQuestion, Question question) {
		currentQuestion.setLabel(question.getLabel());
		currentQuestion.setDescription(question.getDescription());
		currentQuestion.setFullAnswer(question.getFullAnswer());

		// Answer A
		if (!question.getAnsa().equals("")) {
			currentQuestion.setAnsa(question.getAnsa());
			currentQuestion.setCansa(question.getCansa());
		}

		// Answer B
		if (question.getAnsb()!=null &&
				!question.getAnsb().equals("")) {
			currentQuestion.setAnsb(question.getAnsb());
			currentQuestion.setCansb(question.getCansb());
		}

		// Answer C
		if (question.getAnsc()!=null &&
				!question.getAnsc().equals("")) {
			currentQuestion.setAnsc(question.getAnsc());
			currentQuestion.setCansc(question.getCansc());
		}

		// Answer D
		if (question.getAnsd()!=null &&
				!question.getAnsd().equals("")) {
			currentQuestion.setAnsd(question.getAnsd());
			currentQuestion.setCansd(question.getCansd());
		}

		// Answer E
		if (question.getAnse()!=null &&
				!question.getAnse().equals("")) {
			currentQuestion.setAnse(question.getAnse());
			currentQuestion.setCanse(question.getCanse());
		}

		// Answer F
		if (question.getAnsf()!=null &&
				!question.getAnsf().equals("")) {
			currentQuestion.setAnsf(question.getAnsf());
			currentQuestion.setCansf(question.getCansf());
		}

		// Answer G
		if (question.getAnsg()!=null &&
				!question.getAnsg().equals("")) {
			currentQuestion.setAnsg(question.getAnsg());
			currentQuestion.setCansg(question.getCansg());
		}

		// Answer H
		if (question.getAnsh()!=null &&
				!question.getAnsh().equals("")) {
			currentQuestion.setAnsh(question.getAnsh());
			currentQuestion.setCansh(question.getCansh());
		}

		return currentQuestion;
	}
	
}
