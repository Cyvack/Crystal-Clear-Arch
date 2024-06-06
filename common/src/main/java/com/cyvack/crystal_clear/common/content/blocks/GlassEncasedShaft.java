package com.cyvack.crystal_clear.common.content.blocks;

import com.cyvack.crystal_clear.common.registry.CCCBlockEntities;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class GlassEncasedShaft extends EncasedShaftBlock implements EncasedBlock, IBE<KineticBlockEntity> {

    public GlassEncasedShaft(Properties properties, Supplier<Block> casing) {
        super(properties, casing);
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return CCCBlockEntities.GLASS_ENCASED_SHAFT.get();
    }

    @Override
    public boolean skipRendering(BlockState selfState, BlockState adjacentBlock, Direction side) {
        return adjacentBlock.getBlock() instanceof EncasedCogwheelBlock
                || adjacentBlock.getBlock() instanceof EncasedShaftBlock;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    @Override
    public float getShadeBrightness(BlockState p_60472_, BlockGetter p_60473_, BlockPos p_60474_) {
        return 1f;
    }
}
