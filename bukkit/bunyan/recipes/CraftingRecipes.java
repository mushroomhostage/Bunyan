package bunyan.recipes;

import bunyan.Proxy;
import bunyan.blocks.BunyanBlock;
import net.minecraft.server.Block;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;

public class CraftingRecipes
{
    public static void addRecipes()
    {
        Proxy.addRecipe(new ItemStack(Block.CHEST), new Object[] {"###", "# #", "###", '#', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Block.WORKBENCH), new Object[] {"##", "##", '#', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Block.WOOD, 4), new Object[] {"#", '#', new ItemStack(BunyanBlock.widewood, 1, 2)});
        Proxy.addRecipe(new ItemStack(Item.STICK, 4), new Object[] {"#", "#", '#', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Block.WOOD_PLATE), new Object[] {"##", '#', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Item.BOWL, 4), new Object[] {"# #", " # ", '#', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Block.STEP, 6, 2), new Object[] {"###", '#', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Item.BOAT), new Object[] {"X X", "XXX", 'X', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Item.WOOD_DOOR), new Object[] {"##", "##", "##", '#', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Block.TRAP_DOOR, 2), new Object[] {"aaa", "aaa", 'a', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Block.WOOD_STAIRS, 4), new Object[] {"  a", " aa", "aaa", 'a', BunyanBlock.planks});
        Proxy.addRecipe(new ItemStack(Block.FENCE_GATE), new Object[] {"sas", "sas", 'a', BunyanBlock.planks, 's', Item.STICK});
        Proxy.addRecipe(new ItemStack(Item.SIGN), new Object[] {"aaa", "aaa", " s ", 'a', BunyanBlock.planks, 's', Item.STICK});
        Proxy.addRecipe(new ItemStack(Item.BED), new Object[] {"www", "aaa", 'a', BunyanBlock.planks, 'w', Block.WOOL});
        Proxy.addRecipe(new ItemStack(Block.NOTE_BLOCK), new Object[] {"aaa", "asa", "aaa", 'a', BunyanBlock.planks, 's', Item.REDSTONE});
        Proxy.addRecipe(new ItemStack(Block.JUKEBOX), new Object[] {"aaa", "asa", "aaa", 'a', BunyanBlock.planks, 's', Item.DIAMOND});
        Proxy.addRecipe(new ItemStack(Block.PISTON), new Object[] {"aaa", "cic", "crc", 'a', BunyanBlock.planks, 'c', Block.COBBLESTONE, 'i', Item.IRON_INGOT, 'r', Item.REDSTONE});
        Proxy.addRecipe(new ItemStack(Block.BOOKSHELF), new Object[] {"aaa", "sss", "aaa", 'a', BunyanBlock.planks, 's', Item.BOOK});
        Proxy.addRecipe(new ItemStack(Item.WOOD_PICKAXE), new Object[] {"XXX", " # ", " # ", 'X', BunyanBlock.planks, '#', Item.STICK});
        Proxy.addRecipe(new ItemStack(Item.WOOD_SPADE), new Object[] {"X", "#", "#", 'X', BunyanBlock.planks, '#', Item.STICK});
        Proxy.addRecipe(new ItemStack(Item.WOOD_AXE), new Object[] {"XX", "X#", " #", 'X', BunyanBlock.planks, '#', Item.STICK});
        Proxy.addRecipe(new ItemStack(Item.WOOD_HOE), new Object[] {"XX", " #", " #", 'X', BunyanBlock.planks, '#', Item.STICK});
        Proxy.addRecipe(new ItemStack(Item.WOOD_SWORD), new Object[] {"X", "X", "#", 'X', BunyanBlock.planks, '#', Item.STICK});
        ItemStack var0 = new ItemStack(Item.COAL, 1, 1);
        Proxy.addSmelting(BunyanBlock.wood.id, 2, var0);
        Proxy.addSmelting(BunyanBlock.wood.id, 1, var0);
        Proxy.addSmelting(BunyanBlock.widewood.id, 1, var0);
        Proxy.addSmelting(BunyanBlock.widewood.id, 2, var0);
        Proxy.addSmelting(BunyanBlock.widewood.id, 0, var0);
    }
}
