package net.dakotapride.createframed.block;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassBlock;
import net.dakotapride.createframed.CreateFramedMod;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.LoadingModList;

import java.util.ArrayList;
import java.util.List;

public class ConnectedFramedGlassBlock extends StainedGlassBlock {
    boolean fromDyeDepot;
    public ConnectedFramedGlassBlock(boolean fromDyeDepot, DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
        this.fromDyeDepot = fromDyeDepot;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() instanceof ConnectedGlassBlock || adjacentBlockState.getBlock() instanceof ConnectedFramedGlassBlock || super.skipRendering(state, adjacentBlockState, side);
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext ctx, List<Component> pTooltip, TooltipFlag pFlag) {
        if (LoadingModList.get().getModFileById("dye_depot") == null && fromDyeDepot)
            pTooltip.add(Component.translatable("text.createframed.mod_missing.dye_depot").withStyle(ChatFormatting.RED));
    }
}
