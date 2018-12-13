package com.IswAcademy.ShortUrl.Api.Controller.Model;

import java.util.List;

public class ShortenUrlResponse extends Response {
    private final String shorturl;

    public ShortenUrlResponse(String code, String description, List<Error> errors, String shorturl) {
        super(code, description, errors);
        this.shorturl = shorturl;
    }

    public String getShorturl() {
        return shorturl;
    }
}
