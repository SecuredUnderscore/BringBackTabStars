package dev.secured.bringbacktabstars;

import net.minecraft.command.CommandHandler;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BringBackTabStars.MODID, version = BringBackTabStars.VERSION)
public class BringBackTabStars {
    public static final String MODID = "bbts";
    public static final String VERSION = "1.0";
    CommandHandler commandHandler;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        PlayerAPIManager playerManager = new PlayerAPIManager();
        FMLCommonHandler.instance().bus().register(new EntityJoinWorldEventA(playerManager));
        ClientCommandHandler.instance.registerCommand(new TestingCommand());
    }
}
