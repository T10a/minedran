package com.t10a.minedran.item.material;

import com.t10a.minedran.Minedran;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMiscMaterial extends Item
{
    public ItemMiscMaterial(String name)
    {
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(Reference.MOD_ID, name);
        setCreativeTab(Minedran.MINEDRAN_ITEMS);
    }
}
