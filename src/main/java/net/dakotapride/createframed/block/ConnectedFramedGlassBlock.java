package net.dakotapride.createframed.block;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassBlock;
import net.createmod.catnip.annotations.ClientOnly;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class ConnectedFramedGlassBlock extends StainedGlassBlock {
    public ConnectedFramedGlassBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
    }

    @Override
    @ClientOnly
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() instanceof ConnectedGlassBlock || adjacentBlockState.getBlock() instanceof ConnectedFramedGlassBlock || super.skipRendering(state, adjacentBlockState, side);
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
        return true;
    }
}
