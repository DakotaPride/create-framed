package net.dakotapride.createframed.compat;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.TransparentBlock;
import net.neoforged.fml.loading.LoadingModList;

import java.util.List;

public class DyeDepotCompatTransparentBlock extends TransparentBlock {
    boolean fromDyeDepot;
    public DyeDepotCompatTransparentBlock(boolean fromDyeDepot, Properties properties) {
        super(properties);
        this.fromDyeDepot = fromDyeDepot;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext ctx, List<Component> pTooltip, TooltipFlag pFlag) {
        if (LoadingModList.get().getModFileById("dye_depot") == null && fromDyeDepot)
            pTooltip.add(Component.translatable("text.createframed.mod_missing.dye_depot").withStyle(ChatFormatting.RED));
    }
}
