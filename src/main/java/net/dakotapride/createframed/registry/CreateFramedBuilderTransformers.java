package net.dakotapride.createframed.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.content.contraptions.behaviour.DoorMovingInteraction;
import com.simibubi.create.content.decoration.TrainTrapdoorBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.GlassPaneBlock;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorMovementBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.block.connected.GlassPaneCTBehaviour;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.block.TintedConnectedGlassBlock;
import net.dakotapride.createframed.block.TintedConnectedGlassPaneBlock;
import net.dakotapride.createframed.block.TintedFramedGlassTrapdoorBlock;
import net.dakotapride.createframed.block.TintedGlassPaneBlock;
import net.dakotapride.createframed.block.behaviour.FramedDoorMovingInteraction;
import net.dakotapride.createframed.block.behaviour.FramedGlassTrapdoorCTBehaviour;
import net.dakotapride.createframed.block.behaviour.FramedSlidingDoorMovementBehaviour;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorBlock;
import net.dakotapride.createframed.block.door.TintedFramedGlassSlidingDoorBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.Tags;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static com.simibubi.create.Create.REGISTRATE;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

@SuppressWarnings({"unused","removal"})
public class CreateFramedBuilderTransformers {
    private static final CreateRegistrate REGISTRATE = CreateFramedMod.REGISTRATE.creativeModeTab(() -> CreateFramedTabs.CREATE_FRAMED);

    public static BlockEntry<ConnectedGlassBlock> colouredFramedGlass(String name,
                                                                      Supplier<ConnectedTextureBehaviour> behaviour,
                                                                      Block stainedBlock) {
        return REGISTRATE.block(name, ConnectedGlassBlock::new)
                .onRegister(connectedTextures(behaviour))
                .addLayer(() -> RenderType::translucent)
                .initialProperties(() -> stainedBlock)
                .properties((p) -> p.isValidSpawn(CreateFramedBuilderTransformers::never)
                        .isRedstoneConductor(CreateFramedBuilderTransformers::never)
                        .isSuffocating(CreateFramedBuilderTransformers::never)
                        .isViewBlocking(CreateFramedBuilderTransformers::never)
                        .noOcclusion())
                .item()
                .build()
                .register();
    }

    public static BlockEntry<GlassBlock> colouredTiledGlass(String colourType) {
        return REGISTRATE.block(colourType + "_stained_tiled_glass", GlassBlock::new)
                .initialProperties(() -> Blocks.GLASS)
                .addLayer(() -> RenderType::translucent)
                .item()
                .build()
                .register();
    }

    public static BlockEntry<GlassPaneBlock> colouredTiledGlassPane(String colourType) {
        return REGISTRATE.block(colourType + "_stained_tiled_glass_pane", GlassPaneBlock::new)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .addLayer(() -> RenderType::translucent)
                .item()
                .build()
                .register();
    }

    public static BlockEntry<TintedGlassBlock> tintedTiledGlass() {
        return REGISTRATE.block("tinted_tiled_glass", TintedGlassBlock::new)
                .initialProperties(() -> Blocks.TINTED_GLASS)
                .addLayer(() -> RenderType::translucent)
                .item()
                .build()
                .register();
    }

    public static BlockEntry<TintedGlassPaneBlock> tintedTiledGlassPane() {
        return REGISTRATE.block("tinted_tiled_glass_pane", TintedGlassPaneBlock::new)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .addLayer(() -> RenderType::translucent)
                .item()
                .build()
                .register();
    }

