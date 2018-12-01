package com.craftingminegrades.mod.items.tools;

import com.craftingminegrades.mod.Main;
import com.craftingminegrades.mod.init.ModItems;
import com.craftingminegrades.mod.util.IHasModel;

import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel {
	
	public ToolSpade(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.MOD_TAB);

		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}
}
