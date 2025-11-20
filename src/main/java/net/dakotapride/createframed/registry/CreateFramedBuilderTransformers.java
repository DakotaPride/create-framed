package net.dakotapride.createframed.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.TrainTrapdoorBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.GlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.WindowBlock;
import com.simibubi.create.foundation.block.connected.*;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.block.*;
import net.dakotapride.createframed.block.*;
import net.dakotapride.createframed.block.behaviour.FramedDoorMovingInteraction;
import net.dakotapride.createframed.block.behaviour.FramedGlassTrapdoorCTBehaviour;
import net.dakotapride.createframed.block.behaviour.FramedSlidingDoorMovementBehaviour;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorBlock;
import net.dakotapride.createframed.block.door.TintedFramedGlassSlidingDoorBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static com.simibubi.create.api.behaviour.interaction.MovingInteractionBehaviour.interactionBehaviour;
import static com.simibubi.create.api.behaviour.movement.MovementBehaviour.movementBehaviour;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

@SuppressWarnings({"unused","removal"})
public class CreateFramedBuilderTransformers {
    private static final CreateRegistrate REGISTRATE = CreateFramedMod.REGISTRATE.setCreativeTab(CreateFramedTabs.CREATE_FRAMED);

    public static BlockEntry<WindowBlock> windowBlock(String name,
                                                      Supplier<ConnectedTextureBehaviour> behaviour,
                                                      Block block) {
        return REGISTRATE.block(name + "_window", p -> new WindowBlock(p, false))
                .onRegister(connectedTextures(behaviour))
                .addLayer(() -> RenderType::cutout)
                .initialProperties(() -> Blocks.GLASS)
                .properties((p) -> p.isValidSpawn(CreateFramedBuilderTransformers::never)
                        .isRedstoneConductor(CreateFramedBuilderTransformers::never)
                        .isSuffocating(CreateFramedBuilderTransformers::never)
                        .isViewBlocking(CreateFramedBuilderTransformers::never)
                        .noOcclusion()
                        .mapColor(block.defaultMapColor()))
                .simpleItem()
                .register();
    }

    public static BlockEntry<ConnectedGlassPaneBlock> windowPaneBlock(String name,
                                                                      Supplier<CTSpriteShiftEntry> ct,
                                                                      Supplier<MapColor> color) {
        return REGISTRATE.block(name + "_window_pane", ConnectedGlassPaneBlock::new)
                .onRegister(connectedTextures(() -> new HorizontalCTBehaviour(ct.get())))
                .addLayer(() -> RenderType::cutout)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .properties(p -> p.mapColor(color.get()).noOcclusion())
                .simpleItem()
                .register();
    }

    public static BlockEntry<WindowBlock> roseQuartzWindowBlock(String name,
                                                      Supplier<ConnectedTextureBehaviour> behaviour,
                                                      Block block) {
        return REGISTRATE.block(name + "_window", p -> new WindowBlock(p, false))
                .onRegister(connectedTextures(behaviour))
                .addLayer(() -> RenderType::translucent)
                .initialProperties(() -> Blocks.GLASS)
                .properties((p) -> p.isValidSpawn(CreateFramedBuilderTransformers::never)
                        .isRedstoneConductor(CreateFramedBuilderTransformers::never)
                        .isSuffocating(CreateFramedBuilderTransformers::never)
                        .isViewBlocking(CreateFramedBuilderTransformers::never)
                        .noOcclusion()
                        .mapColor(block.defaultMapColor()))
                .simpleItem()
                .register();
    }

    public static BlockEntry<ConnectedGlassPaneBlock> roseQuartzWindowPaneBlock(String name,
                                                                      Supplier<CTSpriteShiftEntry> ct,
                                                                      Supplier<MapColor> color) {
        return REGISTRATE.block(name + "_window_pane", ConnectedGlassPaneBlock::new)
                .onRegister(connectedTextures(() -> new HorizontalCTBehaviour(ct.get())))
                .addLayer(() -> RenderType::translucent)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .properties(p -> p.mapColor(color.get()).noOcclusion())
                .simpleItem()
                .register();
    }

    public static BlockEntry<ConnectedFramedGlassBlock> verticalColouredFramedGlass(String name,
                                                                                    Supplier<ConnectedTextureBehaviour> behaviour,
                                                                                    Block stainedBlock, DyeColor dyeColour) {
        return colouredFramedGlass("vertical_" + name, behaviour, stainedBlock, dyeColour);
    }

    public static BlockEntry<ConnectedFramedGlassBlock> horizontalColouredFramedGlass(String name,
                                                                              Supplier<ConnectedTextureBehaviour> behaviour,
                                                                              Block stainedBlock, DyeColor dyeColour) {
        return colouredFramedGlass("horizontal_" + name, behaviour, stainedBlock, dyeColour);
    }

