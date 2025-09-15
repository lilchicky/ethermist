package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.screen.WandforgingTableMenu;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WandforgingTable extends CraftingTableBlock {

    public static final MapCodec<WandforgingTable> CODEC = simpleCodec(WandforgingTable::new);
    private static final Component CONTAINER_TITLE = Component.translatable("block.ethermist.wandforging_table.menu");

    public WandforgingTable(Properties properties) {
        super(properties);
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider(
                (id, inventory, player) -> new WandforgingTableMenu(
                        id,
                        inventory,
                        ContainerLevelAccess.create(level, pos)
                ),
                CONTAINER_TITLE
        );
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));
            return InteractionResult.CONSUME;
        }
    }

}
