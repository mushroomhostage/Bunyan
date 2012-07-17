package bunyan.config;

import bunyan.Proxy;
import bunyan.recipes.CraftingRecipes;
import forge.Configuration;
import forge.Property;
import java.io.File;

public enum Config
{
    INSTANCE;
    private static final String CONFIG_BUNYAN_MAIN_CFG = "/config/extrabiomes/bunyan.cfg";
    public static Configuration config;

    public static int getOrCreateBlockIdProperty(String var0, int var1)
    {
        return Integer.parseInt(config.getOrCreateBlockIdProperty(var0, var1).value);
    }

    public static boolean getOrCreateBooleanProperty(String var0, String var1, boolean var2)
    {
        return Boolean.parseBoolean(config.getOrCreateBooleanProperty(var0, var1, var2).value);
    }

    public static int getOrCreateIntProperty(String var0, String var1, int var2)
    {
        return Integer.parseInt(config.getOrCreateIntProperty(var0, var1, var2).value);
    }

    public static Property getProperty(String var0, String var1, String var2)
    {
        return config.getOrCreateProperty(var0, var1, var2);
    }

    public static void onLoad()
    {
        config = new Configuration(new File(Proxy.getMinecraftDir(), "/config/extrabiomes/bunyan.cfg"));
        config.load();
        ConfigureBlocks.initialize();
        CraftingRecipes.addRecipes();
        config.save();
    }

    public static void onModsLoaded()
    {
        ConfigureBlocks.addNames();
        ConfigureOreDictionary.initialize();
    }
}
