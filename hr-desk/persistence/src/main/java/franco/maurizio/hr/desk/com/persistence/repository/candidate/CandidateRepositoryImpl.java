package franco.maurizio.hr.desk.com.persistence.repository.candidate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.Candidate;
import franco.maurizio.hr.desk.com.persistence.entity.CandidateStates;
import franco.maurizio.hr.desk.com.persistence.entity.User;
import franco.maurizio.hr.desk.com.persistence.entity.custom.CandidateCustom;
import franco.maurizio.hr.desk.com.persistence.entity.custom.ListedCandidateCustom;

/**
 * CandidateRepositoryImpl
 * 
 * Candidates table repository custom methods implementation
 * 
 * @author maurizio.franco@ymail.com
 * @author joffre
 * @author daniele
 * @author giacomo
 *
 */
@Repository
public class CandidateRepositoryImpl implements CandidateRepositoryCustom {

	private Logger logger = LoggerFactory.getLogger(CandidateRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

//	@Override
//	public List<CandidateCustom> getAllCustomCandidates() {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<CandidateCustom> query = null;
//		query = cb.createQuery(CandidateCustom.class);
//		
//		Root<Candidate> rootTable = query.from(Candidate.class);
//		Root<User> joinTable = query.from(User.class);
//		Root<CandidateStates> joinTable2=query.from(CandidateStates.class);
//		
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		
//		criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id")));
//		criteria.add(cb.equal(joinTable.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
//		criteria.add(cb.equal(rootTable.get("candidateStatesId"),joinTable2.get("id")));
//		
//
//		
//		query.where(criteria.toArray(new Predicate[criteria.size()]));
//		TypedQuery<CandidateCustom> q = em.createQuery(query.multiselect(
//				rootTable.get("id"),
//				rootTable.get("userId"), 
//				rootTable.get("domicileCity"),
//				rootTable.get("studyQualification"),
//				rootTable.get("graduate"), 
//				rootTable.get("highGraduate"),
//				rootTable.get("stillHighStudy"),
//				rootTable.get("mobile"),
//				rootTable.get("cvExternalPath"),
//				joinTable.get("email"),
//				joinTable.get("firstname"),
//				joinTable.get("lastname"),
//				joinTable.get("dateOfBirth"),
//				joinTable.get("imgpath"),
//				rootTable.get("courseCode"),
//				joinTable.get("note"),
//				rootTable.get("label"),
//				rootTable.get("candidateStatesId"),
//				joinTable2.get("statusColor"),
//				joinTable2.get("statusLabel")
//				));
//		List<CandidateCustom> resultList = q.getResultList();
//		return resultList ;
//	}

	/* PAGEABLE -> START */
	/**
	 * Commented because probably no more used or used by old Backoffice Application
	 * just dismissed
	 */
//	public Page<CandidateCustom> getAllCustomCandidatesPaginated(Pageable info) {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<CandidateCustom> query = null;
//		query = cb.createQuery(CandidateCustom.class);
//		
//		Root<Candidate> rootTable = query.from(Candidate.class);
//		Root<User> joinTable = query.from(User.class);
//		Root<CandidateStates> joinTable2=query.from(CandidateStates.class);
//		
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		
//		criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id")));
//		criteria.add(cb.equal(joinTable.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
//		criteria.add(cb.equal(rootTable.get("candidateStatesId"),joinTable2.get("id")));
//		
//		query.orderBy(cb.desc(rootTable.get("candidacy_date_time")));
//		
//		query.where(criteria.toArray(new Predicate[criteria.size()]));
////		query.orderBy(cb.asc(rootTable.get("candidacyDateTime")));//order by for "candidacyDateTime" doesn't works beacause itsn't a field retrieved in the following select!!!! 
//		query.orderBy(cb.desc(rootTable.get("id")));
//		TypedQuery<CandidateCustom> q = em.createQuery(query.multiselect(
//				rootTable.get("id"),
//				rootTable.get("userId"), 
//				rootTable.get("domicileCity"),
//				rootTable.get("studyQualification"),
//				rootTable.get("graduate"), 
//				rootTable.get("highGraduate"),
//				rootTable.get("stillHighStudy"),
//				rootTable.get("mobile"),
//				rootTable.get("cvExternalPath"),
//				joinTable.get("email"),
//				joinTable.get("firstname"),
//				joinTable.get("lastname"),
//				joinTable.get("dateOfBirth"),
//				joinTable.get("imgpath"),
//				rootTable.get("courseCode"),
//				joinTable.get("note"),
//				rootTable.get("label"),
//				rootTable.get("candidateStatesId"),
//				joinTable2.get("statusColor"),
//				joinTable2.get("statusLabel")
//		));
//
//		List<CandidateCustom> resultList = q.getResultList();
//		int start=(int) info.getOffset();
//		int end = (start + info.getPageSize()) > resultList.size() ? resultList.size() : (start + info.getPageSize());        
//		int totalRows = resultList.size();
//
//		Page<CandidateCustom> pageToReturn = new PageImpl<CandidateCustom>(resultList.subList(start, end), info, totalRows); 
//		return pageToReturn;
//	
//	}

	/**
	 * 
	 * Method called by frontend to provides a paginated list of candidate custom
	 * entities.
	 * 
	 * Provides a paginated list of candidate filtered by course code, and
	 * pagination info.
	 * 
	 * @param size
	 * @param number
	 * @param code
	 * @return
	 */
//	public Page<CandidateCustom> getAllCustomCandidatesPaginatedByCourseCode(Pageable info, String courseCode)
//	{
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<CandidateCustom> query = null;
//		query = cb.createQuery(CandidateCustom.class);
//		
//		Root<Candidate> rootTable = query.from(Candidate.class);
//		Root<User> joinTable = query.from(User.class);
//		Root<CandidateStates> joinTable2=query.from(CandidateStates.class);
//		
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		
//		criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id")));
//		criteria.add(cb.equal(joinTable.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
//		if (courseCode!=null) {
//		    criteria.add(cb.equal(rootTable.get("courseCode"), courseCode));
//	    }
//		criteria.add(cb.equal(rootTable.get("candidateStatesId"),joinTable2.get("id")));
//		
//		query.orderBy(cb.desc(rootTable.get("candidacyDateTime")));
//		
//		query.where(criteria.toArray(new Predicate[criteria.size()]));
////		query.orderBy(cb.asc(rootTable.get("candidacyDateTime")));//order by for "candidacyDateTime" doesn't works beacause itsn't a field retrieved in the following select!!!! 
////		query.orderBy(cb.desc(rootTable.get("id")));
//		TypedQuery<CandidateCustom> q = em.createQuery(query.multiselect(
//				rootTable.get("id"),
//				rootTable.get("userId"), 
//				rootTable.get("domicileCity"),
//				rootTable.get("studyQualification"),
//				rootTable.get("graduate"), 
//				rootTable.get("highGraduate"),
//				rootTable.get("stillHighStudy"),
//				rootTable.get("mobile"),
//				rootTable.get("cvExternalPath"),
//				joinTable.get("email"),
//				joinTable.get("firstname"),
//				joinTable.get("lastname"),
//				joinTable.get("dateOfBirth"),
//				joinTable.get("imgpath"),
//				rootTable.get("courseCode"),
//				joinTable.get("note"),
//				rootTable.get("label"),
//				rootTable.get("candidateStatesId"),
//				joinTable2.get("statusColor"),
//				joinTable2.get("statusLabel")
//		));
//
//		List<CandidateCustom> resultList = q.getResultList();
//		logger.info(resultList.toString());
//		int start=(int) info.getOffset();
//		int end = (start + info.getPageSize()) > resultList.size() ? resultList.size() : (start + info.getPageSize());        
//		int totalRows = resultList.size();
//
//		Page<CandidateCustom> pageToReturn = new PageImpl<CandidateCustom>(resultList.subList(start, end), info, totalRows); 
//		return pageToReturn;
//	
//	}
	

	public List<ListedCandidateCustom> findByCourseCode(String courseCode) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ListedCandidateCustom> query = null;
		query = cb.createQuery(ListedCandidateCustom.class);

		Root<Candidate> rootTable = query.from(Candidate.class);
		Root<User> joinTable = query.from(User.class);
		Root<CandidateStates> joinTable2 = query.from(CandidateStates.class);

		List<Predicate> criteria = new ArrayList<Predicate>();

		criteria.add(cb.equal(rootTable.get("insertedBy"), joinTable.get("id")));
//		criteria.add(cb.equal(joinTable.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
		if (courseCode != null) {
			criteria.add(cb.equal(rootTable.get("courseCode"), courseCode));
		}
		criteria.add(cb.equal(rootTable.get("candidateStateCode"), joinTable2.get("statusCode")));

		query.orderBy(cb.desc(rootTable.get("candidacyDateTime")));

		query.where(criteria.toArray(new Predicate[criteria.size()]));
//		query.orderBy(cb.asc(rootTable.get("candidacyDateTime")));//order by for "candidacyDateTime" doesn't works beacause itsn't a field retrieved in the following select!!!! 
//		query.orderBy(cb.desc(rootTable.get("id")));
		TypedQuery<ListedCandidateCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("firstname"), 
				rootTable.get("lastname"), 
				rootTable.get("email"),
				joinTable2.get("statusColor"), 
				joinTable2.get("statusLabel"), 
				rootTable.get("imgpath"),
				rootTable.get("cvExternalPath"), 
				rootTable.get("insertedBy"), 
				joinTable.get("firstname"),
				joinTable.get("lastname")
		));

		List<ListedCandidateCustom> resultList = q.getResultList();
		return resultList ;

	}
	
    public Page<ListedCandidateCustom> getAllCustomCandidatesPaginatedByCourseCode(Pageable info, String courseCode) {
		
		List<ListedCandidateCustom> resultList = findByCourseCode(courseCode);
		logger.info(resultList.toString());
		int start = (int) info.getOffset();
		int end = (start + info.getPageSize()) > resultList.size() ? resultList.size() : (start + info.getPageSize());
		int totalRows = resultList.size();

		Page<ListedCandidateCustom> pageToReturn = new PageImpl<ListedCandidateCustom>(resultList.subList(start, end),
				info, totalRows);
		return pageToReturn;

	}

	/*********** PAGEABLE -> END */

	@Override
	public CandidateCustom getSingleCustomCandidate(Long id) throws NoResultException {
		logger.info("getSingleCustomCandidate - START - with id: {}", id);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateCustom> query = null;
		query = cb.createQuery(CandidateCustom.class);

		Root<Candidate> rootTable = query.from(Candidate.class);
//		Root<User> joinTable = query.from(User.class);
		Root<CandidateStates> joinTable2 = query.from(CandidateStates.class);

		List<Predicate> criteria = new ArrayList<Predicate>();

//		criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id")));
//		criteria.add(cb.equal(joinTable.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
		criteria.add(cb.equal(rootTable.get("id"), id));
//		criteria.add(cb.equal(rootTable.get("candidateStatesId"), joinTable2.get("id")));
		criteria.add(cb.equal(rootTable.get("candidateStateCode"), joinTable2.get("statusCode")));

		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<CandidateCustom> q = em.createQuery(query.multiselect(rootTable.get("id"),
				rootTable.get("domicileCity"), rootTable.get("studyQualification"), rootTable.get("graduate"),
				rootTable.get("highGraduate"), rootTable.get("stillHighStudy"), rootTable.get("mobile"),
				rootTable.get("cvExternalPath"), rootTable.get("email"), rootTable.get("firstname"),
				rootTable.get("lastname"), rootTable.get("dateOfBirth"), rootTable.get("imgpath"),
				rootTable.get("courseCode"), rootTable.get("technicalNote"), rootTable.get("label"),
				rootTable.get("candidateStateCode"), joinTable2.get("statusColor"), joinTable2.get("statusLabel")));

		q.setMaxResults(1);
		return q.getSingleResult();
	}

	/*
	 * public List<CandidateCustom> findByCourseCode(String code){
	 * 
	 * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<CandidateCustom>
	 * query = null; query = cb.createQuery(CandidateCustom.class);
	 * 
	 * Root<Candidate> rootTable = query.from(Candidate.class); // Root<User>
	 * joinTable = query.from(User.class); Root<CandidateStates>
	 * joinTable2=query.from(CandidateStates.class);
	 * 
	 * List<Predicate> criteria = new ArrayList<Predicate>();
	 * 
	 * // criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id"))); //
	 * criteria.add(cb.equal(joinTable.get("role"),
	 * Role.JAVA_COURSE_CANDIDATE_LEVEL));
	 * criteria.add(cb.equal(rootTable.get("courseCode"), code));
	 * criteria.add(cb.equal(rootTable.get("candidateStatesId"),joinTable2.get("id")
	 * ));
	 * 
	 * query.where(criteria.toArray(new Predicate[criteria.size()]));
	 * TypedQuery<CandidateCustom> q = em.createQuery(query.multiselect(
	 * rootTable.get("id"), rootTable.get("userId"), rootTable.get("domicileCity"),
	 * rootTable.get("studyQualification"), rootTable.get("graduate"),
	 * rootTable.get("highGraduate"), rootTable.get("stillHighStudy"),
	 * rootTable.get("mobile"), rootTable.get("cvExternalPath"),
	 * rootTable.get("email"), rootTable.get("firstname"),
	 * rootTable.get("lastname"), rootTable.get("dateOfBirth"),
	 * rootTable.get("imgpath"), rootTable.get("courseCode"),
	 * rootTable.get("technicalNote"), rootTable.get("label"),
	 * rootTable.get("candidateStatesId"), joinTable2.get("statusColor"),
	 * joinTable2.get("statusLabel") ));
	 * 
	 * 
	 * // q.setMaxResults(1); // CandidateCustom returnValue = q.getSingleResult();
	 * // return returnValue ; List<CandidateCustom> values=q.getResultList(); //
	 * logger.info(values.toString()); return values;
	 * 
	 * 
	 * 
	 * }
	 */
}
