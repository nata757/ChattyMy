package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRes {

    @JsonProperty("accessToken")
    private  String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }

    @JsonProperty("refreshToken")
    private  String refreshToken;
    @JsonProperty("expiration ($int64)")
    private  Integer expiration;
}
