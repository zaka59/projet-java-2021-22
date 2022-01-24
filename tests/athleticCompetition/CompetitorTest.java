package athleticCompetition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompetitorTest {

    private Competitor zac;
    private Competitor yoni;

    @BeforeEach
    public void before() {
        this.zac = new Competitor("zac");
        this.yoni = new Competitor("yoni");
    }

    @Test
    public void nameIsCorrectTest() {
        assertEquals("zac", this.zac.getName());
    }

    @Test
    public void pointsAddedTest() {
        assertEquals(0, this.zac.getPoints());
        zac.addPoints(2);
        assertEquals(2, this.zac.getPoints());
    }

    @Test
    public void diffrentCompetitorsTest() {
        assertFalse(zac.equals(yoni));
    }
}
