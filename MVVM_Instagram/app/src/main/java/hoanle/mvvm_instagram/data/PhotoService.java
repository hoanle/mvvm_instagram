package hoanle.mvvm_instagram.data;


import hoanle.mvvm_instagram.extra.Constant;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by hoanle on 4/8/16.
 */
public interface PhotoService {

    @GET(Constant.POPULAR_MEDIA)
    Observable<PhotoResponse> getPhotos();
}
