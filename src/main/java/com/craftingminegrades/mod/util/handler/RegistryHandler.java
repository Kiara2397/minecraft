package com.craftingminegrades.mod.util.handler;

import com.craftingminegrades.mod.init.ModBlocks;
import com.craftingminegrades.mod.init.ModFluids;
import com.craftingminegrades.mod.init.ModItems;
import com.craftingminegrades.mod.items.SwipperItem;
import com.craftingminegrades.mod.proxy.ClientProxy;
import com.craftingminegrades.mod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		ModFluids.registerFluids();
		RenderHandler.registerCustomMeshesAndStates();

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onEvent(KeyInputEvent event) {
		
		KeyBinding changeModeKey = ClientProxy.keyBindings[0];
		changeModeLetter = changeModeKey.getDisplayName();
		
		KeyBinding flyKey = ClientProxy.keyBindings[1];
		
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
		
		if(flyKey.isPressed()) {
		
		//Flying in Survival Mode
			if(Minecraft.getMinecraft().playerController.getCurrentGameType()==GameType.SURVIVAL) {
			
				boolean hasItem = false;
				boolean has10Levels = false;

				ItemStack vibranium = new ItemStack(ModItems.VIBRANIUM);
				
				for(int i=0; i<InventoryPlayer.getHotbarSize(); i++) {
					if(Minecraft.getMinecraft().player.inventory.getStackInSlot(i).isItemEqual(vibranium)) {
						hasItem = true;
					}
				}
				
				if(Minecraft.getMinecraft().player.experienceLevel>=10) {
					has10Levels=true;
				}
				else {
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Flying costs 10 levels"));
				}
	
				if(hasItem && has10Levels) {
					Minecraft.getMinecraft().player.experienceLevel-=10;
					Minecraft.getMinecraft().player.capabilities.allowFlying=true;
					Minecraft.getMinecraft().player.capabilities.allowFlying=true;
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("You can fly like in Creative Mode now"));
				}
			}
		}	
	}
}