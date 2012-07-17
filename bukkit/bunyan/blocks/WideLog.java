package bunyan.blocks;

import forge.ITextureProvider;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.BlockLog;
import net.minecraft.server.Entity;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class WideLog extends BlockLog implements ITextureProvider
{
    public static final int metaRedwood = 0;
    public static final int metaFir = 1;
    public static final int metaOak = 2;

    public static int metadataWithDirection(int var0, int var1)
    {
        var1 -= 2;
        return var0 | var1 << 2;
    }

    public static void setDirection(World var0, int var1, int var2, int var3, byte var4)
    {
        int var5 = var0.getData(var1, var2, var3);
        var0.setData(var1, var2, var3, metadataWithDirection(var5, var4));
    }

    public WideLog(int var1)
    {
        super(var1);
        this.textureId = 0;
        this.a(e);
        this.c(Block.LOG.m());
        this.b(Block.LOG.a((Entity)null) * 5.0F);
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
        return var1 & 3;
    }

    /**
     * Spawns EntityItem in the world for the given ItemStack if the world is not remote.
     */
    protected void a(World var1, int var2, int var3, int var4, ItemStack var5)
    {
        var5.setData(var5.getData() & 3);
        super.a(var1, var2, var3, var4, var5);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        int var3 = ((var2 & 12) >> 2) + 2;
        var2 &= 3;
        byte var4 = 0;
        byte var5 = 0;

        if (var1 != 0 && var1 != 1)
        {
            if (var1 == 2)
            {
                if (var3 == 2)
                {
                    var4 = 0;
                    var5 = 0;
                }
                else if (var3 == 3)
                {
                    var4 = 3;
                    var5 = 0;
                }
                else if (var3 == 4)
                {
                    var4 = 3;
                    var5 = 1;
                }
                else if (var3 == 5)
                {
                    var4 = 0;
                    var5 = 1;
                }
            }
            else if (var1 == 3)
            {
                if (var3 == 2)
                {
                    var4 = 3;
                    var5 = 1;
                }
                else if (var3 == 3)
                {
                    var4 = 0;
                    var5 = 1;
                }
                else if (var3 == 4)
                {
                    var4 = 0;
                    var5 = 0;
                }
                else if (var3 == 5)
                {
                    var4 = 3;
                    var5 = 0;
                }
            }
            else if (var1 == 4)
            {
                if (var3 == 2)
                {
                    var4 = 3;
                    var5 = 0;
                }
                else if (var3 == 3)
                {
                    var4 = 3;
                    var5 = 1;
                }
                else if (var3 == 4)
                {
                    var4 = 0;
                    var5 = 1;
                }
                else if (var3 == 5)
                {
                    var4 = 0;
                    var5 = 0;
                }
            }
            else if (var1 == 5)
            {
                if (var3 == 2)
                {
                    var4 = 0;
                    var5 = 1;
                }
                else if (var3 == 3)
                {
                    var4 = 0;
                    var5 = 0;
                }
                else if (var3 == 4)
                {
                    var4 = 3;
                    var5 = 0;
                }
                else if (var3 == 5)
                {
                    var4 = 3;
                    var5 = 1;
                }
            }
        }
        else if (var3 == 2)
        {
            var4 = 1;
            var5 = 1;
        }
        else if (var3 == 3)
        {
            var4 = 2;
            var5 = 1;
        }
        else if (var3 == 4)
        {
            var4 = 2;
            var5 = 0;
        }
        else if (var3 == 5)
        {
            var4 = 1;
            var5 = 0;
        }

        return (var4 + 3) * 16 + var5 + var2 * 2;
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

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onPlace(World var1, int var2, int var3, int var4)
    {
        super.onPlace(var1, var2, var3, var4);
        this.setDefaultDirection(var1, var2, var3, var4);
    }

    private void setDefaultDirection(World var1, int var2, int var3, int var4)
    {
        if (!var1.isStatic)
        {
            int var5 = var1.getTypeId(var2, var3, var4 - 1);
            int var6 = var1.getTypeId(var2, var3, var4 + 1);
            int var7 = var1.getTypeId(var2 - 1, var3, var4);
            int var8 = var1.getTypeId(var2 + 1, var3, var4);
            byte var9 = 3;

            if (var5 != this.id && var6 != this.id && var7 != this.id && var8 != this.id)
            {
                if (Block.n[var5] && !Block.n[var6])
                {
                    var9 = 3;
                }

                if (Block.n[var6] && !Block.n[var5])
                {
                    var9 = 2;
                }

                if (Block.n[var7] && !Block.n[var8])
                {
                    var9 = 5;
                }

                if (Block.n[var8] && !Block.n[var7])
                {
                    var9 = 4;
                }

                setDirection(var1, var2, var3, var4, var9);
            }
            else
            {
                this.setSmartDirection(var1, var2, var3, var4);
            }
        }
    }

    private void setSmartDirection(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getTypeId(var2, var3, var4 + 1);
        int var6 = 3;
        int var7;
        int var8;

        if (var5 == this.id)
        {
            var7 = var1.getData(var2, var3, var4 + 1);
            var8 = ((var7 & 12) >> 2) + 2;
            var6 = var8 == 3 ? 2 : (var8 == 2 ? 3 : (var8 == 4 ? 5 : 4));
        }

        var5 = var1.getTypeId(var2, var3, var4 - 1);

        if (var5 == this.id)
        {
            var7 = var1.getData(var2, var3, var4 - 1);
            var8 = ((var7 & 12) >> 2) + 2;
            var6 = var8 == 3 ? 2 : (var8 == 2 ? 3 : (var8 == 4 ? 5 : 4));
        }

        var5 = var1.getTypeId(var2 - 1, var3, var4);

        if (var5 == this.id)
        {
            var7 = var1.getData(var2 - 1, var3, var4);
            var8 = ((var7 & 12) >> 2) + 2;
            var6 = var8 == 3 ? 4 : (var8 == 4 ? 3 : (var8 == 2 ? 5 : 2));
        }

        var5 = var1.getTypeId(var2 + 1, var3, var4);

        if (var5 == this.id)
        {
            var7 = var1.getData(var2 + 1, var3, var4);
            var8 = ((var7 & 12) >> 2) + 2;
            var6 = var8 == 3 ? 4 : (var8 == 4 ? 3 : (var8 == 2 ? 5 : 2));
        }

        setDirection(var1, var2, var3, var4, (byte)var6);
    }
}
