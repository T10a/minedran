package com.t10a.minedran.item.material;

import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTutorial extends Item
{
    public ItemTutorial()
    {
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + Reference.ItemBase.TUTORIAL.getUnlocalizedName());
        setRegistryName(Reference.ItemBase.TUTORIAL.getRegistryName());
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
