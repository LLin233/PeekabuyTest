package ll.peekabuytest.models.events;

import java.util.List;

import ll.peekabuytest.models.InspirationLook;

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