    public static BlockEntry<ConnectedFramedGlassBlock> colouredFramedGlass(String name,
                                                                      Supplier<ConnectedTextureBehaviour> behaviour,
                                                                      Block stainedBlock, DyeColor dyeColour) {
        return REGISTRATE.block(name + "_stained_framed_glass", p -> new ConnectedFramedGlassBlock(dyeColour, p))
                .onRegister(connectedTextures(behaviour))
                .addLayer(() -> RenderType::translucent)
                .initialProperties(() -> stainedBlock)
                .properties((p) -> p.isValidSpawn(CreateFramedBuilderTransformers::never)
                        .isRedstoneConductor(CreateFramedBuilderTransformers::never)
                        .isSuffocating(CreateFramedBuilderTransformers::never)
                        .isViewBlocking(CreateFramedBuilderTransformers::never)
                        .noOcclusion())
                .simpleItem()
                .register();
    }

    public static BlockEntry<GlassBlock> colouredTiledGlass(String colourType) {
        return REGISTRATE.block(colourType + "_stained_tiled_glass", GlassBlock::new)
                .initialProperties(() -> Blocks.GLASS)
                .addLayer(() -> RenderType::translucent)
                .simpleItem()
                .register();
    }

    public static BlockEntry<GlassPaneBlock> colouredTiledGlassPane(String colourType) {
        return REGISTRATE.block(colourType + "_stained_tiled_glass_pane", GlassPaneBlock::new)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .addLayer(() -> RenderType::translucent)
                .simpleItem()
                .register();
    }

    public static BlockEntry<TintedGlassBlock> tintedTiledGlass() {
        return REGISTRATE.block("tinted_tiled_glass", TintedGlassBlock::new)
                .initialProperties(() -> Blocks.TINTED_GLASS)
                .addLayer(() -> RenderType::translucent)
                .simpleItem()
                .register();
    }

    public static BlockEntry<TintedGlassPaneBlock> tintedTiledGlassPane() {
        return REGISTRATE.block("tinted_tiled_glass_pane", TintedGlassPaneBlock::new)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .addLayer(() -> RenderType::translucent)
                .simpleItem()
                .register();
    }

