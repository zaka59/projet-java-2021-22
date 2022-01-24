package athleticCompetition.match;

import athleticCompetition.*;
import athleticCompetition.event.MatchEvent;
import athleticCompetition.event.listener.MatchListener;
import athleticCompetition.util.ConsoleColors;
import java.util.ArrayList;

/** Represents a Match.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public abstract class Match {

    /**A list with all the listeners */
    protected ArrayList<MatchListener> matchListeners;

    /**Bool to display a msg is no one is watching */
    protected boolean isWatched;

    /**the first competitor*/
    protected Competitor c1;

    /**the second dcompetitor*/
    protected Competitor c2;

    /**
     * The Constructor
     **/
    public Match() {
        this.matchListeners = new ArrayList<>();
        this.isWatched = false;
    }

    /**
     * Method that makes the first competitor play against the second competitor.
     * @param c1 the first competitor
     * @param c2 the second competitor
     * @return the winner
     */
    public abstract Competitor play(Competitor c1, Competitor c2);

    /**
     * Method that tells to all the listeners that the match is finished,
     * and gives them the winner and the loser
     * @param winner the winner
     * @param loser the loser
     */
    protected synchronized void fireMatchFinished(
        Competitor winner,
        Competitor loser
    ) {
        if (!(this.matchListeners.isEmpty())) {
            isWatched = true;
            MatchEvent e = new MatchEvent(this, winner, loser);
            for (MatchListener listener : this.matchListeners) listener.matchFinished(
                e
            );
            return;
        }
        if (!isWatched) {
            isWatched = true;/* to show this only once*/
            System.out.println(
                ConsoleColors.RED_BOLD +
                "No one is watching which means that the results won't be broadcasted." +
                ConsoleColors.RESET
            );
        }
    }

    /**
     * Method that adds a listener to this match event.
     * @param ml the listener
     */
    public void addListener(MatchListener ml) {
        if (!this.matchListeners.contains(ml)) this.matchListeners.add(ml);
    }

    /**
     * Method that removes a listener from this match event.
     * @param ml the listener
     */
    public void removeListener(MatchListener ml) {
        this.matchListeners.remove(ml);
    }

    /**
     * Gets the first competitor
     * @return the first competitor
     */
    public Competitor getC1() {
        return this.c1;
    }

    /**
     * Gets the second competitor
     * @return the second competitor
     */
    public Competitor getC2() {
        return this.c2;
    }
}
