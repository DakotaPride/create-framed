package net.dakotapride.createframed.block.frogport.colour;

import com.simibubi.create.content.logistics.packagePort.frogport.FrogportVisual;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.block.frogport.DyedFrogportVisual;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;

public class RedFrogportVisual extends DyedFrogportVisual {
    public RedFrogportVisual(VisualizationContext ctx, DyedFrogportBlockEntity blockEntity, float partialTick) {
        super(ctx, blockEntity, partialTick, CreateFramedPartialModels.RED_FROGPORT_BODY,
                CreateFramedPartialModels.RED_FROGPORT_HEAD, CreateFramedPartialModels.RED_FROGPORT_HEAD_GOGGLES);
    }
}
