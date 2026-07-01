package net.dakotapride.createframed.compat;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.createmod.catnip.lang.Lang;
import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.block.ConnectedFramedGlassBlock;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorBlock;
import net.dakotapride.createframed.registry.CreateFramedBuilderTransformers;
import net.dakotapride.createframed.registry.CreateFramedSpriteShifts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.fml.loading.LoadingModList;

import java.util.function.Supplier;

import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

@SuppressWarnings({"unused"})
public enum DyeDepotModule {

    MAROON(() -> CreateFramedSpriteShifts.MAROON_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_MAROON_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_MAROON_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.MAROON_CARDBOARD_WINDOW),
    ROSE(() -> CreateFramedSpriteShifts.ROSE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_ROSE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_ROSE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.ROSE_CARDBOARD_WINDOW),
    CORAL(() -> CreateFramedSpriteShifts.CORAL_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_CORAL_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_CORAL_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.CORAL_CARDBOARD_WINDOW),
    GINGER(() -> CreateFramedSpriteShifts.GINGER_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_GINGER_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_GINGER_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.GINGER_CARDBOARD_WINDOW),
    TAN(() -> CreateFramedSpriteShifts.TAN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_TAN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_TAN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.TAN_CARDBOARD_WINDOW),
    OLIVE(() -> CreateFramedSpriteShifts.OLIVE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_OLIVE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_OLIVE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.OLIVE_CARDBOARD_WINDOW),
    BEIGE(() -> CreateFramedSpriteShifts.BEIGE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_BEIGE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_BEIGE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.BEIGE_CARDBOARD_WINDOW),
    AMBER(() -> CreateFramedSpriteShifts.AMBER_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_AMBER_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_AMBER_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.AMBER_CARDBOARD_WINDOW),
    FOREST(() -> CreateFramedSpriteShifts.FOREST_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_FOREST_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_FOREST_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.FOREST_CARDBOARD_WINDOW),
    VERDANT(() -> CreateFramedSpriteShifts.VERDANT_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_VERDANT_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_VERDANT_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERDANT_CARDBOARD_WINDOW),
    TEAL(() -> CreateFramedSpriteShifts.TEAL_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_TEAL_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_TEAL_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.TEAL_CARDBOARD_WINDOW),
    AQUA(() -> CreateFramedSpriteShifts.AQUA_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_AQUA_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_AQUA_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.AQUA_CARDBOARD_WINDOW),
    MINT(() -> CreateFramedSpriteShifts.MINT_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_MINT_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_MINT_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.MINT_CARDBOARD_WINDOW),
    NAVY(() -> CreateFramedSpriteShifts.NAVY_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_NAVY_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_NAVY_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.NAVY_CARDBOARD_WINDOW),
    SLATE(() -> CreateFramedSpriteShifts.SLATE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_SLATE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_SLATE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.SLATE_CARDBOARD_WINDOW),
    INDIGO(() -> CreateFramedSpriteShifts.INDIGO_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_INDIGO_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_INDIGO_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.INDIGO_CARDBOARD_WINDOW),;

    private final ResourceLocation id;
    public final BlockEntry<ConnectedFramedGlassBlock> glass_block;
    public final BlockEntry<ConnectedFramedGlassBlock> vertical_glass_block;
    public final BlockEntry<ConnectedFramedGlassBlock> horizontal_glass_block;
    public final BlockEntry<DyeDepotCompatTransparentBlock> tiled_glass;
    public final BlockEntry<DyeDepotCompatPaneBlock.Connected> glass_pane;
    public final BlockEntry<DyeDepotCompatPaneBlock.Connected> vertical_glass_pane;
    public final BlockEntry<DyeDepotCompatPaneBlock.Connected> horizontal_glass_pane;
    public final BlockEntry<DyeDepotCompatPaneBlock> tiled_glass_pane;
    public final BlockEntry<FramedGlassSlidingDoorBlock> glass_door;
    public final BlockEntry<DyeDepotCompatTrapdoorBlock> glass_trapdoor;
    public final BlockEntry<DyeDepotCompatCardboardBlock> cardboard_block;
    public final BlockEntry<DyeDepotCompatCardboardBlock> bound_cardboard_block;

    public final BlockEntry<DyeDepotCompatWindowBlock> window_block;
    public final BlockEntry<DyeDepotCompatPaneBlock.Connected> window_pane;

