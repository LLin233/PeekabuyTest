package ll.peekabuytest.models;

import java.util.List;

/**
 * Created by Le on 2016/3/9.
 */
public class ProductsLoadingEvent {
    private List<Product> mProducts;

    public ProductsLoadingEvent(List<Product> products) {
        mProducts = products;
    }

    public List<Product> getSimilarProducts() {
        return mProducts;
    }
}
