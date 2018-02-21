package space.dyenigma.util.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * origin/space.dyenigma.util.security
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2016/3/16
 */
public abstract class Coder {
    public static final String KEY_SHA = "SHA";

    /**
     * @param key
     * @return java.lang.String
     * @Description : BASE64解密
     * @author dingdongliang
     * @date 2018/2/21 10:48
     */
    public static String decryptBASE64ToStr(String key) throws Exception {
        return new String((new BASE64Decoder()).decodeBuffer(key), "UTF-8");
    }

    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * @param bytes
     * @return java.lang.String
     * @Description : BASE64加密
     * @author dingdongliang
     * @date 2018/2/21 10:48
     */
    public static String encryptBASE64(byte[] bytes) throws Exception {
        return (new BASE64Encoder()).encode(bytes);
    }

    public static String encryptStrToBASE64(String str) throws Exception {
        return (new BASE64Encoder()).encode(str.getBytes("UTF-8"));
    }

    public static String encryptMD5(String str) {
        return Md5Utils.hash(str);
    }

    /**
     * @param data
     * @return byte[]
     * @Description : SHA加密
     * @author dingdongliang
     * @date 2018/2/21 10:48
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {

        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data);

        return sha.digest();

    }

    /**
     * Turns array of bytes into string
     * <p>
     * param buf Array of bytes to convert to hex string
     * return Generated hex string
     */
    public static String asHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;

        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)
                strbuf.append("0");

            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }

        return strbuf.toString();
    }

}
