package com.cyvack.crystal_clear.common.content.blocks;

import com.cyvack.crystal_clear.common.registry.CCCBlockEntities;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class GlassEncasedCogwheel extends EncasedCogwheelBlock implements EncasedBlock {
    int blockEntryHash;

    public GlassEncasedCogwheel(Properties properties, boolean large, Supplier<Block> casing) {
        super(properties, large, casing);
        blockEntryHash = casing.get().hashCode();
    }

    @Override
    public BlockEntityType<? extends SimpleKineticBlockEntity> getBlockEntityType() {
        return isLarge ? CCCBlockEntities.GLASS_ENCASED_LARGE_COG.get() : CCCBlockEntities.GLASS_ENCASED_COG.get();
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
