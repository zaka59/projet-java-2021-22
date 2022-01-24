package athleticCompetition.event;

import static org.junit.jupiter.api.Assertions.*;

import athleticCompetition.*;
import athleticCompetition.competition.*;
import athleticCompetition.match.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatchEventTest {

    protected Competitor zac;
    protected Competitor yoni;
    protected Match match;
    protected MatchEvent me;

    @BeforeEach
    public void before() {
        this.zac = new Competitor("Zac");
        this.yoni = new Competitor("Yoni");
        this.match = new RandomWinnerMatch();
    }

    @Test
    public void rightMatchTest() {
        this.me = new MatchEvent(this.match, this.zac, this.yoni);
        assertTrue(this.match.equals(this.me.getSource()));
    }

    @Test
    public void rightLoserTest() {
        Competitor winner = this.match.play(zac, yoni);
        Competitor loser = (winner.equals(zac)) ? yoni : zac;
        this.me = new MatchEvent(this.match, winner, loser);
        assertTrue(this.me.getWinner().equals(winner));
        assertFalse(this.me.getLoser().equals(winner));
    }

    @Test
    public void rightWinnerTest() {
        Competitor winner = this.match.play(zac, yoni);
        Competitor loser = (winner.equals(zac)) ? yoni : zac;
        this.me = new MatchEvent(this.match, winner, loser);
        assertTrue(this.me.getLoser().equals(loser));
        assertFalse(this.me.getWinner().equals(loser));
    }
}
