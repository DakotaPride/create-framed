package net.dakotapride.createframed.block.frogport.colour;

import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.block.frogport.DyedFrogportVisual;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;

public class BlueFrogportVisual extends DyedFrogportVisual {
    public BlueFrogportVisual(VisualizationContext ctx, DyedFrogportBlockEntity blockEntity, float partialTick) {
        super(ctx, blockEntity, partialTick, CreateFramedPartialModels.BLUE_FROGPORT_BODY,
                CreateFramedPartialModels.BLUE_FROGPORT_HEAD, CreateFramedPartialModels.BLUE_FROGPORT_HEAD_GOGGLES);
    }
}
