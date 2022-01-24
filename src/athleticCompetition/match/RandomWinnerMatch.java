package athleticCompetition.match;

import athleticCompetition.*;
import java.util.Random;

/** Represents a random winner Match.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class RandomWinnerMatch extends Match {

    /**Random */
    public static final Random RANDOM = new Random();
    
    /**
     * The Constructor
     */
    public RandomWinnerMatch() {
    	super();
    }

    /**
     * Method that makes the first competitor play against the second competitor.
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    public Competitor play(Competitor c1, Competitor c2) {
        this.c1 = c1;
        this.c2 = c2;
        Competitor winner =  (RANDOM.nextInt(2) == 1) ? c1 : c2;
        Competitor loser = (winner.equals(c2)) ? c1 : c2;
        fireMatchFinished(winner, loser); 
        return winner;
    }
}
