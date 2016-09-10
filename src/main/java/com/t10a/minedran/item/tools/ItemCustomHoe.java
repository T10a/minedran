package com.t10a.minedran.item.tools;

import com.t10a.minedran.Minedran;
import com.t10a.minedran.item.MaterialEffects;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemCustomHoe extends ItemHoe
{
    private final Item.ToolMaterial material;

    public ItemCustomHoe(ToolMaterial material) {
        super(material);
        this.material = material;
        setMaxStackSize(1);

        setCreativeTab(Minedran.MINEDRAN_ITEMS);
        String name = "hoe";
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + getMaterialName().toLowerCase() + "_" + name);
        setRegistryName(Reference.MOD_ID, getMaterialName().toLowerCase() + "_" + name);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        MaterialEffects.effectsOnAttack(material, target, attacker);
        stack.damageItem(2, attacker);
        return true;
    }
}
