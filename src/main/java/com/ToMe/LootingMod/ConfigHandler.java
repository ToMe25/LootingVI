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
		//EnchantDamageLvl = config.getInt("EnchantmentDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentDamage(Sharpness, Smite and Bane of Arthropods).");
		//EnchantDamageLvl = getInt("DamageEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class DamageEnchantment(Sharpness, Smite and Bane of Arthropods).");
		getInt("DamageEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class DamageEnchantment(Sharpness, Smite and Bane of Arthropods).");
		//EnchantLootBonusLvl = config.getInt("EnchantmentLootBonusLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentLootBonus(Looting, Fortune and Luck of the Sea).");
		//EnchantLootBonusLvl = getInt("LootBonusEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class LootBonusEnchantment(Looting, Fortune and Luck of the Sea).");
		getInt("LootBonusEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class LootBonusEnchantment(Looting, Fortune and Luck of the Sea).");
		//EnchantProtectionLvl = config.getInt("EnchantmentProtectionLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentProtection(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		//EnchantProtectionLvl = getInt("ProtectionEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class ProtectionEnchantment(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		getInt("ProtectionEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class ProtectionEnchantment(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		//EnchantArrowDamageLvl = config.getInt("EnchantmentArrowDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentArrowDamage(Power).");
		//EnchantArrowDamageLvl = getInt("PowerEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class PowerEnchantment(Power).");
		getInt("PowerEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class PowerEnchantment(Power).");
		//EnchantDiggingLvl = config.getInt("EnchantmentDiggingLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentDigging(Efficiency).");
		//EnchantDiggingLvl = getInt("EfficiencyEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EfficiencyEnchantment(Efficiency).");
		getInt("EfficiencyEnchantmentLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EfficiencyEnchantment(Efficiency).");
		//EnchantDurabilityLvl = config.getInt("EnchantmentDurabilityLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentDurability(Unbreaking).");
		//EnchantDurabilityLvl = getInt("UnbreakingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class UnbreakingEnchantment(Unbreaking).");
		getInt("UnbreakingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class UnbreakingEnchantment(Unbreaking).");
		//EnchantThornsLvl = config.getInt("EnchantmentThornsLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentThorns(Thorns).");
		//EnchantThornsLvl = getInt("ThornsEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class ThornsEnchantment(Thorns).");
		getInt("ThornsEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class ThornsEnchantment(Thorns).");
		//EnchantOxygenLvl = config.getInt("EnchantmentOxygenLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentOxygen(Respiration).");
		//EnchantOxygenLvl = getInt("RespirationEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class RespirationEnchantment(Respiration).");
		getInt("RespirationEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class RespirationEnchantment(Respiration).");
		//EnchantWaterWalkerLvl = config.getInt("EnchantmentWaterWalkerLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentWaterWalker(Depth Strider).");
		//EnchantWaterWalkerLvl = getInt("DepthStriderEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class DepthStriderEnchantment(Depth Strider).");
		getInt("DepthStriderEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class DepthStriderEnchantment(Depth Strider).");
		//EnchantFrostWalkerLvl = config.getInt("EnchantmentFrostWalkerLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentFrostWalker(Frost Walker).");
		//EnchantFrostWalkerLvl = getInt("FrostWalkerEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class FrostWalkerEnchantment(Frost Walker).");
		getInt("FrostWalkerEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class FrostWalkerEnchantment(Frost Walker).");
		//EnchantKnockbackLvl = config.getInt("EnchantmentKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentKnockback(Knockback).");
		//EnchantKnockbackLvl = getInt("KnockbackEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class KnockbackEnchantment(Knockback).");
		getInt("KnockbackEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class KnockbackEnchantment(Knockback).");
		//EnchantFireAspectLvl = config.getInt("EnchantmentFireAspectLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentFireAspect(Fire Aspect).");
		//EnchantFireAspectLvl = getInt("FireAspectEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class FireAspectEnchantment(Fire Aspect).");
		getInt("FireAspectEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class FireAspectEnchantment(Fire Aspect).");
		//EnchantArrowKnockbackLvl = config.getInt("EnchantmentArrowKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentArrowKnockback(Punch).");
		//EnchantArrowKnockbackLvl = getInt("PunchEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class PunchEnchantment(Punch).");
		getInt("PunchEnchantmentLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class PunchEnchantment(Punch).");
		//EnchantFishingSpeedLvl = config.getInt("EnchantmentFishingSpeedLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentFishingSpeed(Lure).");
		//EnchantFishingSpeedLvl = getInt("LureEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class LureEnchantment(Lure).");
		getInt("LureEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class LureEnchantment(Lure).");
		//EnchantSweepingEdgeLvl = config.getInt("EnchantmentSweepingEdgeLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentSweepingEdge(Sweeping Edge).");
		//EnchantSweepingEdgeLvl = getInt("SweepingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class SweepingEnchantment(Sweeping Edge).");
		getInt("SweepingEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class SweepingEnchantment(Sweeping Edge).");
		//EnchantLoyaltyLvl = getInt("LoyaltyEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class LoyaltyEnchantment(Loyalty).");
		getInt("LoyaltyEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class LoyaltyEnchantment(Loyalty).");
		//EnchantImpalingLvl = getInt("ImpalingEnchantmentLvl", CATEGORY_GENERAL, 5, 1, 10, "The max level for the Class ImpalingEnchantment(Impaling).");
		getInt("ImpalingEnchantmentLvl", CATEGORY_GENERAL, 5, 1, 10, "The max level for the Class ImpalingEnchantment(Impaling).");
		//EnchantRiptideLvl = getInt("RiptideEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class RiptideEnchantment(Riptide).");
		getInt("RiptideEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class RiptideEnchantment(Riptide).");
		//EnchantQuickChargeLvl = getInt("QuickChargeEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class QuickChargeEnchantment(Quick Charge).");
		getInt("QuickChargeEnchantmentLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class QuickChargeEnchantment(Quick Charge).");
		//EnchantPiercingLvl = getInt("PiercingEnchantmentLvl", CATEGORY_GENERAL, 4, 1, 10, "The max level for the Class PiercingEnchantment(Piercing).");
		getInt("PiercingEnchantmentLvl", CATEGORY_GENERAL, 4, 1, 10, "The max level for the Class PiercingEnchantment(Piercing).");
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