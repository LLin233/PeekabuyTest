package ll.peekabuytest.models.events;

import android.graphics.Bitmap;

import ll.peekabuytest.models.Product;

/**
 * Created by Le on 2016/3/12.
 */
public class OutfitItemChangeEvent {

    private Product mProductTryOn;

    public Product getProductTryOn() {
        return mProductTryOn;
    }
    public OutfitItemChangeEvent(Product productTryOn) {
        this.mProductTryOn = productTryOn;
    }


}
