package net.minecraft.enchantment;

import net.minecraft.inventory.EquipmentSlotType;

//import net.minecraft.init.Enchantments;
//import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentLootBonusOW extends Enchantment
{
    protected EnchantmentLootBonusOW(Enchantment.Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType... slots)
    {
        super(rarityIn, typeIn, slots);

        //if (typeIn == EnchantmentType.DIGGER)
        //{
            //this.setName("lootBonusDigger");
        //}
        //else if (typeIn == EnchantmentType.FISHING_ROD)
        //{
            //this.setName("lootBonusFishing");
        //}
        //else
        //{
            //this.setName("lootBonus");
        //}
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 15 + (enchantmentLevel - 1) * 9;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 6;
    }

    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    public boolean canApplyTogether(Enchantment ench)
    {
        return super.canApplyTogether(ench) && ench != Enchantments.SILK_TOUCH;
    }
}