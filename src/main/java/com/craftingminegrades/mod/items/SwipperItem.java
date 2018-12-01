package com.craftingminegrades.mod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.craftingminegrades.mod.util.handler.RegistryHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class SwipperItem extends ItemBase {

	private int usages = 0;
	private static String mode = "Swapping";
	private IBlockState blockSelected = Blocks.AIR.getDefaultState();
	private String blockSelectedName = "None";


	public SwipperItem(String name) {
		super(name);
	}

	//Adds information to tooltip
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag b) {
		super.addInformation(stack, world, list, b);
		list.add(TextFormatting.DARK_PURPLE + I18n.format("This item swaps the block you're looking at for another selected block."));
		list.add(TextFormatting.DARK_PURPLE + I18n.format("The item charges with coal:"));
		list.add(TextFormatting.DARK_PURPLE + I18n.format("1 coal = + 5 usages"));
		list.add(TextFormatting.YELLOW + I18n.format("One usage per swap."));
		list.add(TextFormatting.GREEN + I18n.format("When in Swapping mode, Right-Click to swap the block you're looking at."));
		list.add(TextFormatting.GREEN + I18n.format("Shif + Right-Click to select the block you're looking at."));
		list.add(TextFormatting.RED + I18n.format("When in Charging mode, Right-Click to use one of your coals and charge the usages"));
		list.add(TextFormatting.DARK_BLUE + I18n.format("Press '"+RegistryHandler.getChangeModeLetter()+"' to change modes."));
		list.add(TextFormatting.AQUA + I18n.format("Mode: " + mode));
		list.add(TextFormatting.AQUA + I18n.format("Usages: " + usages));
		list.add(TextFormatting.AQUA + I18n.format("Block selected: " + blockSelectedName));

	}

	public static void setMode(String mode) {
		SwipperItem.mode = mode;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {		
		if(!worldIn.isRemote) {


			//Variables for search and reduction of fuel
			ItemStack fuelItem = this.findFuel(player);
			boolean hasCoal = (fuelItem.getItem() instanceof ItemCoal);

			//Selecting Block for swap
			if(player.isSneaking()) {
				blockSelected = worldIn.getBlockState(pos);
				blockSelectedName = blockSelected.getBlock().getLocalizedName();
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Block Selected: "+blockSelectedName));
			}
			
			//Modes
			if(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof SwipperItem) {
				
				//Swapping
				if(mode.equals("Swapping")) {
					
					ItemStack selBlockInInventory = new ItemStack(blockSelected.getBlock());
					if(player.inventory.hasItemStack(selBlockInInventory)) { //checks if player has selected block in inventory
						
						if(usages>0) {
							worldIn.destroyBlock(pos, true);
							worldIn.setBlockState(pos, blockSelected,1);
							
							//Searches and deletes selected item from player's inventory
							for(int i=0; i<player.inventory.getSizeInventory();i++) {
								if(player.inventory.getStackInSlot(i).isItemEqual(selBlockInInventory)){
									if(!player.inventory.getStackInSlot(i).isItemEqual(player.inventory.getStackInSlot(i+1))) { //Resolves bug: if they're two stacks of the same block type
										player.inventory.decrStackSize(i, 1);
									}
								}
							}
							
							usages--;
							
							return EnumActionResult.SUCCESS;
						} 
						else {
							Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Usage must be greater than 0. Find Coal and charge!"));
						} 
					}
					else if (blockSelectedName.equals("None")){
						Minecraft.getMinecraft().player.sendMessage(new TextComponentString("You haven't selected a block yet."));
					}
					else {
						Minecraft.getMinecraft().player.sendMessage(new TextComponentString("You're lacking " + blockSelectedName + " in inventory."));
					}
				}

				//Charging
				if(mode.equals("Charging")) {
					if(hasCoal) {
						fuelItem.shrink(1);
						if (fuelItem.isEmpty()) {
							player.inventory.deleteStack(fuelItem);
						}
						usages = usages + 5;
					}
					else {
						Minecraft.getMinecraft().player.sendMessage(new TextComponentString("You don't have any coal in your inventory"));
					}
				}
			}

		}
		return EnumActionResult.PASS;
	}

	//Checks if is fuel(coal)
	protected boolean isFuel(ItemStack stack) {
		return stack.getItem() instanceof ItemCoal;
	}

	//Finds coal
	private ItemStack findFuel(EntityPlayer player) {
		if (this.isFuel(player.getHeldItem(EnumHand.OFF_HAND))) {
			return player.getHeldItem(EnumHand.OFF_HAND);
		}
		else if (this.isFuel(player.getHeldItem(EnumHand.MAIN_HAND))) {
			return player.getHeldItem(EnumHand.MAIN_HAND);
		}
		else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isFuel(itemstack)) {
					return itemstack;
				}
			}

			return ItemStack.EMPTY;
		}
	}

}