    DyeDepotModule(Supplier<CTSpriteShiftEntry> basic_ctshift,
                   Supplier<CTSpriteShiftEntry> vertical_ctshift,
                   Supplier<CTSpriteShiftEntry> horizontal_ctshift,
                   Supplier<CTSpriteShiftEntry> window_ctshift) {
        String name = Lang.asId(name());
        Block template_block = Blocks.GLASS;
        DyeColor dyeColour = LoadingModList.get().getModFileById("dye_depot") != null ? DyeColor.valueOf(this.name()) : DyeColor.BLACK;
        id = CreateFramedMod.asResource(name);
        glass_block = CreateFramedBuilderTransformers.colouredFramedGlass(true, name, () -> new SimpleCTBehaviour(basic_ctshift.get()), template_block, dyeColour);
        vertical_glass_block = CreateFramedBuilderTransformers.verticalColouredFramedGlass(true, name, () -> new HorizontalCTBehaviour(vertical_ctshift.get()), template_block, dyeColour);
        horizontal_glass_block = CreateFramedBuilderTransformers.horizontalColouredFramedGlass(true, name, () -> new HorizontalCTBehaviour(horizontal_ctshift.get(), basic_ctshift.get()), template_block, dyeColour);
        tiled_glass = CreateFramedBuilderTransformers.colouredTiledGlass(true, name);
        glass_pane = CreateFramedBuilderTransformers.colouredFramedGlassPane(true, name, () -> template_block, basic_ctshift);
        vertical_glass_pane = CreateFramedBuilderTransformers.verticalColouredFramedGlassPane(true, name, () -> template_block, vertical_ctshift);
        horizontal_glass_pane = CreateFramedBuilderTransformers.horizontalColouredFramedGlassPane(true, name, () -> template_block, horizontal_ctshift);
        tiled_glass_pane = CreateFramedBuilderTransformers.colouredTiledGlassPane(true, name);
        glass_door = CreateFramedBuilderTransformers.framedGlassSlidingDoor(true, name, template_block.defaultMapColor());
        glass_trapdoor = CreateFramedBuilderTransformers.framedGlassTrapdoor(true, name, template_block.defaultMapColor(), basic_ctshift.get());
        cardboard_block = REGISTRATE.block(name + "_cardboard_block", properties -> new DyeDepotCompatCardboardBlock(true, properties)).initialProperties(() -> Blocks.MUSHROOM_STEM).properties(p -> p.sound(SoundType.CHISELED_BOOKSHELF).ignitedByLava().mapColor(template_block.defaultMapColor())).item().burnTime(4000).build().register();
        bound_cardboard_block = REGISTRATE.block("bound_" + name + "_cardboard_block", properties -> new DyeDepotCompatCardboardBlock(true, properties)).initialProperties(() -> Blocks.MUSHROOM_STEM).properties(p -> p.sound(SoundType.CHISELED_BOOKSHELF).ignitedByLava().mapColor(template_block.defaultMapColor())).item().burnTime(4000).build().register();
        window_block = CreateFramedBuilderTransformers.windowBlock(true, name + "_cardboard", () -> new HorizontalCTBehaviour(window_ctshift.get()), template_block);
        window_pane = CreateFramedBuilderTransformers.windowPaneBlock(true, name + "_cardboard", window_ctshift, template_block::defaultMapColor);
    }

    public BlockEntry<ConnectedFramedGlassBlock> getGlassBlock() {
        return glass_block;
    }

    public BlockEntry<ConnectedFramedGlassBlock> getVerticalGlassBlock() {
        return vertical_glass_block;
    }

    public BlockEntry<ConnectedFramedGlassBlock> getHorizontalGlassBlock() {
        return horizontal_glass_block;
    }

    public BlockEntry<DyeDepotCompatTransparentBlock> getTiledGlassBlock() {
        return tiled_glass;
    }

    public BlockEntry<DyeDepotCompatPaneBlock.Connected> getGlassPane() {
        return glass_pane;
    }

    public BlockEntry<DyeDepotCompatPaneBlock.Connected> getVerticalGlassPane() {
        return vertical_glass_pane;
    }

    public BlockEntry<DyeDepotCompatPaneBlock.Connected> getHorizontalGlassPane() {
        return horizontal_glass_pane;
    }

    public BlockEntry<DyeDepotCompatPaneBlock> getTiledGlassPane() {
        return tiled_glass_pane;
    }

    public BlockEntry<FramedGlassSlidingDoorBlock> getGlassDoorBlock() {
        return glass_door;
    }

    public BlockEntry<DyeDepotCompatTrapdoorBlock> getGlassTrapdoorBlock() {
        return glass_trapdoor;
    }

    public BlockEntry<DyeDepotCompatCardboardBlock> getCardboardBlock() {
        return cardboard_block;
    }

    public BlockEntry<DyeDepotCompatCardboardBlock> getBoundCardboardBlock() {
        return bound_cardboard_block;
    }

    public BlockEntry<DyeDepotCompatWindowBlock> getWindowBlock() {
        return window_block;
    }

    public BlockEntry<DyeDepotCompatPaneBlock.Connected> getWindowPaneBlock() {
        return window_pane;
    }

    public static void register() {}

}
