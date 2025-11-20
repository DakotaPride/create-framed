package net.dakotapride.createframed.registry;

import com.simibubi.create.content.decoration.CardboardBlock;
import com.simibubi.create.content.decoration.CardboardBlockItem;
import com.simibubi.create.content.decoration.TrainTrapdoorBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.GlassPaneBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.createmod.catnip.lang.Lang;
import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.block.*;
import net.dakotapride.createframed.block.*;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorBlock;
import net.dakotapride.createframed.block.door.TintedFramedGlassSlidingDoorBlock;
import net.dakotapride.createframed.compat.AlexsCavesModule;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

public enum CreateFramedBlocks {
    RED(() -> CreateFramedSpriteShifts.RED_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_RED_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_RED_STAINED_FRAMED_GLASS,
    Blocks.RED_STAINED_GLASS, DyeColor.RED),
    ORANGE(() -> CreateFramedSpriteShifts.ORANGE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_ORANGE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_ORANGE_STAINED_FRAMED_GLASS,
    Blocks.ORANGE_STAINED_GLASS, DyeColor.ORANGE),
    YELLOW(() -> CreateFramedSpriteShifts.YELLOW_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_YELLOW_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_YELLOW_STAINED_FRAMED_GLASS,
    Blocks.YELLOW_STAINED_GLASS, DyeColor.YELLOW),
    GREEN(() -> CreateFramedSpriteShifts.GREEN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_GREEN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_GREEN_STAINED_FRAMED_GLASS,
    Blocks.GREEN_STAINED_GLASS, DyeColor.GREEN),
    LIME(() -> CreateFramedSpriteShifts.LIME_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_LIME_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_LIME_STAINED_FRAMED_GLASS,
    Blocks.LIME_STAINED_GLASS, DyeColor.LIME),
    BLUE(() -> CreateFramedSpriteShifts.BLUE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_BLUE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_BLUE_STAINED_FRAMED_GLASS,
    Blocks.BLUE_STAINED_GLASS, DyeColor.BLUE),
    LIGHT_BLUE(() -> CreateFramedSpriteShifts.LIGHT_BLUE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_LIGHT_BLUE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_LIGHT_BLUE_STAINED_FRAMED_GLASS,
    Blocks.LIGHT_BLUE_STAINED_GLASS, DyeColor.LIGHT_BLUE),
    CYAN(() -> CreateFramedSpriteShifts.CYAN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_CYAN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_CYAN_STAINED_FRAMED_GLASS,
    Blocks.CYAN_STAINED_GLASS, DyeColor.CYAN),
    PURPLE(() -> CreateFramedSpriteShifts.PURPLE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_PURPLE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_PURPLE_STAINED_FRAMED_GLASS,
    Blocks.PURPLE_STAINED_GLASS, DyeColor.PURPLE),
    MAGENTA(() -> CreateFramedSpriteShifts.MAGENTA_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_MAGENTA_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_MAGENTA_STAINED_FRAMED_GLASS,
    Blocks.MAGENTA_STAINED_GLASS, DyeColor.MAGENTA),
    PINK(() -> CreateFramedSpriteShifts.PINK_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_PINK_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_PINK_STAINED_FRAMED_GLASS,
    Blocks.PINK_STAINED_GLASS, DyeColor.PINK),
    BLACK(() -> CreateFramedSpriteShifts.BLACK_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_BLACK_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_BLACK_STAINED_FRAMED_GLASS,
    Blocks.BLACK_STAINED_GLASS, DyeColor.BLACK),
    GRAY(() -> CreateFramedSpriteShifts.GRAY_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_GRAY_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_GRAY_STAINED_FRAMED_GLASS,
    Blocks.GRAY_STAINED_GLASS, DyeColor.GRAY),
    LIGHT_GRAY(() -> CreateFramedSpriteShifts.LIGHT_GRAY_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_LIGHT_GRAY_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_LIGHT_GRAY_STAINED_FRAMED_GLASS,
    Blocks.LIGHT_GRAY_STAINED_GLASS, DyeColor.LIGHT_GRAY),
    WHITE(() -> CreateFramedSpriteShifts.WHITE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_WHITE_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_WHITE_STAINED_FRAMED_GLASS,
    Blocks.WHITE_STAINED_GLASS, DyeColor.WHITE),
    BROWN(() -> CreateFramedSpriteShifts.BROWN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.VERTICAL_BROWN_STAINED_FRAMED_GLASS,
            () -> CreateFramedSpriteShifts.HORIZONTAL_BROWN_STAINED_FRAMED_GLASS,
    Blocks.BROWN_STAINED_GLASS, DyeColor.BROWN),
    TINTED();

