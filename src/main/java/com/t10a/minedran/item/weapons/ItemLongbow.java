package com.t10a.minedran.item.weapons;

import com.t10a.minedran.Minedran;
import com.t10a.minedran.init.ModItems;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
/* A powerful bow, with bigger arms, longer string & overall more durable construction. This bow is easily capable of hitting targets at a long distance with considerable force.
 * COMPLETION: 100% (Outside of balance tweaks and inevitable bug fixes, this item is complete.)
 */
public class ItemLongbow extends ItemBow
{
    public ItemLongbow() {
        this.maxStackSize = 1;
        this.setMaxDamage(576);
        this.setCreativeTab(Minedran.MINEDRAN_ITEMS);
        String name = "longbow";
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(Reference.MOD_ID, name);
        setHasSubtypes(false);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    ItemStack itemstack = entityIn.getActiveItemStack();
                    return itemstack != null && itemstack.getItem() == ModItems.longbow ? (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {

        if (!(entityLiving instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityplayer = (EntityPlayer) entityLiving;
        boolean hasInfinateArrows = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
        ItemStack itemstack = getArrowsToShoot(entityplayer);
        int draw = getMaxItemUseDuration(stack) - timeLeft;
        draw = ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer) entityLiving, draw, itemstack != null || hasInfinateArrows);
        if (draw < 0) {
            return;
        }

        if (itemstack == null && hasInfinateArrows) {
            itemstack = new ItemStack(Items.ARROW);
        }

        if (itemstack == null) {
            return;
        }

        float drawRatio = getArrowVelocity(draw);
        if (drawRatio >= 0.1) {
            boolean arrowIsInfinite = hasInfinateArrows && itemstack.getItem() instanceof ItemArrow;
            if (!worldIn.isRemote) {
                ItemArrow itemarrow = (ItemArrow) (itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW);
                EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
                entityarrow.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, drawRatio * 4.5F, 0.25F);

                if (drawRatio == 1.0F) {
                    entityarrow.setIsCritical(true);
                }
                int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                if (powerLevel > 0) {
                    entityarrow.setDamage(entityarrow.getDamage() + (double) powerLevel * 0.5D + 0.5D);
                }
                int knockBack = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                if (knockBack > 0) {
                    entityarrow.setKnockbackStrength(knockBack);
                }
                if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                    entityarrow.setFire(100);
                }

                stack.damageItem(1, entityplayer);

                if (arrowIsInfinite) {
                    entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                }

                entityarrow.setDamage(entityarrow.getDamage());

                worldIn.spawnEntityInWorld(entityarrow);
            }

            worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL,
                    1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + drawRatio * 0.5F);

            if (!arrowIsInfinite) {
                --itemstack.stackSize;
                if (itemstack.stackSize == 0) {
                    entityplayer.inventory.deleteStack(itemstack);
                }
            }
            entityplayer.addStat(StatList.getObjectUseStats(this));
        }
    }

    private ItemStack getArrowsToShoot(EntityPlayer player) {
        if (isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
            return player.getHeldItem(EnumHand.OFF_HAND);
        } else if (isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                if (isArrow(itemstack)) {
                    return itemstack;
                }
            }
            return null;
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is
     * being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public int getItemEnchantability() {
        return 1;
    }
}
