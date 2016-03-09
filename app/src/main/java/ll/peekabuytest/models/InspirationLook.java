package ll.peekabuytest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 2016/3/8.
 */
public class InspirationLook {
    public Creator creator;
    public int image_width;
    public int thumbnail_width;
    public int image_height;
    public String image_url;
    public List<String> image_urls = new ArrayList<String>();
    public int thumbnail_height;
    public String thumbnail_url;
    public String id;

    @Override
    public String toString() {
        return "InspirationLook{" +
                "id='" + id + '\'' +
                ", Creater: " + creator.name + "\'" +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
