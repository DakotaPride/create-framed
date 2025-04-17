package net.dakotapride.createframed.block.frogport.colour;

import net.dakotapride.createframed.block.frogport.DyedFrogportRenderer;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class GreenFrogportRenderer extends DyedFrogportRenderer {
    public GreenFrogportRenderer(BlockEntityRendererProvider.Context context) {
        super(context, CreateFramedPartialModels.GREEN_FROGPORT_BODY,
                CreateFramedPartialModels.GREEN_FROGPORT_HEAD, CreateFramedPartialModels.GREEN_FROGPORT_HEAD_GOGGLES);
    }
}
