package com.craftingminegrades.mod.init;

import com.craftingminegrades.mod.fluids.TeleportingFluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
	
	//Fluids
	public static final Fluid TELEPORT_WATER = new TeleportingFluid("teleport_water", 
			new ResourceLocation("im:blocks/teleport_water_still"), new ResourceLocation("im:blocks/teleport_water_flow"));

	public static void registerFluids()
	{
		registerFluid(TELEPORT_WATER);
	}
	
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
		
}