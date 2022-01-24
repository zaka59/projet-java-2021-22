package athleticCompetition.exception;

/** Represents a Exception that will be thrown if a Competitor is not in the Competition.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class NotInCompetitionException extends Exception {


	private static final long serialVersionUID = 1L;

	/**First Constructor
     * */
    public NotInCompetitionException(){
        super();
    }

    /**Second Constructor
     * @param msg the message to display
     */
    public NotInCompetitionException(String msg){
        super(msg);
    }
}
