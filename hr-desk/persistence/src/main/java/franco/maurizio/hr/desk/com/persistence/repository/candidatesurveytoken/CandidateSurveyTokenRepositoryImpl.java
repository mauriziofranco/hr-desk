package franco.maurizio.hr.desk.com.persistence.repository.candidatesurveytoken;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.Candidate;
import franco.maurizio.hr.desk.com.persistence.entity.CandidateSurveyToken;
import franco.maurizio.hr.desk.com.persistence.entity.Survey;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyReply;
import franco.maurizio.hr.desk.com.persistence.entity.custom.CandidateSurveyTokenCustom;
/**
 * CandidateSurveyTokenRepositoryImpl
 * 
 * This class provides implementation for CandidateSurveyTokenRepositoryCustom methods
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public class CandidateSurveyTokenRepositoryImpl implements CandidateSurveyTokenRepositoryCustom {
	
	public static final Logger logger = LoggerFactory.getLogger(CandidateSurveyTokenRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyToken() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		
		criteria.add(cb.equal(rootTable.get("generatedToken"), joinSurveyReplyTable.get("generated_token")));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(rootTable.get("id")));
		TypedQuery<CandidateSurveyTokenCustom> q = em.createQuery(query.multiselect(
			rootTable.get("id"),
			rootTable.get("candidateId"), 
			joinCandidateTable.get("firstname"),
			joinCandidateTable.get("lastname"),
			joinCandidateTable.get("email"),
			rootTable.get("surveyId"),
			joinSurveyTable.get("label"),
			rootTable.get("expirationDateTime"),
			rootTable.get("generatedToken"),
			rootTable.get("expired"),
			joinSurveyReplyTable.get("id"),
			joinSurveyReplyTable.get("pdffilename")
			
			
		));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		return resultList ;
	}
	
	/********** PAGEABLE  -> START */
//	public Page<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExpiredPaginated(Pageable info, Boolean situation) {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
//		query = cb.createQuery(CandidateSurveyTokenCustom.class);
//		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
//		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
//		Root<Survey> joinSurveyTable = query.from(Survey.class);
//		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
//		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
//		criteria.add(cb.equal(rootTable.get("expired"), situation));
//		
//		criteria.add(cb.equal(rootTable.get("generatedToken"), joinSurveyReplyTable.get("generated_token")));
//
////		criteria.add(cb.equal(joinTableUser.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
//		
//		query.where(criteria.toArray(new Predicate[criteria.size()]));
//		TypedQuery<CandidateSurveyTokenCustom> q = em.createQuery(query.multiselect(
//				rootTable.get("id"),
//				rootTable.get("candidateId"), 
//				joinCandidateTable.get("firstname"),
//				joinCandidateTable.get("lastname"),
//				joinCandidateTable.get("email"),
//				rootTable.get("surveyId"),
//				joinSurveyTable.get("label"),
//				rootTable.get("expirationDateTime"),
//				rootTable.get("generatedToken"),
//				rootTable.get("expired"),
//				joinSurveyReplyTable.get("id"),
//				joinSurveyReplyTable.get("pdffilename")
//				));
//		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
//		int start=(int) info.getOffset();
//		int end = (start + info.getPageSize()) > resultList .size() ? resultList .size() : (start + info.getPageSize());        
//		int totalRows = resultList .size();
//		Page<CandidateSurveyTokenCustom> pageToReturn = new PageImpl<CandidateSurveyTokenCustom>(resultList .subList(start, end), info, totalRows); 
//		return pageToReturn;
//	
//	}
	
/*********** PAGEABLE  -> END */
	
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenActive() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), false));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<CandidateSurveyTokenCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("candidateId"), 
				joinCandidateTable.get("firstname"),
				joinCandidateTable.get("lastname"),
				joinCandidateTable.get("email"),
				rootTable.get("surveyId"),
				joinSurveyTable.get("label"),
				rootTable.get("expirationDateTime"),
				rootTable.get("generatedToken"),
				rootTable.get("expired")
				));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		return resultList ;
	
	}
	
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExecuted() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), true));
		
		criteria.add(cb.equal(rootTable.get("generatedToken"), joinSurveyReplyTable.get("generated_token")));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<CandidateSurveyTokenCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("candidateId"), 
				joinCandidateTable.get("firstname"),
				joinCandidateTable.get("lastname"),
				joinCandidateTable.get("email"),
				rootTable.get("surveyId"),
				joinSurveyTable.get("label"),
				rootTable.get("expirationDateTime"),
				rootTable.get("generatedToken"),
				rootTable.get("expired"),
				joinSurveyReplyTable.get("id"),
				joinSurveyReplyTable.get("pdffilename")
				));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		return resultList ;
	
	}
	
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExpiredAndNotExecuted() {
		logger.info("getAllCustomCandidateSurveyTokenExpiredAndNotExecuted - START - ");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), true));
		
		criteria.add(cb.notEqual(rootTable.get("generatedToken"), joinSurveyReplyTable.get("generated_token")));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<CandidateSurveyTokenCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("candidateId"), 
				joinCandidateTable.get("firstname"),
				joinCandidateTable.get("lastname"),
				joinCandidateTable.get("email"),
				rootTable.get("surveyId"),
				joinSurveyTable.get("label"),
				rootTable.get("expirationDateTime"),
				rootTable.get("generatedToken"),
				rootTable.get("expired")
				));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		return resultList ;
	
	}
	
}
