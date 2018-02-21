package space.dyenigma.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * origin/space.dyenigma.util
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:09
 */
public class StringUtil {
    /**
     * @param bytes
     * @return java.lang.String
     * @Description : 将16进制字节数组转换为字符  每个字节第一位为0 如：08转为8
     * @author dingdongliang
     * @date 2018/2/21 10:58
     */
    public static String toHexStringNum(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * @param bytes
     * @return java.lang.String
     * @Description : 将16进制字节数组转换为字符 每个字节第一位不为0 如：1A转为1A
     * @author dingdongliang
     * @date 2018/2/21 10:58
     */
    public static String toHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * @param b
     * @return java.lang.String
     * @Description : 将字节转换成16进制字符
     * @author dingdongliang
     * @date 2018/2/21 10:58
     */
    public static String byteToString(byte b) {
        byte high, low;
        byte maskHigh = (byte) 0xf0;
        byte maskLow = 0x0f;

        high = (byte) ((b & maskHigh) >> 4);
        low = (byte) (b & maskLow);

        StringBuffer buf = new StringBuffer();
        buf.append(findHex(high));
        buf.append(findHex(low));

        return buf.toString();
    }

    private static char findHex(byte b) {
        int t = new Byte(b).intValue();
        t = t < 0 ? t + 16 : t;

        if ((0 <= t) && (t <= 9)) {
            return (char) (t + '0');
        }

        return (char) (t - 10 + 'A');
    }

    /**
     * @param bytes
     * @return char[]
     * @Description : 将字节数组转换成字符串
     * @author dingdongliang
     * @date 2018/2/21 10:58
     */
    public static char[] v2BytesToChars(byte[] bytes) {
        Charset cs = Charset.forName("UTF-8");
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes);
        bb.flip();
        CharBuffer cb = cs.decode(bb);

        return cb.array();
    }

    /**
     * @param s
     * @return boolean
     * @Description : 判断字符串是否为空，在Guava中可以使用!Strings.isNullOrEmpty(str)来判断是否为空
     * @author dingdongliang
     * @date 2018/2/21 10:59
     */
    public static boolean isEmpty(String s) {
        return s == null || s.equalsIgnoreCase("null") || s.trim().length() <= 0;
    }

    /**
     * @param regex
     * @param str
     * @return boolean
     * @Description : 比较字符串str是否符合正则表达似乎regex的规则
     * @author dingdongliang
     * @date 2018/2/21 10:59
     */
    public static boolean compareRegex(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
