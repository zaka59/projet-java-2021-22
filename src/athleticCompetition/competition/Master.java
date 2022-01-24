package athleticCompetition.competition;

import athleticCompetition.*;
import athleticCompetition.competition.selection.*;
import athleticCompetition.match.*;
import athleticCompetition.exception.NotEnoughCompetitorsException;
import java.util.List;

/** Represents a Master Competition.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class Master extends Competition {

    private Selection selection; // the selection method
    private List<League> groups; // the groups
    private Tournament finalists; // the finalists

    /**
     * Constructor
     * @param competitors the competitors list
     * @param match the match type
     * @param selection the selection method
     */
    public Master(
        List<Competitor> competitors,
        Match match,
        Selection selection
    ) {
        super(competitors, match);
        this.selection = selection;
        try {
            this.groups = this.selection.groups(this.competitors);
        } catch (NotEnoughCompetitorsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that allow us to start the Competition
     * */
    @Override
    public void play() {
        this.fireCompetitionStarted();
        int i = 65;
        for (League l : this.groups){
            System.out.println("\nGroup " +((char)i++)+" :\n");
            l.play();
            System.out.println("\n------------------");
        }
        System.out.println("\n###############################");
        this.finalists = this.selection.finalists(this.groups);
        System.out.println("\nFinalists tournament : \n");
        this.finalists.play();
        System.out.println("\n###############################");
        this.fireCompetitionFinished();
    }

    /**
     * Method that makes the competitors plays against each other
     * @param competitors the competitors
     */
    @Override
    protected void play(List<Competitor> competitors) {
        /*Nothing here */
    }
    
    /**Gets the tournament of the finalists
     * @return the tournament 
     */
    public Tournament getFinalists() {
    	return this.finalists;
    }
    
    /**Gets the groups
     * @return the list of groups
     */
    public List<League> getGroups() {
    	return this.groups;
    }
    
}
