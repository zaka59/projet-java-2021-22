package athleticCompetition.exception;

/** Represents a Exception that will be thrown if the amount of players is incorrect.
 * @author Yoni GAUDIERE
 * @author Zakaria EL KHAYARI
 */
public class NotEnoughCompetitorsException extends Exception {


	private static final long serialVersionUID = 1L;

	/**First Constructor
     * */
    public NotEnoughCompetitorsException(){
        super();
    }

    /**Second Constructor
     * @param msg the message to display
     */
    public NotEnoughCompetitorsException(String msg){
        super(msg);
    }
}
