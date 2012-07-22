package bunyan.blocks;

import bunyan.api.Direction;
import bunyan.api.DirectionalBlock;
import bunyan.api.ITurnable;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.BlockLog;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class CustomLog extends BlockLog implements ITurnable
{
    public static final int metaFir = 1;
    public static final int metaAcacia = 2;

    public CustomLog(int var1)
    {
        super(var1);
        this.textureId = 70;
        this.a(e);
        this.j();
        this.c(Block.LOG.m());
        this.b(Block.LOG.a((Entity)null) * 5.0F);
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this.id, 1, 1));
        var1.add(new ItemStack(this.id, 1, 2));
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        int var3 = var1 != 0 && var1 != 1 ? 0 : 1;
        return var3 * 16 + var2;
    }

    /**
     * Returns how much this block can resist explosions from the passed in entity.
     */
    public float a(Entity var1)
    {
        return Block.LOG.a(var1);
    }

    public int getFireSpreadSpeed(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        return Block.LOG.getFireSpreadSpeed(var1, var2, var3, var4, var5, var6);
    }

    public int getFlammability(IBlockAccess var1, int var2, int var3, int var4, int var5, int var6)
    {
        return Block.LOG.getFlammability(var1, var2, var3, var4, var5, var6);
    }

    /**
     * Returns the block hardness.
     */
    public float m()
    {
        return Block.LOG.m();
    }

    public float getHardness(int var1)
    {
        return Block.LOG.getHardness(var1);
    }

    public String getTextureFile()
    {
        return "/bunyan/blocks/blocks.png";
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int getDropType(int var1, Random var2, int var3)
    {
        return this.id;
    }

    public void onLogTurner(EntityHuman var1, World var2, int var3, int var4, int var5, Direction var6)
    {
        if (var6 != Direction.DOWN && var6 != Direction.UP)
        {
            int var7 = var2.getData(var3, var4, var5);
            var2.setRawTypeId(var3, var4, var5, BunyanBlock.turnableCustomWood.id);
            DirectionalBlock.setDataAndFacing(var2, var3, var4, var5, var7, var6, true);
        }
    }
}
