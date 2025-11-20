package net.dakotapride.createframed.registry;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.WindowBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.createmod.catnip.lang.Lang;
import net.dakotapride.createframed.CreateFramedMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public enum CreateFramedWindows {
    COPPER(() -> CreateFramedSpriteShifts.COPPER_WINDOW, Blocks.COPPER_BLOCK, true),
    ZINC(() -> CreateFramedSpriteShifts.ZINC_WINDOW, Blocks.GLOW_LICHEN, true),
    ANDESITE_ALLOY(() -> CreateFramedSpriteShifts.ANDESITE_ALLOY_WINDOW, Blocks.ANDESITE, true),
    // I'm glad I had this, but DAMN create mod did it so much better
    //INDUSTRIAL_IRON(() -> CreateFramedSpriteShifts.INDUSTRIAL_IRON_WINDOW, Blocks.NETHERITE_BLOCK, true),
    ROSE_QUARTZ(() -> CreateFramedSpriteShifts.ROSE_QUARTZ_WINDOW, Blocks.RED_TERRACOTTA, false),
    BRASS(() -> CreateFramedSpriteShifts.BRASS_WINDOW, Blocks.YELLOW_TERRACOTTA, true),
    CARDBOARD(() -> CreateFramedSpriteShifts.CARDBOARD_WINDOW, Blocks.WHITE_TERRACOTTA, true),
    RED_CARDBOARD(() -> CreateFramedSpriteShifts.RED_CARDBOARD_WINDOW, Blocks.RED_TERRACOTTA, true),
    ORANGE_CARDBOARD(() -> CreateFramedSpriteShifts.ORANGE_CARDBOARD_WINDOW, Blocks.ORANGE_TERRACOTTA, true),
    YELLOW_CARDBOARD(() -> CreateFramedSpriteShifts.YELLOW_CARDBOARD_WINDOW, Blocks.YELLOW_TERRACOTTA, true),
    GREEN_CARDBOARD(() -> CreateFramedSpriteShifts.GREEN_CARDBOARD_WINDOW, Blocks.GREEN_TERRACOTTA, true),
    LIME_CARDBOARD(() -> CreateFramedSpriteShifts.LIME_CARDBOARD_WINDOW, Blocks.LIME_TERRACOTTA, true),
    BLUE_CARDBOARD(() -> CreateFramedSpriteShifts.BLUE_CARDBOARD_WINDOW, Blocks.BLUE_TERRACOTTA, true),
    LIGHT_BLUE_CARDBOARD(() -> CreateFramedSpriteShifts.LIGHT_BLUE_CARDBOARD_WINDOW, Blocks.LIGHT_BLUE_TERRACOTTA, true),
    CYAN_CARDBOARD(() -> CreateFramedSpriteShifts.CYAN_CARDBOARD_WINDOW, Blocks.CYAN_TERRACOTTA, true),
    PURPLE_CARDBOARD(() -> CreateFramedSpriteShifts.PURPLE_CARDBOARD_WINDOW, Blocks.PURPLE_TERRACOTTA, true),
    MAGENTA_CARDBOARD(() -> CreateFramedSpriteShifts.MAGENTA_CARDBOARD_WINDOW, Blocks.MAGENTA_TERRACOTTA, true),
    PINK_CARDBOARD(() -> CreateFramedSpriteShifts.PINK_CARDBOARD_WINDOW, Blocks.PINK_TERRACOTTA, true),
    BLACK_CARDBOARD(() -> CreateFramedSpriteShifts.BLACK_CARDBOARD_WINDOW, Blocks.BLACK_TERRACOTTA, true),
    GRAY_CARDBOARD(() -> CreateFramedSpriteShifts.GRAY_CARDBOARD_WINDOW, Blocks.GRAY_TERRACOTTA, true),
    LIGHT_GRAY_CARDBOARD(() -> CreateFramedSpriteShifts.LIGHT_GRAY_CARDBOARD_WINDOW, Blocks.LIGHT_GRAY_TERRACOTTA, true),
    WHITE_CARDBOARD(() -> CreateFramedSpriteShifts.WHITE_CARDBOARD_WINDOW, Blocks.WHITE_TERRACOTTA, true),
    BROWN_CARDBOARD(() -> CreateFramedSpriteShifts.BROWN_CARDBOARD_WINDOW, Blocks.BROWN_TERRACOTTA, true);

    private final ResourceLocation id;
    public final BlockEntry<WindowBlock> window_block;
    public final BlockEntry<ConnectedGlassPaneBlock> window_pane;

    CreateFramedWindows(Supplier<CTSpriteShiftEntry> ctshift, Block template_block, boolean cutout) {

        String name = Lang.asId(name());
        id = CreateFramedMod.asResource(name);

        if (!cutout) {
            window_block = CreateFramedBuilderTransformers.roseQuartzWindowBlock(name, () -> new HorizontalCTBehaviour(ctshift.get()), template_block);
            window_pane = CreateFramedBuilderTransformers.roseQuartzWindowPaneBlock(name, ctshift, template_block::defaultMapColor);
        } else {
            window_block = CreateFramedBuilderTransformers.windowBlock(name, () -> new HorizontalCTBehaviour(ctshift.get()), template_block);
            window_pane = CreateFramedBuilderTransformers.windowPaneBlock(name, ctshift, template_block::defaultMapColor);
        }
    }

    public BlockEntry<WindowBlock> getWindowBlock() {
        return window_block;
    }

    public BlockEntry<ConnectedGlassPaneBlock> getWindowPaneBlock() {
        return window_pane;
    }

    public static void register() {}
}
