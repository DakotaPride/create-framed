package net.dakotapride.createframed.block;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TintedConnectedGlassBlock extends ConnectedGlassBlock {
    public TintedConnectedGlassBlock(Properties p_i48392_1_) {
        super(p_i48392_1_);
    }

    @Override
    public boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return false;
    }

    @Override
    public int getLightBlock(@NotNull BlockState state, BlockGetter getter, @NotNull BlockPos pos) {
        return getter.getMaxLightLevel();
    }
}
