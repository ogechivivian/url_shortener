package com.IswAcademy.ShortUrl.Api.Controller;

import com.IswAcademy.ShortUrl.Api.Controller.Model.Response;
import com.IswAcademy.ShortUrl.Api.Controller.Model.ShortenUrlRequest;
import com.IswAcademy.ShortUrl.Api.Controller.Model.ShortenUrlResponse;
import com.IswAcademy.ShortUrl.Util.UrlUtil;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
//@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api/v1")
public class UrlApi {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/{id}")

    public String getUrl(@PathVariable String id, HttpServletResponse resp) throws IOException {
//        System.out.println("url from req.param:" + id);
       String LongUrl = redisTemplate.opsForValue().get(id);
//        System.out.println("URl Retrieved:" + LongUrl);
        if(LongUrl != null){
            resp.sendRedirect(LongUrl);
        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return LongUrl;

    }

    @PostMapping("/url")

    public Response CreateUrl(@Validated @RequestBody ShortenUrlRequest Url ){
        UrlValidator urlValidator = new UrlValidator(
                new String []{"http", "https"}
        );
        Response response =null;

        System.out.println(Url);
        response = new ShortenUrlResponse("00", "Successful" , null, UrlUtil.generateShortUrl(Url.getUrl(),redisTemplate));
        return response;
    }



}
