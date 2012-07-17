package bunyan.trees;

import bunyan.blocks.BunyanBlock;
import bunyan.blocks.WideLog;
import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class DeadTreeHuge extends TreeGenStraightNoBranchesWide
{
    private static int max(int[] var0)
    {
        int var1 = 0;
        int[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            int var5 = var2[var4];

            if (var5 > var1)
            {
                var1 = var5;
            }
        }

        return var1;
    }

    public DeadTreeHuge(int var1)
    {
        super(false);
        this.blockLeaf = 0;
        this.metaLeaf = 0;
        this.blockWood = BunyanBlock.widewood.id;
        this.metaWood = var1;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (!this.isGoodSoil(var1, var3, var4, var5))
        {
            return false;
        }
        else
        {
            int var6 = var2.nextInt(4) + 1;
            int[] var7 = new int[] {var2.nextInt(8) + var6, var2.nextInt(8) + var6, var2.nextInt(8) + var6, var2.nextInt(8) + var6};
            int var8 = max(var7);

            if (!this.isRoomToGrow(var1, var8, var3, var4, var5))
            {
                return false;
            }
            else
            {
                for (int var9 = 0; var9 < var8; ++var9)
                {
                    int[] var10 = new int[] {3, 4, 2, 5};
                    int var11 = 0;

                    for (int var12 = 0; var12 > -2; --var12)
                    {
                        for (int var13 = 0; var13 > -2; --var13)
                        {
                            int var14 = 0 - var12 * 2 - var13;

                            if (var9 < var7[var14])
                            {
                                this.setTypeAndData(var1, var3 + var13, var4 + var9, var5 + var12, this.blockWood, this.metaWood);
                                this.setMetadata(var1, var3 + var13, var4 + var9, var5 + var12, WideLog.metadataWithDirection(this.metaWood, var10[var11]));
                            }

                            ++var11;
                        }
                    }
                }

                return true;
            }
        }
    }

    protected int getRandomHeight(Random var1)
    {
        return 0;
    }

    protected int getRandomHeightLeavesStart(Random var1)
    {
        return 0;
    }

    protected int getRandomLeafBlocksAboveTrunk(Random var1)
    {
        return 0;
    }

    protected int getRandomMaxLeafRadius(Random var1)
    {
        return 0;
    }

    protected boolean isGoodSoil(World var1, int var2, int var3, int var4)
    {
        for (int var5 = 0; var5 > -2; --var5)
        {
            for (int var6 = 0; var6 > -2; --var6)
            {
                int var7 = var1.getTypeId(var2 + var6, var3 - 1, var4 + var5);

                if (var7 != TerrainGenManager.blockWasteland.id)
                {
                    return false;
                }
            }
        }

        return true;
    }

    protected boolean isRoomToGrow(World var1, int var2, int var3, int var4, int var5)
    {
        if (var4 >= 1 && var4 + var2 + 1 <= 256)
        {
            for (int var6 = var4; var6 <= var4 + 1 + var2; ++var6)
            {
                for (int var7 = var3 - 2; var7 <= var3 + 1; ++var7)
                {
                    for (int var8 = var5 - 2; var8 <= var5 + 1; ++var8)
                    {
                        int var9 = var1.getTypeId(var7, var6, var8);

                        if (Block.byId[var9] != null && var9 != Block.SNOW.id && !Block.byId[var9].isLeaves(var1, var7, var6, var8))
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
