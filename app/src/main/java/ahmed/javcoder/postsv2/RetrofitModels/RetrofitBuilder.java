package ahmed.javcoder.postsv2.RetrofitModels;

import java.util.List;

import ahmed.javcoder.postsv2.pojo.PostModel;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static final String BASE_URL = "http://newsapi.org/" ;

    // create retrofit builder
    public static Observable<List<PostModel>> generateBuilder(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build() ;
        PostsInterface postsInterface = retrofit.create(PostsInterface.class) ;
        return postsInterface.postsInterface();
    }
}
