package com.craftingminegrades.mod.items.tools;

import com.craftingminegrades.mod.Main;
import com.craftingminegrades.mod.init.ModItems;
import com.craftingminegrades.mod.util.IHasModel;

import net.minecraft.item.ItemPickaxe;


public class ToolPickaxe extends ItemPickaxe implements IHasModel {
	
	public ToolPickaxe(String name, ToolMaterial material) {
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
