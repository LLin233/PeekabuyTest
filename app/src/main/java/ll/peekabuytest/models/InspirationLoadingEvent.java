package ll.peekabuytest.models;

import java.util.List;

/**
 * Created by Le on 2016/3/9.
 */
public class InspirationLoadingEvent {
    private List<InspirationLook> mInspirationLookList;
    public InspirationLoadingEvent(List<InspirationLook> list) {
        mInspirationLookList = list;
    }
    public List<InspirationLook> getInspirationLookList() {
        return mInspirationLookList;
    }
}
