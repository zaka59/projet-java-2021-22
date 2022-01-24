package athleticCompetition.competition.selection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;


import athleticCompetition.*;
import athleticCompetition.competition.League;
import athleticCompetition.exception.NotEnoughCompetitorsException;
import athleticCompetition.exception.NotInCompetitionException;

public  class LastSelectionTest extends SelectionTest{



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

        this.selection = new LastSelection(this.match); 
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
    	int size_c = this.competitors.size();
        double log = (int) (Math.log(size_c) / Math.log(2));
        double pow = Math.pow(2, Math.round(log));
        int size_g = this.groups.size();
    }
    
    
    @Test
    public  void rightAmountFinalistsTest(){
        int size_c = this.competitors.size();
        int size_g = this.groups.size();
        assertEquals(this.finalists.getCompetitors().size(),size_g );
    }


    @Test
    public void correctFinalistsTests(){
        int last = (this.competitors.size() / this.groups.size() );
        Competitor c;
        boolean status = false;
        for (League l : this.groups){
            try {
				c = l.getNthCompetitor(last);
                for(Competitor c2 : this.finalists.getCompetitors()){
                    if(c.equals(c2))
                        status=true;
                }
                assertTrue(status);
                status = false;
			} catch (NotInCompetitionException e) {
				fail();
			}
            
        }


    }
   

}
