package bunyan.config;

import bunyan.blocks.BunyanBlock;
import bunyan.items.BunyanItem;
import forge.oredict.OreDictionary;
import net.minecraft.server.ItemStack;

public class ConfigureOreDictionary
{
    public static void initialize()
    {
        OreDictionary.registerOre("woodAcacia", new ItemStack(BunyanBlock.wood, 1, 2));
        OreDictionary.registerOre("woodFir", new ItemStack(BunyanBlock.wood, 1, 1));
        OreDictionary.registerOre("woodFir", new ItemStack(BunyanBlock.widewood, 1, 1));
        OreDictionary.registerOre("woodOak", new ItemStack(BunyanBlock.widewood, 1, 2));
        OreDictionary.registerOre("woodRedWood", new ItemStack(BunyanBlock.widewood, 1, 0));
        OreDictionary.registerOre("logWood", new ItemStack(BunyanBlock.wood, 1, 2));
        OreDictionary.registerOre("logWood", new ItemStack(BunyanBlock.wood, 1, 1));
        OreDictionary.registerOre("logWood", new ItemStack(BunyanBlock.widewood, 1, 1));
        OreDictionary.registerOre("logWood", new ItemStack(BunyanBlock.widewood, 1, 0));
        OreDictionary.registerOre("planksAcacia", new ItemStack(BunyanBlock.planks, 1, 2));
        OreDictionary.registerOre("planksFir", new ItemStack(BunyanBlock.planks, 1, 1));
        OreDictionary.registerOre("planksRedWood", new ItemStack(BunyanBlock.planks, 1, 0));
        OreDictionary.registerOre("planksWood", new ItemStack(BunyanBlock.planks, 1, 2));
        OreDictionary.registerOre("planksWood", new ItemStack(BunyanBlock.planks, 1, 1));
        OreDictionary.registerOre("planksWood", new ItemStack(BunyanBlock.planks, 1, 0));
        OreDictionary.registerOre("toolWood", BunyanItem.logTurner);
        OreDictionary.registerOre("toolLogTurner", BunyanItem.logTurner);
    }
}
