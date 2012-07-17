package bunyan.config;

import bunyan.Proxy;
import bunyan.blocks.BunyanBlock;
import bunyan.blocks.CustomLog;
import bunyan.blocks.CustomWood;
import bunyan.blocks.WideLog;
import bunyan.items.MultiItemBlock;
import net.minecraft.server.ItemStack;

public class ConfigureBlocks
{
    public static void addNames()
    {
        Proxy.addName(new ItemStack(BunyanBlock.wood, 1, 1), "Fir Log");
        Proxy.addName(new ItemStack(BunyanBlock.wood, 1, 2), "Acacia Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewood, 1, 0), "Quarter Huge Redwood Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewood, 1, 1), "Quarter Huge Fir Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewood, 1, 2), "Quarter Huge Oak Log");
        Proxy.addName(new ItemStack(BunyanBlock.planks, 1, 0), "Redwood Planks");
        Proxy.addName(new ItemStack(BunyanBlock.planks, 1, 1), "Fir Planks");
        Proxy.addName(new ItemStack(BunyanBlock.planks, 1, 2), "Acacia Planks");
    }

    public static void initialize()
    {
        int var0 = Config.getOrCreateBlockIdProperty("wood.id", 160);
        BunyanBlock.wood = (new CustomLog(var0)).a("bunyan.wood");
        int var1 = Config.getOrCreateBlockIdProperty("widewood.id", 161);
        BunyanBlock.widewood = (new WideLog(var1)).a("bunyan.widewood");
        int var2 = Config.getOrCreateBlockIdProperty("plank.id", 163);
        BunyanBlock.planks = (new CustomWood(var2)).a("bunyan.plank");
        Proxy.registerBlock(BunyanBlock.wood, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.widewood, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.planks, MultiItemBlock.class);
    }
}
