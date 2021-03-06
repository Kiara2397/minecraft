package com.craftingminegrades.mod.items;

import com.craftingminegrades.mod.Main;
import com.craftingminegrades.mod.init.ModItems;
import com.craftingminegrades.mod.util.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	
	protected int usages = 0;
	
	protected static String mode = "Swapping";
	
	public ItemBase(String name) {
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
