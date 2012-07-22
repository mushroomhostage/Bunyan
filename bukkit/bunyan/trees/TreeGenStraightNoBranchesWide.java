package bunyan.trees;

import bunyan.api.Direction;
import bunyan.api.DirectionalBlock;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public abstract class TreeGenStraightNoBranchesWide extends TreeGenStraightNoBranches
{
    protected static boolean doBlockNotify;

    public TreeGenStraightNoBranchesWide(boolean var1)
    {
        super(var1);
        doBlockNotify = var1;
    }

    protected void growRoots(World var1, Random var2, int var3, int var4, int var5)
    {
        for (int var6 = 0; var6 > -2; --var6)
        {
            for (int var7 = 0; var7 > -2; --var7)
            {
                super.growRoots(var1, var2, var3 + var7, var4, var5 + var6);
            }
        }
    }

    protected boolean isGoodSoil(World var1, int var2, int var3, int var4)
    {
        for (int var5 = 0; var5 > -2; --var5)
        {
            for (int var6 = 0; var6 > -2; --var6)
            {
                if (!super.isGoodSoil(var1, var2 + var6, var3, var4 + var5))
                {
                    return false;
                }
            }
        }

        return true;
    }

    protected void setLeafBlock(World var1, int var2, int var3, int var4)
    {
        for (int var5 = 0; var5 > -2; --var5)
        {
            for (int var6 = 0; var6 > -2; --var6)
            {
                super.setLeafBlock(var1, var2 + var6, var3, var4 + var5);
            }
        }
    }

    protected void setWoodBlock(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getTypeId(var2, var3, var4);

        if (Block.byId[var5] == null || var5 == Block.SNOW.id || Block.byId[var5].isLeaves(var1, var2, var3, var4))
        {
            Direction[] var6 = new Direction[] {Direction.SOUTH, Direction.WEST, Direction.NORTH, Direction.EAST};
            int var7 = 0;

            for (int var8 = 0; var8 > -2; --var8)
            {
                for (int var9 = 0; var9 > -2; --var9)
                {
                    this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2 + var9, var3, var4 + var8, this.blockWood, DirectionalBlock.getCompositeDataAndFacing(this.metaWood, var6[var7++]));
                }
            }
        }
    }
}
