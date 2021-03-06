package com.craftingminegrades.mod;

import com.craftingminegrades.mod.creativetab.ModTab;
import com.craftingminegrades.mod.init.ModRecipes;
import com.craftingminegrades.mod.proxy.CommonProxy;
import com.craftingminegrades.mod.util.Reference;
import com.craftingminegrades.mod.world.ModWorldGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)

public class Main {
	
	@Instance
	public static Main instance;

	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs MOD_TAB = new ModTab();
	
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new ModWorldGen(),3);
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		ModRecipes.init();
		proxy.init();
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event) {
		
	}

}
