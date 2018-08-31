import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * для тестирования сервиса https://jsonplaceholder.typicode.com
 */
public interface TestRestApiInterface {


    @GET("posts/")
    Call<List<Object>> posts();

    @GET("posts/{id}")
    Call<Post> post(@Path("id") int id);

    @POST("posts/")
    Call<Post> createPost(@Body Post ppp);
}
