package athleticCompetition.event.listener;

import athleticCompetition.*;
import athleticCompetition.event.CompetitionEvent;
import athleticCompetition.event.MatchEvent;
import athleticCompetition.util.ConsoleColors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Represents a Bookmaker.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class Bookmaker implements MatchListener, CompetitionListener {

    /*the name*/
    private String name;

    /*the competitors with their respective odds*/
    private Map<Competitor, Integer> odds;

    /**
     * The constructor.
     * @param name the bookmaker's name.
     */
    public Bookmaker(String name) {
        this.name = name;
        this.odds = new HashMap<>();
    }

    /**
     * Gets the bookmaker’s name.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that return the odds of a given competitor
     * @param c the competitor
     * @return the competitor's odds.
     */
    public Integer getCompetitorOdds(Competitor c) {
        return this.odds.get(c);
    }

    /**
     * Method that returns the HashMap with the odds of each competitor
     * @return the hasmap with the Competitors and their odds
     */
    public Map<Competitor, Integer> getOdds() {
        return this.odds;
    }

    /**
     * Method that adds a given list of competitors to the listener
     * @param competitors the competitors
     **/
    public void addCompetitors(List<Competitor> competitors) {
        for (Competitor c : competitors) this.odds.put(c, 1);
    }

    /** Method that does something when a match is finished
     * @param e the event that contains the match
     **/
    public void matchFinished(MatchEvent e) {
        Competitor winner = e.getWinner();
        Competitor loser = e.getLoser();
        try {
            int winnerOdds = (this.odds.get(winner));
            int loserOdds = this.odds.get(loser);
            this.odds.put(winner, (winnerOdds == 1) ? 1 : winnerOdds - 1);
            this.odds.put(loser, (loserOdds + 1));
            System.out.print(
                ConsoleColors.YELLOW + this.name + ConsoleColors.RESET
            );
            System.out.println(
                " : " +
                winner.getName() +
                "'s odds (" +
                winnerOdds +
                ") -> (" +
                ((winnerOdds == 1) ? 1 : winnerOdds - 1) +
                "), " +
                loser.getName() +
                "'s odds (" +
                loserOdds +
                ") -> (" +
                (this.odds.get(loser)) +
                ")."
            );
        } catch (Exception ex) {
            System.out.println("oups");
        }
    }

    /** Method that does something when a competition starts
     * @param e the event that contains the competition
     **/
    public void competitionStarted(CompetitionEvent e) {
        System.out.println(
            ConsoleColors.YELLOW +
            "The bookmaker " +
            this.name +
            " is watching." +
            ConsoleColors.RESET
        );
    }

    /** Method that does something when a competition is finished
     * @param e the event that contains the competition
     **/
    public void competitionFinished(CompetitionEvent e) {
        System.out.println(
            ConsoleColors.YELLOW +
            "The bookmaker " +
            this.name +
            " is not watching anymore." +
            ConsoleColors.RESET
        );
    }
}
