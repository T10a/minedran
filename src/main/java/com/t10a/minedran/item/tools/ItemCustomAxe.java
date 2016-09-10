package com.t10a.minedran.item.tools;


import com.t10a.minedran.Minedran;
import com.t10a.minedran.item.MaterialEffects;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemCustomAxe extends ItemAxe
{
    private final Item.ToolMaterial material;
    public ItemCustomAxe(Item.ToolMaterial material, float damage, float speed)
    {
        super (material, damage, speed);
        setMaxStackSize(1);
        this.material = material;

        setCreativeTab(Minedran.MINEDRAN_ITEMS);
        String name = "axe";
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + getToolMaterialName().toLowerCase() + "_" + name);
        setRegistryName(Reference.MOD_ID, getToolMaterialName().toLowerCase() + "_" + name);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        MaterialEffects.effectsOnAttack(material, target, attacker);
        stack.damageItem(2, attacker);
        return true;
    }
}
