package hearthstone.exception;

/**
 * Exception levée quand on rencontre une carte dorée mais que ce n'est pas
 * possible
 * 
 * @author lanoix-a remm-jf
 * @version 1.0
 */
public class DeckSuppressionException extends HearthstoneException {

    public DeckSuppressionException(String s) {
        super(s);
    }
}
