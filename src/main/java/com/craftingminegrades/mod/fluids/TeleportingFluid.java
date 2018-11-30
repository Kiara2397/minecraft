package com.craftingminegrades.mod.fluids;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeleportingFluid extends FluidBase{

	public TeleportingFluid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
		this.setHasBucket(true);
		this.setDensity(2000);
		this.setGaseous(false);
		this.setLuminosity(9);
		this.setViscosity(4000);
	}
	
	private EnumActionResult teleporting(EntityPlayer player, World worldIn, BlockPos pos){
		if(!worldIn.isRemote) {
			if(player.isOffsetPositionInLiquid(worldIn.getTopSolidOrLiquidBlock(pos).getX(),worldIn.getTopSolidOrLiquidBlock(pos).getY(),worldIn.getTopSolidOrLiquidBlock(pos).getZ()));
				player.attemptTeleport(worldIn.getTopSolidOrLiquidBlock(pos).getX()+5,worldIn.getTopSolidOrLiquidBlock(pos).getY()+5,worldIn.getTopSolidOrLiquidBlock(pos).getZ());
				return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}
	
	public void findLiquid(EntityPlayer player, World worldIn, BlockPos pos) {
		if(!worldIn.isRemote) {
			if(this.canBePlacedInWorld()) {
				teleporting(player, worldIn, pos);
			}
		}
	}
}