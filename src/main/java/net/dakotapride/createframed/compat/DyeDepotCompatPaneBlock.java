package net.dakotapride.createframed.compat;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.GlassPaneBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.LoadingModList;

import java.util.List;

public class DyeDepotCompatPaneBlock extends GlassPaneBlock {
    boolean fromDyeDepot;
    public DyeDepotCompatPaneBlock(boolean fromDyeDepot, Properties builder) {
        super(builder);
        this.fromDyeDepot = fromDyeDepot;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext ctx, List<Component> pTooltip, TooltipFlag pFlag) {
        if (LoadingModList.get().getModFileById("dye_depot") == null && fromDyeDepot)
            pTooltip.add(Component.translatable("text.createframed.mod_missing.dye_depot").withStyle(ChatFormatting.RED));
    }

    public static class Connected extends DyeDepotCompatPaneBlock {
        public Connected(boolean fromDyeDepot, Properties builder) {
            super(fromDyeDepot, builder);
        }

        @Override
        @OnlyIn(Dist.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            if (side.getAxis()
                    .isVertical())
                return adjacentBlockState == state;
            return super.skipRendering(state, adjacentBlockState, side);
        }
    }

}
