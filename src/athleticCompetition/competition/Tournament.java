package athleticCompetition.competition;

import athleticCompetition.*;
import athleticCompetition.match.*;
import athleticCompetition.exception.NotInCompetitionException;
import athleticCompetition.util.*;
import java.util.*;

/** Represents a Tournament Competition.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class Tournament extends Competition {


    /**
     * The Constructor
     * @param competitors the competitors list
     * @param match the match type
     */
    public Tournament(List<Competitor> competitors, Match match) {
        super(competitors, match);
    }

    /** Method that allow us to start the Competition
     **/
    @Override
    public void play() {
        if (this.competitors.size() % 2 != 0) {
            System.out.println("A tournament is played with a number of players with the power of twoo");
            return;
        }
        this.fireCompetitionStarted();
        List<Competitor> copy = new ArrayList<>(this.competitors);
        List<Integer> cache_points = new ArrayList<>();
        for(Competitor c : this.competitors)
        	cache_points.add(c.getPoints());
        int round = 0;
        int totalRounds = (int) (
            Math.log(this.competitors.size()) / Math.log(2)
        );
        
        List<Competitor> winners = new ArrayList<>();
        for (Competitor c : copy) {
            c.addPoints(-c.getPoints());
        }
        while (round <= totalRounds) {
	  
            int size= copy.size();		
	    if (size>1) System.out.println("\nRound of "+ size +" :");

            this.play(copy);

            for (Competitor c : copy) {
                if (c.getPoints() > round) {
                    winners.add(c);
                }
            }
            round++;
            copy.clear();
            copy.addAll(winners);
            winners.clear();
        }
        int i = 0;
        for(Competitor c : this.competitors)
        	c.addPoints(cache_points.get(i++));
        
        try {
            System.out.println(
                ConsoleColors.GREEN +
                "\nThe winner is " +
                this.getNthCompetitor(1).getName() +
                ConsoleColors.RESET
            );
        } catch (NotInCompetitionException e) {}
        this.fireCompetitionFinished();
    }

    /**
     * Method that makes the competitors plays against each other
     * @param competitors the competitors
     */
    @Override
    protected void play(List<Competitor> competitors) {
        Competitor c1;
        Competitor c2;
        for (int i = 1; i < competitors.size(); i += 2) {
            c1 = competitors.get(i);
            c2 = competitors.get(i - 1);
            this.playMatch(c1, c2);
        }
    }
}
