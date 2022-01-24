package athleticCompetition.main;

import athleticCompetition.*;
import athleticCompetition.competition.*;
import athleticCompetition.competition.selection.*;
import athleticCompetition.event.listener.*;
import athleticCompetition.match.*;
import java.util.ArrayList;
import java.util.List;

/**This class is an exemple of a competition Master
 * also, it replicates The UEFA Champions League but the winner is given 
 * This version shows how the Real Madrid won all their UCL.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 **/
public class ChampionsLeagueRigged {

    /* The 2021-2022 UEFA Champions League edition rigged*/

    /** the main method
     * @param args the winner of the Master competition
     */
    public static void main(String[] args) {
        String[] names = {
            "Chelsea FC",
            "Villarreal",
            "Atlético de Madrid",
            "Manchester City",
            "Bayern Munich",
            "Inter Milan",
            "LOSC Lille",
            "Sporting CP",
            "Real Madrid",
            "FC Barcelone",
            "Juventus FC",
            "Manchester United",
            "Paris Saint-Germain",
            "Liverpool FC",
            "Séville FC",
            "Borussia Dortmund",
            "FC Porto",
            "Ajax Amsterdam",
            "Chakhtar Donetsk",
            "RB Leipzig",
            "RB Salzbourg",
            "SL Benfica",
            "Atalanta Bergame",
            "Zénith Saint-Pétersbourg",
            "Beşiktaş JK",
            "Dynamo Kiev",
            "Club Bruges KV",
            "BSC Young Boys",
            "AC Milan",
            "Malmö FF",
            "VfL Wolfsburg",
            "Sheriff Tiraspol",
        };
        List<Competitor> competitors = new ArrayList<>();
        for (String name : names) {
            competitors.add(new Competitor(name));
        }

        Match match = new RiggedMatch(args[0]);
        Selection s = new UCLSelection(match);
        Master m = new Master(competitors, match, s);
        Journalist j = new Journalist("Bein Sports");
        Bookmaker b = new Bookmaker("Betclic");
        m.addListener(j);
        m.addListener(b);
        m.play();
    }
}
