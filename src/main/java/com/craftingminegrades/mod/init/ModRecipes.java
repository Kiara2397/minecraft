package com.craftingminegrades.mod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		GameRegistry.addSmelting(ModBlocks.VIBRANIUM_ORE, new ItemStack(ModItems.VIBRANIUM, 1), 2F);
	}
}