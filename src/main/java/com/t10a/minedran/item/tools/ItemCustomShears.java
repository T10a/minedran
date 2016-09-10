package com.t10a.minedran.item.tools;

import com.t10a.minedran.Minedran;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;

public class ItemCustomShears extends ItemShears
{
    private final Item.ToolMaterial material;

    public ItemCustomShears(ToolMaterial material)
    {
        this.material = material;
        this.setMaxStackSize(1);
        this.setMaxDamage(material.getMaxUses() - 12);
        this.setCreativeTab(Minedran.MINEDRAN_ITEMS);
        String name = "shears";
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + getToolMaterialName().toLowerCase() + "_" + name);
        setRegistryName(Reference.MOD_ID, getToolMaterialName().toLowerCase() + "_" + name);
    }

    public String getToolMaterialName()
    {
        return this.material.toString();
    }

    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this.material.getRepairItemStack();
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }
}
