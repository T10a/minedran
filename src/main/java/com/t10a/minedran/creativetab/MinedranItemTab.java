package com.t10a.minedran.creativetab;

import com.t10a.minedran.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MinedranItemTab extends CreativeTabs
{
    public MinedranItemTab()
    {
            super("tabMinedranItem");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.longbow;
    }
}
