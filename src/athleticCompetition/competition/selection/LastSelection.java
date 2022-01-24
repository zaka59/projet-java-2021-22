package athleticCompetition.competition.selection;

import athleticCompetition.*;
import athleticCompetition.match.*;
import athleticCompetition.competition.*;
import athleticCompetition.exception.*;
import java.util.ArrayList;
import java.util.List;

/** Represents a Selection.
 * it creates 4 groups and selects the last of each group.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class LastSelection implements Selection {

    /**nb of competitors */
    private int nbCompetitors;

    /**the match */
    private Match match;

    /**
     * Constructor 
     * @param match the match type
     */
    public LastSelection(Match match) {
        this.match = match;
    }

    /**
     * Method that creates a list of groups with the a a given list of competitors
     * @param competitors the competitors list
     * @return the groups
     */
    public List<League> groups(List<Competitor> competitors)
        throws NotEnoughCompetitorsException {
        this.nbCompetitors = competitors.size();
        if (
            nbCompetitors < 4 * 2 && nbCompetitors % 2 != 0
        ) throw new NotEnoughCompetitorsException("Not enought competitors");
        List<League> groups = new ArrayList<>();
        List<Competitor> group = new ArrayList<>();
        int i = 0;
        for (Competitor c : competitors) {
            group.add(c);
            i++;
            if (i % (nbCompetitors / 4) == 0) {
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
                finalists.add(l.getNthCompetitor(nbCompetitors / 4));
            } catch (NotInCompetitionException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        Tournament t = new Tournament(finalists, this.match);
        return t;
    }
}
