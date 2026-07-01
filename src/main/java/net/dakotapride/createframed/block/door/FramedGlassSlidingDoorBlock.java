package net.dakotapride.createframed.block.door;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.fml.loading.LoadingModList;

import java.util.List;

public class FramedGlassSlidingDoorBlock extends SlidingDoorBlock {
    boolean fromDyeDepot;
    public FramedGlassSlidingDoorBlock(boolean fromDyeDepot, Properties properties) {
        super(properties, GLASS_SET_TYPE.get(), false);
        this.fromDyeDepot = fromDyeDepot;
    }

    // Only needed with full solid blocks to avoid multiple faces from being rendered, doesn't really work properly with doors.
//    @Override
//    @OnlyIn(Dist.CLIENT)
//    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
//        return adjacentBlockState.getBlock() instanceof ConnectedGlassBlock || super.skipRendering(state, adjacentBlockState, side);
//    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext ctx, List<Component> pTooltip, TooltipFlag pFlag) {
        if (LoadingModList.get().getModFileById("dye_depot") == null && fromDyeDepot)
            pTooltip.add(Component.translatable("text.createframed.mod_missing.dye_depot").withStyle(ChatFormatting.RED));
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
        return true;
    }

    @Override
    protected VoxelShape getVisualShape(BlockState p_309057_, BlockGetter p_308936_, BlockPos p_308956_, CollisionContext p_309006_) {
        return Shapes.empty();
    }

    @Override
    protected float getShadeBrightness(BlockState p_308911_, BlockGetter p_308952_, BlockPos p_308918_) {
        return 1.0F;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState p_309084_, BlockGetter p_309133_, BlockPos p_309097_) {
        return true;
    }

    @Override
    public BlockEntityType<? extends FramedGlassSlidingDoorBlockEntity> getBlockEntityType() {
        return CreateFramedEntityTypes.SLIDING_DOOR.get();
    }
}
