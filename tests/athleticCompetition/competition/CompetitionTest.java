package athleticCompetition.competition;

import static org.junit.jupiter.api.Assertions.*;

import athleticCompetition.*;
import athleticCompetition.match.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class CompetitionTest {

    protected Competitor zac;
    protected Competitor yoni;
    protected Competitor messi;
    protected Competitor ronaldo;
    protected List<Competitor> competitors;
    protected Competition competition;
    protected Match match;

    @BeforeEach
    public void before() {
        this.zac = new Competitor("zac");
        this.yoni = new Competitor("yoni");
        this.messi = new Competitor("messi");
        this.ronaldo = new Competitor("ronaldo");
        this.competitors = new ArrayList<>();
        this.competitors.add(zac);
        this.competitors.add(yoni);
        this.competitors.add(messi);
        this.competitors.add(ronaldo);
        this.match = new RandomWinnerMatch();
    }

    @Test
    public abstract void pointsAddedTest();
}
