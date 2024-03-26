package dev.secured.bringbacktabstars;

import net.hypixel.api.reply.PlayerReply;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HypixelFormatting {
    ChatComponentText rank;
    List<String> numbers;

    public ChatComponentText GetFormatting (PlayerReply.Player response, NetworkPlayerInfo player){
        // API
        int getStar = response.getIntProperty("achievements.bedwars_level", 1);
        putStarsInList(getStar);
        String getHighestRank = response.getHighestRank();
        String getPlusColor = response.getSelectedPlusColor();
        String username = response.getName();

        // Check for nick
        if (response.getStringProperty("playername", "").isEmpty()){
            return new ChatComponentText(EnumChatFormatting.YELLOW  + "NICK " + EnumChatFormatting.RESET + player.getGameProfile().getName());
        }

        // Rank Formatting
        switch (getHighestRank) {
            case "NONE":
                rank = new ChatComponentText(getStarWithFormatting(getStar) + " " + EnumChatFormatting.GRAY + username + " ");
                break;
            case "VIP":
                rank = new ChatComponentText(getStarWithFormatting(getStar) + " " + EnumChatFormatting.GREEN + "[VIP] " + username);
                break;
            case "VIP_PLUS":
                rank = new ChatComponentText(getStarWithFormatting(getStar) + " " + EnumChatFormatting.GREEN + "[VIP" + EnumChatFormatting.GOLD + "+" + EnumChatFormatting.GREEN + "] " + username + " ");
                break;
            case "MVP":
                rank = new ChatComponentText(getStarWithFormatting(getStar) + " " + EnumChatFormatting.AQUA + "[MVP] " + username + " ");
                break;
            case "MVP_PLUS":
                rank = new ChatComponentText(getStarWithFormatting(getStar) + " " + EnumChatFormatting.AQUA + "[MVP" + GetPlusColor(getPlusColor) + "+" + EnumChatFormatting.AQUA + "] " + username + " ");
                break;
            case "SUPERSTAR":
                rank = new ChatComponentText(getStarWithFormatting(getStar) + " " + EnumChatFormatting.GOLD + "[MVP" + GetPlusColor(getPlusColor) + "++" + EnumChatFormatting.GOLD + "] " + username + " ");
                break;
        }

        return rank;
    }

    private EnumChatFormatting GetPlusColor(String plusColor){
        EnumChatFormatting color = EnumChatFormatting.RESET;
        if (plusColor.equals("RED")) {
            color = EnumChatFormatting.RED;
        }
        if (plusColor.equals("GOLD")) {
            color = EnumChatFormatting.GOLD;
        }
        if (plusColor.equals("GREEN")) {
            color = EnumChatFormatting.GREEN;
        }
        if (plusColor.equals("YELLOW")) {
            color = EnumChatFormatting.YELLOW;
        }
        if (plusColor.equals("LIGHT_PURPLE")) {
            color = EnumChatFormatting.LIGHT_PURPLE;
        }
        if (plusColor.equals("WHITE")) {
            color = EnumChatFormatting.WHITE;
        }
        if (plusColor.equals("BLUE")) {
            color = EnumChatFormatting.BLUE;
        }
        if (plusColor.equals("DARK_GREEN")) {
            color = EnumChatFormatting.DARK_GREEN;
        }
        if (plusColor.equals("DARK_RED")) {
            color = EnumChatFormatting.DARK_RED;
        }
        if (plusColor.equals("CYAN")) {
            color = EnumChatFormatting.DARK_AQUA;
        }
        if (plusColor.equals("PURPLE")) {
            color = EnumChatFormatting.DARK_PURPLE;
        }
        if (plusColor.equals("GRAY")) {
            color = EnumChatFormatting.GRAY;
        }
        if (plusColor.equals("BLACK")) {
            color = EnumChatFormatting.BLACK;
        }
        if (plusColor.equals("DARK_BLUE")) {
            color = EnumChatFormatting.DARK_BLUE;
        }
        return color;
    }

    private String getStarWithFormatting(int star){
        EnumChatFormatting starColor1 = null;
        EnumChatFormatting starColor2 = null;
        EnumChatFormatting starColor3 = null;
        EnumChatFormatting starColor4 = null;
        EnumChatFormatting starColor5 = null;
        EnumChatFormatting starColor6 = null;
        EnumChatFormatting starColor7 = null;
        String star1 = "✫";

        if (star < 100) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.GRAY;
            starColor3 = EnumChatFormatting.GRAY;
            starColor4 = EnumChatFormatting.GRAY;
            starColor5 = EnumChatFormatting.GRAY;
            starColor6 = EnumChatFormatting.GRAY;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✫";
        } else if (star < 200) {
            starColor1 = EnumChatFormatting.WHITE;
            starColor2 = EnumChatFormatting.WHITE;
            starColor3 = EnumChatFormatting.WHITE;
            starColor4 = EnumChatFormatting.WHITE;
            starColor5 = EnumChatFormatting.WHITE;
            starColor6 = EnumChatFormatting.WHITE;
            starColor7 = EnumChatFormatting.WHITE;
            star1 = "✫";
        } else if (star < 300) {
            starColor1 = EnumChatFormatting.GOLD;
            starColor2 = EnumChatFormatting.GOLD;
            starColor3 = EnumChatFormatting.GOLD;
            starColor4 = EnumChatFormatting.GOLD;
            starColor5 = EnumChatFormatting.GOLD;
            starColor6 = EnumChatFormatting.GOLD;
            starColor7 = EnumChatFormatting.GOLD;
            star1 = "✫";
        } else if (star < 400) {
            starColor1 = EnumChatFormatting.AQUA;
            starColor2 = EnumChatFormatting.AQUA;
            starColor3 = EnumChatFormatting.AQUA;
            starColor4 = EnumChatFormatting.AQUA;
            starColor5 = EnumChatFormatting.AQUA;
            starColor6 = EnumChatFormatting.AQUA;
            starColor7 = EnumChatFormatting.AQUA;
            star1 = "✫";
        } else if (star < 500) {
            starColor1 = EnumChatFormatting.DARK_GREEN;
            starColor2 = EnumChatFormatting.DARK_GREEN;
            starColor3 = EnumChatFormatting.DARK_GREEN;
            starColor4 = EnumChatFormatting.DARK_GREEN;
            starColor5 = EnumChatFormatting.DARK_GREEN;
            starColor6 = EnumChatFormatting.DARK_GREEN;
            starColor7 = EnumChatFormatting.DARK_GREEN;
            star1 = "✫";
        } else if (star < 600) {
            starColor1 = EnumChatFormatting.DARK_AQUA;
            starColor2 = EnumChatFormatting.DARK_AQUA;
            starColor3 = EnumChatFormatting.DARK_AQUA;
            starColor4 = EnumChatFormatting.DARK_AQUA;
            starColor5 = EnumChatFormatting.DARK_AQUA;
            starColor6 = EnumChatFormatting.DARK_AQUA;
            starColor7 = EnumChatFormatting.DARK_AQUA;
            star1 = "✫";
        } else if (star < 700) {
            starColor1 = EnumChatFormatting.DARK_RED;
            starColor2 = EnumChatFormatting.DARK_RED;
            starColor3 = EnumChatFormatting.DARK_RED;
            starColor4 = EnumChatFormatting.DARK_RED;
            starColor5 = EnumChatFormatting.DARK_RED;
            starColor6 = EnumChatFormatting.DARK_RED;
            starColor7 = EnumChatFormatting.DARK_RED;
            star1 = "✫";
        } else if (star < 800) {
            starColor1 = EnumChatFormatting.LIGHT_PURPLE;
            starColor2 = EnumChatFormatting.LIGHT_PURPLE;
            starColor3 = EnumChatFormatting.LIGHT_PURPLE;
            starColor4 = EnumChatFormatting.LIGHT_PURPLE;
            starColor5 = EnumChatFormatting.LIGHT_PURPLE;
            starColor6 = EnumChatFormatting.LIGHT_PURPLE;
            starColor7 = EnumChatFormatting.LIGHT_PURPLE;
            star1 = "✫";
        } else if (star < 900) {
            starColor1 = EnumChatFormatting.BLUE;
            starColor2 = EnumChatFormatting.BLUE;
            starColor3 = EnumChatFormatting.BLUE;
            starColor4 = EnumChatFormatting.BLUE;
            starColor5 = EnumChatFormatting.BLUE;
            starColor6 = EnumChatFormatting.BLUE;
            starColor7 = EnumChatFormatting.BLUE;
            star1 = "✫";
        } else if (star < 1000) {
            starColor1 = EnumChatFormatting.DARK_PURPLE;
            starColor2 = EnumChatFormatting.DARK_PURPLE;
            starColor3 = EnumChatFormatting.DARK_PURPLE;
            starColor4 = EnumChatFormatting.DARK_PURPLE;
            starColor5 = EnumChatFormatting.DARK_PURPLE;
            starColor6 = EnumChatFormatting.DARK_PURPLE;
            starColor7 = EnumChatFormatting.DARK_PURPLE;
            star1 = "✫";
        } else if (star < 1100) {
            starColor1 = EnumChatFormatting.RED;
            starColor2 = EnumChatFormatting.GOLD;
            starColor3 = EnumChatFormatting.YELLOW;
            starColor4 = EnumChatFormatting.GREEN;
            starColor5 = EnumChatFormatting.AQUA;
            starColor6 = EnumChatFormatting.LIGHT_PURPLE;
            starColor7 = EnumChatFormatting.DARK_PURPLE;
            star1 = "✫";
        } else if (star < 1200) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.WHITE;
            starColor3 = EnumChatFormatting.WHITE;
            starColor4 = EnumChatFormatting.WHITE;
            starColor5 = EnumChatFormatting.WHITE;
            starColor6 = EnumChatFormatting.GRAY;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 1300) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.YELLOW;
            starColor3 = EnumChatFormatting.YELLOW;
            starColor4 = EnumChatFormatting.YELLOW;
            starColor5 = EnumChatFormatting.YELLOW;
            starColor6 = EnumChatFormatting.GOLD;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 1400) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.AQUA;
            starColor3 = EnumChatFormatting.AQUA;
            starColor4 = EnumChatFormatting.AQUA;
            starColor5 = EnumChatFormatting.AQUA;
            starColor6 = EnumChatFormatting.DARK_AQUA;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 1500) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.GREEN;
            starColor3 = EnumChatFormatting.GREEN;
            starColor4 = EnumChatFormatting.GREEN;
            starColor5 = EnumChatFormatting.GREEN;
            starColor6 = EnumChatFormatting.DARK_GREEN;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 1600) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.DARK_AQUA;
            starColor3 = EnumChatFormatting.DARK_AQUA;
            starColor4 = EnumChatFormatting.DARK_AQUA;
            starColor5 = EnumChatFormatting.DARK_AQUA;
            starColor6 = EnumChatFormatting.BLUE;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 1700) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.RED;
            starColor3 = EnumChatFormatting.RED;
            starColor4 = EnumChatFormatting.RED;
            starColor5 = EnumChatFormatting.RED;
            starColor6 = EnumChatFormatting.DARK_RED;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 1800) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.LIGHT_PURPLE;
            starColor3 = EnumChatFormatting.LIGHT_PURPLE;
            starColor4 = EnumChatFormatting.LIGHT_PURPLE;
            starColor5 = EnumChatFormatting.LIGHT_PURPLE;
            starColor6 = EnumChatFormatting.DARK_PURPLE;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 1900) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.BLUE;
            starColor3 = EnumChatFormatting.BLUE;
            starColor4 = EnumChatFormatting.BLUE;
            starColor5 = EnumChatFormatting.BLUE;
            starColor6 = EnumChatFormatting.DARK_BLUE;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 2000) {
            starColor1 = EnumChatFormatting.GRAY;
            starColor2 = EnumChatFormatting.DARK_PURPLE;
            starColor3 = EnumChatFormatting.DARK_PURPLE;
            starColor4 = EnumChatFormatting.DARK_PURPLE;
            starColor5 = EnumChatFormatting.DARK_PURPLE;
            starColor6 = EnumChatFormatting.DARK_GRAY;
            starColor7 = EnumChatFormatting.GRAY;
            star1 = "✪";
        } else if (star < 2100) {
            starColor1 = EnumChatFormatting.DARK_GRAY;
            starColor2 = EnumChatFormatting.GRAY;
            starColor3 = EnumChatFormatting.WHITE;
            starColor4 = EnumChatFormatting.WHITE;
            starColor5 = EnumChatFormatting.GRAY;
            starColor6 = EnumChatFormatting.GRAY;
            starColor7 = EnumChatFormatting.DARK_GRAY;
            star1 = "✪";
        } else if (star < 2200) {
            starColor1 = EnumChatFormatting.WHITE;
            starColor2 = EnumChatFormatting.WHITE;
            starColor3 = EnumChatFormatting.YELLOW;
            starColor4 = EnumChatFormatting.YELLOW;
            starColor5 = EnumChatFormatting.GOLD;
            starColor6 = EnumChatFormatting.GOLD;
            starColor7 = EnumChatFormatting.GOLD;
            star1 = "⚝";
        } else if (star < 2300) {
            starColor1 = EnumChatFormatting.GOLD;
            starColor2 = EnumChatFormatting.GOLD;
            starColor3 = EnumChatFormatting.WHITE;
            starColor4 = EnumChatFormatting.WHITE;
            starColor5 = EnumChatFormatting.AQUA;
            starColor6 = EnumChatFormatting.DARK_AQUA;
            starColor7 = EnumChatFormatting.DARK_AQUA;
            star1 = "⚝";
        } else if (star < 2400) {
            starColor1 = EnumChatFormatting.DARK_PURPLE;
            starColor2 = EnumChatFormatting.DARK_PURPLE;
            starColor3 = EnumChatFormatting.LIGHT_PURPLE;
            starColor4 = EnumChatFormatting.LIGHT_PURPLE;
            starColor5 = EnumChatFormatting.GOLD;
            starColor6 = EnumChatFormatting.YELLOW;
            starColor7 = EnumChatFormatting.YELLOW;
            star1 = "⚝";
        } else if (star < 2500) {
            starColor1 = EnumChatFormatting.AQUA;
            starColor2 = EnumChatFormatting.AQUA;
            starColor3 = EnumChatFormatting.WHITE;
            starColor4 = EnumChatFormatting.WHITE;
            starColor5 = EnumChatFormatting.GRAY;
            starColor6 = EnumChatFormatting.DARK_GRAY;
            starColor7 = EnumChatFormatting.DARK_GRAY;
            star1 = "⚝";
        } else if (star < 2600) {
            starColor1 = EnumChatFormatting.WHITE;
            starColor2 = EnumChatFormatting.WHITE;
            starColor3 = EnumChatFormatting.GREEN;
            starColor4 = EnumChatFormatting.GREEN;
            starColor5 = EnumChatFormatting.DARK_GREEN;
            starColor6 = EnumChatFormatting.DARK_GREEN;
            starColor7 = EnumChatFormatting.DARK_GREEN;
            star1 = "⚝";
        } else if (star < 2700) {
            starColor1 = EnumChatFormatting.DARK_RED;
            starColor2 = EnumChatFormatting.DARK_RED;
            starColor3 = EnumChatFormatting.RED;
            starColor4 = EnumChatFormatting.RED;
            starColor5 = EnumChatFormatting.LIGHT_PURPLE;
            starColor6 = EnumChatFormatting.LIGHT_PURPLE;
            starColor7 = EnumChatFormatting.DARK_PURPLE;
            star1 = "⚝";
        } else if (star < 2800) {
            starColor1 = EnumChatFormatting.YELLOW;
            starColor2 = EnumChatFormatting.YELLOW;
            starColor3 = EnumChatFormatting.WHITE;
            starColor4 = EnumChatFormatting.WHITE;
            starColor5 = EnumChatFormatting.DARK_GRAY;
            starColor6 = EnumChatFormatting.DARK_GRAY;
            starColor7 = EnumChatFormatting.DARK_GRAY;
            star1 = "⚝";
        } else if (star < 2900) {
            starColor1 = EnumChatFormatting.GREEN;
            starColor2 = EnumChatFormatting.GREEN;
            starColor3 = EnumChatFormatting.DARK_GREEN;
            starColor4 = EnumChatFormatting.DARK_GREEN;
            starColor5 = EnumChatFormatting.GOLD;
            starColor6 = EnumChatFormatting.GOLD;
            starColor7 = EnumChatFormatting.YELLOW;
            star1 = "⚝";
        } else if (star < 3000) {
            starColor1 = EnumChatFormatting.AQUA;
            starColor2 = EnumChatFormatting.AQUA;
            starColor3 = EnumChatFormatting.DARK_AQUA;
            starColor4 = EnumChatFormatting.DARK_AQUA;
            starColor5 = EnumChatFormatting.BLUE;
            starColor6 = EnumChatFormatting.BLUE;
            starColor7 = EnumChatFormatting.BLUE;
            star1 = "⚝";
        } else if (star < 3100) {
            starColor1 = EnumChatFormatting.YELLOW;
            starColor2 = EnumChatFormatting.YELLOW;
            starColor3 = EnumChatFormatting.GOLD;
            starColor4 = EnumChatFormatting.GOLD;
            starColor5 = EnumChatFormatting.RED;
            starColor6 = EnumChatFormatting.RED;
            starColor7 = EnumChatFormatting.DARK_RED;
            star1 = "⚝";
        } else if (star > 3099) {
            starColor1 = EnumChatFormatting.YELLOW;
            starColor2 = EnumChatFormatting.YELLOW;
            starColor3 = EnumChatFormatting.GOLD;
            starColor4 = EnumChatFormatting.GOLD;
            starColor5 = EnumChatFormatting.RED;
            starColor6 = EnumChatFormatting.RED;
            starColor7 = EnumChatFormatting.DARK_RED;
            star1 = "⚝";
        }
        return new String(starColor1 + "[" + starColor2 + numbers.get(0) + starColor3 + numbers.get(1) + starColor4 + numbers.get(2) + starColor5 + numbers.get(3) + starColor6 + starColor7 + "]");
//        return new String(starColor1 + "[" + starColor2 + numbers.get(0) + starColor3 + numbers.get(1) + starColor4 + numbers.get(2) + starColor5 + numbers.get(3) + starColor6 + star1 + starColor7 + "]");
    }

    private void putStarsInList(int stars) {
        numbers = new ArrayList<String>();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (stars > 0) {
            stack.push(stars % 10);
            stars = stars / 10;
        }
        if (stack.size() == 1) {
            numbers.add(String.valueOf(stack.pop()));
            numbers.add("");
            numbers.add("");
            numbers.add("");
        } else if (stack.size() == 2) {
            numbers.add(String.valueOf(stack.pop()));
            numbers.add(String.valueOf(stack.pop()));
            numbers.add("");
            numbers.add("");
        } else if (stack.size() == 3) {
            numbers.add(String.valueOf(stack.pop()));
            numbers.add(String.valueOf(stack.pop()));
            numbers.add(String.valueOf(stack.pop()));
            numbers.add("");
        } else if (stack.size() == 4) {
            numbers.add(String.valueOf(stack.pop()));
            numbers.add(String.valueOf(stack.pop()));
            numbers.add(String.valueOf(stack.pop()));
            numbers.add(String.valueOf(stack.pop()));
        }
    }
}
