/**
 * 
 */
package franco.maurizio.hr.desk.com.backend;

import java.time.LocalDateTime;
import java.util.Optional;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import franco.maurizio.hr.desk.com.persistence.entity.CandidateSurveyToken;
import franco.maurizio.hr.desk.com.persistence.entity.CeReProAbstractEntity;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyReply;
import franco.maurizio.hr.desk.com.persistence.entity.custom.CustomErrorType;
import franco.maurizio.hr.desk.com.persistence.repository.SurveyRepository;
import franco.maurizio.hr.desk.com.persistence.repository.UserRepository;
import franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;
import franco.maurizio.hr.desk.com.persistence.repository.surveyreply.SurveyReplyRepository;
import franco.maurizio.hr.desk.com.rest.request.SurveyReplyRequest;
import franco.maurizio.hr.desk.com.rest.request.SurveyReplyStartRequest;
import franco.maurizio.hr.desk.com.service.SurveyReplyRequestService;


/**
 * @author Marco Fulgosi
 * @author Antonio Iannaccone - Roma Academy VII
 *
 */

@RestController
@RequestMapping("/api/v1/surveyreplyrequest")
public class SurveyReplyRequestController {

	@Autowired
	private SurveyRepository surveyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SurveyReplyRepository surveyReplyRepository;
	@Autowired
	private SurveyReplyRequestService surveyReplyRequestService;
	@Autowired
	private CandidateSurveyTokenRepository candidateSurveyTokenRepository;
	@Autowired
	PdfController pdfController;
	@Autowired
	private Environment env;
	
	public static final Logger logger = LoggerFactory.getLogger(SurveyReplyRequestController.class);
	/** CREATE A NEW SURVEY REPLY REQUEST */
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CeReProAbstractEntity> insertSurveyReply(@Valid @RequestBody final SurveyReplyRequest surveyReplyRequest) {
		logger.info("insertSurveyReply - START - surveyReplyRequest: {}", surveyReplyRequest);
		
		if (surveyRepository.findById(surveyReplyRequest.getSurveyId())==null)
			return new ResponseEntity<>(
					new CustomErrorType("Unable to create new Survey Reply. Survey Id: " + surveyReplyRequest.getSurveyId()
							+ " is not present in database."),HttpStatus.CONFLICT);
		
		if (userRepository.findById(surveyReplyRequest.getUserId()) == null)
			return new ResponseEntity<>(
					new CustomErrorType("Unable to create new Survey Reply. User id: " + surveyReplyRequest.getUserId()
							+ " is not present in database."),HttpStatus.CONFLICT);
		
		/* Creating a SurveyReply by SurveyReplyRequest */
		SurveyReply surveyReply = new SurveyReply();
		surveyReply.setSurveyId(surveyReplyRequest.getSurveyId());
		surveyReply.setCandidateId(surveyReplyRequest.getUserId());
		surveyReply.setStarttime(surveyReplyRequest.getStarttime());
		surveyReply.setEndtime(surveyReplyRequest.getEndtime());
		
		surveyReply.setAnswers(surveyReplyRequestService.answersToString(surveyReplyRequest.getAnswers()));
		surveyReply.setPoints(surveyReplyRequestService.calculateScore(surveyReplyRequest.getAnswers()).toString()); 
		surveyReply.setPdffilename("Risposte del candidato n."+surveyReplyRequest.getUserId()+" Al questionario n."+surveyReplyRequest.getSurveyId());
		surveyReply.setGenerated_token(surveyReplyRequest.getGenerated_token());
		
		surveyReplyRepository.save(surveyReply);
		return new ResponseEntity<>(surveyReply, HttpStatus.CREATED);
	}
	
	/** CREATE A NEW START SURVEY REPLY */
	@PostMapping(value = "/start/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CeReProAbstractEntity> insertStartSurveyReply(@Valid @RequestBody final SurveyReplyStartRequest surveyReplyRequest) {
		logger.info("Creating Survey Reply : {}", surveyReplyRequest);
		
		if (surveyRepository.findById(surveyReplyRequest.getSurveyId())==null)
			return new ResponseEntity<>(
					new CustomErrorType("Unable to create new Survey Reply. Survey Id: " + surveyReplyRequest.getSurveyId()
							+ " is not present in database."),HttpStatus.CONFLICT);
		
		if (userRepository.findById(surveyReplyRequest.getCandidateId()) == null)
			return new ResponseEntity<>(
					new CustomErrorType("Unable to create new Survey Reply. User id: " + surveyReplyRequest.getCandidateId()
							+ " is not present in database."),HttpStatus.CONFLICT);
		
		/* Creating a SurveyReply by SurveyReplyRequest */
		SurveyReply surveyReply = new SurveyReply();
		surveyReply.setSurveyId(surveyReplyRequest.getSurveyId());
		surveyReply.setCandidateId(surveyReplyRequest.getCandidateId());
		surveyReply.setStarttime(LocalDateTime.now());
		surveyReply.setGenerated_token(surveyReplyRequest.getGenerated_token());
			
		surveyReplyRepository.save(surveyReply);
		
		logger.info("surveyReplyRequest.getUserTokenId() "+surveyReplyRequest.getUserTokenId());
		
		Optional<CandidateSurveyToken> candidateSurveyToken = candidateSurveyTokenRepository.findById(surveyReplyRequest.getUserTokenId());

		CandidateSurveyToken currentCandidateSurveyToken = candidateSurveyToken.get();
		currentCandidateSurveyToken.setExpired(true);
		candidateSurveyTokenRepository.save(currentCandidateSurveyToken); 

		return new ResponseEntity<>(surveyReply, HttpStatus.CREATED);
	}
	
	/** END SURVEY REPLY */
	@PutMapping(value = "/end/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CeReProAbstractEntity> updateSurvay(@PathVariable final Long id, @RequestBody SurveyReplyRequest surveyReplyRequest) {


		Optional<SurveyReply> optSurveyReply = surveyReplyRepository.findById(id);

		if (optSurveyReply.isEmpty()) {
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		
		SurveyReply currentSurveyReply = optSurveyReply.get(); 
		currentSurveyReply.setEndtime(LocalDateTime.now());
		currentSurveyReply.setAnswers(surveyReplyRequestService.answersToString(surveyReplyRequest.getAnswers()));
//		currentSurveyReply.setPoints(surveyReplyRequestService.pointsCalculator(surveyReplyRequest.getAnswers()).toString()); 
		currentSurveyReply.setPoints(surveyReplyRequestService.calculateScore(surveyReplyRequest.getAnswers())); 
	 
		currentSurveyReply.setGenerated_token(surveyReplyRequest.getGenerated_token());
		
		surveyReplyRepository.save(currentSurveyReply);
		
		pdfController.createPdfForSurveyFromId(currentSurveyReply.getId());
		
		return new ResponseEntity<>(currentSurveyReply, HttpStatus.OK);
	}
	
}
