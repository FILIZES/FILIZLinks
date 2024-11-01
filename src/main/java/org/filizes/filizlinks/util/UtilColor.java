package org.filizes.filizlinks.util;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilColor {
    public static final String AUTHOR = "FILIZES";

    public static String color(String text) {
        Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String hexCode = matcher.group();
            String replaceSharp = hexCode.replace('#', 'x');
            StringBuilder builder = new StringBuilder();

            for (char c : replaceSharp.toCharArray()) {
                builder.append("&").append(c);
            }

            text = text.replace(hexCode, builder.toString());
        }

        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
