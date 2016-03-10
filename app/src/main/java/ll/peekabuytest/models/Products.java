package ll.peekabuytest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 2016/3/9.
 */
public class Products {
    public String message;
    public int code;
    public List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }
}
