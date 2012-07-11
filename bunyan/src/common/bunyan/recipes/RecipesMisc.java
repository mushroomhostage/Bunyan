/**
 * Copyright (c) Scott Killen, 2012
 * 
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license
 * located in /MMPL-1.0.txt
 */

package bunyan.recipes;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import bunyan.Proxy;
import bunyan.blocks.BunyanBlock;
import bunyan.blocks.CustomLog;
import bunyan.blocks.CustomWood;
import bunyan.blocks.WideLog;

public class RecipesMisc {

	public static void addRecipes() {

		// planks
		Proxy.addRecipe(new ItemStack(Block.planks, 4),
				new Object[] {
						"#",
						Character.valueOf('#'),
						new ItemStack(BunyanBlock.widewood, 1,
								WideLog.metaOak) });

		// sticks
		Proxy.addRecipe(new ItemStack(Item.stick, 4), new Object[] {
				"#", "#", Character.valueOf('#'), BunyanBlock.planks });

		// pressure plate
		Proxy.addRecipe(new ItemStack(Block.pressurePlatePlanks),
				new Object[] { "##", Character.valueOf('#'),
						BunyanBlock.planks });

		// bowl
		Proxy.addRecipe(new ItemStack(Item.bowlEmpty),
				new Object[] { "# #", " # ", Character.valueOf('#'),
						BunyanBlock.planks });

		// slabs
		Proxy.addRecipe(new ItemStack(Block.stairSingle, 6, 2),
				new Object[] { "###", Character.valueOf('#'),
						BunyanBlock.planks });

		// boat
		Proxy.addRecipe(new ItemStack(Item.boat), new Object[] { "X X",
				"XXX", Character.valueOf('X'), BunyanBlock.planks });

		// door
		Proxy.addRecipe(new ItemStack(Item.doorWood), new Object[] {
				"##", "##", "##", Character.valueOf('#'),
				BunyanBlock.planks });

		// trapdoor
		Proxy.addRecipe(new ItemStack(Block.trapdoor, 2),
				new Object[] { "aaa", "aaa", Character.valueOf('a'),
						BunyanBlock.planks });

		// stairs
		Proxy.addRecipe(
				new ItemStack(Block.stairCompactPlanks),
				new Object[] { "  a", " aa", "aaa",
						Character.valueOf('a'), BunyanBlock.planks });

		// gate
		Proxy.addRecipe(new ItemStack(Block.fenceGate), new Object[] {
				"sas", "sas", Character.valueOf('a'),
				BunyanBlock.planks, Character.valueOf('s'), Item.stick });

		// sign
		Proxy.addRecipe(new ItemStack(Item.sign), new Object[] { "aaa",
				"aaa", " s ", Character.valueOf('a'),
				BunyanBlock.planks, Character.valueOf('s'), Item.stick });

		// bed
		Proxy.addRecipe(new ItemStack(Item.bed), new Object[] { "www",
				"aaa", Character.valueOf('a'), BunyanBlock.planks,
				Character.valueOf('w'), Block.cloth });

		// noteblock
		Proxy.addRecipe(new ItemStack(Block.music), new Object[] {
				"aaa", "asa", "aaa", Character.valueOf('a'),
				BunyanBlock.planks, Character.valueOf('s'),
				Item.redstone });

		// jukebox
		Proxy.addRecipe(
				new ItemStack(Block.jukebox),
				new Object[] { "aaa", "asa", "aaa",
						Character.valueOf('a'), BunyanBlock.planks,
						Character.valueOf('s'), Item.diamond });

		// piston
		Proxy.addRecipe(new ItemStack(Block.pistonBase), new Object[] {
				"aaa", "cic", "crc", Character.valueOf('a'),
				BunyanBlock.planks, Character.valueOf('c'),
				Block.cobblestone, Character.valueOf('i'),
				Item.ingotIron, Character.valueOf('r'), Item.redstone });

		// jukebox
		Proxy.addRecipe(new ItemStack(Block.bookShelf), new Object[] {
				"aaa", "sss", "aaa", Character.valueOf('a'),
				BunyanBlock.planks, Character.valueOf('s'), Item.book });

	}

}
