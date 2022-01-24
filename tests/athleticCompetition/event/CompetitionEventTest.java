package athleticCompetition.event;

import static org.junit.jupiter.api.Assertions.*;

import athleticCompetition.*;
import athleticCompetition.competition.*;
import athleticCompetition.match.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompetitionEventTest {

    protected Competitor zac;
    protected Competitor yoni;
    protected List<Competitor> competitors;
    protected Competition competition;
    protected Match match;
    protected CompetitionEvent ce;

    @BeforeEach
    public void before() {
        this.zac = new Competitor("Zac");
        this.yoni = new Competitor("Yoni");
        this.competitors = new ArrayList<>();
        this.match = new RandomWinnerMatch();
        this.competition = new League(this.competitors, this.match);
        this.ce = new CompetitionEvent(this.competition);
    }

    @Test
    public void rightCompetitionTest() {
        assertTrue(this.competition.equals(this.ce.getSource()));
    }
}
