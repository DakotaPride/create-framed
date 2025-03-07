package net.dakotapride.createframed.compat;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.fml.ModList;

import java.util.List;

public class AlexsCavesCompatConnectedGlassBlock extends ConnectedGlassBlock {
    public AlexsCavesCompatConnectedGlassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext ctx, List<Component> pTooltip, TooltipFlag pFlag) {
        if (!ModList.get().isLoaded("alexscaves"))
            pTooltip.add(Component.translatable("text.createframed.mod_missing.alexs_caves").withStyle(ChatFormatting.RED));
    }
}
