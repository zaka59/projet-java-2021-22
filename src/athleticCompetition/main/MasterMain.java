package athleticCompetition.main;

import athleticCompetition.*;
import athleticCompetition.competition.Master;
import athleticCompetition.competition.selection.*;
import athleticCompetition.event.listener.*;
import athleticCompetition.match.*;
import java.util.ArrayList;
import java.util.List;

/**This class is an exemple of a competition Master
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 **/
public class MasterMain {

    /** the main method
     * @param args the arguments
     */
    public static void main(String[] args) {
        String[] names = {
            "Zac",
            "Yoni",
            "Messi",
            "Ronaldo",
            "Musk",
            "Lebron",
            "Damien",
            "Routier",
            "Dave",
            "Kevin",
            "Ellis",
            "Mabel",
            "Jenna",
            "Irene",
            "Teresa",
            "Fannie",
            "Angela",
            "Trump",
            "Obama",
            "Macron",
            "Filip",
            "Samar",
            "Wara",
            "Isidore",
        };
        List<Competitor> competitors = new ArrayList<>();
        for (String name : names) {
            competitors.add(new Competitor(name));
        }
        Match match = new RandomWinnerMatch();
        Selection s = new FirstSelection(match);
        Master m = new Master(competitors, match, s);
        Journalist j = new Journalist("BBC");
        Bookmaker b = new Bookmaker("Betclic");
        m.addListener(j);
        m.addListener(b);
        m.play();
    }
}
