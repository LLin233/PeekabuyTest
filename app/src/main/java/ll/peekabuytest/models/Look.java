package ll.peekabuytest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 2016/3/8.
 */
public class Look {
    public String creator_profile_picture_url;
    public String description;
    public List<Object> tags = new ArrayList<Object>();
    public String timestamp;
    public int num_saves;
    public List<String> image_urls = new ArrayList<String>();
    public String hashcode;
    public String thumbnail_url;
    public int num_likes;
    public int thumbnail_width;
    public Object item_info;
    public int thumbnail_height;
    public String creator_username;
    public String id;
    public List<InspirationLook> inspiration_looks = new ArrayList<InspirationLook>();
    public String linkback_url;
    public List<Product> products = new ArrayList<Product>();
    public String creator_name;
    public int num_comments;
    public Creator creator;
    public int image_width;
    public List<Object> taggings = new ArrayList<Object>();
    public Object inputs_info;
    public int image_height;
    public String image_url;
    public int promotion_status;
    public int type;

    @Override
    public String toString() {
        return "Look{" +
                "creatorProfilePictureUrl='" + creator_profile_picture_url + '\'' +
                ", inspirationLooks=" + inspiration_looks +
                ", products=" + products +
                ", id='" + id + '\'' +
                ", thumbnailUrl='" + thumbnail_url + '\'' +
                '}';
    }
}
