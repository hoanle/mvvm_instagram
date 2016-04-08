package hoanle.mvvm_instagram.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by hoanle on 4/8/16.
 */
public class PhotoFactory {
    private final static String BASE_URL = "https://api.instagram.com/";

    public static PhotoService create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(PhotoService.class);
    }

}
