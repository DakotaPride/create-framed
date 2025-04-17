package net.dakotapride.createframed.block.frogport.colour;

import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.block.frogport.DyedFrogportVisual;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;

public class PurpleFrogportVisual extends DyedFrogportVisual {
    public PurpleFrogportVisual(VisualizationContext ctx, DyedFrogportBlockEntity blockEntity, float partialTick) {
        super(ctx, blockEntity, partialTick, CreateFramedPartialModels.PURPLE_FROGPORT_BODY,
                CreateFramedPartialModels.PURPLE_FROGPORT_HEAD, CreateFramedPartialModels.PURPLE_FROGPORT_HEAD_GOGGLES);
    }
}
