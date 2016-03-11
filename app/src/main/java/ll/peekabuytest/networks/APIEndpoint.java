package ll.peekabuytest.networks;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import ll.peekabuytest.Constants;
import ll.peekabuytest.models.InspirationLoadingEvent;
import ll.peekabuytest.models.Look;
import ll.peekabuytest.models.Looks;
import ll.peekabuytest.models.OutfitLoadingEvent;
import ll.peekabuytest.models.Product;
import ll.peekabuytest.models.Products;
import ll.peekabuytest.models.ProductsLoadingEvent;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Le on 2016/3/8.
 */
public final class APIEndpoint {
    private static APIService mAPIService;
    protected static OkHttpClient httpClient = new OkHttpClient();
    protected static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    static {
        setupRestClient();
    }

    private APIEndpoint() {
    }

    private static void setupRestClient() {
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        httpClient.interceptors().add(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mAPIService = retrofit.create(APIService.class);
    }

    public static APIService getApiService() {
        return mAPIService;
    }

    public static void requestUserOutfit(String username) {
        mAPIService.getLooks(username)
                .enqueue(new Callback<Looks>() {
                    @Override
                    public void onResponse(Response<Looks> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            List<Look> lookList = response.body().getLooks();
                            if (!lookList.isEmpty()) {
                                EventBus.getDefault().postSticky(new InspirationLoadingEvent(lookList.get(0).inspiration_looks));
                                EventBus.getDefault().postSticky(new OutfitLoadingEvent(lookList.get(0)));
                            } else {
                                //TODO handle empty response
                            }
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    public static void requestSimilarProducts(String username, String productId, final Product originalItem) {
        mAPIService.getSimilarProducts(username, productId)
                .enqueue(new Callback<Products>() {
                    @Override
                    public void onResponse(Response<Products> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            List<Product> list = response.body().getProducts();
                            list.add(0, originalItem);
                            Log.v("Products", list.toString());
                            EventBus.getDefault().postSticky(new ProductsLoadingEvent(list));
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
    }


}
