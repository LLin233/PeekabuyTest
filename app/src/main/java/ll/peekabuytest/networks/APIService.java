package ll.peekabuytest.networks;

import com.google.gson.JsonElement;

import ll.peekabuytest.models.Looks;
import ll.peekabuytest.models.Products;
import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Le on 2016/3/8.
 */
public interface APIService {
    @FormUrlEncoded
    @POST("create_looks_from_closet_with_anchors/")
    Call<Looks> getLooks(@Field("username") String username);

    //https://test.flaunt.peekabuy.com/api/look/get_similar_products/?username=xi-liu1&product_id=234
    @GET("get_similar_products/")
    Call<Products> getSimilarProducts(@Query("username") String username, @Query("product_id") String id);
}
