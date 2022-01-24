package athleticCompetition.match;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import athleticCompetition.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class MatchTest {

	protected Competitor yoni;
	protected Competitor zac;
	protected Match match;

	@BeforeEach
	public void before()
	{
		this.yoni = new Competitor("Yoni");
		this.zac = new Competitor("Zac");
	}

    @Test
    public abstract void thereIsAWinnerTest();

    @Test
    public abstract void rightCompetitorsTest();

}

