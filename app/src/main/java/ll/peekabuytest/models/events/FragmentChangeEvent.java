package ll.peekabuytest.models.events;

/**
 * Created by Le on 2016/3/12.
 */
public class FragmentChangeEvent {
    boolean isProductMode = false;
    public FragmentChangeEvent(boolean isProductMode) {
        this.isProductMode = isProductMode;
    }

    public boolean isProductMode() {
        return isProductMode;
    }
}
