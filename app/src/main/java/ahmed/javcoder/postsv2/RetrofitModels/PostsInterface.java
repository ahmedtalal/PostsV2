package ahmed.javcoder.postsv2.RetrofitModels;

import java.util.List;

import ahmed.javcoder.postsv2.pojo.PostModel;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

interface PostsInterface {
    @GET("posts")
    Observable<List<PostModel>> postsInterface() ;
}
