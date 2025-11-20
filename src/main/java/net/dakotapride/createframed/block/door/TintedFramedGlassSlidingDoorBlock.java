package net.dakotapride.createframed.block.door;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TintedFramedGlassSlidingDoorBlock extends FramedGlassSlidingDoorBlock {
    public TintedFramedGlassSlidingDoorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getLightBlock(@NotNull BlockState state, BlockGetter getter, @NotNull BlockPos pos) {
        return state.getValue(OPEN) ? super.getLightBlock(state, getter, pos) : getter.getMaxLightLevel();
    }
}
