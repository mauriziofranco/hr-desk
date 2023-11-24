/**
 * 
 */
package franco.maurizio.hr.desk.com.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author maurizio
 *
 */
@Getter @Setter @NoArgsConstructor @ToString
public class SurveyReplyScore {
	private long minRangeScore ;
	private long maxRangeScore ;
	private long score ;
	private short scoreAsPercentage ;
	
}
