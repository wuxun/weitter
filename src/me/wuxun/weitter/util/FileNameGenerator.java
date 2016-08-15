package me.wuxun.weitter.util;

import java.security.MessageDigest;

public class FileNameGenerator {

    private static final String JPEG = "image/jpeg";
    private static final String PNG = "image/png";

    private static final String salt = "weitter-avatar";

    public static String getAvatarName(String uuid, String contentType) {
        return getMD5(salt + uuid) + getExt(contentType);
    }

    private static String getExt(String contentType) {
        if (JPEG.equals(contentType)) {
            return ".jpg";
        } else if (PNG.equals(contentType)) {
            return ".png";
        }
        return "";
    }

    private static String getMD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