    public static <B extends FramedGlassSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> slidingDoor(String type) {
        return b -> b.initialProperties(Material.WOOD) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F))
                .addLayer(() -> RenderType::translucent)
                .onRegister(interactionBehaviour(new FramedDoorMovingInteraction()))
                .onRegister(movementBehaviour(new FramedSlidingDoorMovementBehaviour()))
                .item()
                .build();
    }

    public static <B extends TintedFramedGlassSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> tintedSlidingDoor(String type) {
        return b -> b.initialProperties(Material.WOOD) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F))
                .addLayer(() -> RenderType::translucent)
                .onRegister(interactionBehaviour(new FramedDoorMovingInteraction()))
                .onRegister(movementBehaviour(new FramedSlidingDoorMovementBehaviour()))
                .item()
                .build();
    }

    public static BlockEntry<FramedGlassSlidingDoorBlock> framedGlassSlidingDoor(String type, MaterialColor colour) {
        return REGISTRATE.block(type + "_door", FramedGlassSlidingDoorBlock::new)
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.GLASS).color(colour))
                .transform(CreateFramedBuilderTransformers.slidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static BlockEntry<TintedFramedGlassSlidingDoorBlock> tintedFramedGlassSlidingDoor(String type, MaterialColor colour) {
        return REGISTRATE.block(type + "_door", TintedFramedGlassSlidingDoorBlock::new)
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.GLASS).color(colour))
                .transform(CreateFramedBuilderTransformers.tintedSlidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static BlockEntry<TrainTrapdoorBlock> framedGlassTrapdoor(String name, MaterialColor colour, CTSpriteShiftEntry spriteShiftEntry) {
        return REGISTRATE.block(name + "_trapdoor", TrainTrapdoorBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .transform(BuilderTransformers.trapdoor(false))
                .properties(p -> p.sound(SoundType.GLASS).noOcclusion().color(colour))
                .onRegister(connectedTextures(() -> new FramedGlassTrapdoorCTBehaviour(spriteShiftEntry)))
                .addLayer(() -> RenderType::translucent)
                .register();
    }

    public static BlockEntry<TintedFramedGlassTrapdoorBlock> tintedFramedGlassTrapdoor(String name, MaterialColor colour, CTSpriteShiftEntry spriteShiftEntry) {
        return REGISTRATE.block(name + "_trapdoor", TintedFramedGlassTrapdoorBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .transform(BuilderTransformers.trapdoor(false))
                .properties(p -> p.sound(SoundType.GLASS).noOcclusion().color(colour))
                .onRegister(connectedTextures(() -> new FramedGlassTrapdoorCTBehaviour(spriteShiftEntry)))
                .addLayer(() -> RenderType::translucent)
                .register();
    }

    public static BlockEntry<ConnectedGlassPaneBlock> colouredFramedGlassPane(String name, Supplier<? extends Block> parent,
                                                                              Supplier<CTSpriteShiftEntry> ctshift) {
        ResourceLocation sideTexture = CreateFramedMod.asResource(name);
        ResourceLocation itemSideTexture = CreateFramedMod.asResource(name);
        ResourceLocation topTexture = CreateFramedMod.asResource(name + "_top");
        Supplier<Supplier<RenderType>> renderType = () -> RenderType::translucent;
        return connectedGlassPane(name, parent, ctshift, sideTexture, itemSideTexture, topTexture, renderType);
    }

    public static BlockEntry<TintedConnectedGlassPaneBlock> tintedFramedGlassPane(String name, Supplier<? extends Block> parent,
                                                                                  Supplier<CTSpriteShiftEntry> ctshift) {
        ResourceLocation sideTexture = CreateFramedMod.asResource(name);
        ResourceLocation itemSideTexture = CreateFramedMod.asResource(name);
        ResourceLocation topTexture = CreateFramedMod.asResource(name + "_top");
        Supplier<Supplier<RenderType>> renderType = () -> RenderType::translucent;
        return tintedConnectedGlassPane(name, parent, ctshift, sideTexture, itemSideTexture, topTexture, renderType);
    }

    public static BlockEntry<TintedConnectedGlassBlock> tintedFramedGlass() {
        return REGISTRATE.block("tinted_framed_glass", TintedConnectedGlassBlock::new)
                .onRegister(connectedTextures(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.TINTED_FRAMED_GLASS)))
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

    private static boolean never(BlockState p_235436_0_, BlockGetter p_235436_1_, BlockPos p_235436_2_) {
        return false;
    }

    private static Boolean never(BlockState p_235427_0_, BlockGetter p_235427_1_, BlockPos p_235427_2_,
                                 EntityType<?> p_235427_3_) {
        return false;
    }

    private static BlockEntry<ConnectedGlassPaneBlock> connectedGlassPane(String name, Supplier<? extends Block> parent,
                                                                          Supplier<CTSpriteShiftEntry> ctshift, ResourceLocation sideTexture, ResourceLocation itemSideTexture,
                                                                          ResourceLocation topTexture, Supplier<Supplier<RenderType>> renderType) {
        NonNullConsumer<? super ConnectedGlassPaneBlock> connectedTextures =
                connectedTextures(() -> new GlassPaneCTBehaviour(ctshift.get()));
        String CGPparents = "block/connected_glass_pane/";
        String prefix = name + "_pane_";

        Function<RegistrateBlockstateProvider, ModelFile> post =
                getPaneModelProvider(CGPparents, prefix, "post", sideTexture, topTexture),
                side = getPaneModelProvider(CGPparents, prefix, "side", sideTexture, topTexture),
                sideAlt = getPaneModelProvider(CGPparents, prefix, "side_alt", sideTexture, topTexture),
                noSide = getPaneModelProvider(CGPparents, prefix, "noside", sideTexture, topTexture),
                noSideAlt = getPaneModelProvider(CGPparents, prefix, "noside_alt", sideTexture, topTexture);

        NonNullBiConsumer<DataGenContext<Block, ConnectedGlassPaneBlock>, RegistrateBlockstateProvider> stateProvider =
                (c, p) -> p.paneBlock(c.get(), post.apply(p), side.apply(p), sideAlt.apply(p), noSide.apply(p),
                        noSideAlt.apply(p));

        return glassPane(name, parent, itemSideTexture, topTexture, ConnectedGlassPaneBlock::new, renderType,
                connectedTextures, stateProvider);
    }

    private static BlockEntry<TintedConnectedGlassPaneBlock> tintedConnectedGlassPane(String name, Supplier<? extends Block> parent,
                                                                          Supplier<CTSpriteShiftEntry> ctshift, ResourceLocation sideTexture, ResourceLocation itemSideTexture,
                                                                          ResourceLocation topTexture, Supplier<Supplier<RenderType>> renderType) {
        NonNullConsumer<? super TintedConnectedGlassPaneBlock> connectedTextures =
                connectedTextures(() -> new GlassPaneCTBehaviour(ctshift.get()));
        String CGPparents = "block/connected_glass_pane/";
        String prefix = name + "_pane_";

        Function<RegistrateBlockstateProvider, ModelFile> post =
                getPaneModelProvider(CGPparents, prefix, "post", sideTexture, topTexture),
                side = getPaneModelProvider(CGPparents, prefix, "side", sideTexture, topTexture),
                sideAlt = getPaneModelProvider(CGPparents, prefix, "side_alt", sideTexture, topTexture),
                noSide = getPaneModelProvider(CGPparents, prefix, "noside", sideTexture, topTexture),
                noSideAlt = getPaneModelProvider(CGPparents, prefix, "noside_alt", sideTexture, topTexture);

        NonNullBiConsumer<DataGenContext<Block, TintedConnectedGlassPaneBlock>, RegistrateBlockstateProvider> stateProvider =
                (c, p) -> p.paneBlock(c.get(), post.apply(p), side.apply(p), sideAlt.apply(p), noSide.apply(p),
                        noSideAlt.apply(p));

        return glassPane(name, parent, itemSideTexture, topTexture, TintedConnectedGlassPaneBlock::new, renderType,
                connectedTextures, stateProvider);
    }

    private static Function<RegistrateBlockstateProvider, ModelFile> getPaneModelProvider(String CGPparents,
                                                                                          String prefix, String partial,
                                                                                          ResourceLocation sideTexture,
                                                                                          ResourceLocation topTexture) {
        return p -> p.models()
                .withExistingParent(prefix + partial, CreateFramedMod.asResource(CGPparents + partial))
                .texture("pane", sideTexture)
                .texture("edge", topTexture);
    }

    private static <G extends GlassPaneBlock> BlockEntry<G> glassPane(String name, Supplier<? extends Block> parent,
                                                                      ResourceLocation sideTexture, ResourceLocation topTexture, NonNullFunction<BlockBehaviour.Properties, G> factory,
                                                                      Supplier<Supplier<RenderType>> renderType, NonNullConsumer<? super G> connectedTextures,
                                                                      NonNullBiConsumer<DataGenContext<Block, G>, RegistrateBlockstateProvider> stateProvider) {
        name += "_pane";

        return REGISTRATE.block(name, factory)
                .onRegister(connectedTextures)
                .addLayer(renderType)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .properties(p -> p.color(parent.get()
                        .defaultMaterialColor()))
                .blockstate(stateProvider)
                .item()
                .build()
                .register();
    }
}
