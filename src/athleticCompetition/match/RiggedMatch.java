package athleticCompetition.match;

import athleticCompetition.*;
import java.util.Random;

/** Represents a rigged match where the winner is given.
 * if the competitor dosen't play the winner will be chosen randomly
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class RiggedMatch extends Match {

    /**Random */
    public static final Random RANDOM = new Random();
    /**winner's name' */
    private String winnerName;

    /**
     * The Constructor
     * @param winnerName the winner's name
     */
    public RiggedMatch(String winnerName) {
        super();
        this.winnerName = winnerName;
    }

    /**
     * Method that makes the first competitor play against the second competitor.
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    public Competitor play(Competitor c1, Competitor c2) {
        this.c1 = c1;
        this.c2 = c2;
        Competitor winner;
        if (c1.getName().equals(winnerName)) winner = c1; else if (
            c2.getName().equals(winnerName)
        ) winner = c2; else winner = (RANDOM.nextInt(2) == 1) ? c1 : c2;
        Competitor loser = (winner.equals(c2)) ? c1 : c2;
        fireMatchFinished(winner, loser);
        return winner;
    }
}
