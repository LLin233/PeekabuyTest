package ll.peekabuytest.models.events;

import java.util.List;

import ll.peekabuytest.models.Product;

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
