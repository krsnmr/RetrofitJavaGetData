import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.FormUrlEncoded;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class VdkRtrTest {

    VdkRestApiInterface api;

    @Before
    public void BeforeUnitTest() {
        Retrofit rf = APIClient.VdkApiClient();
        api = rf.create(VdkRestApiInterface.class);
    }

    /*** Проверить что от сервиса пришло простое сообщение */
    @Test
    public void simple_service_return_text() throws IOException {
        Call<String> call = api.simple();
        Response<String> response = call.execute();
        String authResponse = response.body();
        assertTrue(response.isSuccessful());
        assertTrue(authResponse.startsWith("data"));
    }

    /*** Получить токен */
    @Test
    public void get_toke_return() throws IOException {


        Call<TokenData> call = api.getToken(
                "AIS_Brigady",
                "IVBhc3N3b3JkQA==",// неправильный пароль закодированный в BASE64 в классе Main  ;
                "password");
        //Будет Имя пользователя или пароль указаны неправильно.
        Response<TokenData> response = call.execute();
        TokenData authResponse = response.body();
        assertTrue(response.isSuccessful());
        assertEquals("aaa", authResponse.getAccessToken());
    }

    /*** При помощи токена получить данные (если отказано в регистрации то токен устарел!)  */
    @Test
    public void get_secret_data_1() throws IOException {

        String tokenTxt = "Bearer " + "HlbQ9w_fAo6SZ9ybVNKlMpwz43V63xh7znOSBvHXPYAetowI6855fRZq2-h7AVr76r72K5Ue7bRSILsTJ6XIJhwCVXUSOyCi-YvQwydxy3i7oL1lbno0yp-mj16BOrSKSmtSNFl8sMk7vFhbo9Tco4siCb0FFpDBvM3QkiYrlljBxSM0nr52pqa2WTrj8u3FaYSQn9ciwQim1O5snyKtxGRDbGdJR5Aggad0NU4Ei6Y6hUR8jqIuE4l5cTJcxmh17xduLXoB-P2rMQ_3jiDE4Vx2xrHXVc_FZFVojWErWw16boEnBjY7udWDi0la85H__45ONSu8gD_SmSjEQjqy0JdGJl9hYmirPejy-NZHUIwznsJvnguvCATqvOx-wiSvDSct4CtEw7qme6nW90GCGg";
        Call<String[]> call = api.values(tokenTxt);
        Response<String[]> response = call.execute();
        String[] data = response.body();
        assertTrue(response.isSuccessful());
        assertEquals(data.length, 2);
    }


    /*** При помощи токена получить данные (если отказано в регистрации то токен устарел!) */
    @Test
    public void get_secret_data_2() throws IOException {
        String tokenTxt = "Bearer " + "HlbQ9w_fAo6SZ9ybVNKlMpwz43V63xh7znOSBvHXPYAetowI6855fRZq2-h7AVr76r72K5Ue7bRSILsTJ6XIJhwCVXUSOyCi-YvQwydxy3i7oL1lbno0yp-mj16BOrSKSmtSNFl8sMk7vFhbo9Tco4siCb0FFpDBvM3QkiYrlljBxSM0nr52pqa2WTrj8u3FaYSQn9ciwQim1O5snyKtxGRDbGdJR5Aggad0NU4Ei6Y6hUR8jqIuE4l5cTJcxmh17xduLXoB-P2rMQ_3jiDE4Vx2xrHXVc_FZFVojWErWw16boEnBjY7udWDi0la85H__45ONSu8gD_SmSjEQjqy0JdGJl9hYmirPejy-NZHUIwznsJvnguvCATqvOx-wiSvDSct4CtEw7qme6nW90GCGg";

        Call<String> call = api.values(tokenTxt, 1);
        Response<String> response = call.execute();
        String data = response.body();
        assertTrue(response.isSuccessful());
        assertEquals(data, "value");
    }

}
