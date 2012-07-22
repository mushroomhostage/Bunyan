package bunyan;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.FMLRegistry;
import forge.IBonemealHandler;
import forge.MinecraftForge;
import java.io.File;
import net.minecraft.server.Block;
import net.minecraft.server.FurnaceRecipes;
import net.minecraft.server.ItemStack;

public enum Proxy
{
    INSTANCE;

    public static void addName(Object var0, String var1)
    {
        if (var0 != null)
        {
            FMLCommonHandler.instance().addNameForObject(var0, "en_US", var1);
        }
    }

    public static void addRecipe(ItemStack var0, Object[] var1)
    {
        FMLRegistry.addRecipe(var0, var1);
    }

    public static void addShapelessRecipe(ItemStack var0, Object[] var1)
    {
        FMLRegistry.addShapelessRecipe(var0, var1);
    }

    public static void addSmelting(int var0, int var1, ItemStack var2)
    {
        FurnaceRecipes.getInstance().addSmelting(var0, var1, var2);
    }

    public static File getMinecraftDir()
    {
        return FMLCommonHandler.instance().getMinecraftRootDirectory();
    }

    public static void preloadTexture(String var0) {}

    public static void registerBlock(Block var0)
    {
        if (var0 != null)
        {
            FMLRegistry.registerBlock(var0);
        }
    }

    public static void registerBlock(Block var0, Class var1)
    {
        if (var0 != null)
        {
            FMLRegistry.registerBlock(var0, var1);
        }
    }

    public static void registerBonemealHandler(IBonemealHandler var0)
    {
        MinecraftForge.registerBonemealHandler(var0);
    }

    public static String getObjectDisplayName(ItemStack var0)
    {
        return "";
    }
}
