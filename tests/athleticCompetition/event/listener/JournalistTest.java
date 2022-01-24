package athleticCompetition.event.listener;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JournalistTest {

    private Journalist jl;

    @BeforeEach
    public void before() {
        this.jl = new Journalist("Anderson Cooper");
    }

    @Test
    public void rightNameTest() {
        assertEquals(this.jl.getName(), "Anderson Cooper");
    }
}
