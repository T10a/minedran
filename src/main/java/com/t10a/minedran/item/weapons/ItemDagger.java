package com.t10a.minedran.item.weapons;

import com.google.common.collect.Multimap;
import com.t10a.minedran.Minedran;
import com.t10a.minedran.item.MaterialEffects;
import com.t10a.minedran.reference.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/* A short blade, ideal for concealing & sneak attacks. Note, that unless you were to stealthfully eliminate a foe, you become less capable of sneak attacking the enemy, as it is aware of you.
 * COMPLETION STATUS: 98% (Due to a bug, which prevents this from recieving Sword enchants. This will also go on weapons that do not extend Vanilla weapons/tools.)
 */
public class ItemDagger extends Item
{
    private final float attackDamage;
    private final Item.ToolMaterial material;

    public ItemDagger(Item.ToolMaterial material)
    {
        this.material = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses() / 2);
        this.setCreativeTab(Minedran.MINEDRAN_ITEMS);
        this.attackDamage = (1.0F + material.getDamageVsEntity());
        String name = "dagger";
        this.addPropertyOverride(new ResourceLocation("sneaking"), new IItemPropertyGetter()
        {
            NBTTagCompound nbt;
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                nbt = stack.getTagCompound();
                return entityIn.isSneaking() ? 1.0F : 0.0F;
            }
        });
        //It's a good idea to put the mod id in front of the unlocalised name. Otherwise, naming conflicts may arise.
        setUnlocalizedName(Reference.MOD_ID + "." + getToolMaterialName().toLowerCase() + "_" + name);
        setRegistryName(Reference.MOD_ID, getToolMaterialName().toLowerCase() + "_" + name);
    }
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        MaterialEffects.effectsOnAttack(material, target, attacker);
        if(attacker.isSneaking() &&  attacker.isInvisible())
        {
            target.attackEntityFrom(DamageSource.generic, attackDamage*4);
            attacker.removePotionEffect(MobEffects.INVISIBILITY);
            stack.damageItem(4, attacker);
            return true;
        }
        else if(attacker.isSneaking() || attacker.isInvisible())
        {
            target.attackEntityFrom(DamageSource.generic, attackDamage*2);
            attacker.removePotionEffect(MobEffects.INVISIBILITY);
            stack.damageItem(2, attacker);
            return true;
        }
        stack.damageItem(1, attacker);
        return true;
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

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }

    public String getToolMaterialName()
    {
        return this.material.toString();
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this.material.getRepairItemStack();
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }

        return multimap;
    }
}
