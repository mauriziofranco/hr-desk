package franco.maurizio.hr.desk.com.persistence.repository.question;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.entity.custom.QuestionCustom;
/**
 * 
 * 
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public class QuestionRepositoryImpl implements QuestionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * extract questions form question table more position field from surveyquestions table and fit into a QuestionCustom Object
	 * @param surveyId
	 * @return
	 */
	@Override
	public List<QuestionCustom> findBySurveyId(long surveyId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<QuestionCustom> query = cb.createQuery(QuestionCustom.class);
		Root<SurveyQuestion> rootTable= query.from(SurveyQuestion.class);
		Root<Question> joinTable  = query.from(Question.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(joinTable.get("id"), rootTable.get("questionId")));
		criteria.add(cb.equal(rootTable.get("surveyId"), surveyId));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.asc(rootTable.get("position")));
		
		TypedQuery<QuestionCustom> q = em.createQuery(query.multiselect(
			joinTable.get("id"),
			joinTable.get("label"),
			joinTable.get("description"),
			joinTable.get("ansa"),
			joinTable.get("ansb"),
			joinTable.get("ansc"),
			joinTable.get("ansd"),
			joinTable.get("anse"),
			joinTable.get("ansf"),
			joinTable.get("ansg"),
			joinTable.get("ansh"),
			joinTable.get("cansa"),
			joinTable.get("cansb"),
			joinTable.get("cansc"),
			joinTable.get("cansd"),
			joinTable.get("canse"),
			joinTable.get("cansf"),
			joinTable.get("cansg"),
			joinTable.get("cansh"),			
			joinTable.get("fullAnswer"),			
			rootTable.get("position")
		));
		List<QuestionCustom> resultList = q.getResultList();
		return resultList ;
	}
	

}