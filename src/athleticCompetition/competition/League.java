package athleticCompetition.competition;
import athleticCompetition.*;
import athleticCompetition.match.*;
import java.util.List;
import java.util.Map;

/** Represents a League Competition.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class League extends Competition {


    /**
     * Constructor
     * @param competitors the competitors list
     * @param match the match type
     */
    public League(List<Competitor> competitors,Match match) {
        super(competitors,match);
    }

    /**
     * Method that allow us to start the Competition
     * */
    @Override
    public void play(){
        this.fireCompetitionStarted();
        System.out.print("\n");
        this.play(this.competitors);
        Map<Competitor, Integer> ranking = this.ranking();
        System.out.println("\n*** Ranking ***");
        ranking.forEach(
            (c,p) -> {
                System.out.println(c.getName() + " - " + p);
            }
        );
        System.out.print("\n");
        this.fireCompetitionFinished();
           
    }

    /**
     * Method that makes the competitors plays against each other  
     * @param competitors the competitors
     */
    @Override
    protected void play(List<Competitor> competitors) {
        for (Competitor c1 : competitors) {
            for (Competitor c2 : competitors) {
                if (c1 != c2) this.playMatch(c1, c2);
            }
        }
    }

}