    public static <B extends FramedGlassSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> slidingDoor(String type) {
        return b -> b.initialProperties(() -> Blocks.OAK_DOOR) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F)
                        .isViewBlocking(CreateFramedBuilderTransformers::never))
                .addLayer(() -> RenderType::translucent)
                .onRegister(interactionBehaviour(new FramedDoorMovingInteraction()))
                .onRegister(movementBehaviour(new FramedSlidingDoorMovementBehaviour()))
                .simpleItem();
    }

    public static <B extends TintedFramedGlassSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> tintedSlidingDoor(String type) {
        return b -> b.initialProperties(() -> Blocks.OAK_DOOR) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F)
                        .isViewBlocking(CreateFramedBuilderTransformers::never))
                .addLayer(() -> RenderType::translucent)
                .onRegister(interactionBehaviour(new FramedDoorMovingInteraction()))
                .onRegister(movementBehaviour(new FramedSlidingDoorMovementBehaviour()))
                .item()
                .build();
    }

    public static BlockEntry<FramedGlassSlidingDoorBlock> framedGlassSlidingDoor(String type, MapColor colour) {
        return REGISTRATE.block(type + "_stained_framed_glass_door", FramedGlassSlidingDoorBlock::new)
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.GLASS).mapColor(colour).noOcclusion())
                .transform(CreateFramedBuilderTransformers.slidingDoor(type))
                .register();
    }

    public static BlockEntry<TintedFramedGlassSlidingDoorBlock> tintedFramedGlassSlidingDoor(String type, MapColor colour) {
        return REGISTRATE.block(type + "_door", TintedFramedGlassSlidingDoorBlock::new)
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.GLASS).mapColor(colour).noOcclusion())
                .transform(CreateFramedBuilderTransformers.tintedSlidingDoor(type))
                .register();
    }

    public static BlockEntry<TrainTrapdoorBlock> framedGlassTrapdoor(String name, MapColor colour, CTSpriteShiftEntry spriteShiftEntry) {
        return REGISTRATE.block(name + "_stained_framed_glass_trapdoor", TrainTrapdoorBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .transform(BuilderTransformers.trapdoor(false))
                .properties(p -> p.sound(SoundType.GLASS).noOcclusion().mapColor(colour))
                .onRegister(connectedTextures(() -> new FramedGlassTrapdoorCTBehaviour(spriteShiftEntry)))
                .addLayer(() -> RenderType::translucent)
                .register();
    }

    public static BlockEntry<TintedFramedGlassTrapdoorBlock> tintedFramedGlassTrapdoor(String name, MapColor colour, CTSpriteShiftEntry spriteShiftEntry) {
        return REGISTRATE.block(name + "_trapdoor", TintedFramedGlassTrapdoorBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .transform(BuilderTransformers.trapdoor(false))
                .properties(p -> p.sound(SoundType.GLASS).noOcclusion().mapColor(colour))
                .onRegister(connectedTextures(() -> new FramedGlassTrapdoorCTBehaviour(spriteShiftEntry)))
                .addLayer(() -> RenderType::translucent)
                .register();
    }

    public static BlockEntry<ConnectedGlassPaneBlock> verticalColouredFramedGlassPane(String name,
                                                                                      Supplier<Block> stainedBlock,
                                                                                      Supplier<CTSpriteShiftEntry> behaviour) {
        return colouredFramedGlassPane("vertical_" + name, stainedBlock, behaviour);
    }

    public static BlockEntry<ConnectedGlassPaneBlock> horizontalColouredFramedGlassPane(String name,
                                                                                        Supplier<Block> stainedBlock,
                                                                                        Supplier<CTSpriteShiftEntry> behaviour) {
        return colouredFramedGlassPane("horizontal_" + name, stainedBlock, behaviour);
    }

    public static BlockEntry<ConnectedGlassPaneBlock> colouredFramedGlassPane(String name, Supplier<? extends Block> parent,
                                                                              Supplier<CTSpriteShiftEntry> ctshift) {
        Supplier<Supplier<RenderType>> renderType = () -> RenderType::translucent;
        return connectedGlassPane(name + "_stained_framed_glass", parent, ctshift, renderType);
    }

    public static BlockEntry<TintedConnectedGlassPaneBlock> tintedFramedGlassPane(String name, Supplier<? extends Block> parent,
                                                                                  Supplier<CTSpriteShiftEntry> ctshift) {
        Supplier<Supplier<RenderType>> renderType = () -> RenderType::translucent;
        return tintedConnectedGlassPane(name, parent, ctshift, renderType);
    }

    public static BlockEntry<TintedConnectedGlassBlock> tintedFramedGlass(CTSpriteShiftEntry entry) {
        return REGISTRATE.block("tinted_framed_glass", TintedConnectedGlassBlock::new)
                .onRegister(connectedTextures(() -> new SimpleCTBehaviour(entry)))
                .addLayer(() -> RenderType::translucent)
                .initialProperties(() -> Blocks.TINTED_GLASS)
                .properties((p) -> p.isValidSpawn(CreateFramedBuilderTransformers::never)
                        .isRedstoneConductor(CreateFramedBuilderTransformers::never)
                        .isSuffocating(CreateFramedBuilderTransformers::never)
                        .isViewBlocking(CreateFramedBuilderTransformers::never)
                        .noOcclusion())
                .item()
                .build()
                .register();
    }

    public static BlockEntry<TintedConnectedGlassBlock> tintedFramedGlass(String name, ConnectedTextureBehaviour.Base behaviour) {
        return REGISTRATE.block(name + "_" + "tinted_framed_glass", TintedConnectedGlassBlock::new)
                .onRegister(connectedTextures(() -> behaviour))
                .addLayer(() -> RenderType::translucent)
                .initialProperties(() -> Blocks.TINTED_GLASS)
                .properties((p) -> p.isValidSpawn(CreateFramedBuilderTransformers::never)
                        .isRedstoneConductor(CreateFramedBuilderTransformers::never)
                        .isSuffocating(CreateFramedBuilderTransformers::never)
                        .isViewBlocking(CreateFramedBuilderTransformers::never)
                        .noOcclusion())
                .item()
                .build()
                .register();
    }

    public static boolean never(BlockState p_235436_0_, BlockGetter p_235436_1_, BlockPos p_235436_2_) {
        return false;
    }

    public static Boolean never(BlockState p_235427_0_, BlockGetter p_235427_1_, BlockPos p_235427_2_,
                                 EntityType<?> p_235427_3_) {
        return false;
    }

    private static BlockEntry<ConnectedGlassPaneBlock> connectedGlassPane(String name, Supplier<? extends Block> parent,
                                                                          Supplier<CTSpriteShiftEntry> ctshift, Supplier<Supplier<RenderType>> renderType) {
        NonNullConsumer<? super ConnectedGlassPaneBlock> connectedTextures =
                connectedTextures(() -> new GlassPaneCTBehaviour(ctshift.get()));

        return glassPane(name, parent, ConnectedGlassPaneBlock::new, renderType,
                connectedTextures);
    }

    private static BlockEntry<TintedConnectedGlassPaneBlock> tintedConnectedGlassPane(String name, Supplier<? extends Block> parent,
                                                                          Supplier<CTSpriteShiftEntry> ctshift, Supplier<Supplier<RenderType>> renderType) {
        NonNullConsumer<? super TintedConnectedGlassPaneBlock> connectedTextures =
                connectedTextures(() -> new GlassPaneCTBehaviour(ctshift.get()));

        return glassPane(name, parent, TintedConnectedGlassPaneBlock::new, renderType,
                connectedTextures);
    }

    private static <G extends GlassPaneBlock> BlockEntry<G> glassPane(String name, Supplier<? extends Block> parent, NonNullFunction<BlockBehaviour.Properties, G> factory,
                                                                      Supplier<Supplier<RenderType>> renderType, NonNullConsumer<? super G> connectedTextures) {
        name += "_pane";

        return REGISTRATE.block(name, factory)
                .onRegister(connectedTextures)
                .addLayer(renderType)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .properties(p -> p.mapColor(parent.get().defaultMapColor()))
                .simpleItem()
                .register();
    }
}
