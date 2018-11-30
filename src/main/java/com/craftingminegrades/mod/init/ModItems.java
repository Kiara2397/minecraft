package com.craftingminegrades.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.craftingminegrades.mod.items.ItemBase;
import com.craftingminegrades.mod.items.SwipperItem;
import com.craftingminegrades.mod.items.armor.ArmorBase;
import com.craftingminegrades.mod.items.tools.ToolAxe;
import com.craftingminegrades.mod.items.tools.ToolBow;
import com.craftingminegrades.mod.items.tools.ToolHoe;
import com.craftingminegrades.mod.items.tools.ToolPickaxe;
import com.craftingminegrades.mod.items.tools.ToolSpade;
import com.craftingminegrades.mod.items.tools.ToolSword;
import com.craftingminegrades.mod.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//Materials
	public static final ToolMaterial MATERIAL_VIBRANIUM = EnumHelper.addToolMaterial("material_vibranium", 3, 2000, 9.0F, 5.0F, 30);
	public static final ArmorMaterial ARMOR_MATERIAL_VIBRANIUM = EnumHelper.addArmorMaterial("armor_material_vibranium", Reference.MOD_ID + ":vibranium", 15, 
			new int[] {4, 1, 7, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);

	//Items
	public static final Item VIBRANIUM = new ItemBase("vibranium");
	public static final Item AMETHYST = new ItemBase("amethyst");
	public static final Item CAP_SHIELD = new ItemBase("cap_shield");
	public static final Item SWIPPER_WAND = new SwipperItem("swipper_wand");

	//Tools
	public static final ItemSword VIBRANIUM_SWORD = new ToolSword("vibranium_sword", MATERIAL_VIBRANIUM);
	public static final ItemSpade VIBRANIUM_SHOVEL = new ToolSpade("vibranium_shovel", MATERIAL_VIBRANIUM);
	public static final ItemPickaxe VIBRANIUM_PICKAXE = new ToolPickaxe("vibranium_pickaxe", MATERIAL_VIBRANIUM);
	public static final ItemAxe VIBRANIUM_AXE = new ToolAxe("vibranium_axe", MATERIAL_VIBRANIUM);
	public static final ItemHoe VIBRANIUM_HOE = new ToolHoe("vibranium_hoe", MATERIAL_VIBRANIUM);
	public static final ItemBow VIBRANIUM_BOW = new ToolBow("vibranium_bow");
	//Armor
	public static final Item VIBRANIUM_HELMET = new ArmorBase("vibranium_helmet", ARMOR_MATERIAL_VIBRANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item VIBRANIUM_CHESTPLATE = new ArmorBase("vibranium_chestplate", ARMOR_MATERIAL_VIBRANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item VIBRANIUM_LEGGINGS = new ArmorBase("vibranium_leggings", ARMOR_MATERIAL_VIBRANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item VIBRANIUM_BOOTS = new ArmorBase("vibranium_boots", ARMOR_MATERIAL_VIBRANIUM, 1, EntityEquipmentSlot.FEET);
}
