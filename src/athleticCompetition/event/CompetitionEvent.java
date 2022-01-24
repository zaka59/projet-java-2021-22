package athleticCompetition.event;


import java.util.EventObject;
import athleticCompetition.competition.*;


/** Represents an even which contains a Competition.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class CompetitionEvent extends EventObject {
    
    /** to avoid warnings */
    private static final long serialVersionUID = 1L;

  
    /**
     * The Constructor
     * @param source the competiiton
     */
    public CompetitionEvent(Competition source){
        super(source);
    }

}
