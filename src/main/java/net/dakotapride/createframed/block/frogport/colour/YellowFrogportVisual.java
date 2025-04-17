package net.dakotapride.createframed.block.frogport.colour;

import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.block.frogport.DyedFrogportVisual;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;

public class YellowFrogportVisual extends DyedFrogportVisual {
    public YellowFrogportVisual(VisualizationContext ctx, DyedFrogportBlockEntity blockEntity, float partialTick) {
        super(ctx, blockEntity, partialTick, CreateFramedPartialModels.YELLOW_FROGPORT_BODY,
                CreateFramedPartialModels.YELLOW_FROGPORT_HEAD, CreateFramedPartialModels.YELLOW_FROGPORT_HEAD_GOGGLES);
    }
}
