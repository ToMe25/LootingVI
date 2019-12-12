package com.ToMe.LootingMod;

//import net.minecraft.enchantment.Enchantment.Rarity;
//import net.minecraft.enchantment.EnchantmentLootBonus;
import net.minecraft.enchantment.EnchantmentType;
//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnchantmentLootBonusOW;
//import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.LootBonusEnchantment;
//import net.minecraft.init.Enchantments;
//import net.minecraft.inventory.EntityEquipmentSlot;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.inventory.EquipmentSlotType;

/**
 * This class was intended to be used for overriding the base class but is currently unused.
 */
public class LootingVI extends /*EnchantmentLootBonus*/LootBonusEnchantment {
	
	//protected LootingVI(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
	protected LootingVI(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
		super(rarityIn, typeIn, slots);
	}
	
	/*@Override
	public int getMaxLevel() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	@Override
	public boolean canApplyTogether(Enchantment ench) {
		// TODO Auto-generated method stub
		return super.canApplyTogether(ench);
	}*/
	
}
