package com.craftingminegrades.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.craftingminegrades.mod.blocks.BlockBase;
import com.craftingminegrades.mod.blocks.VibraniumOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Block
	public static final Block SPACE_BLOCK = new BlockBase("space_block", Material.WEB);

	//Ore Block
	public static final Block VIBRANIUM_ORE = new VibraniumOre("vibranium_ore", Material.ROCK);
	
}
