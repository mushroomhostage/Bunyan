package bunyan.config;

import bunyan.Proxy;
import bunyan.blocks.BunyanBlock;
import bunyan.blocks.CustomLog;
import bunyan.blocks.CustomWood;
import bunyan.blocks.TurnableCustomLog;
import bunyan.blocks.TurnableVanillaLog;
import bunyan.blocks.WideLog;
import bunyan.blocks.WideLogBarkOnBottom;
import bunyan.blocks.WideLogBarkOnTop;
import bunyan.items.MultiItemBlock;
import net.minecraft.server.Block;
import net.minecraft.server.ItemStack;

public class ConfigureBlocks
{
    private static void addCustomLogNames()
    {
        Proxy.addName(new ItemStack(BunyanBlock.wood, 1, 1), "Fir Log");
        Proxy.addName(new ItemStack(BunyanBlock.wood, 1, 2), "Acacia Log");
    }

    private static void addDirectionalCustomLogNames()
    {
        String var0 = Proxy.getObjectDisplayName(new ItemStack(BunyanBlock.wood, 1, 2));
        Proxy.addName(new ItemStack(BunyanBlock.turnableCustomWood, 1, 2), var0);
        var0 = Proxy.getObjectDisplayName(new ItemStack(BunyanBlock.wood, 1, 1));
        Proxy.addName(new ItemStack(BunyanBlock.turnableCustomWood, 1, 1), var0);
    }

    private static void addDirectionalVanillaLogNames()
    {
        String var0 = Proxy.getObjectDisplayName(new ItemStack(Block.LOG, 1, 0));
        Proxy.addName(new ItemStack(BunyanBlock.turnableVanillaWood, 1, 0), var0);
        var0 = Proxy.getObjectDisplayName(new ItemStack(Block.LOG, 1, 1));
        Proxy.addName(new ItemStack(BunyanBlock.turnableVanillaWood, 1, 1), var0);
        var0 = Proxy.getObjectDisplayName(new ItemStack(Block.LOG, 1, 2));
        Proxy.addName(new ItemStack(BunyanBlock.turnableVanillaWood, 1, 2), var0);
        var0 = Proxy.getObjectDisplayName(new ItemStack(Block.LOG, 1, 3));
        Proxy.addName(new ItemStack(BunyanBlock.turnableVanillaWood, 1, 3), var0);
    }

    public static void addNames()
    {
        addCustomLogNames();
        addWideLogNames();
        addPlankNames();
        addDirectionalVanillaLogNames();
        addDirectionalCustomLogNames();
    }

    private static void addPlankNames()
    {
        Proxy.addName(new ItemStack(BunyanBlock.planks, 1, 0), "Redwood Planks");
        Proxy.addName(new ItemStack(BunyanBlock.planks, 1, 1), "Fir Planks");
        Proxy.addName(new ItemStack(BunyanBlock.planks, 1, 2), "Acacia Planks");
    }

    private static void addWideLogNames()
    {
        Proxy.addName(new ItemStack(BunyanBlock.widewood, 1, 0), "Quarter Huge Redwood Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewood, 1, 1), "Quarter Huge Fir Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewood, 1, 2), "Quarter Huge Oak Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewoodBarkTop, 1, 0), "Quarter Huge Redwood Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewoodBarkTop, 1, 1), "Quarter Huge Fir Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewoodBarkTop, 1, 2), "Quarter Huge Oak Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewoodBarkBottom, 1, 0), "Quarter Huge Redwood Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewoodBarkBottom, 1, 1), "Quarter Huge Fir Log");
        Proxy.addName(new ItemStack(BunyanBlock.widewoodBarkBottom, 1, 2), "Quarter Huge Oak Log");
    }

    public static void initialize()
    {
        int var0 = Config.getOrCreateBlockIdProperty("wood.id", 160);
        BunyanBlock.wood = (new CustomLog(var0)).a("bunyan.wood");
        int var1 = Config.getOrCreateBlockIdProperty("widewood.id", 161);
        BunyanBlock.widewood = (new WideLog(var1)).a("bunyan.widewood");
        int var2 = Config.getOrCreateBlockIdProperty("plank.id", 163);
        BunyanBlock.planks = (new CustomWood(var2)).a("bunyan.plank");
        int var3 = Config.getOrCreateBlockIdProperty("vanilla.wood.alt.id", 164);
        BunyanBlock.turnableVanillaWood = (new TurnableVanillaLog(var3)).a("bunyan.vanilla.wood");
        int var4 = Config.getOrCreateBlockIdProperty("turnable.wood.alt.id", 165);
        BunyanBlock.turnableCustomWood = (new TurnableCustomLog(var4)).a("bunyan.wood.alt");
        int var5 = Config.getOrCreateBlockIdProperty("widewood.alt0.id", 166);
        BunyanBlock.widewoodBarkTop = (new WideLogBarkOnTop(var5)).a("bunyan.widewood.alt0");
        int var6 = Config.getOrCreateBlockIdProperty("widewood.alt1.id", 167);
        BunyanBlock.widewoodBarkBottom = (new WideLogBarkOnBottom(var6)).a("bunyan.widewood.alt1");
        Proxy.registerBlock(BunyanBlock.wood, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.widewood, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.widewoodBarkTop, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.widewoodBarkBottom, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.planks, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.turnableVanillaWood, MultiItemBlock.class);
        Proxy.registerBlock(BunyanBlock.turnableCustomWood, MultiItemBlock.class);
    }
}
