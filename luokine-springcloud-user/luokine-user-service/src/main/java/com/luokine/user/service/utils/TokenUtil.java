package com.luokine.user.service.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.luokine.user.service.bean.SysUser;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: tiantziquan
 * @create: 2019-06-17 19:24
 */
public class TokenUtil {
    private static final long EXPIRE_TIME= 30*60*1000;    //过期时间
    private static final String TOKEN_SECRET="token123";  //密钥

    /**
     * 签名生成
     * @param user
     * @return
     */
    public static String sign(SysUser user){

        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", user.getUsername())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;

    }


    /**
     * 签名验证
     * @param token
     * @return
     */
    public static boolean verify(String token){


        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过："+jwt.getClaim("username").asString());
//            System.out.println("issuer: " + jwt.getIssuer());
//            System.out.println("username: " + jwt.getClaim("username").asString());
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(jwt.getExpiresAt());
            System.out.println("过期时间：" + format);
            return true;
        } catch (Exception e){
            return false;
        }

    }

}
