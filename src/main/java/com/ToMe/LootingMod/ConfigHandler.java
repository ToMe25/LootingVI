package com.ToMe.LootingMod;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	public static final String CATEGORY_GENERAL = "general";
	
	protected Configuration config;
	
	public boolean EnableCreeperKill;
	public int EnchantDamageLvl;
	public int EnchantLootBonusLvl;
	public int EnchantProtectionLvl;
	public int EnchantArrowDamageLvl;
	public int EnchantDiggingLvl;
	public int EnchantDurabilityLvl;
	public int EnchantThornsLvl;
	public int EnchantOxygenLvl;
	public int EnchantWaterWalkerLvl;
	public int EnchantFrostWalkerLvl;
	public int EnchantKnockbackLvl;
	public int EnchantFireAspectLvl;
	public int EnchantArrowKnockbackLvl;
	public int EnchantFishingSpeedLvl;
	
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
		EnchantDamageLvl = config.getInt("EnchantmentDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentDamage(Sharpness, Smite and Bane of Arthropods).");
		EnchantLootBonusLvl = config.getInt("EnchantmentLootBonusLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentLootBonus(Looting, Fortune and Luck of the Sea).");
		EnchantProtectionLvl = config.getInt("EnchantmentProtectionLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentProtection(Protection, Fire Protection, Projectile Protection, Blast Protection and Feather Falling).");
		EnchantArrowDamageLvl = config.getInt("EnchantmentArrowDamageLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentArrowDamage(Power).");
		EnchantDiggingLvl = config.getInt("EnchantmentDiggingLvl", CATEGORY_GENERAL, 6, 1, 10, "The max level for the Class EnchantmentDigging(Efficiency).");
		EnchantDurabilityLvl = config.getInt("EnchantmentDurabilityLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentDurability(Unbreaking).");
		EnchantThornsLvl = config.getInt("EnchantmentThornsLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentThorns(Thorns).");
		EnchantOxygenLvl = config.getInt("EnchantmentOxygenLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentOxygen(Respiration).");
		EnchantWaterWalkerLvl = config.getInt("EnchantmentWaterWalkerLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentWaterWalker(Depth Strider).");
		EnchantFrostWalkerLvl = config.getInt("EnchantmentFrostWalkerLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentFrostWalker(Frost Walker).");
		EnchantKnockbackLvl = config.getInt("EnchantmentKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentKnockback(Knockback).");
		EnchantFireAspectLvl = config.getInt("EnchantmentFireAspectLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentFireAspect(Fire Aspect).");
		EnchantArrowKnockbackLvl = config.getInt("EnchantmentArrowKnockbackLvl", CATEGORY_GENERAL, 2, 1, 10, "The max level for the Class EnchantmentArrowKnockback(Punch).");
		EnchantFishingSpeedLvl = config.getInt("EnchantmentFishingSpeedLvl", CATEGORY_GENERAL, 3, 1, 10, "The max level for the Class EnchantmentFishingSpeed(Lure).");
	}
	
}