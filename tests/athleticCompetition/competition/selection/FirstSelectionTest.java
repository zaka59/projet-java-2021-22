package athleticCompetition.competition.selection;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import athleticCompetition.Competitor;
import athleticCompetition.competition.League;
import athleticCompetition.exception.NotEnoughCompetitorsException;
import athleticCompetition.exception.NotInCompetitionException;


public class FirstSelectionTest extends SelectionTest{



    @BeforeEach
    public void before(){
        super.before();
        String[] names = {
            "Zac",
            "Yoni",
            "Messi",
            "Ronaldo",
            "Musk",
            "Lebron",
            "Damien",
            "Routier",
            "Dave",
            "Kevin",
            "Ellis",
            "Mabel",
            "Jenna",
            "Irene",
            "Teresa",
            "Fannie",
            "Angela",
            "Trump",
            "Obama",
            "Macron",
            "Filip",
            "Samar",
            "Wara",
            "Isidore",
        };
        for (String name : names) {
            this.competitors.add(new Competitor(name));
        }

        this.selection = new FirstSelection(this.match); 
        try {
			this.groups = this.selection.groups(this.competitors);
		} catch (NotEnoughCompetitorsException e) {
			fail();
		}
        for (League l : this.groups){
            l.play();
        }
        this.finalists = this.selection.finalists(this.groups);    
    }


    @Test
    public  void rightAmountGroupsTest(){
        assertTrue(this.groups.size() == 4);
    }

    @Test
    public  void rightAmountCompetitorsTest(){
        assertTrue(this.competitors.size() == 24);
        for (League l : this.groups){
            assertTrue(l.getCompetitors().size()==6);
        }

    }
    @Test
    public  void rightAmountFinalistsTest(){
        assertTrue(this.finalists.getCompetitors().size() == 4);
    }
    
    @Test
    public  void correctFinalistsTests(){
        Competitor c;
        for (League l : this.groups){
            try {
				c = l.getNthCompetitor(1);
				assertTrue(this.finalists.getCompetitors().contains(c));
			} catch (NotInCompetitionException e) {
				fail();
			}
            
        }


    }
}
