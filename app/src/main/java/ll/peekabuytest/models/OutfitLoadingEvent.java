package ll.peekabuytest.models;

/**
 * Created by Le on 2016/3/8.
 */
public class OutfitLoadingEvent {
    private Look mLook;

    public OutfitLoadingEvent(Look loadedLook) {
        this.mLook = loadedLook;
    }

    public Look getLook() {
        return mLook;
    }
}
