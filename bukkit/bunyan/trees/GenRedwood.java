package bunyan.trees;

import bunyan.blocks.BunyanBlock;
import extrabiomes.api.BiomeManager;
import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.World;

public class GenRedwood extends TreeGenStraightNoBranchesWide
{
    public GenRedwood(boolean var1)
    {
        super(var1);
        this.blockLeaf = TerrainGenManager.blockRedwoodLeaves.id;
        this.metaLeaf = TerrainGenManager.metaRedwoodLeaves;
        this.blockWood = BunyanBlock.widewood.id;
        this.metaWood = 0;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        BiomeBase var6 = var1.getBiome(var3, var5);
        return var6 == BiomeManager.wasteland && var2.nextInt(4) == 0 ? (new DeadTreeHuge(this.metaWood)).a(var1, var2, var3, var4, var5) : super.a(var1, var2, var3, var4, var5);
    }

    protected int getRandomHeight(Random var1)
    {
        return var1.nextInt(30) + 32;
    }

    protected int getRandomHeightLeavesStart(Random var1)
    {
        return 1 + var1.nextInt(24);
    }

    protected int getRandomLeafBlocksAboveTrunk(Random var1)
    {
        return var1.nextInt(3);
    }

    protected int getRandomMaxLeafRadius(Random var1)
    {
        return 2 + var1.nextInt(6);
    }
}
