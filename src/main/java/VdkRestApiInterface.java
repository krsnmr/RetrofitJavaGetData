import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * для тестирования сервиса VDK
 */
public interface VdkRestApiInterface {

    /* Проверить что от сервиса пришло простое сообщение */
    @GET("api/simple/")
    Call<String> simple();

    /*
     Получить токен
     */
    @FormUrlEncoded
    @POST("token")
    Call<TokenData> getToken(@Field("username") String userName,
                             @Field("password") String password,
                             @Field("grant_type") String grantType);


    /* При помощи токена получить данные */
    @GET("api/values/")
    Call<String[]> values(@Header("Authorization") String accessToken);


    /* При помощи токена в заголовке и  парамтра получить данные */
    @GET("api/values/{id}")
    Call<String> values(@Header("Authorization") String accessToken, @Path("id") int id);


}
