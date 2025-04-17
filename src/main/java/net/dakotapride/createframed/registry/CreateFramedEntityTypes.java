package net.dakotapride.createframed.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorBlockEntity;
import net.dakotapride.createframed.block.door.FramedGlassSlidingDoorRenderer;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.block.frogport.colour.*;

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
                            CreateFramedBlocks.BROWN.getGlassDoorBlock(), CreateFramedBlocks.TINTED.getTintedGlassDoor()
                    )
                    .register();


    public static final BlockEntityEntry<DyedFrogportBlockEntity> RED_FROGPORT =
            REGISTRATE.blockEntity("red_frogport", DyedFrogportBlockEntity::new)
                    .visual(() -> RedFrogportVisual::new, true)
                    .renderer(() -> RedFrogportRenderer::new)
                    .validBlocks(CreateFramedFrogports.RED.getFrogport())
                    .register();
    public static final BlockEntityEntry<DyedFrogportBlockEntity> ORANGE_FROGPORT =
            REGISTRATE.blockEntity("orange_frogport", DyedFrogportBlockEntity::new)
                    .visual(() -> OrangeFrogportVisual::new, true)
                    .renderer(() -> OrangeFrogportRenderer::new)
                    .validBlocks(CreateFramedFrogports.ORANGE.getFrogport())
                    .register();
    public static final BlockEntityEntry<DyedFrogportBlockEntity> YELLOW_FROGPORT =
            REGISTRATE.blockEntity("yellow_frogport", DyedFrogportBlockEntity::new)
                    .visual(() -> YellowFrogportVisual::new, true)
                    .renderer(() -> YellowFrogportRenderer::new)
                    .validBlocks(CreateFramedFrogports.YELLOW.getFrogport())
                    .register();
    public static final BlockEntityEntry<DyedFrogportBlockEntity> GREEN_FROGPORT =
            REGISTRATE.blockEntity("green_frogport", DyedFrogportBlockEntity::new)
                    .visual(() -> GreenFrogportVisual::new, true)
                    .renderer(() -> GreenFrogportRenderer::new)
                    .validBlocks(CreateFramedFrogports.GREEN.getFrogport())
                    .register();
    public static final BlockEntityEntry<DyedFrogportBlockEntity> BLUE_FROGPORT =
            REGISTRATE.blockEntity("blue_frogport", DyedFrogportBlockEntity::new)
                    .visual(() -> BlueFrogportVisual::new, true)
                    .renderer(() -> BlueFrogportRenderer::new)
                    .validBlocks(CreateFramedFrogports.BLUE.getFrogport())
                    .register();
    public static final BlockEntityEntry<DyedFrogportBlockEntity> PURPLE_FROGPORT =
            REGISTRATE.blockEntity("purple_frogport", DyedFrogportBlockEntity::new)
                    .visual(() -> PurpleFrogportVisual::new, true)
                    .renderer(() -> PurpleFrogportRenderer::new)
                    .validBlocks(CreateFramedFrogports.PURPLE.getFrogport())
                    .register();

    public static void register() {}
}
