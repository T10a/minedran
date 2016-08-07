package com.t10a.minedran.item.tools;

import com.t10a.minedran.item.MaterialEffects;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemCustomShovel extends ItemSpade
{
    private final Item.ToolMaterial material;

    public ItemCustomShovel(ToolMaterial material) {
        super(material);
        this.material = material;
        setMaxStackSize(1);

        setCreativeTab(CreativeTabs.TOOLS);
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + Reference.ItemBase.MODSHOVEL.getUnlocalizedName() + "_" + getToolMaterialName().toLowerCase());
        setRegistryName(Reference.ItemBase.MODSHOVEL.getRegistryName()  + "_" + getToolMaterialName().toLowerCase());
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        MaterialEffects.effectsOnAttack(material, target, attacker);
        stack.damageItem(2, attacker);
        return true;
    }
}
