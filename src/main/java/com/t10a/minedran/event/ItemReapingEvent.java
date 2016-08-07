package com.t10a.minedran.event;

import com.t10a.minedran.item.tools.ItemScythe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemReapingEvent
{
    @SubscribeEvent
    public void onBlockBroken(BlockEvent.BreakEvent event)
    {
        ItemStack stack = event.getPlayer().getHeldItemMainhand();
        if(stack != null && stack.getItem() instanceof ItemScythe && canHarvest(event.getState()))
        {
            World world = event.getWorld();
            EntityPlayer player = event.getPlayer();
            BlockPos basePos = event.getPos();

            int range = 2;

            for(int i = -range; i < range + 1; i++)
                for(int k = -range; k < range + 1; k++) {
                    if(i == 0 && k == 0)
                        continue;

                    BlockPos pos = basePos.add(i, 0, k);
                    IBlockState state = world.getBlockState(pos);
                    if(canHarvest(state)) {
                        Block block = state.getBlock();
                        if(block.canHarvestBlock(world, pos, player))
                            block.harvestBlock(world, player, pos, state, world.getTileEntity(pos), stack);
                        world.setBlockToAir(pos);
                        world.playEvent(2001, pos, Block.getIdFromBlock(block) + (block.getMetaFromState(state) << 12));
                    }
                }

            stack.damageItem(1, player);
        }
        else if(stack != null && stack.getItem() instanceof ItemScythe && canShear(event.getState()))
        {
            World world = event.getWorld();
            EntityPlayer player = event.getPlayer();
            BlockPos basePos = event.getPos();

            int range = 1;

            for(int i = -range; i < range + 1; i++)
                for(int k = -range; k < range + 1; k++) {
                    if(i == 0 && k == 0)
                        continue;

                    BlockPos pos = basePos.add(i, 0, k);
                    IBlockState state = world.getBlockState(pos);
                    if(canShear(state)) {
                        Block block = state.getBlock();
                        if(block.canHarvestBlock(world, pos, player))
                            block.harvestBlock(world, player, pos, state, world.getTileEntity(pos), stack);
                        world.setBlockToAir(pos);
                        world.playEvent(2001, pos, Block.getIdFromBlock(block) + (block.getMetaFromState(state) << 12));
                    }
                }

            stack.damageItem(1, player);
        }
    }

    private boolean canHarvest(IBlockState state)
    {
        return state.getBlock() instanceof BlockBush;
    }
    private boolean canShear(IBlockState state)
    {
        return state.getBlock() instanceof BlockLeaves;
    }
}
