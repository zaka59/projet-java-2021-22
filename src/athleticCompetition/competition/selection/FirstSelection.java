package athleticCompetition.competition.selection;

import athleticCompetition.*;
import athleticCompetition.match.*;
import athleticCompetition.competition.*;
import athleticCompetition.exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/** Represents a Selection.
 * it creates 4 groups of 6 competitors and selects the first of each group.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class FirstSelection implements Selection {



    /**the match */
    private Match match;



    /**
     * Constructor
     * @param match the match type
     */
    public FirstSelection(Match match) {
        this.match = match;
    }

    /**
     * Method that creates a list of groups with the a a given list of competitors
     * @param competitors the competitors list
     * @return the groups
     */
    public List<League> groups(List<Competitor> competitors)
        throws NotEnoughCompetitorsException {
        int size = competitors.size();
        if (
            size != 24
        ) throw new NotEnoughCompetitorsException(" ");
        List<League> groups = new ArrayList<>();
        List<Competitor> group = new ArrayList<>();
        int i = 0;
        Collections.shuffle(competitors); /*shuffle */
        for (Competitor c : competitors) {
            group.add(c);
            i++;
            if (i % 6 == 0) {
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
                finalists.add(l.getNthCompetitor(1));
            } catch (NotInCompetitionException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        Tournament t = new Tournament(finalists, this.match);
        return t;
    }
}
