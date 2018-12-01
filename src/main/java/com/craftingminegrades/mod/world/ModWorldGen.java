package com.craftingminegrades.mod.world;

import java.util.Random;

import com.craftingminegrades.mod.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimension()==0) {
			generateOverWorld(random, chunkX, chunkZ, world, chunkGenerator,chunkProvider);
		}
	}
	
	public void generateOverWorld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		generateOre(ModBlocks.VIBRANIUM_ORE.getDefaultState(),world,random,chunkX*16,chunkZ*16,16,64,random.nextInt(7)+4,15);
	}
	
	public void generateOre(IBlockState ore, World world, Random random, int x, int z, int maxY, int minY, int size, int chances) {
		int deltaY = Math.abs(maxY - minY);
		
		for (int i=0; i<chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}

}
