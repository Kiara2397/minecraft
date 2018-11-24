package com.craftingminegrades.mod.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class SwipperItem extends ItemBase {
	
	private int usages = 0;
	private String mode;
	private String blockSelected;

	public SwipperItem(String name) {
		super(name);
	}
	
	//Adds information to tooltip
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag b) {
		super.addInformation(stack, world, list, b);
		list.add(TextFormatting.DARK_PURPLE + I18n.format("This item swaps the block you're looking at for another selected block."));
		list.add(TextFormatting.DARK_PURPLE + I18n.format("The item charges with ingots:"));
		list.add(TextFormatting.DARK_PURPLE + I18n.format("Gold +10 usages"));
		list.add(TextFormatting.DARK_PURPLE + I18n.format("Iron +5 usages"));
		list.add(TextFormatting.YELLOW + I18n.format("One usage per swap."));
		list.add(TextFormatting.DARK_BLUE + I18n.format("Right-Click to swap the block you're looking at."));
		list.add(TextFormatting.DARK_BLUE + I18n.format("Shif + Right-Click to select the block you're looking at."));
		list.add(TextFormatting.DARK_BLUE + I18n.format("Press 'M' to change modes."));
		list.add(TextFormatting.AQUA + I18n.format("Mode: " + mode));
		list.add(TextFormatting.AQUA + I18n.format("Usages: " + usages));
		list.add(TextFormatting.AQUA + I18n.format("Block selected: " + blockSelected));
		
	}
	
	@Override
	public boolean canItemEditBlocks() {
		return true;
	}
	
	@Override
	public Item setMaxStackSize(int maxStackSize) {
		maxStackSize = 1;
		return super.setMaxStackSize(1);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return super.getItemBurnTime(itemStack);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}


}
