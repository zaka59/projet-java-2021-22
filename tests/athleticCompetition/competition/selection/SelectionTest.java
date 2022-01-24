package athleticCompetition.competition.selection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import athleticCompetition.competition.League;
import athleticCompetition.*;
import athleticCompetition.match.*;
import athleticCompetition.competition.Tournament;

public  abstract class  SelectionTest {


    protected List<League> groups;
    protected Tournament finalists;
    protected Selection selection;
    protected List<Competitor> competitors;
    protected Match match;

    @BeforeEach
    public void before(){
        this.match = new RandomWinnerMatch(); 
        this.competitors = new ArrayList<>();
        this.groups = new ArrayList<>();
        
    }


    @Test
    public abstract void rightAmountGroupsTest();

    @Test
    public abstract void rightAmountCompetitorsTest();

    @Test
    public abstract void rightAmountFinalistsTest();

    @Test
    public abstract void correctFinalistsTests();
}
