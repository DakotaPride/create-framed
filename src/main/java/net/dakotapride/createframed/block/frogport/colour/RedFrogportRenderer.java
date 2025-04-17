package net.dakotapride.createframed.block.frogport.colour;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dakotapride.createframed.block.frogport.DyedFrogportRenderer;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class RedFrogportRenderer extends DyedFrogportRenderer {
    public RedFrogportRenderer(BlockEntityRendererProvider.Context context) {
        super(context, CreateFramedPartialModels.RED_FROGPORT_BODY,
                CreateFramedPartialModels.RED_FROGPORT_HEAD, CreateFramedPartialModels.RED_FROGPORT_HEAD_GOGGLES);
    }
}
