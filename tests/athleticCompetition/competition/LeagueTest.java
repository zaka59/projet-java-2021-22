package athleticCompetition.competition;

import static org.junit.jupiter.api.Assertions.*;

import athleticCompetition.*;
import athleticCompetition.match.RandomWinnerMatch;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeagueTest extends CompetitionTest {

    @BeforeEach
    public void before() {
        super.before();
        this.competition = new League(this.competitors, this.match);
    }

    @Test
    public void RankigTest() {
        Map<Competitor, Integer> ranking = this.competition.ranking();
        int previous = 0;
        int tmp;
        for (var e : ranking.keySet()) {
            tmp = e.getPoints();
            if (tmp < previous) fail();
            previous = tmp;
        }
    }

    @Test
    public void pointsAddedTest() {
        assertTrue(zac.getPoints() == 0);
        assertTrue(yoni.getPoints() == 0);
        assertTrue(messi.getPoints() == 0);
        assertTrue(ronaldo.getPoints() == 0);
        this.competition.play();
        assertTrue(
            zac.getPoints() <= 6 &&
            yoni.getPoints() <= 6 &&
            messi.getPoints() <= 6 &&
            ronaldo.getPoints() <= 6
        );
    }
}
