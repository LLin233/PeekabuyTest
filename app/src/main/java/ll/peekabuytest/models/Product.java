package ll.peekabuytest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 2016/3/8.
 */
public class Product {
    public String merchant;
    public String sub_category;
    public String price;
    public String brand_name;
    public String product_url;
    public String currency;
    public List<Object> colors = new ArrayList<Object>();
    public String masked_image_url;
    public int num_likes;
    public float y_1;
    public float x_0;
    public float x_1;
    public int price_cents;
    public String date_saved;
    public String id;
    public List<String> color_swatch_url = new ArrayList<String>();
    public String description;
    public List<String> color_images_url = new ArrayList<String>();
    public List<String> alt_images_url = new ArrayList<String>();
    public int update_time_sec;
    public String main_category;
    public int fair_market_price_cents;
    public Object type;
    public List<Object> sizes = new ArrayList<Object>();
    public int image_width;
    public String fair_market_price;
    public float y_0;
    public int image_height;
    public String image_url;
    public String details;
    public boolean in_stock;
    public int num_saves;

    public float[] getCoordinates() {
        return new float[]{x_0, y_0, x_1, y_1};
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                "price='" + price + '\'' +
                ", image_url='" + image_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
