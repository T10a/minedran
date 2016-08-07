package com.t10a.minedran.item.tools;

import com.google.common.collect.Sets;
import com.t10a.minedran.item.MaterialEffects;
import com.t10a.minedran.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.List;
import java.util.Set;

public class ItemScythe extends ItemTool
{
    private final Item.ToolMaterial material;
    private static final Set<Block> HARVESTABLE = Sets.newHashSet(new Block[] {Blocks.LEAVES, Blocks.LEAVES2, Blocks.WHEAT, Blocks.POTATOES, Blocks.CARROTS, Blocks.GRASS, Blocks.TALLGRASS});

    public ItemScythe(ToolMaterial material) {
        super(1.0F, -2.8F, material, HARVESTABLE);
        this.material = material;
        setMaxStackSize(1);

        setCreativeTab(CreativeTabs.TOOLS);
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + Reference.ItemBase.SCYTHE.getUnlocalizedName() + "_" + getToolMaterialName().toLowerCase());
        setRegistryName(Reference.ItemBase.SCYTHE.getRegistryName()  + "_" + getToolMaterialName().toLowerCase());
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean par4)
    {
        list.add("Chop up grass, and harvest a wide area!");
    }
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        MaterialEffects.effectsOnAttack(material, target, attacker);
        stack.damageItem(2, attacker);
        return true;
    }
}
