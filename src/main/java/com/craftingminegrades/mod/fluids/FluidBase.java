package com.craftingminegrades.mod.fluids;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;

public class FluidBase extends Fluid {

	protected int mapColor = 0xFFFFFFFF;
	protected float overlayAlpha = 0.2F;
	protected SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
	protected SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
	protected boolean bucketEnabled = false;


	public FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
	}


	@Override
	public FluidBase setEmptySound(SoundEvent parSound) {
		emptySound = parSound;
		return this;
	}


	@Override
	public SoundEvent getEmptySound() {
		return emptySound;
	}


	@Override
	public FluidBase setFillSound(SoundEvent parSound) {
		fillSound = parSound;
		return this;
	}


	@Override
	public SoundEvent getFillSound() {
		return fillSound;
	}


	public FluidBase setHasBucket(boolean parEnableBucket) {
		bucketEnabled = parEnableBucket;
		return this;
	}

	public boolean isBucketEnabled() {
		return bucketEnabled;
	}
}