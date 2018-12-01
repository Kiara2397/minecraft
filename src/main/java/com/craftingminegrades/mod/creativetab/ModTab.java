package com.craftingminegrades.mod.creativetab;

import com.craftingminegrades.mod.init.ModItems;
import com.craftingminegrades.mod.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModTab extends CreativeTabs{
	
	public ModTab() 
	{
		super(0,"Mod Tab");
	}
	
	 @SideOnly(Side.CLIENT)
	@Override
	public String getTranslatedTabLabel() {
		return Reference.MOD_ID + " " + this.getTabLabel();
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModItems.VIBRANIUM);
	}

}
