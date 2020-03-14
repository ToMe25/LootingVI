package com.ToMe.LootingMod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
//import net.minecraft.entity.EnumCreatureType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
//import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;

public class CreeperKill extends Enchantment{

	//protected CreeperKill(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
	public CreeperKill() {
		//super(rarityIn, typeIn, slots);
		super(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
		this.setName("CreeperKill");
		//this.setRegistryName("CreeperKill");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		// TODO Auto-generated method stub
		//if(target.getClass() == net.minecraft.entity.monster.EntityCreeper.class) {
		if(target instanceof EntityCreeper && user instanceof EntityPlayer) {
			//target.isDead = true;
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) user), Float.MAX_VALUE);
		}
		super.onEntityDamaged(user, target, level);
	}
	
	public int getMinEnchantability(int enchantmentLevel) {
		//return enchantmentLevel * 9;
		return ConfigHandler.CreeperKillBaseEnchantability + (enchantmentLevel - 1) * ConfigHandler.CreeperKillEnchantabilityMultiplier;
	}
	
	public int getMaxEnchantability(int enchantmentLevel)
	{
		return this.getMinEnchantability(enchantmentLevel) + 15;
	}
	
}
