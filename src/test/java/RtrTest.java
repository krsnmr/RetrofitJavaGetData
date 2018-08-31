import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *  для тестирования сервиса https://jsonplaceholder.typicode.com
 */
public class RtrTest {

    TestRestApiInterface api;

    @Before
    public  void BeforeUnitTest(){
        Retrofit rf =  APIClient.JsonPlaceholderApiClient();
        api = rf.create(TestRestApiInterface.class);
    }


    @Test
    public void posts_test_1() throws Exception {
        Call<Post> call = api.post(33);
        Response<Post> response = call.execute();
        Post ppp = response.body();
        assertEquals(ppp.getUserId(),4);
    }

    @Test
    public void posts_test() throws Exception {
        Call<List<Object>> call = api.posts();
        Response<List<Object>> response = call.execute();
        List<Object> txt = response.body();
        assertEquals(100, txt.size());
    }

    @Test
    public void create_posts_test_1() throws Exception {
        Post p1 = new Post(0,1,"aaa","qqqq");
        Call<Post> call = api.createPost(p1);
        Response<Post> response = call.execute();
        Post ppp = response.body();
        assertEquals(ppp.getId(),101);
    }


}
