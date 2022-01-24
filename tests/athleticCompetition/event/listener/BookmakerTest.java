package athleticCompetition.event.listener;

import static org.junit.jupiter.api.Assertions.*;

import athleticCompetition.*;
import athleticCompetition.competition.*;
import athleticCompetition.event.MatchEvent;
import athleticCompetition.match.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookmakerTest {

    private Bookmaker bm;
    private Competitor zac;
    private Competitor yoni;
    private List<Competitor> competitors;
    private Competition competition;
    private Match match;

    @BeforeEach
    public void before() {
        this.bm = new Bookmaker("Betclic");
        this.zac = new Competitor("Zac");
        this.yoni = new Competitor("Yoni");
        this.competitors = new ArrayList<>();
        this.competitors.add(this.zac);
        this.competitors.add(this.yoni);
        this.match = new RandomWinnerMatch();
        this.competition = new League(this.competitors, this.match);
        this.competition.addListener(bm);
    }

    @Test
    public void competitorsAddedToListenerTest() {
        this.competition.play();
        assertTrue(
            this.competition.getCompetitors().size() == this.bm.getOdds().size()
        );
        for (Competitor c : this.competition.getCompetitors()) {
            assertTrue(this.bm.getOdds().containsKey(c));
        }
    }

    @Test
    public void allCompetitorsHaveAtLeastOneOddTest() {
        this.competition.play();
        for (Competitor c : this.competition.getCompetitors()) {
            assertTrue(this.bm.getOdds().get(c) >= 1);
        }
    }

    @Test
    public void oddsAddedCorrectlyTestTest() {
        this.bm.addCompetitors(this.competitors);
        this.match.addListener(bm);
        Competitor winner = this.match.play(this.zac, this.yoni);
        Competitor loser = (winner.equals(zac)) ? this.yoni : this.zac;
        assertEquals(this.bm.getCompetitorOdds(winner), 1);
        assertEquals(this.bm.getOdds().get(loser), 2);
    }

    @Test
    public void rightNameTest() {
        assertTrue(this.bm.getName().equals("Betclic"));
    }
}
