package com.ToMe.LootingMod;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	public static final String CATEGORY_GENERAL = "general";
	
	protected Configuration config;
	
	public boolean EnableCreeperKill;
	//public int EnchantDamageLvl;
	public static int EnchantDamageLvl;
	//public int EnchantLootBonusLvl;
	public static int EnchantLootBonusLvl;
	//public int EnchantProtectionLvl;
	public static int EnchantProtectionLvl;
	//public int EnchantArrowDamageLvl;
	public static int EnchantArrowDamageLvl;
	//public int EnchantDiggingLvl;
	public static int EnchantDiggingLvl;
	//public int EnchantDurabilityLvl;
	public static int EnchantDurabilityLvl;
	//public int EnchantThornsLvl;
	public static int EnchantThornsLvl;
	//public int EnchantOxygenLvl;
	public static int EnchantOxygenLvl;
	//public int EnchantWaterWalkerLvl;
	public static int EnchantWaterWalkerLvl;
	//public int EnchantFrostWalkerLvl;
	public static int EnchantFrostWalkerLvl;
	//public int EnchantKnockbackLvl;
	public static int EnchantKnockbackLvl;
	//public int EnchantFireAspectLvl;
	public static int EnchantFireAspectLvl;
	//public int EnchantArrowKnockbackLvl;
	public static int EnchantArrowKnockbackLvl;
	//public int EnchantFishingSpeedLvl;
	public static int EnchantFishingSpeedLvl;
	//public int EnchantSweepingEdgeLvl;
	public static int EnchantSweepingEdgeLvl;
	public static int SharpnessBaseEnchantability;
	public static int SmiteBaseEnchantability;
	public static int BaneOfArthropodsBaseEnchantability;
	public static int SharpnessEnchantabilityMultiplier;
	public static int SmiteEnchantabilityMultiplier;
	public static int BaneOfArthropodsEnchantabilityMultiplier;
	public static int EnchantLootBonusBaseEnchantability;
	public static int EnchantLootBonusEnchantabilityMultiplier;
	public static int ProtectionBaseEnchantability;
	public static int FireProtectionBaseEnchantability;
	public static int FeatherFallingBaseEnchantability;
	public static int BlastProtectionBaseEnchantability;
	public static int ProjectileProtectionBaseEnchantability;
	public static int ProtectionEnchantabilityMultiplier;
	public static int FireProtectionEnchantabilityMultiplier;
	public static int FeatherFallingEnchantabilityMultiplier;
	public static int BlastProtectionEnchantabilityMultiplier;
	public static int ProjectileProtectionEnchantabilityMultiplier;
	public static int EnchantArrowDamageBaseEnchantability;
	public static int EnchantArrowDamageEnchantabilityMultiplier;
	public static int EnchantDiggingBaseEnchantability;
	public static int EnchantDiggingEnchantabilityMultiplier;
	public static int EnchantDurabilityBaseEnchantability;
	public static int EnchantDurabilityEnchantabilityMultiplier;
	public static int EnchantThornsBaseEnchantability;
	public static int EnchantThornsEnchantabilityMultiplier;
	public static int EnchantOxygenBaseEnchantability;
	public static int EnchantOxygenEnchantabilityMultiplier;
	public static int EnchantWaterWalkerBaseEnchantability;
	public static int EnchantWaterWalkerEnchantabilityMultiplier;
	public static int EnchantKnockbackBaseEnchantability;
	public static int EnchantKnockbackEnchantabilityMultiplier;
	public static int EnchantFireAspectBaseEnchantability;
	public static int EnchantFireAspectEnchantabilityMultiplier;
	public static int EnchantArrowKnockbackBaseEnchantability;
	public static int EnchantArrowKnockbackEnchantabilityMultiplier;
	public static int EnchantFishingSpeedBaseEnchantability;
	public static int EnchantFishingSpeedEnchantabilityMultiplier;
	public static int EnchantSweepingEdgeBaseEnchantability;
	public static int EnchantSweepingEdgeEnchantabilityMultiplier;
	public static int CreeperKillBaseEnchantability;
	public static int CreeperKillEnchantabilityMultiplier;
	
	public ConfigHandler(File cfgfile) {
	//public ConfigHandler(FMLPreInitializationEvent e) {
		//System.out.println(Minecraft.getMinecraft().mcDataDir);
		//File cfgfile = e.getSuggestedConfigurationFile();
		config = new Configuration(cfgfile);
		try {
            config.load();
            InitConfig();
        } catch (Exception e1) {
        	e1.printStackTrace();
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
	}
	
	public void InitConfig() {
		config.addCustomCategoryComment(CATEGORY_GENERAL, "The Configuration of this Mod.");
		EnableCreeperKill = config.getBoolean("EnableCreeperKill", CATEGORY_GENERAL, true, "Enables / Disables the CreeperKill Enchant.");
		EnchantDamageLvl = config.getInt("EnchantmentDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EnchantmentDamage(Sharpness, Smite and Bane of Arthropods).");
		EnchantLootBonusLvl = config.getInt("EnchantmentLootBonusLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EnchantmentLootBonus(Looting, Fortune and Luck of the Sea).");
		EnchantProtectionLvl = config.getInt("EnchantmentProtectionLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EnchantmentProtection(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		EnchantArrowDamageLvl = config.getInt("EnchantmentArrowDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EnchantmentArrowDamage(Power).");
		EnchantDiggingLvl = config.getInt("EnchantmentDiggingLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EnchantmentDigging(Efficiency).");
		EnchantDurabilityLvl = config.getInt("EnchantmentDurabilityLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class EnchantmentDurability(Unbreaking).");
		EnchantThornsLvl = config.getInt("EnchantmentThornsLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class EnchantmentThorns(Thorns).");
		EnchantOxygenLvl = config.getInt("EnchantmentOxygenLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class EnchantmentOxygen(Respiration).");
		EnchantWaterWalkerLvl = config.getInt("EnchantmentWaterWalkerLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class EnchantmentWaterWalker(Depth Strider).");
		EnchantFrostWalkerLvl = config.getInt("EnchantmentFrostWalkerLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class EnchantmentFrostWalker(Frost Walker).");
		EnchantKnockbackLvl = config.getInt("EnchantmentKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class EnchantmentKnockback(Knockback).");
		EnchantFireAspectLvl = config.getInt("EnchantmentFireAspectLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class EnchantmentFireAspect(Fire Aspect).");
		EnchantArrowKnockbackLvl = config.getInt("EnchantmentArrowKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class EnchantmentArrowKnockback(Punch).");
		EnchantFishingSpeedLvl = config.getInt("EnchantmentFishingSpeedLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class EnchantmentFishingSpeed(Lure).");
		EnchantSweepingEdgeLvl = config.getInt("EnchantSweepingEdgeLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class EnchantmentSweepingEdge(Sweeping Edge).");
		SharpnessBaseEnchantability = config.getInt("SharpnessBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Sharpness. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		SmiteBaseEnchantability = config.getInt("SmiteBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Smite. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		BaneOfArthropodsBaseEnchantability = config.getInt("BaneOfArthropodsBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Bane of Arthropods. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		SharpnessEnchantabilityMultiplier = config.getInt("SharpnessEnchantabilityMultiplier", CATEGORY_GENERAL, 11, 0, 50, "The multiplier for the min Enchantability of Sharpness. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		SmiteEnchantabilityMultiplier = config.getInt("SmiteEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Smite. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		BaneOfArthropodsEnchantabilityMultiplier = config.getInt("BaneOfArthropodsEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Bane of Arthropods. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantLootBonusBaseEnchantability = config.getInt("EnchantLootBonusBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class EnchantmentLootBonus. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantLootBonusEnchantabilityMultiplier = config.getInt("EnchantLootBonusEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentLootBonus. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		ProtectionBaseEnchantability = config.getInt("ProtectionBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		FireProtectionBaseEnchantability = config.getInt("FireProtectionBaseEnchantability", CATEGORY_GENERAL, 10, 0, 50, "The base value for the min Enchantability of Fire Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		FeatherFallingBaseEnchantability = config.getInt("FeatherFallingBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Feather Falling. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		BlastProtectionBaseEnchantability = config.getInt("BlastProtectionBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Blast Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		ProjectileProtectionBaseEnchantability = config.getInt("ProjectileProtectionBaseEnchantability", CATEGORY_GENERAL, 3, 0, 50, "The base value for the min Enchantability of Projectile Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		ProtectionEnchantabilityMultiplier = config.getInt("ProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 11, 0, 50, "The multiplier for the min Enchantability of Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		FireProtectionEnchantabilityMultiplier = config.getInt("FireProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Fire Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		FeatherFallingEnchantabilityMultiplier = config.getInt("FeatherFallingEnchantabilityMultiplier", CATEGORY_GENERAL, 6, 0, 50, "The multiplier for the min Enchantability of Feather Falling. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		BlastProtectionEnchantabilityMultiplier = config.getInt("BlastProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Blast Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		ProjectileProtectionEnchantabilityMultiplier = config.getInt("ProjectileProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 6, 0, 50, "The multiplier for the min Enchantability of Projectile Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantArrowDamageBaseEnchantability = config.getInt("EnchantArrowDamageBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EnchantmentArrowDamage. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantArrowDamageEnchantabilityMultiplier = config.getInt("EnchantArrowDamageEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentArrowDamage. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantDiggingBaseEnchantability = config.getInt("EnchantDiggingBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EnchantmentDigging. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantDiggingEnchantabilityMultiplier = config.getInt("EnchantDiggingEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentDigging. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantDurabilityBaseEnchantability = config.getInt("EnchantDurabilityBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of the class EnchantmentDurability. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantDurabilityEnchantabilityMultiplier = config.getInt("EnchantDurabilityEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentDurability. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantThornsBaseEnchantability = config.getInt("EnchantThornsBaseEnchantability", CATEGORY_GENERAL, 10, 0, 50, "The base value for the min Enchantability of the class EnchantmentThorns. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantThornsEnchantabilityMultiplier = config.getInt("EnchantThornsEnchantabilityMultiplier", CATEGORY_GENERAL, 20, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentThorns. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantOxygenBaseEnchantability = config.getInt("EnchantOxygenBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EnchantmentOxygen. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantOxygenEnchantabilityMultiplier = config.getInt("EnchantOxygenEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentOxygen. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantWaterWalkerBaseEnchantability = config.getInt("EnchantWaterWalkerBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EnchantmentWaterWalker. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantWaterWalkerEnchantabilityMultiplier = config.getInt("EnchantWaterWalkerEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentWaterWalker. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantKnockbackBaseEnchantability = config.getInt("EnchantKnockbackBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EnchantmentKnockback. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantKnockbackEnchantabilityMultiplier = config.getInt("EnchantKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentKnockback. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantFireAspectBaseEnchantability = config.getInt("EnchantFireAspectBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EnchantmentFireAspect. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantFireAspectEnchantabilityMultiplier = config.getInt("EnchantFireAspectEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentFireAspect. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantArrowKnockbackBaseEnchantability = config.getInt("EnchantArrowKnockbackBaseEnchantability", CATEGORY_GENERAL, 12, 0, 50, "The base value for the min Enchantability of the class EnchantmentArrowKnockback. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantArrowKnockbackEnchantabilityMultiplier = config.getInt("EnchantArrowKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL, 20, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentArrowKnockback. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantFishingSpeedBaseEnchantability = config.getInt("EnchantFishingSpeedBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class EnchantmentFishingSpeed. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantFishingSpeedEnchantabilityMultiplier = config.getInt("EnchantFishingSpeedEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentFishingSpeed. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		EnchantSweepingEdgeBaseEnchantability = config.getInt("EnchantSweepingEdgeBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class EnchantmentSweepingEdge. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		EnchantSweepingEdgeEnchantabilityMultiplier = config.getInt("EnchantSweepingEdgeEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class EnchantmentSweepingEdge. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		CreeperKillBaseEnchantability = config.getInt("CreeperKillBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Creeper Kill. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		CreeperKillEnchantabilityMultiplier = config.getInt("CreeperKillEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of Creeper Kill. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
	}
	
}