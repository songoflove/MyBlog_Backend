package com.lhp.nicole.blog.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    // 秘钥 Key 鍵
    /*
     * jwt由三部分组成：
     * A：Header,{"type":"JWT","alg":"HS256"}固定
     * B：payload,存放信息，如用户id，过期时间等，可被解密，不能存放敏感信息
     * C：签证，A+B+秘钥 加密而成，只要秘钥不丢失，可认为是安全的
     */
    private static final String jwtToken = "1232022Lhp!@#$$";

    // create token
    public static String createToken(Long userId){
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,jwtToken) //签发算法，秘钥为jwtToken
                .setClaims(claims) //body数据，唯一，自行设置
                .setIssuedAt(new Date()) //设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000)); //一天有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    //check token validation
    public static Map<String,Object> checkToken(String token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>)parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

/*    // test
    public static void main(String[] args) {
        String token = JWTUtils.createToken(100L);
        System.out.println(token);
        Map<String,Object> map = JWTUtils.checkToken(token);
        System.out.println(map.get("userId"));
    }*/

}
