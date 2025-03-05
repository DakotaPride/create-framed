package net.dakotapride.createframed.compat;

import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.createmod.catnip.lang.Lang;
import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.registry.CreateFramedBuilderTransformers;
import net.dakotapride.createframed.registry.CreateFramedSpriteShifts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

@SuppressWarnings({"unused"})
public enum AlexsCavesModule {

    RED(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.RED_FRAMED_RADON_LAMP)),
    ORANGE(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.ORANGE_FRAMED_RADON_LAMP)),
    YELLOW(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.YELLOW_FRAMED_RADON_LAMP)),
    GREEN(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.GREEN_FRAMED_RADON_LAMP)),
    LIME(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.LIME_FRAMED_RADON_LAMP)),
    BLUE(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.BLUE_FRAMED_RADON_LAMP)),
    LIGHT_BLUE(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.LIGHT_BLUE_FRAMED_RADON_LAMP)),
    CYAN(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.CYAN_FRAMED_RADON_LAMP)),
    PURPLE(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.PURPLE_FRAMED_RADON_LAMP)),
    MAGENTA(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.MAGENTA_FRAMED_RADON_LAMP)),
    PINK(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.PINK_FRAMED_RADON_LAMP)),
    BLACK(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.BLACK_FRAMED_RADON_LAMP)),
    GRAY(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.GRAY_FRAMED_RADON_LAMP)),
    LIGHT_GRAY(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.LIGHT_GRAY_FRAMED_RADON_LAMP)),
    WHITE(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.WHITE_FRAMED_RADON_LAMP)),
    BROWN(() -> new SimpleCTBehaviour(CreateFramedSpriteShifts.BROWN_FRAMED_RADON_LAMP));

    private final ResourceLocation id;
    public final BlockEntry<AlexsCavesCompatConnectedGlassBlock> glass_block;

    AlexsCavesModule(Supplier<ConnectedTextureBehaviour> behaviour) {
        String name = Lang.asId(name());
        id = CreateFramedMod.asResource(name);
        glass_block = framedRadonGlass(name, behaviour);
    }

    public BlockEntry<AlexsCavesCompatConnectedGlassBlock> getGlassBlock() {
        return glass_block;
    }

    public static void register() {}

    public static BlockEntry<AlexsCavesCompatConnectedGlassBlock> framedRadonGlass(String name,
                                                                      Supplier<ConnectedTextureBehaviour> behaviour) {
        return REGISTRATE.block("framed_radon_lamp_" + name, AlexsCavesCompatConnectedGlassBlock::new)
                .onRegister(connectedTextures(behaviour))
                //.addLayer(() -> RenderType::translucent)
                .initialProperties(() -> Blocks.GLASS)
                .properties((p) -> p.isValidSpawn(CreateFramedBuilderTransformers::never)
                        .isRedstoneConductor(CreateFramedBuilderTransformers::never)
                        .isSuffocating(CreateFramedBuilderTransformers::never)
                        .isViewBlocking(CreateFramedBuilderTransformers::never)
                        .mapColor(MapColor.TERRACOTTA_WHITE)
                        .requiresCorrectToolForDrops()
                        .lightLevel(state -> 15)
                        .strength(2F, 11.0F))
                .simpleItem()
                .register();
    }

}
