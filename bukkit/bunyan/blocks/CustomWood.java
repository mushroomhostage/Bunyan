package bunyan.blocks;

import java.util.ArrayList;
import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class CustomWood extends Block
{
    public static final int metaRedwood = 0;
    public static final int metaFir = 1;
    public static final int metaAcacia = 2;

    public CustomWood(int var1)
    {
        super(var1, Material.WOOD);
        this.a(e);
        this.c(Block.WOOD.m());
        this.b(Block.WOOD.a((Entity)null) * 5.0F);
        this.j();
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this.id, 1, 0));
        var1.add(new ItemStack(this.id, 1, 1));
        var1.add(new ItemStack(this.id, 1, 2));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int getDropData(int var1)
    {
        return var1;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        boolean var3 = true;
        return 32 + var2;
    }

    /**
     * Returns how much this block can resist explosions from the passed in entity.
     */
    public float a(Entity var1)
    {
        return Block.WOOD.a(var1);
    }

    public int getFireSpreadSpeed(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        return Block.WOOD.getFireSpreadSpeed(var1, var2, var3, var4, var5, var6);
    }

    public int getFlammability(IBlockAccess var1, int var2, int var3, int var4, int var5, int var6)
    {
        return Block.WOOD.getFlammability(var1, var2, var3, var4, var5, var6);
    }

    /**
     * Returns the block hardness.
     */
    public float m()
    {
        return Block.WOOD.m();
    }

    public float getHardness(int var1)
    {
        return Block.WOOD.getHardness(var1);
    }

    public String getTextureFile()
    {
        return "/bunyan/blocks/blocks.png";
    }
}
