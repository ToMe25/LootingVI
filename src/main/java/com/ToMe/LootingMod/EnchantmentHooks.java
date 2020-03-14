package com.ToMe.LootingMod;

//import net.minecraft.enchantment.EnchantmentProtection;

public class EnchantmentHooks {

	public static int getDamageEnchantability(int damageType, int enchantmentLevel) {
		switch (damageType) {
		case 0:
			return ConfigHandler.SharpnessBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.SharpnessEnchantabilityMultiplier;
		case 1:
			return ConfigHandler.SmiteBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.SmiteEnchantabilityMultiplier;
		case 2:
			return ConfigHandler.BaneOfArthropodsBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.BaneOfArthropodsEnchantabilityMultiplier;
		default:
			return 0;

		}
	}

	public static int getProtectionEnchantability(int protectionType, int enchantmentLevel) {
		switch (protectionType) {
		case 0:
			return ConfigHandler.ProtectionBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.ProtectionEnchantabilityMultiplier;
		case 1:
			return ConfigHandler.FireProtectionBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.FireProtectionEnchantabilityMultiplier;
		case 2:
			return ConfigHandler.FeatherFallingBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.FeatherFallingEnchantabilityMultiplier;

		case 3:
			return ConfigHandler.BlastProtectionBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.BlastProtectionEnchantabilityMultiplier;

		case 4:
			return ConfigHandler.ProjectileProtectionBaseEnchantability
					+ (enchantmentLevel - 1) * ConfigHandler.ProjectileProtectionEnchantabilityMultiplier;
		default:
			return 0;

		}
	}

}
