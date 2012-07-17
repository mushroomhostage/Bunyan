package bunyan;

import bunyan.blocks.BunyanBlock;
import forge.IOreHandler;
import net.minecraft.server.ItemStack;

public class WoodOreHandler implements IOreHandler
{
    public void registerOre(String var1, ItemStack var2)
    {
        if (var1.equals("woodAcacia"))
        {
            Proxy.addRecipe(new ItemStack(BunyanBlock.planks, 4, 2), new Object[] {"#", '#', var2});
        }
        else if (var1.equals("woodFir"))
        {
            Proxy.addRecipe(new ItemStack(BunyanBlock.planks, 4, 1), new Object[] {"#", '#', var2});
        }
        else if (var1.equals("woodRedWood"))
        {
            Proxy.addRecipe(new ItemStack(BunyanBlock.planks, 4, 0), new Object[] {"#", '#', var2});
        }
    }
}
