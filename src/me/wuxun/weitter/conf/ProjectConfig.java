package me.wuxun.weitter.conf;

public class ProjectConfig {
    private static String AvatarSavePath = "/Users/wuxun/upload/";

    public static String getAvatarSavePath() {
        return AvatarSavePath;
    }

    public static void setAvatarSavePath(String avatarSavePath) {
        AvatarSavePath = avatarSavePath;
    }
}
