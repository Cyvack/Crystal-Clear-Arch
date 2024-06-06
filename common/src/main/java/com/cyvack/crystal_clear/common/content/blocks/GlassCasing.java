package com.cyvack.crystal_clear.common.content.blocks;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class GlassCasing extends CasingBlock {

	public GlassCasing(Properties p_53640_) {
		super(p_53640_);
	}

	@Override
	public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction side) {
		return ((pState.getBlock() instanceof GlassCasing) && (pAdjacentBlockState.getBlock() instanceof GlassCasing));
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
