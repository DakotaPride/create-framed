package net.dakotapride.createframed.block.behaviour;

import com.simibubi.create.content.decoration.TrapdoorCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class FramedGlassTrapdoorCTBehaviour extends TrapdoorCTBehaviour {
    CTSpriteShiftEntry spriteShift;

    public FramedGlassTrapdoorCTBehaviour(CTSpriteShiftEntry spriteShift) {
        this.spriteShift = spriteShift;
    }

    @Override
    public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {
        return spriteShift;
    }

}
