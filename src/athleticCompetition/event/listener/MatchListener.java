package athleticCompetition.event.listener;

import athleticCompetition.event.*;
import athleticCompetition.Competitor;
import java.util.EventListener;
import java.util.List;

/** Represents a match listener/observer.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public interface MatchListener extends EventListener{
    

    /** Method that does something when a match is finished
     * @param e the event that contains the match
     **/
    public void matchFinished(MatchEvent e);

    /**
     * Method that adds a given list of competitors to the listener
     * @param competitors the competitors
     **/
    public void addCompetitors(List<Competitor> competitors);
   

}
