package com.t10a.minedran.item.weapons;

import com.google.common.collect.Sets;
import com.t10a.minedran.item.MaterialEffects;
import com.t10a.minedran.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Set;

public class ItemMace extends ItemTool
/* A shaped sphere of metal/stone/wood on a stick. While it is somewhat heavy and expensive, this club is easily capable of briefly stunning opponents with some luck.
 * COMPLETION STATUS: 100% DONE (Only thing I really need to do here now is future optimisation, and balancing (right now, this weapon sucks))
 */
{
    //Dummy set to get the tool class to shut up. Also, stops the crashing. I know, I could set a custom item like the sword.
    private static final Set<Block> MaceBlocks = Sets.newHashSet(new Block[] {Blocks.BEDROCK});
    public final Item.ToolMaterial material;

    public ItemMace(ToolMaterial material) {
        super(1.0F, -2.8F, material, MaceBlocks);
        setMaxStackSize(1);
        this.material = material;
        this.efficiencyOnProperMaterial = 0.0F;

        setCreativeTab(CreativeTabs.COMBAT);
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + Reference.ItemBase.MACE.getUnlocalizedName() + "_" + getToolMaterialName().toLowerCase());
        setRegistryName(Reference.ItemBase.MACE.getRegistryName()  + "_" + getToolMaterialName().toLowerCase());
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean par4)
    {
        list.add("Hit enemies for a chance to inflict Slowness!");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        MaterialEffects.effectsOnAttack(material, target, attacker);
        int pow=(int)(Math.random()*4+1);
        if (pow == 1)
            target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80));
        stack.damageItem(1, attacker);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }
}

