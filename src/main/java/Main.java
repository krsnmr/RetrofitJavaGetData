import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Base64;

public class Main {


    public static void main(String[] args) {
       String str = "!Password@";
        byte[] aaa = str.getBytes();
        String encodedPsw = Base64.getEncoder().encodeToString(aaa);
       System.out.println("encoded password is " + encodedPsw);/**/


        Retrofit rf = APIClient.VdkApiClient();
        VdkRestApiInterface api = rf.create(VdkRestApiInterface.class);


        // простой запрос без пароля
        Call<String> call = api.simple();
        try {
            Response<String> response = call.execute();
            String txt = response.body();
            System.out.println("Получено: " + txt);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        /* чтобы получить токен, надо передать имя и пароль(в Base64 кодировке) и строку "password" */
        String psw = encodedPsw;// "IVBhc3N3b3JkQA==";// неправильный пароль закодированный в BASE64 ;
        Call<TokenData> call2 = api.getToken("AIS_Brigady", psw, "password");
        String tokenTxt = "";
        try {
            Response<TokenData> response = call2.execute();
            TokenData authResponse = response.body();
            tokenTxt = authResponse.getAccessToken();
            System.out.println("Токен: " + tokenTxt);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        Call<String[]> call3 = api.values("Bearer " + tokenTxt);
        try {
            Response<String[]> response = call3.execute();
            String[] txtArr = response.body();
            for (int i = 0; i < txtArr.length; i++) {
                System.out.println("Данные " + i + txtArr[i]);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
