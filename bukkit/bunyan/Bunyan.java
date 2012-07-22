package bunyan;

import bunyan.blocks.RenderManager;
import bunyan.config.Config;
import bunyan.trees.DeadTreeHuge;
import bunyan.trees.GenFirTree;
import bunyan.trees.GenFirTreeHuge;
import bunyan.trees.GenOakHuge;
import bunyan.trees.GenRedwood;
import extrabiomes.api.BiomeManager;
import extrabiomes.api.PluginManager;
import extrabiomes.api.TerrainGenManager;
import forge.IOreHandler;
import forge.NetworkMod;
import forge.oredict.OreDictionary;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public enum Bunyan
{
    INSTANCE;
    private static final String NAME = "Bunyan";
    private static final String VERSION = "1.4";
    private static IOreHandler woodOreHandler;

    public static boolean clientSideRequired()
    {
        return true;
    }

    public static String getName()
    {
        return "Bunyan";
    }

    public static String getVersion()
    {
        return "1.4";
    }

    public static void onGenerateSurface(World var0, Random var1, int var2, int var3)
    {
        BiomeBase var4 = var0.getBiome(var2, var3);
        int var5;
        int var6;
        int var7;

        if ((var4 == BiomeBase.FOREST || var4 == BiomeBase.FOREST_HILLS || var4 == BiomeManager.forestedhills || var4 == BiomeManager.forestedisland || var4 == BiomeManager.rainforest) && var1.nextInt(100) == 0)
        {
            var5 = var2 + var1.nextInt(16) + 8;
            var6 = var3 + var1.nextInt(16) + 8;
            var7 = var0.getHighestBlockYAt(var5, var6);
            (new GenOakHuge(false)).a(var0, var1, var5, var7, var6);
        }

        if ((var4 == BiomeBase.PLAINS || var4 == BiomeBase.SMALL_MOUNTAINS) && var1.nextInt(1000) == 0)
        {
            var5 = var2 + var1.nextInt(16) + 8;
            var6 = var3 + var1.nextInt(16) + 8;
            var7 = var0.getHighestBlockYAt(var5, var6);
            (new GenOakHuge(false)).a(var0, var1, var5, var7, var6);
        }

        if (var4 == BiomeManager.wasteland && var1.nextInt(50) == 0)
        {
            var5 = var2 + var1.nextInt(16) + 8;
            var6 = var3 + var1.nextInt(16) + 8;
            var7 = var0.getHighestBlockYAt(var5, var6);
            (new DeadTreeHuge(var1.nextInt(3))).a(var0, var1, var5, var7, var6);
        }

        if (!ExtrabiomesPlugin.isActive() && (var4 == BiomeBase.TAIGA || var4 == BiomeBase.TAIGA_HILLS))
        {
            if (var1.nextInt(130) == 0)
            {
                var5 = var2 + var1.nextInt(16) + 8;
                var6 = var3 + var1.nextInt(16) + 8;
                var7 = var0.getHighestBlockYAt(var5, var6);
                (new GenRedwood(false)).a(var0, var1, var5, var7, var6);
            }

            if (var1.nextInt(9) == 0)
            {
                var5 = var2 + var1.nextInt(16) + 8;
                var6 = var3 + var1.nextInt(16) + 8;
                var7 = var0.getHighestBlockYAt(var5, var6);
                Object var8 = var1.nextInt(2) == 0 ? new GenFirTree(false) : new GenFirTreeHuge(false);
                ((WorldGenerator)var8).a(var0, var1, var5, var7, var6);
            }
        }
    }

    public static void onLoad(NetworkMod var0)
    {
        Proxy.preloadTexture("/bunyan/blocks/blocks.png");
        Proxy.preloadTexture("/bunyan/items/items.png");
        Config.onLoad();
        RenderManager.initialize(var0);
        woodOreHandler = new WoodOreHandler();
        OreDictionary.registerOreHandler(woodOreHandler);
        PluginManager.plugins.add(ExtrabiomesPlugin.INSTANCE);
        TerrainGenManager.treesCanGrowOnIDs.add(Integer.valueOf(Block.DIRT.id));
        TerrainGenManager.treesCanGrowOnIDs.add(Integer.valueOf(Block.GRASS.id));
        TerrainGenManager.treesCanGrowOnIDs.add(Integer.valueOf(Block.SOIL.id));
        KeyPressManager.registerKeys(var0);
    }

    public static void onModsLoaded()
    {
        Config.onModsLoaded();

        if (modEE.isEnabled())
        {
            modEE.INSTANCE.activate();
        }
    }
}
