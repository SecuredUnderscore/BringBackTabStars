package dev.secured.bringbacktabstars;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.http.HypixelHttpClient;
import net.hypixel.api.reply.PlayerReply;
import net.hypixel.api.unirest.UnirestHttpClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import static dev.secured.bringbacktabstars.NewThread.exec;

public class PlayerAPIManager {
    Minecraft minecraft = Minecraft.getMinecraft();
    HypixelFormatting hypixelFormatting;
    HypixelHttpClient client;
    HypixelAPI hypixelAPI;
    APICache apiCache;
    PlayerReply.Player apiReply;

    public PlayerAPIManager(){
        this.hypixelFormatting = new HypixelFormatting();
        this.client = new UnirestHttpClient(UUID.fromString(SecretSauce.APIKEY));
        this.hypixelAPI = new HypixelAPI(client);
        this.apiCache = new APICache();
    }

    public void submitPlayer(EntityPlayer player){
        if (ScoreboardManager.isInBedwarsQueue()){
            scanAllPlayersAndFormat();
//            minecraft.thePlayer.addChatComponentMessage(new ChatComponentText(player.getDisplayNameString()));
//            minecraft.thePlayer.addChatComponentMessage(new ChatComponentText(minecraft.thePlayer.getDisplayNameString()));
//            if (player.getDisplayNameString().equals(minecraft.thePlayer.getDisplayNameString())){
//                minecraft.thePlayer.addChatComponentMessage(new ChatComponentText("True"));
//                scanAllPlayersAndFormat();
//            } else {
//                minecraft.thePlayer.addChatComponentMessage(new ChatComponentText("False"));
////                scanPlayer(player);
//                scanAllPlayersAndFormat();
//            }
        }
    }

    private void scanAllPlayersAndFormat() {
        Collection<NetworkPlayerInfo> players = minecraft.getNetHandler().getPlayerInfoMap();
        for (NetworkPlayerInfo player : players){
            exec.execute(() -> {
                IChatComponent newDisplayName = null;
                UUID uuid = player.getGameProfile().getId();
                if (apiCache.get(uuid) != null){
                    newDisplayName = hypixelFormatting.GetFormatting(apiCache.get(uuid), player);
                } else {
                        try {
                            apiReply = hypixelAPI.getPlayerByUuid(uuid).get().getPlayer();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    apiCache.put(uuid, apiReply);
                    newDisplayName = hypixelFormatting.GetFormatting(apiReply, player);
                }
                minecraft.getNetHandler().getPlayerInfo(player.getGameProfile().getId()).setDisplayName(newDisplayName);
            });
        }
    }

//    private void scanPlayer(EntityPlayer player){
//        minecraft.getNetHandler().getPlayerInfo(player.getUniqueID()).setDisplayName(new ChatComponentText("Else"));
//    }
}
