package bunyan.trees;

import bunyan.blocks.BunyanBlock;
import bunyan.blocks.WideLog;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class GenOakHuge extends TreeGenerator
{
    final int blockTrunk;
    final int metaTrunk;

    public GenOakHuge(boolean var1)
    {
        super(var1);
        this.blockLeaf = Block.LEAVES.id;
        this.metaLeaf = 0;
        this.blockWood = Block.LOG.id;
        this.metaWood = 0;
        this.blockTrunk = BunyanBlock.widewood.id;
        this.metaTrunk = 2;
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
            int var7 = this.getRandomMaxLeafRadius(var2);
            this.growTree(var1, var2, var3, var4, var5, var6, 0, var7);
            return true;
        }
    }

    protected int getRandomHeight(Random var1)
    {
        return var1.nextInt(4) + 3;
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
        return 15 + var1.nextInt(25);
    }

    private void growLeafNode(World var1, int var2, int var3, int var4)
    {
        for (int var5 = -3; var5 <= 3; ++var5)
        {
            for (int var6 = -3; var6 <= 3; ++var6)
            {
                if ((Math.abs(var5) != 3 || Math.abs(var6) != 3) && (Math.abs(var5) != 3 || Math.abs(var6) != 2) && (Math.abs(var5) != 2 || Math.abs(var6) != 3) && (var5 != 0 || var6 != 0) && var1.getTypeId(var2 + var5, var3, var4 + var6) == 0)
                {
                    this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2 + var5, var3, var4 + var6, this.blockLeaf, this.metaLeaf);
                }

                if (Math.abs(var5) < 3 && Math.abs(var6) < 3 && (Math.abs(var5) != 2 || Math.abs(var6) != 2))
                {
                    if (var1.getTypeId(var2 + var5, var3 - 1, var4 + var6) == 0)
                    {
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2 + var5, var3 - 1, var4 + var6, this.blockLeaf, this.metaLeaf);
                    }

                    if (var1.getTypeId(var2 + var5, var3 + 1, var4 + var6) == 0)
                    {
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2 + var5, var3 + 1, var4 + var6, this.blockLeaf, this.metaLeaf);
                    }
                }
            }
        }
    }

    protected void growLeaves(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        GenOakHuge.BendDirection[] var9 = GenOakHuge.BendDirection.values();
        int var10 = var9.length;

        for (int var11 = 0; var11 < var10; ++var11)
        {
            GenOakHuge.BendDirection var12 = var9[var11];
            GenOakHuge.BendDirection[] var13 = GenOakHuge.BendDirection.values();
            int var14 = var13.length;

            for (int var15 = 0; var15 < var14; ++var15)
            {
                GenOakHuge.BendDirection var16 = var13[var15];

                if (var12 != GenOakHuge.BendDirection.STRAIGHT || var16 != GenOakHuge.BendDirection.STRAIGHT)
                {
                    this.primary(var1, var2, var8, var12, var16, var3, var4 + var6, var5);
                    this.inside(var1, var2, var8, var12, var16, var3, var4 + var6, var5);
                    this.insideSmall(var1, var2, var8, var12, var16, var3, var4 + var6, var5);
                }
            }
        }
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

    protected void growTree(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        this.growRoots(var1, var2, var3, var4, var5);
        this.growTrunk(var1, var2, var3, var4, var5, var6);
        this.growLeaves(var1, var2, var3, var4, var5, var6, var7, var8);
    }

    protected void growTrunk(World var1, Random var2, int var3, int var4, int var5, int var6)
    {
        int[] var7 = new int[] {3, 4, 2, 5};

        for (int var8 = 0; var8 < var6 + 1; ++var8)
        {
            int var9 = 0;

            for (int var10 = 0; var10 > -2; --var10)
            {
                for (int var11 = 0; var11 > -2; --var11)
                {
                    this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3 + var11, var4 + var8, var5 + var10, this.blockTrunk, WideLog.metadataWithDirection(this.metaTrunk, var7[var9++]));
                }
            }
        }
    }

    private void inside(World var1, Random var2, int var3, GenOakHuge.BendDirection var4, GenOakHuge.BendDirection var5, int var6, int var7, int var8)
    {
        for (int var9 = 0; var9 < 2 * var3 / 3; ++var9)
        {
            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var6, var7, var8, this.blockWood, this.metaWood);

            if (var2.nextInt(3) == 0 || var9 == 2 * var3 / 3 - 1)
            {
                this.growLeafNode(var1, var6, var7, var8);
            }

            switch (GenOakHuge.NamelessClass1076110991.$SwitchMap$bunyan$trees$GenOakHuge$BendDirection[var4.ordinal()])
            {
                case 1:
                    var6 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var6 += var2.nextInt(2);
                    break;

                case 3:
                    var6 -= var2.nextInt(2);
            }

            switch (GenOakHuge.NamelessClass1076110991.$SwitchMap$bunyan$trees$GenOakHuge$BendDirection[var5.ordinal()])
            {
                case 1:
                    var8 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var8 += var2.nextInt(2);
                    break;

                case 3:
                    var8 -= var2.nextInt(2);
            }

            if (var2.nextInt(6) == 0 && var9 > var3 / 3)
            {
                this.secondary(var1, var2, var3 / 3 - var9 / 3, var4, var5, var6, var7, var8);
            }

            ++var7;
        }
    }

    private void insideSmall(World var1, Random var2, int var3, GenOakHuge.BendDirection var4, GenOakHuge.BendDirection var5, int var6, int var7, int var8)
    {
        for (int var9 = 0; var9 < var3 / 3; ++var9)
        {
            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var6, var7, var8, this.blockWood, this.metaWood);

            if (var2.nextInt(3) == 0 || var9 == var3 / 3 - 1)
            {
                this.growLeafNode(var1, var6, var7, var8);
            }

            switch (GenOakHuge.NamelessClass1076110991.$SwitchMap$bunyan$trees$GenOakHuge$BendDirection[var4.ordinal()])
            {
                case 1:
                    var6 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var6 += var2.nextInt(2);
                    break;

                case 3:
                    var6 -= var2.nextInt(2);
            }

            switch (GenOakHuge.NamelessClass1076110991.$SwitchMap$bunyan$trees$GenOakHuge$BendDirection[var5.ordinal()])
            {
                case 1:
                    var8 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var8 += var2.nextInt(2);
                    break;

                case 3:
                    var8 -= var2.nextInt(2);
            }

            if (var2.nextInt(6) == 0 && var9 > var3 / 6)
            {
                this.secondary(var1, var2, var3 / 6 - var9 / 6, var4, var5, var6, var7, var8);
            }

            ++var7;
        }
    }

    protected boolean isGoodSoil(World var1, int var2, int var3, int var4)
    {
        if (!super.isGoodSoil(var1, var2, var3, var4))
        {
            return false;
        }
        else
        {
            int var5 = var1.getTypeId(var2, var3 - 2, var4);
            return var5 != Block.STATIONARY_WATER.id && var5 != Block.WATER.id && var5 != Block.STONE.id;
        }
    }

    private void primary(World var1, Random var2, int var3, GenOakHuge.BendDirection var4, GenOakHuge.BendDirection var5, int var6, int var7, int var8)
    {
        GenOakHuge.Acuteness var9 = GenOakHuge.Acuteness.LOOSE;
        int var10 = 0;

        if (var4 == GenOakHuge.BendDirection.RIGHT)
        {
            var6 += 2;
        }

        if (var4 == GenOakHuge.BendDirection.LEFT)
        {
            var6 -= 2;
        }

        if (var5 == GenOakHuge.BendDirection.RIGHT)
        {
            var8 += 2;
        }

        if (var5 == GenOakHuge.BendDirection.LEFT)
        {
            var8 -= 2;
        }

        for (; var10 < var3; ++var10)
        {
            switch (GenOakHuge.NamelessClass1076110991.$SwitchMap$bunyan$trees$GenOakHuge$Acuteness[var9.ordinal()])
            {
                case 1:
                    if (var2.nextInt(4) == 0)
                    {
                        ++var7;
                    }

                    break;

                case 2:
                    if (var2.nextInt(2) == 0)
                    {
                        ++var7;
                    }

                    break;

                case 3:
                    ++var7;
            }

            this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var6, var7, var8, this.blockWood, this.metaWood);

            if (var2.nextInt(3) == 0 || var10 == var3 - 1)
            {
                this.growLeafNode(var1, var6, var7, var8);
            }

            switch (GenOakHuge.NamelessClass1076110991.$SwitchMap$bunyan$trees$GenOakHuge$BendDirection[var4.ordinal()])
            {
                case 1:
                    var6 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var6 += var2.nextInt(2);
                    break;

                case 3:
                    var6 -= var2.nextInt(2);
            }

            switch (GenOakHuge.NamelessClass1076110991.$SwitchMap$bunyan$trees$GenOakHuge$BendDirection[var5.ordinal()])
            {
                case 1:
                    var8 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var8 += var2.nextInt(2);
                    break;

                case 3:
                    var8 -= var2.nextInt(2);
            }

            if (var10 == var3 / 3)
            {
                var9 = GenOakHuge.Acuteness.TIGHTER;
            }

            if (var10 == 2 * var3 / 3)
            {
                var9 = GenOakHuge.Acuteness.TIGHT;
            }

            if (var2.nextInt(4) == 0)
            {
                this.secondary(var1, var2, var3 / 2 - var10 / 2, var4, var5, var6, var7, var8);
            }
        }
    }

    private void secondary(World var1, Random var2, int var3, GenOakHuge.BendDirection var4, GenOakHuge.BendDirection var5, int var6, int var7, int var8)
    {
        int var9 = 0;

        for (int var10 = 0; var10 < 2; ++var10)
        {
            int var11 = var6;
            int var12 = var7;

            for (int var13 = var8; var9 < var3; ++var9)
            {
                if (var2.nextInt(2) == 0)
                {
                    ++var12;
                }

                this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var11, var12, var13, this.blockWood, this.metaWood);

                if (var2.nextInt(4) == 0 || var9 == var3 - 1)
                {
                    this.growLeafNode(var1, var11, var12, var13);
                }

                if (var5 == GenOakHuge.BendDirection.STRAIGHT)
                {
                    if (var4 == GenOakHuge.BendDirection.RIGHT)
                    {
                        var11 += var2.nextInt(2);
                    }
                    else
                    {
                        var11 -= var2.nextInt(2);
                    }

                    if (var10 == 0)
                    {
                        var13 += var2.nextInt(2);
                    }
                    else
                    {
                        var13 -= var2.nextInt(2);
                    }
                }

                if (var4 == GenOakHuge.BendDirection.STRAIGHT)
                {
                    if (var5 == GenOakHuge.BendDirection.RIGHT)
                    {
                        var13 += var2.nextInt(2);
                    }
                    else
                    {
                        var13 -= var2.nextInt(2);
                    }

                    if (var10 == 0)
                    {
                        var11 += var2.nextInt(2);
                    }
                    else
                    {
                        var11 -= var2.nextInt(2);
                    }
                }

                if (var4 == GenOakHuge.BendDirection.RIGHT)
                {
                    if (var5 == GenOakHuge.BendDirection.RIGHT)
                    {
                        if (var10 == 0)
                        {
                            var13 += var2.nextInt(2);
                        }
                        else
                        {
                            var11 += var2.nextInt(2);
                        }
                    }

                    if (var5 == GenOakHuge.BendDirection.LEFT)
                    {
                        if (var10 == 0)
                        {
                            var13 -= var2.nextInt(2);
                        }
                        else
                        {
                            var11 += var2.nextInt(2);
                        }
                    }
                }

                if (var4 == GenOakHuge.BendDirection.LEFT)
                {
                    if (var5 == GenOakHuge.BendDirection.RIGHT)
                    {
                        if (var10 == 0)
                        {
                            var13 += var2.nextInt(2);
                        }
                        else
                        {
                            var11 -= var2.nextInt(2);
                        }
                    }

                    if (var5 == GenOakHuge.BendDirection.LEFT)
                    {
                        if (var10 == 0)
                        {
                            var13 -= var2.nextInt(2);
                        }
                        else
                        {
                            var11 -= var2.nextInt(2);
                        }
                    }
                }
            }
        }
    }

    static enum Acuteness
    {
        LOOSE("LOOSE", 0),
        TIGHTER("TIGHTER", 1),
        TIGHT("TIGHT", 2);

        private static final GenOakHuge.Acuteness[] $VALUES = new GenOakHuge.Acuteness[]{LOOSE, TIGHTER, TIGHT};

        private Acuteness(String var1, int var2) {}
    }

    static enum BendDirection
    {
        LEFT("LEFT", 0),
        STRAIGHT("STRAIGHT", 1),
        RIGHT("RIGHT", 2);

        private static final GenOakHuge.BendDirection[] $VALUES = new GenOakHuge.BendDirection[]{LEFT, STRAIGHT, RIGHT};

        private BendDirection(String var1, int var2) {}
    }

    static class NamelessClass1076110991
    {
        static final int[] $SwitchMap$bunyan$trees$GenOakHuge$BendDirection;

        static final int[] $SwitchMap$bunyan$trees$GenOakHuge$Acuteness = new int[GenOakHuge.Acuteness.values().length];

        static
        {
            try
            {
                $SwitchMap$bunyan$trees$GenOakHuge$Acuteness[GenOakHuge.Acuteness.LOOSE.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$trees$GenOakHuge$Acuteness[GenOakHuge.Acuteness.TIGHTER.ordinal()] = 2;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$trees$GenOakHuge$Acuteness[GenOakHuge.Acuteness.TIGHT.ordinal()] = 3;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            $SwitchMap$bunyan$trees$GenOakHuge$BendDirection = new int[GenOakHuge.BendDirection.values().length];

            try
            {
                $SwitchMap$bunyan$trees$GenOakHuge$BendDirection[GenOakHuge.BendDirection.STRAIGHT.ordinal()] = 1;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$trees$GenOakHuge$BendDirection[GenOakHuge.BendDirection.RIGHT.ordinal()] = 2;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$trees$GenOakHuge$BendDirection[GenOakHuge.BendDirection.LEFT.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
