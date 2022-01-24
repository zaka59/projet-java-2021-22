package athleticCompetition.event;

import athleticCompetition.*;
import java.util.EventObject;
import athleticCompetition.match.*;


/** Represents an even which contains a match.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class MatchEvent extends EventObject {
        
    /**to avoid warnings */
    private static final long serialVersionUID = 1L;
   
    /**the winner of the match*/ 
    private Competitor winner;

    /**the loser of the match*/ 
    private Competitor loser;

    /**
     * The Constructor
     * @param source the match
     * @param winner the winner of the given match
     * @param loser the loser of the given match
     */
    public MatchEvent(Match source,Competitor winner, Competitor loser ){
        super(source);
        this.winner = winner;
        this.loser = loser;
    }


    /**
     * Gets the winner of the given match
     * @return the winner
     */
    public Competitor getWinner(){
        return this.winner;
    }


    /** 
     * Gets the loser of the given match
     * @return the loser
     */
    public Competitor getLoser(){
        return this.loser;
    }

}
