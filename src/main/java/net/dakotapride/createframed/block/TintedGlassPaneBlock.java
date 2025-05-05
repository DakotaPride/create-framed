package net.dakotapride.createframed.block;

import com.simibubi.create.content.decoration.palettes.GlassPaneBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TintedGlassPaneBlock extends GlassPaneBlock {
    public TintedGlassPaneBlock(Properties properties) {
        super(properties);
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
