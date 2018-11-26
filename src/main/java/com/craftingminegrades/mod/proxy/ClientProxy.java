package com.craftingminegrades.mod.proxy;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	
	public static KeyBinding changeModeKey;
	
	@Override
	public void init() {
		changeModeKey = new KeyBinding("key.item.changemode", Keyboard.KEY_M, "key.immod.item");
		ClientRegistry.registerKeyBinding(changeModeKey);
	}
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

}
