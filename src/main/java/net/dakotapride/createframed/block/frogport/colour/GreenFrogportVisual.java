package net.dakotapride.createframed.block.frogport.colour;

import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.block.frogport.DyedFrogportVisual;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;

public class GreenFrogportVisual extends DyedFrogportVisual {
    public GreenFrogportVisual(VisualizationContext ctx, DyedFrogportBlockEntity blockEntity, float partialTick) {
        super(ctx, blockEntity, partialTick, CreateFramedPartialModels.GREEN_FROGPORT_BODY,
                CreateFramedPartialModels.GREEN_FROGPORT_HEAD, CreateFramedPartialModels.GREEN_FROGPORT_HEAD_GOGGLES);
    }
}
