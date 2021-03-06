package com.t10a.minedran.item;

import com.t10a.minedran.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class MaterialEffects
{
    public static void effectsOnAttack(final Item.ToolMaterial material, final EntityLivingBase target, final EntityLivingBase attacker)
    {
        if (material.equals(ModItems.TUTORIAL))
        {
            if(target.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)
            {
                target.attackEntityFrom(DamageSource.magic, 5);
                target.setFire(5);
            }
        }
    }
}