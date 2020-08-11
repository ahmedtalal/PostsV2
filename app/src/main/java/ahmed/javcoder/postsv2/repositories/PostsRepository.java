package ahmed.javcoder.postsv2.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ahmed.javcoder.postsv2.RetrofitModels.RetrofitBuilder;
import ahmed.javcoder.postsv2.pojo.PostModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PostsRepository {
    private static final String TAG = "PostsRepository";
    private static PostsRepository repository ;
    private MutableLiveData<List<PostModel>> mutableLiveData = new MutableLiveData<>() ;

    public static PostsRepository getInstance(){
        if (repository == null){
            repository = new PostsRepository() ;
        }
        return repository ;
    }

    public MutableLiveData<List<PostModel>> getPosts(){
        Observable<List<PostModel>> observable = RetrofitBuilder.generateBuilder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) ;

        // create Observer
        Observer<List<PostModel>> observer = new Observer<List<PostModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<PostModel> postModels) {
                mutableLiveData.setValue(postModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };

        // connect observable with observer
        observable.subscribe(observer) ;

        return mutableLiveData ;
    }
}
