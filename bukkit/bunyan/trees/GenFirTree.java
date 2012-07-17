package bunyan.trees;

import bunyan.blocks.BunyanBlock;
import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class GenFirTree extends TreeGenerator
{
    public GenFirTree(boolean var1)
    {
        super(var1);
        this.blockLeaf = TerrainGenManager.blockFirLeaves.id;
        this.metaLeaf = TerrainGenManager.metaFirLeaves;
        this.blockWood = BunyanBlock.wood.id;
        this.metaWood = 1;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (!this.isGoodSoil(var1, var3, var4, var5))
        {
            return false;
        }
        else
        {
            int var6 = this.getRandomHeight(var2);
            int var7 = this.getRandomHeightLeavesStart(var2);
            int var8 = this.getRandomMaxLeafRadius(var2);

            if (!this.isRoomToGrow(var1, var3, var4, var5, var6, var7, var8))
            {
                return false;
            }
            else
            {
                this.growTree(var1, var2, var3, var4, var5, var6, var7, var8);
                return true;
            }
        }
    }

    protected int getRandomHeight(Random var1)
    {
        return var1.nextInt(8) + 24;
    }

    protected int getRandomHeightLeavesStart(Random var1)
    {
        return 1 + var1.nextInt(12);
    }

    protected int getRandomLeafBlocksAboveTrunk(Random var1)
    {
        return var1.nextInt(3);
    }

    protected int getRandomMaxLeafRadius(Random var1)
    {
        return 2 + var1.nextInt(6);
    }

    protected void growLeaves(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        int var9 = var6 - var7;
        int var10 = var2.nextInt(2);
        int var11 = 1;
        boolean var12 = false;

        for (int var13 = 0; var13 <= var9; ++var13)
        {
            int var14 = var4 + var6 - var13;

            for (int var15 = var3 - var10; var15 <= var3 + var10; ++var15)
            {
                int var16 = var15 - var3;

                for (int var17 = var5 - var10; var17 <= var5 + var10; ++var17)
                {
                    int var18 = var17 - var5;

                    if (Math.abs(var16) != var10 || Math.abs(var18) != var10 || var10 <= 0)
                    {
                        this.setLeafBlock(var1, var15, var14, var17);
                    }
                }
            }

            if (var10 >= var11)
            {
                var10 = var12 ? 1 : 0;
                var12 = true;
                ++var11;

                if (var11 > var8)
                {
                    var11 = var8;
                }
            }
            else
            {
                ++var10;
            }
        }
    }

    protected void growRoots(World var1, Random var2, int var3, int var4, int var5)
    {
        var1.setRawTypeId(var3, var4 - 1, var5, Block.DIRT.id);
    }

    protected void growTree(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        this.growRoots(var1, var2, var3, var4, var5);
        this.growLeaves(var1, var2, var3, var4, var5, var6, var7, var8);
        this.growTrunk(var1, var2, var3, var4, var5, var6);
    }

    protected void growTrunk(World var1, Random var2, int var3, int var4, int var5, int var6)
    {
        int var7 = this.getRandomLeafBlocksAboveTrunk(var2);

        for (int var8 = 0; var8 < var6 - var7; ++var8)
        {
            this.setWoodBlock(var1, var3, var4 + var8, var5);
        }
    }

    protected boolean isRoomToGrow(World var1, int var2, int var3, int var4, int var5, int var6, int var7)
    {
        if (var3 >= 1 && var3 + var5 + 1 <= 256)
        {
            for (int var8 = var3; var8 <= var3 + 1 + var5; ++var8)
            {
                int var9 = var8 - var3 < var6 ? 0 : var7;

                for (int var10 = var2 - var9; var10 <= var2 + var9; ++var10)
                {
                    for (int var11 = var4 - var9; var11 <= var4 + var9; ++var11)
                    {
                        int var12 = var1.getTypeId(var10, var8, var11);

                        if (Block.byId[var12] != null && var12 != Block.SNOW.id && !Block.byId[var12].isLeaves(var1, var10, var8, var11))
                        {
                            return false;
                        }
                    }
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
