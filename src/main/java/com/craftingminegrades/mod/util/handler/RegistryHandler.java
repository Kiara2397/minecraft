package com.craftingminegrades.mod.util.handler;

import com.craftingminegrades.mod.init.ModBlocks;
import com.craftingminegrades.mod.init.ModItems;
import com.craftingminegrades.mod.items.SwipperItem;
import com.craftingminegrades.mod.proxy.ClientProxy;
import com.craftingminegrades.mod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler {
	
	private static int count=0;
	
	public static String changeModeLetter;
	
	public static String getChangeModeLetter() {
		return changeModeLetter;
	}
	

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for (Block block : ModBlocks.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onEvent(KeyInputEvent event) {
		
		KeyBinding changeModeKey = ClientProxy.changeModeKey;
		changeModeLetter = changeModeKey.getDisplayName();
		
		if(changeModeKey.isPressed()) {
			if(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof SwipperItem) {
				count++;
				
				//Changing modes of SwipperItem
				int option = count%2;
				switch (option) {
				case 0:
					SwipperItem.setMode("Charging");
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Mode: Charging"));
					break;
				case 1:
					SwipperItem.setMode("Swapping");
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Mode: Swapping"));
				default:
					break;
				}		
			}
		}
	}
}