    private final ResourceLocation id;
    public BlockEntry<ConnectedFramedGlassBlock> glass_block;
    public BlockEntry<ConnectedFramedGlassBlock> vertical_glass_block;
    public BlockEntry<ConnectedFramedGlassBlock> horizontal_glass_block;
    public BlockEntry<GlassBlock> tiled_glass;
    public BlockEntry<ConnectedGlassPaneBlock> glass_pane;
    public BlockEntry<ConnectedGlassPaneBlock> vertical_glass_pane;
    public BlockEntry<ConnectedGlassPaneBlock> horizontal_glass_pane;
    public BlockEntry<GlassPaneBlock> tiled_glass_pane;
    public BlockEntry<FramedGlassSlidingDoorBlock> glass_door;
    public BlockEntry<TrainTrapdoorBlock> glass_trapdoor;
    public BlockEntry<CardboardBlock> cardboard_block;
    public BlockEntry<CardboardBlock> bound_cardboard_block;

    public static final List<Supplier<Item>> FUEL_ITEMS = new ArrayList<>();

    CreateFramedBlocks(Supplier<CTSpriteShiftEntry> basic_ctshift,
                       Supplier<CTSpriteShiftEntry> vertical_ctshift,
                       Supplier<CTSpriteShiftEntry> horizontal_ctshift,
                       Block template_block, DyeColor dyeColour) {

        String name = Lang.asId(name());
        id = CreateFramedMod.asResource(name);
        glass_block = CreateFramedBuilderTransformers.colouredFramedGlass(name, () -> new SimpleCTBehaviour(basic_ctshift.get()), template_block, dyeColour);
        vertical_glass_block = CreateFramedBuilderTransformers.verticalColouredFramedGlass(name, () -> new HorizontalCTBehaviour(vertical_ctshift.get()), template_block, dyeColour);
        horizontal_glass_block = CreateFramedBuilderTransformers.horizontalColouredFramedGlass(name, () -> new HorizontalCTBehaviour(horizontal_ctshift.get(), basic_ctshift.get()), template_block, dyeColour);
        tiled_glass = CreateFramedBuilderTransformers.colouredTiledGlass(name);
        glass_pane = CreateFramedBuilderTransformers.colouredFramedGlassPane(name, () -> template_block, basic_ctshift);
        vertical_glass_pane = CreateFramedBuilderTransformers.verticalColouredFramedGlassPane(name, () -> template_block, vertical_ctshift);
        horizontal_glass_pane = CreateFramedBuilderTransformers.horizontalColouredFramedGlassPane(name, () -> template_block, horizontal_ctshift);
        tiled_glass_pane = CreateFramedBuilderTransformers.colouredTiledGlassPane(name);
        glass_door = CreateFramedBuilderTransformers.framedGlassSlidingDoor(name, template_block.defaultMapColor());
        glass_trapdoor = CreateFramedBuilderTransformers.framedGlassTrapdoor(name, template_block.defaultMapColor(), basic_ctshift.get());

        cardboard_block = REGISTRATE.block(name + "_cardboard_block", CardboardBlock::new).initialProperties(() -> Blocks.MUSHROOM_STEM).properties(p -> p.sound(SoundType.CHISELED_BOOKSHELF).ignitedByLava().mapColor(template_block.defaultMapColor())).item(CardboardBlockItem::new).build().register();
        bound_cardboard_block = REGISTRATE.block("bound_" + name + "_cardboard_block", CardboardBlock::new).initialProperties(() -> Blocks.MUSHROOM_STEM).properties(p -> p.sound(SoundType.CHISELED_BOOKSHELF).ignitedByLava().mapColor(template_block.defaultMapColor())).item(CardboardBlockItem::new).build().register();
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

    public BlockEntry<GlassBlock> getTiledGlassBlock() {
        return tiled_glass;
    }

    public BlockEntry<ConnectedGlassPaneBlock> getGlassPane() {
        return glass_pane;
    }

    public BlockEntry<ConnectedGlassPaneBlock> getVerticalGlassPane() {
        return vertical_glass_pane;
    }

    public BlockEntry<ConnectedGlassPaneBlock> getHorizontalGlassPane() {
        return horizontal_glass_pane;
    }

    public BlockEntry<GlassPaneBlock> getTiledGlassPane() {
        return tiled_glass_pane;
    }

    public BlockEntry<FramedGlassSlidingDoorBlock> getGlassDoorBlock() {
        return glass_door;
    }

    public BlockEntry<TrainTrapdoorBlock> getGlassTrapdoorBlock() {
        return glass_trapdoor;
    }

    public BlockEntry<CardboardBlock> getCardboardBlock() {
        return cardboard_block;
    }

    public BlockEntry<CardboardBlock> getBoundCardboardBlock() {
        return bound_cardboard_block;
    }

    /* Tinted Blocks */

    public BlockEntry<TintedConnectedGlassBlock> tinted_glass;
    public BlockEntry<TintedConnectedGlassBlock> vertical_tinted_glass;
    public BlockEntry<TintedConnectedGlassBlock> horizontal_tinted_glass;
    public BlockEntry<TintedGlassBlock> tinted_tiled_glass;
    public BlockEntry<TintedConnectedGlassPaneBlock> tinted_glass_pane;
    public BlockEntry<TintedConnectedGlassPaneBlock> vertical_tinted_glass_pane;
    public BlockEntry<TintedConnectedGlassPaneBlock> horizontal_tinted_glass_pane;
    public BlockEntry<TintedGlassPaneBlock> tinted_tiled_glass_pane;
    public BlockEntry<TintedFramedGlassSlidingDoorBlock> tinted_glass_door;
    public BlockEntry<TintedFramedGlassTrapdoorBlock> tinted_glass_trapdoor;

    CreateFramedBlocks() {

        String name = Lang.asId(name());
        id = CreateFramedMod.asResource(name);
        tinted_glass = CreateFramedBuilderTransformers.tintedFramedGlass(CreateFramedSpriteShifts.TINTED_FRAMED_GLASS);
        vertical_tinted_glass = CreateFramedBuilderTransformers.tintedFramedGlass("vertical",
                new HorizontalCTBehaviour(CreateFramedSpriteShifts.VERTICAL_TINTED_FRAMED_GLASS, CreateFramedSpriteShifts.TINTED_FRAMED_GLASS));
        horizontal_tinted_glass = CreateFramedBuilderTransformers.tintedFramedGlass("horizontal",
                new HorizontalCTBehaviour(CreateFramedSpriteShifts.HORIZONTAL_TINTED_FRAMED_GLASS, CreateFramedSpriteShifts.TINTED_FRAMED_GLASS));
        tinted_tiled_glass = CreateFramedBuilderTransformers.tintedTiledGlass();
        tinted_glass_pane = CreateFramedBuilderTransformers.tintedFramedGlassPane("tinted_framed_glass",
                tinted_glass, () -> CreateFramedSpriteShifts.TINTED_FRAMED_GLASS);
        vertical_tinted_glass_pane = CreateFramedBuilderTransformers.tintedFramedGlassPane("vertical_tinted_framed_glass",
                tinted_glass, () -> CreateFramedSpriteShifts.VERTICAL_TINTED_FRAMED_GLASS);
        horizontal_tinted_glass_pane = CreateFramedBuilderTransformers.tintedFramedGlassPane("horizontal_tinted_framed_glass",
                tinted_glass, () -> CreateFramedSpriteShifts.HORIZONTAL_TINTED_FRAMED_GLASS);
        tinted_tiled_glass_pane = CreateFramedBuilderTransformers.tintedTiledGlassPane();
        tinted_glass_door = CreateFramedBuilderTransformers.tintedFramedGlassSlidingDoor("tinted_framed_glass", MapColor.COLOR_BLACK);
        tinted_glass_trapdoor = CreateFramedBuilderTransformers.tintedFramedGlassTrapdoor("tinted_framed_glass", MapColor.COLOR_BLACK, CreateFramedSpriteShifts.TINTED_FRAMED_GLASS);
    }

    public BlockEntry<TintedConnectedGlassBlock> getTintedGlass() {
        return tinted_glass;
    }

    public BlockEntry<TintedConnectedGlassBlock> getVerticalTintedGlass() {
        return vertical_tinted_glass;
    }

    public BlockEntry<TintedConnectedGlassBlock> getHorizontalTintedGlass() {
        return horizontal_tinted_glass;
    }

    public BlockEntry<TintedGlassBlock> getTintedTiledGlass() {
        return tinted_tiled_glass;
    }

    public BlockEntry<TintedGlassPaneBlock> getTintedTiledGlassPane() {
        return tinted_tiled_glass_pane;
    }

    public BlockEntry<TintedConnectedGlassPaneBlock> getTintedGlassPane() {
        return tinted_glass_pane;
    }

    public BlockEntry<TintedConnectedGlassPaneBlock> getVerticalTintedGlassPane() {
        return vertical_tinted_glass_pane;
    }

    public BlockEntry<TintedConnectedGlassPaneBlock> getHorizontalTintedGlassPane() {
        return horizontal_tinted_glass_pane;
    }

    public BlockEntry<TintedFramedGlassSlidingDoorBlock> getTintedGlassDoor() {
        return tinted_glass_door;
    }

    public BlockEntry<TintedFramedGlassTrapdoorBlock> getTintedGlassTrapoor() {
        return tinted_glass_trapdoor;
    }

    public static void register() {
        CreateFramedWindows.register();
        MiscBlocks.register();

        // Alex's Caves
        AlexsCavesModule.register();
    }
}
