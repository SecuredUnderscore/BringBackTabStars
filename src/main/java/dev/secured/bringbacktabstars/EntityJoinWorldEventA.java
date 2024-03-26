package dev.secured.bringbacktabstars;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityJoinWorldEventA {

    PlayerAPIManager playerAPIManager;

    public EntityJoinWorldEventA(PlayerAPIManager playerAPIManager){
        this.playerAPIManager = playerAPIManager;
    }

    @SubscribeEvent
    public void entityJoinWorldEvent(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayer){
            playerAPIManager.submitPlayer((EntityPlayer) event.entity);
        }
    }
}
