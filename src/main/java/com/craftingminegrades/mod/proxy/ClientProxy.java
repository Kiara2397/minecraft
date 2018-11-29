package com.craftingminegrades.mod.proxy;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	
	public static KeyBinding[] keyBindings;
	
	@Override
	public void init() {
		
		keyBindings = new KeyBinding[2];
		
		keyBindings[0]= new KeyBinding("key.item.changemode", Keyboard.KEY_M, "key.immod.item");
		keyBindings[1]= new KeyBinding("key.survival.fly", Keyboard.KEY_GRAVE, "key.immod.item");
		
		//Register keys
		for(KeyBinding keys : keyBindings) {
		ClientRegistry.registerKeyBinding(keys);
		}
	}
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

}