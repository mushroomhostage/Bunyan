package bunyan.recipes;

import bunyan.Proxy;
import bunyan.blocks.BunyanBlock;
import bunyan.items.BunyanItem;
import net.minecraft.server.Block;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;

public class CraftingRecipes
{
    private static final Character[][] SYMBOLS = new Character[][] {{'#', 'A'}, {'A', '#'}};

    private static void addAxeRecipes()
    {
        String[][] var0 = new String[][] {{"##", "A#", "#A", "AA"}, {"#s", "As"}};
        ItemStack var1 = new ItemStack(Item.WOOD_AXE);
        String[] var2 = var0[0];
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0[1];
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, " s", var13[0], BunyanBlock.planks, var13[1], Block.WOOD, 's', Item.STICK});
                }
            }
        }
    }

    private static void addBedRecipes()
    {
        String[] var0 = new String[] {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"};
        ItemStack var1 = new ItemStack(Item.BED);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            Character[][] var6 = SYMBOLS;
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Character[] var9 = var6[var8];
                Proxy.addRecipe(var1, new Object[] {"www", var5, var9[0], BunyanBlock.planks, var9[1], Block.WOOD, 'w', Block.WOOL});
            }
        }
    }

    private static void addBoatRecipes()
    {
        String[][] var0 = new String[][] {{"# #", "A #", "# A", "A A"}, {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"}};
        ItemStack var1 = new ItemStack(Item.BOAT);
        String[] var2 = var0[0];
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0[1];
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, var13[0], BunyanBlock.planks, var13[1], Block.WOOD});
                }
            }
        }
    }

    private static void addBookshelfRecipes()
    {
        String[] var0 = new String[] {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"};
        ItemStack var1 = new ItemStack(Block.BOOKSHELF);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, "bbb", var9, var13[0], BunyanBlock.planks, var13[1], Block.WOOD, 'b', Item.BOOK});
                }
            }
        }
    }

    private static void addBowlRecipes()
    {
        String[][] var0 = new String[][] {{"# #", "A #", "# A", "A A"}, {" # ", " A "}};
        ItemStack var1 = new ItemStack(Item.BOWL, 4);
        String[] var2 = var0[0];
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0[1];
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, var13[0], BunyanBlock.planks, var13[1], Block.WOOD});
                }
            }
        }
    }

    private static void addChestRecipes()
    {
        String[][] var0 = new String[][] {{"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"}, {"# #", "A #", "# A", "A A"}};
        ItemStack var1 = new ItemStack(Block.CHEST);
        String[] var2 = var0[0];
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0[1];
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                String[] var10 = var0[0];
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    String var13 = var10[var12];
                    Character[][] var14 = SYMBOLS;
                    int var15 = var14.length;

                    for (int var16 = 0; var16 < var15; ++var16)
                    {
                        Character[] var17 = var14[var16];
                        Proxy.addRecipe(var1, new Object[] {var5, var9, var13, var17[0], BunyanBlock.planks, var17[1], Block.WOOD});
                    }
                }
            }
        }
    }

    private static void addDoorRecipes()
    {
        String[] var0 = new String[] {"##", "A#", "#A", "AA"};
        ItemStack var1 = new ItemStack(Item.WOOD_DOOR);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                String[] var10 = var0;
                int var11 = var0.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    String var13 = var10[var12];
                    Character[][] var14 = SYMBOLS;
                    int var15 = var14.length;

                    for (int var16 = 0; var16 < var15; ++var16)
                    {
                        Character[] var17 = var14[var16];
                        Proxy.addRecipe(var1, new Object[] {var5, var9, var13, var17[0], BunyanBlock.planks, var17[1], Block.WOOD});
                    }
                }
            }
        }
    }

    private static void addGateRecipes()
    {
        String[] var0 = new String[] {"s#s", "sAs"};
        ItemStack var1 = new ItemStack(Block.FENCE_GATE);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, var13[0], BunyanBlock.planks, var13[1], Block.WOOD, 's', Item.STICK});
                }
            }
        }
    }

    private static void addHoeRecipes()
    {
        String[] var0 = new String[] {"##", "A#", "#A", "AA"};
        ItemStack var1 = new ItemStack(Item.WOOD_HOE);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            Character[][] var6 = SYMBOLS;
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Character[] var9 = var6[var8];
                Proxy.addRecipe(var1, new Object[] {var5, " s", " s", var9[0], BunyanBlock.planks, var9[1], Block.WOOD, 's', Item.STICK});
            }
        }
    }

    private static void addJukeboxRecipes()
    {
        String[][] var0 = new String[][] {{"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"}, {"#d#", "Ad#", "#dA", "AdA"}};
        ItemStack var1 = new ItemStack(Block.NOTE_BLOCK);
        String[] var2 = var0[0];
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0[1];
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                String[] var10 = var0[0];
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    String var13 = var10[var12];
                    Character[][] var14 = SYMBOLS;
                    int var15 = var14.length;

                    for (int var16 = 0; var16 < var15; ++var16)
                    {
                        Character[] var17 = var14[var16];
                        Proxy.addRecipe(var1, new Object[] {var5, var9, var13, var17[0], BunyanBlock.planks, var17[1], Block.WOOD, 'd', Item.DIAMOND});
                    }
                }
            }
        }
    }

    private static void addLogTurnerRecipes()
    {
        ItemStack var0 = new ItemStack(BunyanItem.logTurner);
        new ItemStack(Item.STICK, 5);
        Proxy.addRecipe(var0, new Object[] {"ss", " s", "ss", 's', Item.STICK});
        Proxy.addShapelessRecipe(new ItemStack(Item.STICK, 5), new Object[] {var0});
    }

    private static void addNoteblockRecipes()
    {
        String[][] var0 = new String[][] {{"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"}, {"#r#", "Ar#", "#rA", "ArA"}};
        ItemStack var1 = new ItemStack(Block.JUKEBOX);
        String[] var2 = var0[0];
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0[1];
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                String[] var10 = var0[0];
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    String var13 = var10[var12];
                    Character[][] var14 = SYMBOLS;
                    int var15 = var14.length;

                    for (int var16 = 0; var16 < var15; ++var16)
                    {
                        Character[] var17 = var14[var16];
                        Proxy.addRecipe(var1, new Object[] {var5, var9, var13, var17[0], BunyanBlock.planks, var17[1], Block.WOOD, 'r', Item.REDSTONE});
                    }
                }
            }
        }
    }

    private static void addPickaxeRecipes()
    {
        String[] var0 = new String[] {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"};
        ItemStack var1 = new ItemStack(Item.WOOD_PICKAXE);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            Character[][] var6 = SYMBOLS;
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Character[] var9 = var6[var8];
                Proxy.addRecipe(var1, new Object[] {var5, " s ", " s ", var9[0], BunyanBlock.planks, var9[1], Block.WOOD, 's', Item.STICK});
            }
        }
    }

    private static void addPistonRecipes()
    {
        String[] var0 = new String[] {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"};
        ItemStack var1 = new ItemStack(Block.PISTON);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            Character[][] var6 = SYMBOLS;
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Character[] var9 = var6[var8];
                Proxy.addRecipe(var1, new Object[] {var5, "cic", "crc", var9[0], BunyanBlock.planks, var9[1], Block.WOOD, 'c', Block.COBBLESTONE, 'i', Item.IRON_INGOT, 'r', Item.REDSTONE});
            }
        }
    }

    private static void addPlankRecipes()
    {
        Proxy.addRecipe(new ItemStack(Block.WOOD, 4), new Object[] {"#", '#', new ItemStack(BunyanBlock.widewood, 1, 2)});
        Proxy.addRecipe(new ItemStack(Block.WOOD, 4), new Object[] {"#", '#', new ItemStack(BunyanBlock.turnableVanillaWood, 1, 0)});
        Proxy.addRecipe(new ItemStack(Block.WOOD, 4, 1), new Object[] {"#", '#', new ItemStack(BunyanBlock.turnableVanillaWood, 1, 1)});
        Proxy.addRecipe(new ItemStack(Block.WOOD, 4, 2), new Object[] {"#", '#', new ItemStack(BunyanBlock.turnableVanillaWood, 1, 2)});
        Proxy.addRecipe(new ItemStack(Block.WOOD, 4, 3), new Object[] {"#", '#', new ItemStack(BunyanBlock.turnableVanillaWood, 1, 3)});
    }

    private static void addPressurePlateRecipes()
    {
        String[] var0 = new String[] {"##", "A#", "#A", "AA"};
        ItemStack var1 = new ItemStack(Block.WOOD_PLATE);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            Character[][] var6 = SYMBOLS;
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Character[] var9 = var6[var8];
                Proxy.addRecipe(var1, new Object[] {var5, var9[0], BunyanBlock.planks, var9[1], Block.WOOD});
            }
        }
    }

    private static void addShovelRecipes()
    {
        Proxy.addRecipe(new ItemStack(Item.WOOD_SPADE), new Object[] {"#", "s", "s", '#', BunyanBlock.planks, 's', Item.STICK});
    }

    private static void addSignRecipes()
    {
        String[] var0 = new String[] {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"};
        ItemStack var1 = new ItemStack(Item.SIGN);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, " s ", var13[0], BunyanBlock.planks, var13[1], Block.WOOD, 's', Item.STICK});
                }
            }
        }
    }

    private static void addSlabRecipes()
    {
        String[] var0 = new String[] {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"};
        ItemStack var1 = new ItemStack(Block.STEP, 6, 2);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            Character[][] var6 = SYMBOLS;
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Character[] var9 = var6[var8];
                Proxy.addRecipe(var1, new Object[] {var5, var9[0], BunyanBlock.planks, var9[1], Block.WOOD});
            }
        }
    }

    private static void addSmelting()
    {
        ItemStack var0 = new ItemStack(Item.COAL, 1, 1);
        int[][] var1 = new int[][] {{BunyanBlock.wood.id, 2}, {BunyanBlock.wood.id, 1}, {BunyanBlock.widewood.id, 1}, {BunyanBlock.widewood.id, 2}, {BunyanBlock.widewood.id, 0}, {BunyanBlock.turnableVanillaWood.id, 0}, {BunyanBlock.turnableVanillaWood.id, 1}, {BunyanBlock.turnableVanillaWood.id, 2}, {BunyanBlock.turnableVanillaWood.id, 3}, {BunyanBlock.turnableCustomWood.id, 2}, {BunyanBlock.turnableCustomWood.id, 1}};
        int[][] var2 = var1;
        int var3 = var1.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            int[] var5 = var2[var4];
            Proxy.addSmelting(var5[0], var5[1], var0);
        }
    }

    private static void addStairRecipes()
    {
        String[][] var0 = new String[][] {{"  #", "  A"}, {" ##", " A#", " #A", " AA"}, {"###", "##A", "#A#", "#AA", "A##", "A#A", "AA#", "AAA"}};
        ItemStack var1 = new ItemStack(Block.WOOD_STAIRS, 4);
        String[] var2 = var0[0];
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0[1];
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                String[] var10 = var0[2];
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    String var13 = var10[var12];
                    Character[][] var14 = SYMBOLS;
                    int var15 = var14.length;

                    for (int var16 = 0; var16 < var15; ++var16)
                    {
                        Character[] var17 = var14[var16];
                        Proxy.addRecipe(var1, new Object[] {var5, var9, var13, var17[0], BunyanBlock.planks, var17[1], Block.WOOD});
                    }
                }
            }
        }
    }

    private static void addStickRecipes()
    {
        String[] var0 = new String[] {"#", "A"};
        ItemStack var1 = new ItemStack(Item.STICK, 4);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, var13[0], BunyanBlock.planks, var13[1], Block.WOOD});
                }
            }
        }
    }

    private static void addSwordRecipes()
    {
        String[] var0 = new String[] {"#", "A"};
        ItemStack var1 = new ItemStack(Item.WOOD_SWORD);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, "s", var13[0], BunyanBlock.planks, var13[1], Block.WOOD, 's', Item.STICK});
                }
            }
        }
    }

    private static void addTrapDoorRecipes()
    {
        String[] var0 = new String[] {"###", "#A#", "A#A", "A##", "##A", "#AA", "AA#", "AAA"};
        ItemStack var1 = new ItemStack(Block.TRAP_DOOR, 2);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, var13[0], BunyanBlock.planks, var13[1], Block.WOOD});
                }
            }
        }
    }

    private static void addWorkbenchRecipes()
    {
        String[] var0 = new String[] {"##", "A#", "#A", "AA"};
        ItemStack var1 = new ItemStack(Block.WORKBENCH);
        String[] var2 = var0;
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            String var5 = var2[var4];
            String[] var6 = var0;
            int var7 = var0.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                String var9 = var6[var8];
                Character[][] var10 = SYMBOLS;
                int var11 = var10.length;

                for (int var12 = 0; var12 < var11; ++var12)
                {
                    Character[] var13 = var10[var12];
                    Proxy.addRecipe(var1, new Object[] {var5, var9, var13[0], BunyanBlock.planks, var13[1], Block.WOOD});
                }
            }
        }
    }

    public static void initialize()
    {
        addAxeRecipes();
        addBedRecipes();
        addBoatRecipes();
        addBookshelfRecipes();
        addBowlRecipes();
        addChestRecipes();
        addDoorRecipes();
        addGateRecipes();
        addHoeRecipes();
        addJukeboxRecipes();
        addNoteblockRecipes();
        addPickaxeRecipes();
        addPistonRecipes();
        addPlankRecipes();
        addPressurePlateRecipes();
        addShovelRecipes();
        addSignRecipes();
        addSlabRecipes();
        addStairRecipes();
        addStickRecipes();
        addSwordRecipes();
        addTrapDoorRecipes();
        addWorkbenchRecipes();
        addLogTurnerRecipes();
        addSmelting();
    }
}
