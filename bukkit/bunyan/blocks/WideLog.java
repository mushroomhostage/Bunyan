package bunyan.blocks;

import bunyan.api.Direction;
import bunyan.api.DirectionalBlock;
import bunyan.api.TurnableLog;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.ItemStack;
import net.minecraft.server.MathHelper;
import net.minecraft.server.World;

public class WideLog extends TurnableLog
{
    public static final int metaRedwood = 0;
    public static final int metaFir = 1;
    public static final int metaOak = 2;

    public WideLog(int var1)
    {
        super(var1, 48);
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this.id, 1, 0));
        var1.add(new ItemStack(this.id, 1, 1));
        var1.add(new ItemStack(this.id, 1, 2));
    }

    /**
     * The type of render function that is called for this block
     */
    public int c()
    {
        return 0;
    }

    public String getTextureFile()
    {
        return "/bunyan/blocks/blocks.png";
    }

    public int getTextureOffsetFromFacingSideAndMetadata(Direction var1, Direction var2, int var3)
    {
        int var4 = getDataFromMetadata(var3);
        byte var5 = 0;
        byte var6 = 0;

        switch (WideLog.NamelessClass1555442305.$SwitchMap$bunyan$api$Direction[var2.ordinal()])
        {
            case 1:
                switch (WideLog.NamelessClass1555442305.$SwitchMap$bunyan$api$Direction[var1.ordinal()])
                {
                    case 1:
                        var5 = 0;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    case 2:
                        var5 = 3;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    case 3:
                        var5 = 3;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    case 4:
                        var5 = 0;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    default:
                        return var5 * 16 + var6 + var4 * 2;
                }

            case 2:
                switch (WideLog.NamelessClass1555442305.$SwitchMap$bunyan$api$Direction[var1.ordinal()])
                {
                    case 1:
                        var5 = 3;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    case 2:
                        var5 = 0;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    case 3:
                        var5 = 0;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    case 4:
                        var5 = 3;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    default:
                        return var5 * 16 + var6 + var4 * 2;
                }

            case 3:
                switch (WideLog.NamelessClass1555442305.$SwitchMap$bunyan$api$Direction[var1.ordinal()])
                {
                    case 1:
                        var5 = 3;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    case 2:
                        var5 = 3;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    case 3:
                        var5 = 0;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    case 4:
                        var5 = 0;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    default:
                        return var5 * 16 + var6 + var4 * 2;
                }

            case 4:
                switch (WideLog.NamelessClass1555442305.$SwitchMap$bunyan$api$Direction[var1.ordinal()])
                {
                    case 1:
                        var5 = 0;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    case 2:
                        var5 = 0;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    case 3:
                        var5 = 3;
                        var6 = 0;
                        return var5 * 16 + var6 + var4 * 2;

                    case 4:
                        var5 = 3;
                        var6 = 1;
                        return var5 * 16 + var6 + var4 * 2;

                    default:
                        return var5 * 16 + var6 + var4 * 2;
                }

            case 5:
            case 6:
                switch (WideLog.NamelessClass1555442305.$SwitchMap$bunyan$api$Direction[var1.ordinal()])
                {
                    case 1:
                        var5 = 1;
                        var6 = 1;
                        break;

                    case 2:
                        var5 = 2;
                        var6 = 1;
                        break;

                    case 3:
                        var5 = 2;
                        var6 = 0;
                        break;

                    case 4:
                        var5 = 1;
                        var6 = 0;
                }
        }

        return var5 * 16 + var6 + var4 * 2;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int getDropType(int var1, Random var2, int var3)
    {
        return BunyanBlock.widewood.id;
    }

    /**
     * Called when the block is placed in the world.
     */
    public void postPlace(World var1, int var2, int var3, int var4, EntityLiving var5)
    {
        Direction var6 = Direction.NORTH;

        if (var5 != null)
        {
            int var7 = MathHelper.floor((double)(var5.yaw * 4.0F / 360.0F) + 0.5D) & 3;

            switch (var7)
            {
                case 0:
                    var6 = Direction.SOUTH;
                    break;

                case 1:
                    var6 = Direction.WEST;
                    break;

                case 2:
                    var6 = Direction.EAST;
                    break;

                case 3:
                    var6 = Direction.NORTH;
            }

            setFacing(var1, var2, var3, var4, var6, true);
        }
    }

    public void onLogTurner(EntityHuman var1, World var2, int var3, int var4, int var5, Direction var6)
    {
        int var7;

        if (var6 == Direction.UP)
        {
            var7 = DirectionalBlock.getDataFromMetadata(var2.getData(var3, var4, var5));
            var2.setRawTypeIdAndData(var3, var4, var5, BunyanBlock.widewoodBarkBottom.id, var7);
            BunyanBlock.widewoodBarkBottom.postPlace(var2, var3, var4, var5, var1);
        }
        else if (var6 == Direction.DOWN)
        {
            var7 = DirectionalBlock.getDataFromMetadata(var2.getData(var3, var4, var5));
            var2.setRawTypeIdAndData(var3, var4, var5, BunyanBlock.widewoodBarkTop.id, var7);
            BunyanBlock.widewoodBarkTop.postPlace(var2, var3, var4, var5, var1);
        }
        else
        {
            Direction var8 = Direction.NORTH;

            switch (WideLog.NamelessClass1555442305.$SwitchMap$bunyan$api$Direction[var6.ordinal()])
            {
                case 1:
                case 4:
                    var8 = var6.oppositeSide();
                    break;

                case 2:
                    var8 = var6.leftSide();
                    break;

                case 3:
                    var8 = var6.rightSide();
            }

            DirectionalBlock.setFacing(var2, var3, var4, var5, var8, true);
        }
    }

    public boolean render(IBlockAccess var1, int var2, int var3, int var4, int var5)
    {
        return RenderManager.renderRotatedLog(this, var1, var2, var3, var4, var5);
    }

    static class NamelessClass1555442305
    {
        static final int[] $SwitchMap$bunyan$api$Direction = new int[Direction.values().length];

        static
        {
            try
            {
                $SwitchMap$bunyan$api$Direction[Direction.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$api$Direction[Direction.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$api$Direction[Direction.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$api$Direction[Direction.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$api$Direction[Direction.DOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                $SwitchMap$bunyan$api$Direction[Direction.UP.ordinal()] = 6;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
