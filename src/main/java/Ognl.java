import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created by jimjian on 2016/11/25.
 */
public class Ognl {

    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null) return true;

        if (o instanceof String) {
            if (((String) o).length() == 0) {
                return true;
            }
        } else if (o instanceof Collection) {
            if (((Collection) o).isEmpty()) {
                return true;
            }
        } else if (o.getClass().isArray()) {
            if (Array.getLength(o) == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).isEmpty()) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}