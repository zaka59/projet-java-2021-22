package athleticCompetition.event.listener;

import athleticCompetition.Competitor;
import athleticCompetition.event.*;
import athleticCompetition.match.*;
import athleticCompetition.util.ConsoleColors;
import java.util.List;

/** Represents a Journalist.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class Journalist implements MatchListener, CompetitionListener {

    /*the name*/
    private String name;

    /**
     * The constructor.
     * @param name the journalist's name.
     */
    public Journalist(String name) {
        this.name = name;
    }

    /**
     * Gets the journalist’s name.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that adds a given list of competitors to the listener
     * @param competitors the competitors
     **/
    public void addCompetitors(List<Competitor> competitors) {
        /*the journalist doesn't take any competitors, so this method stays empty*/
    }

    /** Method that does something when a match is finished
     * @param e the event that contains the match
     **/
    public void matchFinished(MatchEvent e) {
        System.out.print(ConsoleColors.CYAN + this.name + ConsoleColors.RESET);
        System.out.print(
            " : " +
            ((Match) e.getSource()).getC1().getName() +
            " vs " +
            ((Match) e.getSource()).getC2().getName() +
            " --> " +
            ConsoleColors.GREEN +
            e.getWinner().getName() +
            " wins! \n" +
            ConsoleColors.RESET
        );
    }

    /** Method that does something when a competition starts
     * @param e the event that contains the competition
     * */
    public void competitionStarted(CompetitionEvent e) {
        System.out.println(
            ConsoleColors.CYAN +
            this.name +
            " is broadcasting this competition." +
            ConsoleColors.RESET
        );
    }

    /** Method that does something when a competition is finished
     * @param e the event that contains the competition
     * */
    public void competitionFinished(CompetitionEvent e) {
        System.out.println(
            ConsoleColors.CYAN +
            this.name +
            " stopped broadcasting this competition." +
            ConsoleColors.RESET
        );
    }
}
