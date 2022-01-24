package athleticCompetition.competition;

import static org.junit.jupiter.api.Assertions.*;

import athleticCompetition.*;
import athleticCompetition.competition.selection.*;
import athleticCompetition.competition.selection.FirstSelection;
import athleticCompetition.exception.NotInCompetitionException;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MasterTest extends CompetitionTest {

    @BeforeEach
    public void before() {
        super.before();
        String[] names = {
            "Zac",
            "Yoni",
            "Messi",
            "Ronaldo",
            "Musk",
            "Lebron",
            "Damien",
            "Routier",
            "Dave",
            "Kevin",
            "Ellis",
            "Mabel",
            "Jenna",
            "Irene",
            "Teresa",
            "Fannie",
            "Angela",
            "Trump",
            "Obama",
            "Macron",
            "Filip",
            "Samar",
            "Wara",
            "Isidore",
        };
        List<Competitor> cc = new ArrayList<>();
        for (String name : names) {
            cc.add(new Competitor(name));
        }

        Selection s = new FirstSelection(this.match);
        this.competition = new Master(cc, this.match, s);
    }

    @Test
    public void pointsAddedTest() {
        for (Competitor c : this.competition.getCompetitors()) {
            assertTrue(c.getPoints() == 0);
        }
    }

    @Test
    public void rightAmountGroupsTest() {
        assertTrue(((Master) this.competition).getGroups().size() == 4);
    }

    @Test
    public void rightAmountFinalistsTest() {
        this.competition.play();
        assertTrue(
            ((Master) this.competition).getFinalists()
                .getCompetitors()
                .size() ==
            4
        );
    }

    @Test
    public void onlyOneWinnerTest() {
        this.competition.play();
        try {
        Competitor winner = this.competition.getNthCompetitor(1);
        int winnerPoints = winner.getPoints();
            for(Competitor c : this.competition.getCompetitors()){
                if(!c.equals(winner))
                    assertTrue(winnerPoints > c.getPoints());
            }
            
        } catch (NotInCompetitionException e1) {
            fail();
        }
    }

    /* @Disabled("Disabled for now") */
    @Test
    public void rightWinnerTest() {
        this.competition.play();
        try {
            assertEquals(
                this.competition.getNthCompetitor(1)
                    ,
                        ((Master) this.competition).getFinalists()
                            .getNthCompetitor(1)
                    
            );
        } catch (NotInCompetitionException e) {
            fail();
        }
    }
}
