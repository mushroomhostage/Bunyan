package bunyan.trees;

import bunyan.blocks.WideLog;
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
        super.growRoots(var1, var2, var3, var4, var5);
        super.growRoots(var1, var2, var3 - 1, var4, var5);
        super.growRoots(var1, var2, var3, var4, var5 - 1);
        super.growRoots(var1, var2, var3 - 1, var4, var5 - 1);
    }

    protected boolean isGoodSoil(World var1, int var2, int var3, int var4)
    {
        return super.isGoodSoil(var1, var2, var3, var4) && super.isGoodSoil(var1, var2, var3, var4 - 1) && super.isGoodSoil(var1, var2 - 1, var3, var4) && super.isGoodSoil(var1, var2 - 1, var3, var4 - 1);
    }

    protected void setLeafBlock(World var1, int var2, int var3, int var4)
    {
        super.setLeafBlock(var1, var2, var3, var4);
        super.setLeafBlock(var1, var2 - 1, var3, var4);
        super.setLeafBlock(var1, var2, var3, var4 - 1);
        super.setLeafBlock(var1, var2 - 1, var3, var4 - 1);
    }

    protected void setMetadata(World var1, int var2, int var3, int var4, int var5)
    {
        if (doBlockNotify)
        {
            var1.setData(var2, var3, var4, var5);
        }
        else if (var1.isLoaded(var2, var3, var4) && var1.getChunkAtWorldCoords(var2, var4).seenByPlayer)
        {
            if (var1.setRawData(var2, var3, var4, var5))
            {
                var1.notify(var2, var3, var4);
            }
        }
        else
        {
            var1.setRawData(var2, var3, var4, var5);
        }
    }

    protected void setWoodBlock(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getTypeId(var2, var3, var4);

        if (Block.byId[var5] == null || var5 == Block.SNOW.id || Block.byId[var5].isLeaves(var1, var2, var3, var4))
        {
            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2, var3, var4, this.blockWood, this.metaWood);
            this.setMetadata(var1, var2, var3, var4, WideLog.metadataWithDirection(this.metaWood, 3));
            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2 - 1, var3, var4, this.blockWood, this.metaWood);
            this.setMetadata(var1, var2 - 1, var3, var4, WideLog.metadataWithDirection(this.metaWood, 4));
            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2, var3, var4 - 1, this.blockWood, this.metaWood);
            this.setMetadata(var1, var2, var3, var4 - 1, WideLog.metadataWithDirection(this.metaWood, 2));
            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2 - 1, var3, var4 - 1, this.blockWood, this.metaWood);
            this.setMetadata(var1, var2 - 1, var3, var4 - 1, WideLog.metadataWithDirection(this.metaWood, 5));
        }
    }
}
