package athleticCompetition.competition;

import static org.junit.jupiter.api.Assertions.*;

import athleticCompetition.*;
import athleticCompetition.exception.NotInCompetitionException;
import athleticCompetition.match.RandomWinnerMatch;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TournamentTest extends CompetitionTest {

    @BeforeEach
    public void before() {
        super.before();
        this.competition = new Tournament(this.competitors, this.match);
    }

    @Test
    public void pointsAddedTest() {
        assertTrue(zac.getPoints() == 0);
        assertTrue(yoni.getPoints() == 0);
        assertTrue(messi.getPoints() == 0);
        assertTrue(ronaldo.getPoints() == 0);
        this.competition.play();
        assertTrue(
            zac.getPoints() <= 2 &&
            yoni.getPoints() <= 2 &&
            messi.getPoints() <= 2 &&
            ronaldo.getPoints() <= 2
        );
    }

    @Test
    public void onlyOneWinnerTest() {
        this.competition.play();
        Map<Competitor, Integer> ranking = this.competition.ranking();
        Competitor winner = ranking.keySet().iterator().next();
        int winnerPoints = winner.getPoints();
        for (var e : ranking.keySet()) {
            if (e != winner) {
                if (e.getPoints() >= winnerPoints) fail();
            }
        }
    }

    @Test
    public void winnerHasCorrectPoints() {
        this.competition.play();
        Competitor winner;
        try {
            winner = this.competition.getNthCompetitor(1);
            assertTrue(winner.getPoints() == 2);
        } catch (NotInCompetitionException e) {
            fail();
        }
    }
}
