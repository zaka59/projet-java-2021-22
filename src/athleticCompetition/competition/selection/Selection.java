package athleticCompetition.competition.selection;

import athleticCompetition.*;
import athleticCompetition.competition.*;
import athleticCompetition.exception.NotEnoughCompetitorsException;
import java.util.List;

/** Represents a Selection type.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public interface Selection {
	

     
    /**
     * Method that creates a list of groups with the a a given list of competitors
     * @param competitors the competitors list
     * @return the groups
	 * @throws NotEnoughCompetitorsException In case that the there isn't enough competitors
	 */
    public List<League> groups(List<Competitor> competitors)
        throws NotEnoughCompetitorsException;

    /**
     * Method that returns the nb of groups
     * @return the nb of groups
     */
    //public int getNbGroups();

    /**
     * Method that creates a Tournament of the winner of each group
     * @param groups the groups of competitors
     * @return the groups
     */
    public Tournament finalists(List<League> groups);
}
