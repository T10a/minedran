package com.t10a.minedran.item.weapons;

import com.t10a.minedran.item.MaterialEffects;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemCustomSword extends ItemSword
{
    private final Item.ToolMaterial material;

    public ItemCustomSword(ToolMaterial material) {
        super(material);
        this.material = material;
        setMaxStackSize(1);

        setCreativeTab(CreativeTabs.COMBAT);
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + Reference.ItemBase.MODSWORD.getUnlocalizedName() + "_" + getToolMaterialName().toLowerCase());
        setRegistryName(Reference.ItemBase.MODSWORD.getRegistryName()  + "_" + getToolMaterialName().toLowerCase());
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        MaterialEffects.effectsOnAttack(material, target, attacker);
        stack.damageItem(1, attacker);
        return true;
    }
}