package athleticCompetition.competition;

import athleticCompetition.*;
import athleticCompetition.event.*;
import athleticCompetition.event.listener.*;
import athleticCompetition.exception.*;
import athleticCompetition.match.*;
import java.util.*;

/** Represents a Competition.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public abstract class Competition {

    /**
     * the match type
     */
    protected Match match;

    /**
     * the competitors
     */
    protected final List<Competitor> competitors;

    /**the list of listeners*/
    protected ArrayList<CompetitionListener> competitionListeners;

    /** Constructor
     * @param competitors the competitors list
     * @param match the match type
     */
    public Competition(List<Competitor> competitors, Match match) {
        this.competitors = competitors;
        this.match = match;
        this.competitionListeners = new ArrayList<>();
    }

    /** Method that allow us to start the Competition
     * */
    public abstract void play();

    /** Method that makes the competitors plays against each other
     * @param competitors the competitors
     */
    protected abstract void play(List<Competitor> competitors);

    /** Method that starts a match between the c1 competitor and the c2 competitor
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    protected void playMatch(Competitor c1, Competitor c2) {
        Competitor winner = this.match.play(c1, c2);
        winner.addPoints(1);
    }

    /** Method that returns a LinkedHashMap of the competitors with their respective points
     * @return the LinkedHashMap oh the competitor
     */
    public Map<Competitor, Integer> ranking() {
        List<Competitor> copy = new ArrayList<>(this.competitors);
        Map<Competitor, Integer> ranking = new LinkedHashMap<>();
        Competitor bestOf;
        int pointsBestOf;
        while (!copy.isEmpty()) {
            bestOf = copy.get(0);
            pointsBestOf = bestOf.getPoints();
            int i = 0;
            int j = 0;
            for (Competitor c : copy) {
                if (pointsBestOf < c.getPoints()) {
                    bestOf = c;
                    pointsBestOf = c.getPoints();
                    j = i;
                }
                i++;
            }
            ranking.put(copy.remove(j), pointsBestOf);
        }
        return ranking;
    }

    /**Method that returns the nth competitor.
     * @param nth the nth competitor of the ranking
     * @return the nth competitor
     * @throws NotInCompetitionException if the nth is bigger than the nb of competitors
     */
    public Competitor getNthCompetitor(int nth)
        throws NotInCompetitionException {
        if (nth > this.competitors.size()) throw new NotInCompetitionException(
            "There is only " + this.competitors.size() + "competitors."
        );
        Competitor winner;
        winner = (Competitor) this.ranking().keySet().toArray()[nth - 1];
        return winner;
    }

    /**Gets the competitors list
     * @return the competitors
     */
    public List<Competitor> getCompetitors() {
        return this.competitors;
    }

    /**Method that adds the list of competitors to all the listeners
     **/
    protected void addCompetitorsToListeners() {
        for (CompetitionListener listener : this.competitionListeners) {
            listener.addCompetitors(this.competitors);
        }
    }

    /**Method that adds a given listener to this competition
     * @param cl the listener
     */
    public void addListener(CompetitionListener cl) {
        if (!this.competitionListeners.contains(cl)) {
            this.competitionListeners.add(cl);
            this.match.addListener((MatchListener) cl);
        }
    }

    /**Method that removes a given listener to this competition
     * @param cl the listener
     */
    public void removeListener(CompetitionListener cl) {
        this.competitionListeners.remove(cl);
        this.match.removeListener((MatchListener) cl);
    }

    /**Method that allows all the listeners to know that the competition started
     **/
    protected synchronized void fireCompetitionStarted() {
        if (!(this.competitionListeners.isEmpty())) {
            this.addCompetitorsToListeners();
            CompetitionEvent e = new CompetitionEvent(this);
            for (CompetitionListener listener : this.competitionListeners) 
                listener.competitionStarted(e);
        }
    }

    /**Method that allows all the listeners to know that the competition is finished
     **/
    protected synchronized void fireCompetitionFinished() {
        if (!(this.competitionListeners.isEmpty())) {
            CompetitionEvent e = new CompetitionEvent(this);
            for (CompetitionListener listener : this.competitionListeners) 
                listener.competitionFinished(e);
        }
    }
}
