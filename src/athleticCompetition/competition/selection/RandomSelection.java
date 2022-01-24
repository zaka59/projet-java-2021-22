package athleticCompetition.competition.selection;

import athleticCompetition.*;
import athleticCompetition.match.*;
import athleticCompetition.competition.*;
import athleticCompetition.exception.*;
import athleticCompetition.match.RandomWinnerMatch;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Represents a Selection.
 * it creates 4 groups  of 4 competitors and selects a random competitors of each group.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class RandomSelection implements Selection {

    /**random to shuffle the competitors*/
    private static final Random RANDOM = new Random();

    /**the match */
    private Match match;


    /**
     * Constructor 
     * @param match the match type
     */
    public RandomSelection(Match match) {
        this.match = new RandomWinnerMatch();
    }

    /**
     * Method that creates a list of groups with the a a given list of competitors
     * @param competitors the competitors list
     * @return the groups
     */
    public List<League> groups(List<Competitor> competitors)
        throws NotEnoughCompetitorsException {
        if (competitors.size() != 16
        ) throw new NotEnoughCompetitorsException("this competition needs 16 competitors" );
        List<League> groups = new ArrayList<>();
        List<Competitor> group = new ArrayList<>();
        int i = 0;
        for (Competitor c : competitors) {
            group.add(c);
            i++;
            if (i % 4 == 0) {
                groups.add(new League(group, match));
                group = new ArrayList<>();
            }
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
                finalists.add(
                    l.getNthCompetitor(
                        RANDOM.nextInt(4) + 1
                    )
                );
            } catch (NotInCompetitionException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        Tournament t = new Tournament(finalists, this.match);
        return t;
    }
}
