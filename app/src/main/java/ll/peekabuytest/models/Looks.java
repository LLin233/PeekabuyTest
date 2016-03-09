package ll.peekabuytest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 2016/3/8.
 */
public class Looks {
    public boolean has_more;
    public String message;
    public int code;
    public List<Look> looks = new ArrayList<Look>();

    public List<Look> getLooks() {
        return looks;
    }

    @Override
    public String toString() {
        return "Code: " + code + " " + message;
    }
}
