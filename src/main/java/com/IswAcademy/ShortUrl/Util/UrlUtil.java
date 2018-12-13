package com.IswAcademy.ShortUrl.Util;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.nio.charset.StandardCharsets;

public class UrlUtil {
    @Autowired
    StringRedisTemplate redisTemplate;

    public static  String generateShortUrl( String LongUrl, StringRedisTemplate redisTemplate){

        String shorturl = Hashing.murmur3_32().hashString(LongUrl, StandardCharsets.UTF_8).toString();
            System.out.println("URl Id generated: " + shorturl);
           redisTemplate.opsForValue().set(shorturl, LongUrl);

            return shorturl;

    }

}
