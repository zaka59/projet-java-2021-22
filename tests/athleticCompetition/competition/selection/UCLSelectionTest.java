package athleticCompetition.competition.selection;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import athleticCompetition.*;

import athleticCompetition.competition.League;
import athleticCompetition.exception.NotEnoughCompetitorsException;
import athleticCompetition.exception.NotInCompetitionException;


public  class UCLSelectionTest extends SelectionTest{



    @BeforeEach
    public void before(){
        super.before();
        String[] names = {
                "Chelsea FC",
                "Villarreal",
                "Atlético de Madrid",
                "Manchester City",
                "Bayern Munich",
                "Inter Milan",
                "LOSC Lille",
                "Sporting CP",
                "Real Madrid",
                "FC Barcelone",
                "Juventus FC",
                "Manchester United",
                "Paris Saint-Germain",
                "Liverpool FC",
                "Séville FC",
                "Borussia Dortmund",
                "FC Porto",
                "Ajax Amsterdam",
                "Chakhtar Donetsk",
                "RB Leipzig",
                "RB Salzbourg",
                "SL Benfica",
                "Atalanta Bergame",
                "Zénith Saint-Pétersbourg",
                "Beşiktaş JK",
                "Dynamo Kiev",
                "Club Bruges KV",
                "BSC Young Boys",
                "AC Milan",
                "Malmö FF",
                "VfL Wolfsburg",
                "Sheriff Tiraspol",
            };
        for (String name : names) {
            this.competitors.add(new Competitor(name));
        }

        this.selection = new UCLSelection(this.match); 
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
        assertTrue(this.groups.size() == 8);
    }

    @Test
    public  void rightAmountCompetitorsTest(){
        int size_c = this.competitors.size();
        assertTrue(size_c  == 32);
        for (League l : this.groups){
            assertTrue(l.getCompetitors().size()== 4  );
        }

    }
    @Test
    public  void rightAmountFinalistsTest(){

        assertTrue(this.finalists.getCompetitors().size() == 16) ;
    }
    
    @Test
    public  void correctFinalistsTests(){
         
        Competitor c;
        for (League l : this.groups){
            try {
				c = l.getNthCompetitor(1);
				assertTrue(this.finalists.getCompetitors().contains(c));
				c = l.getNthCompetitor(2);
				assertTrue(this.finalists.getCompetitors().contains(c));
			} catch (NotInCompetitionException e) {
				fail();
			}
            
        }


    }

}
