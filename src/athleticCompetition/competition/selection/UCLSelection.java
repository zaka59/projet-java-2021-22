package athleticCompetition.competition.selection;

import athleticCompetition.*;
import athleticCompetition.match.*;
import athleticCompetition.competition.*;
import athleticCompetition.exception.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/** Represents a Selection.
 * it replicates the UEFA Champions League
 * 8 groups of 4 teams and only the first and the second qualify to the tournament
 * In order to work, the teams have to be sorted correctly,
 * the first 8 represent the first podium, the 8 next the second etc
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class UCLSelection implements Selection {

    /**random to shuffle the competitors*/
    private static final Random RANDOM = new Random();

    /**the match */
    private Match match;


    /**
     * Constructor
     * @param match the match type
     */
    public UCLSelection(Match match ) {
        this.match = match;
    }

    /**
     * Method that creates a list of groups with the a a given list of competitors
     * @param competitors the competitors list
     * @return the groups
     */
    public List<League> groups(List<Competitor> competitors)
        throws NotEnoughCompetitorsException {
        if (competitors.size() != 32) throw new NotEnoughCompetitorsException("The UCL needs exacly 32 competitors");
        List<League> groups = new ArrayList<>();
        List<Competitor> group = new ArrayList<>();
        List<Competitor> podium1 = new ArrayList<>(competitors).subList(0, 8);
        List<Competitor> podium2 = new ArrayList<>(competitors).subList(8, 16);
        List<Competitor> podium3 = new ArrayList<>(competitors).subList(16, 24);
        List<Competitor> podium4 = new ArrayList<>(competitors).subList(24, 32);
        for (int i = 8; i >= 1; i--) {
            // here we add a random team of each podium
            group.add(podium1.remove(RANDOM.nextInt(i)));
            group.add(podium2.remove(RANDOM.nextInt(i)));
            group.add(podium3.remove(RANDOM.nextInt(i)));
            group.add(podium4.remove(RANDOM.nextInt(i)));

            groups.add(new League(group, this.match));
            group = new ArrayList<>();
        }
        return groups;
    }

    /**
     * Method that creates a Tournament of the winner of each group
     * @param groups the groups of competitors
     * @return the groups
     */
    public Tournament finalists(List<League> groups) {
        List<Competitor> finalists = new ArrayList<>();
        for (League l : groups) {
            try {
                finalists.add(l.getNthCompetitor(1));
                finalists.add(l.getNthCompetitor(2));
            } catch (NotInCompetitionException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        Collections.shuffle(finalists);/*tirage au sort*/
        Tournament t = new Tournament(finalists, this.match);
        return t;
    }
}
