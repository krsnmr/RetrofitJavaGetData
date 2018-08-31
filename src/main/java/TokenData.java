import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TokenData {

    /* значение токен */
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    /* длительность в секундах: напр 43200 - 12часов */
    @SerializedName("expires_in")
    private String expiresIn;

    /* имя пользователя */
    private String userName;

    /* дата получения напр Thu, 30 Aug 2018 17:59:45 GMT */
    @SerializedName(".issued")
    private String issuedDate;
    /* дата окончания напр Fri, 31 Aug 2018 05:59:45 GMT*/
    @SerializedName(".expires")
    private String expiresDate;

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getUserName() {
        return userName;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public String getExpiresDate() {
        return expiresDate;
    }
}
