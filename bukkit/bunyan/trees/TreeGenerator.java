package bunyan.trees;

import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public abstract class TreeGenerator extends WorldGenerator
{
    protected int blockLeaf;
    protected int blockWood;
    protected int metaLeaf;
    protected int metaWood;

    public TreeGenerator(boolean var1)
    {
        super(var1);
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

    protected abstract int getRandomHeight(Random var1);

    protected abstract int getRandomHeightLeavesStart(Random var1);

    protected abstract int getRandomLeafBlocksAboveTrunk(Random var1);

    protected abstract int getRandomMaxLeafRadius(Random var1);

    protected abstract void growLeaves(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8);

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

    protected abstract void growTrunk(World var1, Random var2, int var3, int var4, int var5, int var6);

    protected boolean isGoodSoil(World var1, int var2, int var3, int var4)
    {
        return TerrainGenManager.treesCanGrowOnIDs.contains(Integer.valueOf(var1.getTypeId(var2, var3 - 1, var4)));
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
                        if (!var1.q().isChunkLoaded(var10 >> 4, var11 >> 4))
                        {
                            return false;
                        }

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

    protected void setLeafBlock(World var1, int var2, int var3, int var4)
    {
        if (var1.q().isChunkLoaded(var2 >> 4, var4 >> 4))
        {
            Block var5 = Block.byId[var1.getTypeId(var2, var3, var4)];

            if (var5 == null || var5.canBeReplacedByLeaves(var1, var2, var3, var4))
            {
                this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2, var3, var4, this.blockLeaf, this.metaLeaf);
            }
        }
    }

    protected void setWoodBlock(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getTypeId(var2, var3, var4);

        if (Block.byId[var5] == null || var5 == Block.SNOW.id || Block.byId[var5].isLeaves(var1, var2, var3, var4))
        {
            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2, var3, var4, this.blockWood, this.metaWood);
        }
    }
}
