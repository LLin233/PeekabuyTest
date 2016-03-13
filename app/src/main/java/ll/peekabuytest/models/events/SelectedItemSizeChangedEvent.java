package ll.peekabuytest.models.events;

/**
 * Created by Le on 2016/3/12.
 */
public class SelectedItemSizeChangedEvent {
    private int newWidth;
    private int newHeight;

    public SelectedItemSizeChangedEvent(float newWidth, float newHeight) {
        this.newHeight = (int) newHeight;
        this.newWidth = (int) newWidth;
    }
    public int getNewHeight() {
        return newHeight;
    }

    public int getNewWidth() {
        return newWidth;
    }
}
