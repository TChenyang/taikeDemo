package com.nandu.oddity.modules.sys.shiro;


import com.nandu.oddity.common.exception.NanDuException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    //加密算法
    public static final String hashAlgorithmName = "SHA-256";
    //循环次数
    public static final int hasIterations = 16;

    public static String sha256(String password, String salt){
        return new SimpleHash(hashAlgorithmName,password,salt,hasIterations).toString();
    }

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    /*public static Long SysUserEntity(){
        return getUserEntity().getUserId();
    }*/

    /*public static Long getUserId(){
        return getUserEntity().getUserId();
    }*/

    public static void setSessionAttribute(Object key,Object value){
        getSession().setAttribute(key,value);
    }

    public static Object getSessionAttribute(Object key){
        return getSession().getAttribute(key);
    }

    public static boolean isLogin(){
        return  SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout(){
        SecurityUtils.getSubject().logout();
    }

    public static String getKaptcha(String key){
        Object kaptcha = getSessionAttribute(key);
        if (kaptcha == null){
//            throw new NanDuException("验证码已失效");
        }
        getSession().removeAttribute(key);
        return  kaptcha.toString();
    }


}
