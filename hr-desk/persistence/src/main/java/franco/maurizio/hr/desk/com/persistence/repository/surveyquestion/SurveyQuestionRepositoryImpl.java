package franco.maurizio.hr.desk.com.persistence.repository.surveyquestion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import franco.maurizio.hr.desk.com.persistence.entity.Question;
import franco.maurizio.hr.desk.com.persistence.entity.Survey;
import franco.maurizio.hr.desk.com.persistence.entity.SurveyQuestion;
import franco.maurizio.hr.desk.com.persistence.entity.custom.SurveyQuestionCustom;
import franco.maurizio.hr.desk.com.persistence.entity.custom.UserSurveyTokenCustom;
/**
 * SurveyQuestionRepositoryImpl
 * 
 * This class provides implementation for SurveyQuestionRepositoryCustom methods
 * 
 * @author joffre
 *
 */
@Repository
public class SurveyQuestionRepositoryImpl implements SurveyQuestionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<SurveyQuestionCustom> getAllCustomSurveyQuestion() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SurveyQuestionCustom> query = null;
		query = cb.createQuery(SurveyQuestionCustom.class);
		Root<SurveyQuestion> rootTable = query.from(SurveyQuestion.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		Root<Question> joinQuestionTable = query.from(Question.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("questionId"), joinQuestionTable.get("id")));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(rootTable.get("id")));
		TypedQuery<SurveyQuestionCustom> q = em.createQuery(query.multiselect(
			rootTable.get("id"),
			rootTable.get("surveyId"),
			rootTable.get("questionId"),
			rootTable.get("position"),
			joinSurveyTable.get("label"),
			joinQuestionTable.get("label")
		));
		List<SurveyQuestionCustom> resultList = q.getResultList();
		return resultList ;
	}
	

}