package com.craftingminegrades.mod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class VibraniumOre extends BlockBase {

	public VibraniumOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 2);
	}
}