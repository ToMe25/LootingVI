package com.ToMe.LootingMod;

import java.lang.reflect.Method;

//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnumEnchantmentType;
//import net.minecraft.inventory.EntityEquipmentSlot;

import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnchantmentArrowDamage;
//import net.minecraft.enchantment.EnchantmentArrowFire;
//import net.minecraft.enchantment.EnchantmentArrowInfinite;
//import net.minecraft.enchantment.EnchantmentArrowKnockback;
//import net.minecraft.enchantment.EnchantmentDamage;
//import net.minecraft.enchantment.EnchantmentDigging;
//import net.minecraft.enchantment.EnchantmentDurability;
//import net.minecraft.enchantment.EnchantmentFireAspect;
//import net.minecraft.enchantment.EnchantmentFishingSpeed;
//import net.minecraft.enchantment.EnchantmentFrostWalker;
//import net.minecraft.enchantment.EnchantmentKnockback;
//import net.minecraft.enchantment.EnchantmentLootBonus;
//import net.minecraft.enchantment.EnchantmentMending;
//import net.minecraft.enchantment.EnchantmentOxygen;
//import net.minecraft.enchantment.EnchantmentProtection;
//import net.minecraft.enchantment.EnchantmentThorns;
//import net.minecraft.enchantment.EnchantmentUntouching;
//import net.minecraft.enchantment.EnchantmentWaterWalker;
//import net.minecraft.enchantment.EnchantmentWaterWorker;
import net.minecraft.enchantment.EnumEnchantmentType;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.event.RegistryEvent.Register;
//import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was intended to be used for overriding stuff in the Enchantment registry but is currently unused.
 */
public abstract class Registry extends Enchantment{
	
	//public static SharpVI SharpVI = new SharpVI(Enchantment.Rarity.RARE, 0, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	//public static LootingVI LootingIV = new LootingVI(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	
	protected Registry(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, typeIn, slots);
		// TODO Auto-generated constructor stub
	}
	
	public static void registerEnchantments() {
		
		//Class cls = EnchantmentDamage.class;
		//Method m;
		//try {
			
			//m = cls.getMethod("getMaxLevel", null);
			//m.setAccessible(true);
			//System.out.println(m);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		//System.out.println(m);
		/*try {
			GameRegistry.addSubstitutionAlias("minecraft:sharpness", null, LootingMod.SharpnessVI);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//REGISTRY.
		//this.underlyingIntegerMap
		//REGISTRY.register(16, new ResourceLocation("minecraft:sharpness"), LootingMod.SharpnessVI);
		//REGISTRY.putObject(new ResourceLocation("minecraft:sharpness"), LootingMod.SharpnessVI);
		//REGISTRY.putObject(new ResourceLocation("minecraft:sharpness"), LootingMod.SharpnessVI.setName("sharpness"));
        //REGISTRY.register(16, new ResourceLocation("Sharpness"), SharpVI);
		//REGISTRY.register(123, new ResourceLocation("adsdasdsasd"), SharpVI);
		//REGISTRY.register(12, new ResourceLocation("lootingIV"), LootingIV);
		//REGISTRY.putObject(new ResourceLocation("sharpness"), SharpVI);
		//ForgeRegistries.ENCHANTMENTS
		//Remove R = new Remove(0);
		
	}
	
}