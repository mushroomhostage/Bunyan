package bunyan.trees;

import java.util.Random;
import net.minecraft.server.World;

public abstract class TreeGenStraightNoBranches extends TreeGenerator
{
    public TreeGenStraightNoBranches(boolean var1)
    {
        super(var1);
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

    protected void growTrunk(World var1, Random var2, int var3, int var4, int var5, int var6)
    {
        int var7 = this.getRandomLeafBlocksAboveTrunk(var2);

        for (int var8 = 0; var8 < var6 - var7; ++var8)
        {
            this.setWoodBlock(var1, var3, var4 + var8, var5);
        }
    }
}
