package athleticCompetition.event.listener;

import athleticCompetition.Competitor;
import athleticCompetition.event.*;
import java.util.EventListener;
import java.util.List;

/** Represents a competition listener/observer.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public interface CompetitionListener extends EventListener{
    



    /** Method that does something when a competition starts
     * @param e the event that contains the competition
     **/
    public void competitionStarted(CompetitionEvent e);



    /** Method that does something when a competition is finished
     * @param e the event that contains the competition
     **/
    public void competitionFinished(CompetitionEvent e);

    /**
     * Method that adds a given list of competitors to the listener
     * @param competitors the competitors
     **/
    public void addCompetitors(List<Competitor> competitors);
   

}
