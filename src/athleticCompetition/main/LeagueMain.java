package athleticCompetition.main;

import athleticCompetition.*;
import athleticCompetition.competition.*;
import athleticCompetition.event.listener.Bookmaker;
import athleticCompetition.event.listener.Journalist;
import athleticCompetition.match.*;
import java.util.ArrayList;
import java.util.List;

/**This class is an exemple of a competition League
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 **/
public class LeagueMain {

    /** the main method
     * @param args the arguments
     */
    public static void main(String[] args) {
        List<Competitor> competitors = new ArrayList<>();
        if (args.length > 0) {
            for (String name : args) {
                competitors.add(new Competitor(name));
            }
        } else {
            String[] names = {
                "Zac",
                "Yoni",
                "Messi",
                "Ronaldo",
                "Musk",
                "Lebron",
                "Damien",
                "Routier",
            };

            for (String name : names) {
                competitors.add(new Competitor(name));
            }
        }

        Match match = new RandomWinnerMatch();
        League l = new League(competitors, match);
        Journalist j = new Journalist("BBC");
        Bookmaker b = new Bookmaker("Betclic");
        l.addListener(j);
        l.addListener(b);
        l.play();
    }
}
