package com.IswAcademy.ShortUrl.Api.Controller.Model;

import javax.validation.constraints.NotBlank;

public class ShortenUrlRequest {
    @NotBlank(message="Enter url")
    private String Url;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return "ShortenUrlRequest{" +
                "Url='" + Url + '\'' +
                '}';
    }
}
