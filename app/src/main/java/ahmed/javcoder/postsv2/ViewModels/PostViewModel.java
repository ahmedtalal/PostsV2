package ahmed.javcoder.postsv2.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ahmed.javcoder.postsv2.pojo.PostModel;

import java.util.List;

import ahmed.javcoder.postsv2.repositories.PostsRepository;

public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> mutableLiveData ;
    PostsRepository repository ;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        repository = PostsRepository.getInstance();
        mutableLiveData = repository.getPosts() ;
    }

    // this method is used to recieve news from mutableLiveData class
    public LiveData<List<PostModel>> recievePosts(){
        return mutableLiveData ;
    }


}
