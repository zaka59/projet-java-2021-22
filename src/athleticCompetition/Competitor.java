package athleticCompetition;

/** Represents a Competitor.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class Competitor {

    private String name;/*competitor's name*/
    private int points;/* competitor's points*/

    /**
     * The Constructor
     * @param name the competitor's name
     */
    public Competitor(String name) {
        this.name = name;
        this.points = 0;
    }

    /**
     * Gets the competitor’s name.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the competitor’s points.
     * @return the points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Method that adds points to the competitor
     * @param points the points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * The toString method
     * */
    public String toString() {
        return "The competitor " + this.name + " has " + this.points;
    }

    /**
     * Method that checks if the given competitor is the same as this one
     * @param obj the other competitor
     * */
    public boolean equals(Object obj) {
        if (!(obj instanceof Competitor)) return false;
        Competitor other = (Competitor) obj;
        if (this.name == null) {
            return (other.name == null);
        } else {
            return this.name.equals(other.name);
        }
    }
}
