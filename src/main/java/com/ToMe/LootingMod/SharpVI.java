package com.ToMe.LootingMod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
/*import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.enchantment.EnumEnchantmentType;*/
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * This class was intended to be used for overriding the base class but is currently unused.
 */
public class SharpVI extends /*Enchantment*/EnchantmentDamage {

    public SharpVI(Enchantment.Rarity rarityIn, int damageTypeIn, /*EntityEquipmentSlot...*/EntityEquipmentSlot[] slots)
    {
        //super(rarityIn, EnumEnchantmentType.WEAPON, slots);
    	super(rarityIn, damageTypeIn, slots);
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    /*public int getMinEnchantability(int enchantmentLevel)
    {
        return 4 * enchantmentLevel;
    }*/

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    /*public int getMaxEnchantability(int enchantmentLevel)
    {
        return 30;
    }*/

    /**
     * Returns the maximum level that the enchantment can have.
     */
    /*public int getMaxLevel()
    {
        return 6;
    }*/

    /**
     * Calculates the additional damage that will be dealt by an item with this enchantment. This alternative to
     * calcModifierDamage is sensitive to the targets EnumCreatureAttribute.
     */
    /*public float calcDamageByCreature(int level, EnumCreatureAttribute creatureType)
    {
    	//System.err.println("This does Momently not Work :)");
    	//System.out.println("This does Momently not Work :)");
        //return Float.MAX_VALUE;
    	return 1.0F + (float)Math.max(0, 5) * 0.5F;
    }*/

    /**
     * Return the name of key in translation table of this enchantment.
     */
    /*public String getName()
    {
        return "Sharpness";
    }*/
    
    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    /*public boolean canApplyTogether(Enchantment ench)
    {
    	return !(ench instanceof SharpVI);
    }*/
    
    /**
     * Determines if this enchantment can be applied to a specific ItemStack.
     */
    /*public boolean canApply(ItemStack stack)
    {
        return stack.getItem() instanceof ItemAxe ? true : super.canApply(stack);
    }*/
}