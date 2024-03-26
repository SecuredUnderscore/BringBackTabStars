package dev.secured.bringbacktabstars;

import net.minecraft.client.Minecraft;

public class ScoreboardManager {
    public static boolean isInBedwarsQueue() {
        Minecraft minecraft = Minecraft.getMinecraft();
        String team_6 = "";
        if (minecraft.theWorld.getScoreboard().getTeamNames().contains("team_6")) {
            team_6 = minecraft.theWorld.getScoreboard().getTeam("team_6").getColorPrefix();
        }
        return team_6.contains("Waiting") || team_6.contains("Starting");
    }
}
