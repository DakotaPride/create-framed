package net.dakotapride.createframed.block.door;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlockEntity;
import com.simibubi.create.foundation.utility.animation.LerpedFloat;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FramedGlassSlidingDoorBlockEntity extends SlidingDoorBlockEntity {
    public LerpedFloat animation;
    public FramedGlassSlidingDoorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        animation = LerpedFloat.linear()
                .startWithValue(isOpen(state) ? 1 : 0);
    }

    @Override
    public void tick() {
        boolean open = isOpen(getBlockState());
        boolean wasSettled = animation.settled();
        animation.chase(open ? 1 : 0, .15f, LerpedFloat.Chaser.LINEAR);
        animation.tickChaser();

        if (!open && !wasSettled && animation.settled() && !isVisible(getBlockState()))
            showBlockModel();

        super.tick();
    }

    @Override
    protected boolean shouldRenderSpecial(BlockState state) {
        return super.shouldRenderSpecial(state);
    }
}
