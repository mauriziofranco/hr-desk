package franco.maurizio.hr.desk.com.persistence.repository.surveyreply;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.SurveyReply;
/**
 * CandidateRepositoryImpl
 * 
 * This class provides implementation for CandidateRepositoryCustom methods
 * 
 * @author m.franco
 *
 */
@Repository
public class SurveyReplyRepositoryImpl implements SurveyReplyRepositoryCustom {

	public static final Logger logger = LoggerFactory.getLogger(SurveyReplyRepositoryImpl.class);

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public long getSurveyReplyCountForDay(LocalDate day) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<SurveyReply> rootTable = cq.from(SurveyReply.class);
		cq.select(cb.count(cq.from(SurveyReply.class)));
		List<Predicate> conditionsList = new ArrayList<Predicate>();
		LocalDateTime dateTimeStart = LocalDateTime.of(day.getYear(), day.getMonth(), day.getDayOfMonth(), 0, 0);
        logger.info("dateTimeStart: " + dateTimeStart);
		LocalDateTime dateTimeEnd = LocalDateTime.of(day.getYear(), day.getMonth(), day.getDayOfMonth(), 23, 59);
		logger.info("dateTimeEnd: " + dateTimeEnd);
		Predicate currentDateRange =  cb.between(rootTable.get("endtime"), dateTimeStart, dateTimeEnd);
		conditionsList.add(currentDateRange);
		cq.where(conditionsList.toArray(new Predicate[]{}));
		return em.createQuery(cq).getResultList().size();
	}
}
