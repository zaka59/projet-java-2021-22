package athleticCompetition.match;
import athleticCompetition.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RandomWinnerMatchTest extends MatchTest{



    @BeforeEach
    public void before(){
        super.before();
        this.match = new RandomWinnerMatch();
    }
    @Test
    public void thereIsAWinnerTest() {
        Competitor winner = match.play(zac, yoni);
        assertTrue(winner.equals(zac) || winner.equals(yoni));
    }
     
    @Test
    public void rightCompetitorsTest(){
        this.match.play(this.zac, this.yoni);
        assertEquals(this.match.getC1(),this.zac);
        assertEquals(this.match.getC2(),this.yoni);
    }
}
