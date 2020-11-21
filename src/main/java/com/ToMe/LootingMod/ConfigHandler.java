package com.ToMe.LootingMod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

//import net.minecraft.client.Minecraft;
//import net.minecraftforge.common.config.Configuration;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	public static final String CATEGORY_GENERAL = "general";
	
	//protected Configuration config;
	private CommentedFileConfig config;
	private ForgeConfigSpec.Builder specBuilder = new ForgeConfigSpec.Builder();
	private Map<String, ConfigValue<?>> values = new HashMap<String, ConfigValue<?>>();
	
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
	public static int EnchantLoyaltyLvl;
	public static int EnchantImpalingLvl;
	public static int EnchantRiptideLvl;
	public static int EnchantQuickChargeLvl;
	public static int EnchantPiercingLvl;
	public static int EnchantSoulSpeedLvl;
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
	public static int EnchantLoyaltyBaseEnchantability;
	public static int EnchantLoyaltyEnchantabilityMultiplier;
	public static int EnchantImpalingBaseEnchantability;
	public static int EnchantImpalingEnchantabilityMultiplier;
	public static int EnchantRiptideBaseEnchantability;
	public static int EnchantRiptideEnchantabilityMultiplier;
	public static int EnchantQuickChargeBaseEnchantability;
	public static int EnchantQuickChargeEnchantabilityMultiplier;
	public static int EnchantPiercingBaseEnchantability;
	public static int EnchantPiercingEnchantabilityMultiplier;
	public static int EnchantSoulSpeedBaseEnchantability;
	public static int EnchantSoulSpeedEnchantabilityMultiplier;
	public static int CreeperKillBaseEnchantability;
	public static int CreeperKillEnchantabilityMultiplier;
	
	public ConfigHandler(File cfgfile) {
	//public ConfigHandler(FMLPreInitializationEvent e) {
		//System.out.println(Minecraft.getMinecraft().mcDataDir);
		//File cfgfile = e.getSuggestedConfigurationFile();
		//config = new Configuration(cfgfile);
		config = CommentedFileConfig.builder(cfgfile).sync().autosave().build();
		config.load();
		InitConfig();
		ForgeConfigSpec spec = specBuilder.build();
		//ForgeConfigSpec spec = new ForgeConfigSpec.Builder().build();
		//ForgeConfigSpec spec = initConfigSpec();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, spec, config.getFile().getName());
		spec.setConfig(config);
		LoadConfig();
		//try {
            //config.load();
            //InitConfig();
        //} catch (Exception e1) {
        	//e1.printStackTrace();
        //}
       	//} finally {
       		//spec.setConfig(config);
    		//ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, spec, config.getFile().getName());
            //if (config.hasChanged()) {
                //config.save();
            //}
       	//}
	}
	
	//private ForgeConfigSpec initConfigSpec() {
		//ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		//builder.comment("The Configuration of this Mod.").push(CATEGORY_GENERAL);
		//builder.comment("Enables / Disables the CreeperKill Enchant.").define("EnableCreeperKill", true);
		//builder.comment("The max level for the Class DamageEnchantment(Sharpness, Smite and Bane of Arthropods).").defineInRange("DamageEnchantmentLvl", 6, 1, 10);
		//return builder.build();
	//}
	
	public void InitConfig() {
		//config.addCustomCategoryComment(CATEGORY_GENERAL, "The Configuration of this Mod.");
		//config.setComment(CATEGORY_GENERAL, "The Configuration of this Mod.");
		specBuilder.comment("The Configuration of this Mod.").push(CATEGORY_GENERAL).pop();
		//EnableCreeperKill = config.getBoolean("EnableCreeperKill", CATEGORY_GENERAL, true, "Enables / Disables the CreeperKill Enchant.");
		//EnableCreeperKill = getBoolean("EnableCreeperKill", CATEGORY_GENERAL, true, "Enables / Disables the CreeperKill Enchant.");
		getBoolean("EnableCreeperKill", CATEGORY_GENERAL, true, "Enables / Disables the CreeperKill Enchant.");
		//EnchantDamageLvl = config.getInt("EnchantmentDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class DamageEnchantment(Sharpness, Smite and Bane of Arthropods).");
		//EnchantDamageLvl = getInt("DamageEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class DamageEnchantment(Sharpness, Smite and Bane of Arthropods).");
		getInt("DamageEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class DamageEnchantment(Sharpness, Smite and Bane of Arthropods).");
		//EnchantLootBonusLvl = config.getInt("EnchantmentLootBonusLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class LootBonusEnchantment(Looting, Fortune and Luck of the Sea).");
		//EnchantLootBonusLvl = getInt("LootBonusEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class LootBonusEnchantment(Looting, Fortune and Luck of the Sea).");
		getInt("LootBonusEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class LootBonusEnchantment(Looting, Fortune and Luck of the Sea).");
		//EnchantProtectionLvl = config.getInt("EnchantmentProtectionLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class ProtectionEnchantment(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		//EnchantProtectionLvl = getInt("ProtectionEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class ProtectionEnchantment(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		getInt("ProtectionEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class ProtectionEnchantment(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		//EnchantArrowDamageLvl = config.getInt("EnchantmentArrowDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class PowerEnchantment(Power).");
		//EnchantArrowDamageLvl = getInt("PowerEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class PowerEnchantment(Power).");
		getInt("PowerEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class PowerEnchantment(Power).");
		//EnchantDiggingLvl = config.getInt("EnchantmentDiggingLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EfficiencyEnchantment(Efficiency).");
		//EnchantDiggingLvl = getInt("EfficiencyEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EfficiencyEnchantment(Efficiency).");
		getInt("EfficiencyEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the enchantments of class EfficiencyEnchantment(Efficiency).");
		//EnchantDurabilityLvl = config.getInt("EnchantmentDurabilityLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class UnbreakingEnchantment(Unbreaking).");
		//EnchantDurabilityLvl = getInt("UnbreakingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class UnbreakingEnchantment(Unbreaking).");
		getInt("UnbreakingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class UnbreakingEnchantment(Unbreaking).");
		//EnchantThornsLvl = config.getInt("EnchantmentThornsLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class ThornsEnchantment(Thorns).");
		//EnchantThornsLvl = getInt("ThornsEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class ThornsEnchantment(Thorns).");
		getInt("ThornsEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class ThornsEnchantment(Thorns).");
		//EnchantOxygenLvl = config.getInt("EnchantmentOxygenLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class RespirationEnchantment(Respiration).");
		//EnchantOxygenLvl = getInt("RespirationEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class RespirationEnchantment(Respiration).");
		getInt("RespirationEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class RespirationEnchantment(Respiration).");
		//EnchantWaterWalkerLvl = config.getInt("EnchantmentWaterWalkerLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class DepthStriderEnchantment(Depth Strider).");
		//EnchantWaterWalkerLvl = getInt("DepthStriderEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class DepthStriderEnchantment(Depth Strider).");
		getInt("DepthStriderEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class DepthStriderEnchantment(Depth Strider).");
		//EnchantFrostWalkerLvl = config.getInt("EnchantmentFrostWalkerLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class FrostWalkerEnchantment(Frost Walker).");
		//EnchantFrostWalkerLvl = getInt("FrostWalkerEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class FrostWalkerEnchantment(Frost Walker).");
		getInt("FrostWalkerEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class FrostWalkerEnchantment(Frost Walker).");
		//EnchantKnockbackLvl = config.getInt("EnchantmentKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class KnockbackEnchantment(Knockback).");
		//EnchantKnockbackLvl = getInt("KnockbackEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class KnockbackEnchantment(Knockback).");
		getInt("KnockbackEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class KnockbackEnchantment(Knockback).");
		//EnchantFireAspectLvl = config.getInt("EnchantmentFireAspectLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class FireAspectEnchantment(Fire Aspect).");
		//EnchantFireAspectLvl = getInt("FireAspectEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class FireAspectEnchantment(Fire Aspect).");
		getInt("FireAspectEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class FireAspectEnchantment(Fire Aspect).");
		//EnchantArrowKnockbackLvl = config.getInt("EnchantmentArrowKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class PunchEnchantment(Punch).");
		//EnchantArrowKnockbackLvl = getInt("PunchEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class PunchEnchantment(Punch).");
		getInt("PunchEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the enchantments of class PunchEnchantment(Punch).");
		//EnchantFishingSpeedLvl = config.getInt("EnchantmentFishingSpeedLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class LureEnchantment(Lure).");
		//EnchantFishingSpeedLvl = getInt("LureEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class LureEnchantment(Lure).");
		getInt("LureEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class LureEnchantment(Lure).");
		//EnchantSweepingEdgeLvl = config.getInt("EnchantSweepingEdgeLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class SweepingEdgeEnchantment(Sweeping Edge).");
		//EnchantSweepingEdgeLvl = getInt("SweepingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class SweepingEdgeEnchantment(Sweeping Edge).");
		getInt("SweepingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class SweepingEnchantment(Sweeping Edge).");
		//EnchantLoyaltyLvl = getInt("LoyaltyEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class LoyaltyEnchantment(Loyalty).");
		getInt("LoyaltyEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class LoyaltyEnchantment(Loyalty).");
		//EnchantImpalingLvl = getInt("ImpalingEnchantmentLvl", CATEGORY_GENERAL, 5, 1, 10, "The max level for the enchantments of class ImpalingEnchantment(Impaling).");
		getInt("ImpalingEnchantmentLvl", CATEGORY_GENERAL, 5, 1, 10, "The max level for the enchantments of class ImpalingEnchantment(Impaling).");
		//EnchantRiptideLvl = getInt("RiptideEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class RiptideEnchantment(Riptide).");
		getInt("RiptideEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class RiptideEnchantment(Riptide).");
		//EnchantQuickChargeLvl = getInt("QuickChargeEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class QuickChargeEnchantment(Quick Charge).");
		getInt("QuickChargeEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class QuickChargeEnchantment(Quick Charge).");
		//EnchantPiercingLvl = getInt("PiercingEnchantmentLvl", CATEGORY_GENERAL, 4, 1, 10, "The max level for the enchantments of class PiercingEnchantment(Piercing).");
		getInt("PiercingEnchantmentLvl", CATEGORY_GENERAL, 4, 1, 10, "The max level for the enchantments of class PiercingEnchantment(Piercing).");
		getInt("SoulSpeedEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the enchantments of class SoulSpeedEnchantment(Sould Speed).");
		//SharpnessBaseEnchantability = config.getInt("SharpnessBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Sharpness. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("SharpnessBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Sharpness. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//SmiteBaseEnchantability = config.getInt("SmiteBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Smite. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("SmiteBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Smite. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//BaneOfArthropodsBaseEnchantability = config.getInt("BaneOfArthropodsBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Bane of Arthropods. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("BaneOfArthropodsBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Bane of Arthropods. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//SharpnessEnchantabilityMultiplier = config.getInt("SharpnessEnchantabilityMultiplier", CATEGORY_GENERAL, 11, 0, 50, "The multiplier for the min Enchantability of Sharpness. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("SharpnessEnchantabilityMultiplier", CATEGORY_GENERAL, 11, 0, 50, "The multiplier for the min Enchantability of Sharpness. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//SmiteEnchantabilityMultiplier = config.getInt("SmiteEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Smite. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("SmiteEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Smite. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//BaneOfArthropodsEnchantabilityMultiplier = config.getInt("BaneOfArthropodsEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Bane of Arthropods. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("BaneOfArthropodsEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Bane of Arthropods. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantLootBonusBaseEnchantability = config.getInt("EnchantLootBonusBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class LootBonusEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantLootBonusBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class LootBonusEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantLootBonusEnchantabilityMultiplier = config.getInt("EnchantLootBonusEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class LootBonusEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantLootBonusEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class LootBonusEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//ProtectionBaseEnchantability = config.getInt("ProtectionBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("ProtectionBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//FireProtectionBaseEnchantability = config.getInt("FireProtectionBaseEnchantability", CATEGORY_GENERAL, 10, 0, 50, "The base value for the min Enchantability of Fire Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("FireProtectionBaseEnchantability", CATEGORY_GENERAL, 10, 0, 50, "The base value for the min Enchantability of Fire Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//FeatherFallingBaseEnchantability = config.getInt("FeatherFallingBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Feather Falling. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("FeatherFallingBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Feather Falling. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//BlastProtectionBaseEnchantability = config.getInt("BlastProtectionBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Blast Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("BlastProtectionBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of Blast Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//ProjectileProtectionBaseEnchantability = config.getInt("ProjectileProtectionBaseEnchantability", CATEGORY_GENERAL, 3, 0, 50, "The base value for the min Enchantability of Projectile Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("ProjectileProtectionBaseEnchantability", CATEGORY_GENERAL, 3, 0, 50, "The base value for the min Enchantability of Projectile Protection. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//ProtectionEnchantabilityMultiplier = config.getInt("ProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 11, 0, 50, "The multiplier for the min Enchantability of Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("ProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 11, 0, 50, "The multiplier for the min Enchantability of Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//FireProtectionEnchantabilityMultiplier = config.getInt("FireProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Fire Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("FireProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Fire Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//FeatherFallingEnchantabilityMultiplier = config.getInt("FeatherFallingEnchantabilityMultiplier", CATEGORY_GENERAL, 6, 0, 50, "The multiplier for the min Enchantability of Feather Falling. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("FeatherFallingEnchantabilityMultiplier", CATEGORY_GENERAL, 6, 0, 50, "The multiplier for the min Enchantability of Feather Falling. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//BlastProtectionEnchantabilityMultiplier = config.getInt("BlastProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Blast Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("BlastProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of Blast Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//ProjectileProtectionEnchantabilityMultiplier = config.getInt("ProjectileProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 6, 0, 50, "The multiplier for the min Enchantability of Projectile Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("ProjectileProtectionEnchantabilityMultiplier", CATEGORY_GENERAL, 6, 0, 50, "The multiplier for the min Enchantability of Projectile Protection. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantArrowDamageBaseEnchantability = config.getInt("EnchantArrowDamageBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class PowerEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantArrowDamageBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class PowerEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantArrowDamageEnchantabilityMultiplier = config.getInt("EnchantArrowDamageEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class PowerEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantArrowDamageEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class PowerEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantDiggingBaseEnchantability = config.getInt("EnchantDiggingBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EfficiencyEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantDiggingBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class EfficiencyEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantDiggingEnchantabilityMultiplier = config.getInt("EnchantDiggingEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EfficiencyEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantDiggingEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class EfficiencyEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantDurabilityBaseEnchantability = config.getInt("EnchantDurabilityBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of the class UnbreakingEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantDurabilityBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of the class UnbreakingEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantDurabilityEnchantabilityMultiplier = config.getInt("EnchantDurabilityEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of the class UnbreakingEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantDurabilityEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of the class UnbreakingEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantThornsBaseEnchantability = config.getInt("EnchantThornsBaseEnchantability", CATEGORY_GENERAL, 10, 0, 50, "The base value for the min Enchantability of the class ThornsEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantThornsBaseEnchantability", CATEGORY_GENERAL, 10, 0, 50, "The base value for the min Enchantability of the class ThornsEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantThornsEnchantabilityMultiplier = config.getInt("EnchantThornsEnchantabilityMultiplier", CATEGORY_GENERAL, 20, 0, 50, "The multiplier for the min Enchantability of the class ThornsEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantThornsEnchantabilityMultiplier", CATEGORY_GENERAL, 20, 0, 50, "The multiplier for the min Enchantability of the class ThornsEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantOxygenBaseEnchantability = config.getInt("EnchantOxygenBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class RespirationEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantOxygenBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class RespirationEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantOxygenEnchantabilityMultiplier = config.getInt("EnchantOxygenEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class RespirationEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantOxygenEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class RespirationEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantWaterWalkerBaseEnchantability = config.getInt("EnchantWaterWalkerBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class DepthStriderEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantWaterWalkerBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class DepthStriderEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantWaterWalkerEnchantabilityMultiplier = config.getInt("EnchantWaterWalkerEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class DepthStriderEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantWaterWalkerEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class DepthStriderEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantKnockbackBaseEnchantability = config.getInt("EnchantKnockbackBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class KnockbackEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantKnockbackBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class KnockbackEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantKnockbackEnchantabilityMultiplier = config.getInt("EnchantKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class KnockbackEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class KnockbackEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantFireAspectBaseEnchantability = config.getInt("EnchantFireAspectBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class FireAspectEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantFireAspectBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class FireAspectEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantFireAspectEnchantabilityMultiplier = config.getInt("EnchantFireAspectEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class FireAspectEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantFireAspectEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class FireAspectEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantArrowKnockbackBaseEnchantability = config.getInt("EnchantArrowKnockbackBaseEnchantability", CATEGORY_GENERAL, 12, 0, 50, "The base value for the min Enchantability of the class PunchEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantArrowKnockbackBaseEnchantability", CATEGORY_GENERAL, 12, 0, 50, "The base value for the min Enchantability of the class PunchEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantArrowKnockbackEnchantabilityMultiplier = config.getInt("EnchantArrowKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL, 20, 0, 50, "The multiplier for the min Enchantability of the class PunchEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantArrowKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL, 20, 0, 50, "The multiplier for the min Enchantability of the class PunchEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantFishingSpeedBaseEnchantability = config.getInt("EnchantFishingSpeedBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class LureEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantFishingSpeedBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class LureEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantFishingSpeedEnchantabilityMultiplier = config.getInt("EnchantFishingSpeedEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class LureEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantFishingSpeedEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class LureEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//EnchantSweepingEdgeBaseEnchantability = config.getInt("EnchantSweepingEdgeBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class SweepingEdgeEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantSweepingEdgeBaseEnchantability", CATEGORY_GENERAL, 15, 0, 50, "The base value for the min Enchantability of the class SweepingEdgeEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//EnchantSweepingEdgeEnchantabilityMultiplier = config.getInt("EnchantSweepingEdgeEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class SweepingEdgeEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantSweepingEdgeEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of the class SweepingEdgeEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantLoyaltyBaseEnchantability", CATEGORY_GENERAL, 5, 0, 50, "The base value for the min Enchantability of the class LoyaltyEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantLoyaltyEnchantabilityMultiplier", CATEGORY_GENERAL, 7, 0, 50, "The multiplier for the min Enchantability of the class LoyaltyEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantImpalingBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class ImpalingEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantImpalingEnchantabilityMultiplier", CATEGORY_GENERAL, 8, 0, 50, "The multiplier for the min Enchantability of the class ImpalingEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantRiptideBaseEnchantability", CATEGORY_GENERAL, 10, 0, 50, "The base value for the min Enchantability of the class RiptideEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantRiptideEnchantabilityMultiplier", CATEGORY_GENERAL, 7, 0, 50, "The multiplier for the min Enchantability of the class RiptideEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantQuickChargeBaseEnchantability", CATEGORY_GENERAL, 12, 0, 50, "The base value for the min Enchantability of the class QuickChargeEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantQuickChargeyEnchantabilityMultiplier", CATEGORY_GENERAL, 20, 0, 50, "The multiplier for the min Enchantability of the class QuickChargeEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantPiercingBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class PiercingEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantPiercingEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class PiercingEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("EnchantSoulSpeedBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of the class SoulSpeedEnchantment. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("EnchantSoulSpeedEnchantabilityMultiplier", CATEGORY_GENERAL, 10, 0, 50, "The multiplier for the min Enchantability of the class SoulSpeedEnchantment. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		//CreeperKillBaseEnchantability = config.getInt("CreeperKillBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Creeper Kill. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		getInt("CreeperKillBaseEnchantability", CATEGORY_GENERAL, 1, 0, 50, "The base value for the min Enchantability of Creeper Kill. The min Enchantability is the result of baseEnchantability(this) + (enchantmentLevel - 1) * enchantabilityMultiplier.");
		//CreeperKillEnchantabilityMultiplier = config.getInt("CreeperKillEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of Creeper Kill. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
		getInt("CreeperKillEnchantabilityMultiplier", CATEGORY_GENERAL, 9, 0, 50, "The multiplier for the min Enchantability of Creeper Kill. The min Enchantability is the result of baseEnchantability + (enchantmentLevel - 1) * enchantabilityMultiplier(this).");
	}
	
	private void LoadConfig() {
		EnableCreeperKill = getBooleanValue("EnableCreeperKill", CATEGORY_GENERAL);
		EnchantDamageLvl = getIntValue("DamageEnchantmentLvl", CATEGORY_GENERAL);
		EnchantLootBonusLvl = getIntValue("LootBonusEnchantmentLvl", CATEGORY_GENERAL);
		EnchantProtectionLvl = getIntValue("ProtectionEnchantmentLvl", CATEGORY_GENERAL);
		EnchantArrowDamageLvl = getIntValue("PowerEnchantmentLvl", CATEGORY_GENERAL);
		EnchantDiggingLvl = getIntValue("EfficiencyEnchantmentLvl", CATEGORY_GENERAL);
		EnchantDurabilityLvl = getIntValue("UnbreakingEnchantmentLvl", CATEGORY_GENERAL);
		EnchantThornsLvl = getIntValue("ThornsEnchantmentLvl", CATEGORY_GENERAL);
		EnchantOxygenLvl = getIntValue("RespirationEnchantmentLvl", CATEGORY_GENERAL);
		EnchantWaterWalkerLvl = getIntValue("DepthStriderEnchantmentLvl", CATEGORY_GENERAL);
		EnchantFrostWalkerLvl = getIntValue("FrostWalkerEnchantmentLvl", CATEGORY_GENERAL);
		EnchantKnockbackLvl = getIntValue("KnockbackEnchantmentLvl", CATEGORY_GENERAL);
		EnchantFireAspectLvl = getIntValue("FireAspectEnchantmentLvl", CATEGORY_GENERAL);
		EnchantArrowKnockbackLvl = getIntValue("PunchEnchantmentLvl", CATEGORY_GENERAL);
		EnchantFishingSpeedLvl = getIntValue("LureEnchantmentLvl", CATEGORY_GENERAL);
		EnchantSweepingEdgeLvl = getIntValue("SweepingEnchantmentLvl", CATEGORY_GENERAL);
		EnchantLoyaltyLvl = getIntValue("LoyaltyEnchantmentLvl", CATEGORY_GENERAL);
		EnchantImpalingLvl = getIntValue("ImpalingEnchantmentLvl", CATEGORY_GENERAL);
		EnchantRiptideLvl = getIntValue("RiptideEnchantmentLvl", CATEGORY_GENERAL);
		EnchantQuickChargeLvl = getIntValue("QuickChargeEnchantmentLvl", CATEGORY_GENERAL);
		EnchantPiercingLvl = getIntValue("PiercingEnchantmentLvl", CATEGORY_GENERAL);
		EnchantSoulSpeedLvl = getIntValue("SoulSpeedEnchantmentLvl", CATEGORY_GENERAL);
		SharpnessBaseEnchantability = getIntValue("SharpnessBaseEnchantability", CATEGORY_GENERAL);
		SmiteBaseEnchantability = getIntValue("SmiteBaseEnchantability", CATEGORY_GENERAL);
		BaneOfArthropodsBaseEnchantability = getIntValue("BaneOfArthropodsBaseEnchantability", CATEGORY_GENERAL);
		SharpnessEnchantabilityMultiplier = getIntValue("SharpnessEnchantabilityMultiplier", CATEGORY_GENERAL);
		SmiteEnchantabilityMultiplier = getIntValue("SmiteEnchantabilityMultiplier", CATEGORY_GENERAL);
		BaneOfArthropodsEnchantabilityMultiplier = getIntValue("BaneOfArthropodsEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantLootBonusBaseEnchantability = getIntValue("EnchantLootBonusBaseEnchantability", CATEGORY_GENERAL);
		EnchantLootBonusEnchantabilityMultiplier = getIntValue("EnchantLootBonusEnchantabilityMultiplier", CATEGORY_GENERAL);
		ProtectionBaseEnchantability = getIntValue("ProtectionBaseEnchantability", CATEGORY_GENERAL);
		FireProtectionBaseEnchantability = getIntValue("FireProtectionBaseEnchantability", CATEGORY_GENERAL);
		FeatherFallingBaseEnchantability = getIntValue("FeatherFallingBaseEnchantability", CATEGORY_GENERAL);
		BlastProtectionBaseEnchantability = getIntValue("BlastProtectionBaseEnchantability", CATEGORY_GENERAL);
		ProjectileProtectionBaseEnchantability = getIntValue("ProjectileProtectionBaseEnchantability", CATEGORY_GENERAL);
		ProtectionEnchantabilityMultiplier = getIntValue("ProtectionEnchantabilityMultiplier", CATEGORY_GENERAL);
		FireProtectionEnchantabilityMultiplier = getIntValue("FireProtectionEnchantabilityMultiplier", CATEGORY_GENERAL);
		FeatherFallingEnchantabilityMultiplier = getIntValue("FeatherFallingEnchantabilityMultiplier", CATEGORY_GENERAL);
		BlastProtectionEnchantabilityMultiplier = getIntValue("BlastProtectionEnchantabilityMultiplier", CATEGORY_GENERAL);
		ProjectileProtectionEnchantabilityMultiplier = getIntValue("ProjectileProtectionEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantArrowDamageBaseEnchantability = getIntValue("EnchantArrowDamageBaseEnchantability", CATEGORY_GENERAL);
		EnchantArrowDamageEnchantabilityMultiplier = getIntValue("EnchantArrowDamageEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantDiggingBaseEnchantability = getIntValue("EnchantDiggingBaseEnchantability", CATEGORY_GENERAL);
		EnchantDiggingEnchantabilityMultiplier = getIntValue("EnchantDiggingEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantDurabilityBaseEnchantability = getIntValue("EnchantDurabilityBaseEnchantability", CATEGORY_GENERAL);
		EnchantDurabilityEnchantabilityMultiplier = getIntValue("EnchantDurabilityEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantThornsBaseEnchantability = getIntValue("EnchantThornsBaseEnchantability", CATEGORY_GENERAL);
		EnchantThornsEnchantabilityMultiplier = getIntValue("EnchantThornsEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantOxygenBaseEnchantability = getIntValue("EnchantOxygenBaseEnchantability", CATEGORY_GENERAL);
		EnchantOxygenEnchantabilityMultiplier = getIntValue("EnchantOxygenEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantWaterWalkerBaseEnchantability = getIntValue("EnchantWaterWalkerBaseEnchantability", CATEGORY_GENERAL);
		EnchantWaterWalkerEnchantabilityMultiplier = getIntValue("EnchantWaterWalkerEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantKnockbackBaseEnchantability = getIntValue("EnchantKnockbackBaseEnchantability", CATEGORY_GENERAL);
		EnchantKnockbackEnchantabilityMultiplier = getIntValue("EnchantKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantFireAspectBaseEnchantability = getIntValue("EnchantFireAspectBaseEnchantability", CATEGORY_GENERAL);
		EnchantFireAspectEnchantabilityMultiplier = getIntValue("EnchantFireAspectEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantArrowKnockbackBaseEnchantability = getIntValue("EnchantArrowKnockbackBaseEnchantability", CATEGORY_GENERAL);
		EnchantArrowKnockbackEnchantabilityMultiplier = getIntValue("EnchantArrowKnockbackEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantFishingSpeedBaseEnchantability = getIntValue("EnchantFishingSpeedBaseEnchantability", CATEGORY_GENERAL);
		EnchantFishingSpeedEnchantabilityMultiplier = getIntValue("EnchantFishingSpeedEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantSweepingEdgeBaseEnchantability = getIntValue("EnchantSweepingEdgeBaseEnchantability", CATEGORY_GENERAL);
		EnchantSweepingEdgeEnchantabilityMultiplier = getIntValue("EnchantSweepingEdgeEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantLoyaltyBaseEnchantability = getIntValue("EnchantLoyaltyBaseEnchantability", CATEGORY_GENERAL);
		EnchantLoyaltyEnchantabilityMultiplier = getIntValue("EnchantLoyaltyEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantImpalingBaseEnchantability = getIntValue("EnchantImpalingBaseEnchantability", CATEGORY_GENERAL);
		EnchantImpalingEnchantabilityMultiplier = getIntValue("EnchantImpalingEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantRiptideBaseEnchantability = getIntValue("EnchantRiptideBaseEnchantability", CATEGORY_GENERAL);
		EnchantRiptideEnchantabilityMultiplier = getIntValue("EnchantRiptideEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantQuickChargeBaseEnchantability = getIntValue("EnchantQuickChargeBaseEnchantability", CATEGORY_GENERAL);
		EnchantQuickChargeEnchantabilityMultiplier = getIntValue("EnchantQuickChargeEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantPiercingBaseEnchantability = getIntValue("EnchantPiercingBaseEnchantability", CATEGORY_GENERAL);
		EnchantPiercingEnchantabilityMultiplier = getIntValue("EnchantPiercingEnchantabilityMultiplier", CATEGORY_GENERAL);
		EnchantSoulSpeedBaseEnchantability = getIntValue("EnchantSoulSpeedBaseEnchantability", CATEGORY_GENERAL);
		EnchantSoulSpeedEnchantabilityMultiplier = getIntValue("EnchantSoulSpeedEnchantabilityMultiplier", CATEGORY_GENERAL);
		CreeperKillBaseEnchantability = getIntValue("CreeperKillBaseEnchantability", CATEGORY_GENERAL);
		CreeperKillEnchantabilityMultiplier = getIntValue("CreeperKillEnchantabilityMultiplier", CATEGORY_GENERAL);
	}
	
	//public boolean getBoolean(String name, String category, boolean defaultValue, String comment) {
	private void getBoolean(String name, String category, boolean defaultValue, String comment) {
		String path = category + "." + name;
		BooleanValue value = specBuilder.comment(comment, "Default: " + defaultValue).define(path, defaultValue);
		values.put(path, value);
		//specBuilder.build();
		//return value.get();
		//if(!config.contains(path) || !(config.get(path) instanceof Boolean)) {
			//config.set(path, defaultValue);
		//}
		//if(comment != null) {
			//config.setComment(path, comment + String.format(" [default: %b]", defaultValue));
		//}
		//return config.get(path);
	}
	
	//public int getInt(String name, String category, int defaultValue, int min, int max, String comment) {
	private void getInt(String name, String category, int defaultValue, int min, int max, String comment) {
		String path = category + "." + name;
		IntValue value = specBuilder.comment(comment, "Default: " + defaultValue).defineInRange(path, defaultValue, min, max);
		values.put(path, value);
		//specBuilder.build();
		//ForgeConfigSpec spec = specBuilder.build();
		//spec.setConfig(config);
		//return value.get();
		//if(!config.contains(path) || !(config.get(path) instanceof Integer) || ((int)config.get(path)) < min || ((int)config.get(path)) > max) {
			//config.set(path, defaultValue);
		//}
		//if(comment != null) {
			//config.setComment(path, comment + String.format(" [range: %d ~ %d, default: %d]", min, max, defaultValue));
		//}
		//return config.get(path);
	}
	
	private boolean getBooleanValue(String name, String category) {
		String path = category + "." + name;
		if(values.containsKey(path)) {
			ConfigValue<?> value = values.get(path);
			if(value instanceof BooleanValue) {
				return ((BooleanValue) value).get();
			}
		}
		return false;
	}
	
	private int getIntValue(String name, String category) {
		String path = category + "." + name;
		if(values.containsKey(path)) {
			ConfigValue<?> value = values.get(path);
			if(value instanceof IntValue) {
				return ((IntValue) value).get();
			}
		}
		return 0;
	}
	
}