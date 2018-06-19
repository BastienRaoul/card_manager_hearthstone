package hearthstone.exception;

/**
 * Exception levée quand une carte BASIQUE est trouvée alors que ce n'est pas p
 * ssible
 * 
 * @author lanoix-a remm-jf
 * @version 1.0
 */
public class CarteBasiqueException extends HearthstoneException {
    public CarteBasiqueException(String s) {
        super(s);
    }
}
