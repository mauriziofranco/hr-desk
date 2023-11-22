package centauri.academy.cerepro.backend;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import centauri.academy.cerepro.service.QuestionService;
import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;
import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.entity.custom.CustomErrorType;
import franco.maurizio.hr.desk.com.persistence.repository.question.QuestionRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyquestion.SurveyQuestionRepository;

/**
 * controller class for question entity
 * 
 * @author daniele piccinni
 * @author Orlando Platì
 * @author maurizio.franco@ymail.com
 */
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
	public static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Value( "${error.question.creation.fails.message:Unable to create new question.}" )
	private String QUESTION_CREATION_FAILS_MESSAGE ;
	
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SurveyQuestionRepository surveyQuestionRepository;

	@GetMapping("/")
	public ResponseEntity<List<Question>> listAllQuestions() {
		List<Question> questions = questionService.getAll();
		if (questions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // code 204
		}
		return new ResponseEntity<>(questions, HttpStatus.OK); // code 200
	}

	@GetMapping("/{id}")
	public ResponseEntity<CeReProAbstractEntity> getQuestionById(@PathVariable("id") final Long id) {
		Optional<Question> optQ = questionRepository.findById(id);
		if (!optQ.isPresent()) {
			return new ResponseEntity<>(new CustomErrorType("Question with id " + id + " not found"),
					HttpStatus.NOT_FOUND); // code 404
		}
		return new ResponseEntity<>(optQ.get(), HttpStatus.OK); // code 200
	}

	// method to create a question
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CeReProAbstractEntity> createQuestion(@Valid @RequestBody final Question question) {
		logger.info("Creating question : {}", question);		
		Question insertedEntity = questionService.insert(question);
		if (insertedEntity!= null)
				return new ResponseEntity<>(question, HttpStatus.CREATED); //code 201
		else return new ResponseEntity<>(
				new CustomErrorType(
						QUESTION_CREATION_FAILS_MESSAGE),
				HttpStatus.BAD_REQUEST);//400
	}

//	// method to update an existing question
//	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<CeReProAbstractEntity> updateQuestion(@PathVariable("id") final Long id,
//			@RequestBody Question question) {
//		// fetch question based on id and set it to currentQuestion object of type
//		// QuestionDTO
//		Optional<Question> optQuestion = questionRepository.findById(id);
//		if (!optQuestion.isPresent()) {
//			return new ResponseEntity<>(new CustomErrorType("Unable to upate. Question with id " + id + " not found."),
//					HttpStatus.NOT_FOUND); // code 404
//		} else {
//			List<SurveyQuestion> sqs = surveyQuestionRepository.findByQuestionId(id);
//			if (sqs.isEmpty()) {
//				Question currentQuestion = optQuestion.get();
//				// update currentQuestion object data with question object data
//				currentQuestion = validateQuestion(currentQuestion, question);
//				// save currentQuestion obejct
//				questionRepository.saveAndFlush(currentQuestion);
//				// return ResponseEntity object
//				return new ResponseEntity<>(currentQuestion, HttpStatus.OK); // code 200
//			} else {
//				return new ResponseEntity<>(
//						new CustomErrorType(
//								"Unable to upate. Question with id " + id + " is referenced by a survey question."),
//						HttpStatus.CONFLICT); // code 409
//			}
//		}
//	}

	// delete an existing question
	@DeleteMapping("/{id}")
	public ResponseEntity<CeReProAbstractEntity> deleteQuestion(@PathVariable("id") final Long id) {
		Optional<Question> question = questionRepository.findById(id);
		if (!question.isPresent()) {
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Question with id " + id + " not found."),
					HttpStatus.NOT_FOUND); // code 404
		}
		List<SurveyQuestion> sqs = surveyQuestionRepository.findByQuestionId(id);
		if (sqs.isEmpty()) {
			questionRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // code 204
		} else {
			return new ResponseEntity<>(
					new CustomErrorType(
							"Unable to delete. Question with id " + id + " is referenced by a survey question."),
					HttpStatus.CONFLICT); // code 409
		}
	}

	
}