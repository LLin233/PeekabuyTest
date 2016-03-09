package ll.peekabuytest.networks;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import de.greenrobot.event.EventBus;
import ll.peekabuytest.Constants;
import ll.peekabuytest.models.Looks;
import ll.peekabuytest.models.OutfitLoadingEvent;
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
                                EventBus.getDefault().post(new OutfitLoadingEvent(response.body().getLooks().get(0)));
                            }
                        }
                        @Override
                        public void onFailure(Throwable t) {
                            t.printStackTrace();
                        }
                    });
    }

}
