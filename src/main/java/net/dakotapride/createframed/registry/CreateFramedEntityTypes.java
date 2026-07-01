package net.dakotapride.createframed.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorBlockEntity;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorRenderer;
import net.dakotapride.createframed.compat.DyeDepotModule;

import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

public class CreateFramedEntityTypes {

    public static final BlockEntityEntry<FramedGlassSlidingDoorBlockEntity> SLIDING_DOOR =
            REGISTRATE.blockEntity("sliding_door", FramedGlassSlidingDoorBlockEntity::new)
                    .renderer(() -> FramedGlassSlidingDoorRenderer::new)
                    .validBlocks(
                            CreateFramedBlocks.RED.getGlassDoorBlock(), CreateFramedBlocks.ORANGE.getGlassDoorBlock(), CreateFramedBlocks.YELLOW.getGlassDoorBlock(),
                            CreateFramedBlocks.GREEN.getGlassDoorBlock(), CreateFramedBlocks.LIME.getGlassDoorBlock(), CreateFramedBlocks.BLUE.getGlassDoorBlock(),
                            CreateFramedBlocks.LIGHT_BLUE.getGlassDoorBlock(), CreateFramedBlocks.CYAN.getGlassDoorBlock(), CreateFramedBlocks.PURPLE.getGlassDoorBlock(),
                            CreateFramedBlocks.MAGENTA.getGlassDoorBlock(), CreateFramedBlocks.PINK.getGlassDoorBlock(), CreateFramedBlocks.BLACK.getGlassDoorBlock(),
                            CreateFramedBlocks.GRAY.getGlassDoorBlock(), CreateFramedBlocks.LIGHT_GRAY.getGlassDoorBlock(), CreateFramedBlocks.WHITE.getGlassDoorBlock(),
                            CreateFramedBlocks.BROWN.getGlassDoorBlock(), CreateFramedBlocks.TINTED.getTintedGlassDoor(),

                            DyeDepotModule.MAROON.getGlassDoorBlock(), DyeDepotModule.ROSE.getGlassDoorBlock(), DyeDepotModule.CORAL.getGlassDoorBlock(),
                            DyeDepotModule.INDIGO.getGlassDoorBlock(), DyeDepotModule.NAVY.getGlassDoorBlock(), DyeDepotModule.SLATE.getGlassDoorBlock(),
                            DyeDepotModule.OLIVE.getGlassDoorBlock(), DyeDepotModule.AMBER.getGlassDoorBlock(), DyeDepotModule.BEIGE.getGlassDoorBlock(),
                            DyeDepotModule.TEAL.getGlassDoorBlock(), DyeDepotModule.MINT.getGlassDoorBlock(), DyeDepotModule.AQUA.getGlassDoorBlock(),
                            DyeDepotModule.VERDANT.getGlassDoorBlock(), DyeDepotModule.FOREST.getGlassDoorBlock(), DyeDepotModule.GINGER.getGlassDoorBlock(),
                            DyeDepotModule.TAN.getGlassDoorBlock()
                    )
                    .register();

    public static void register() {}
}
