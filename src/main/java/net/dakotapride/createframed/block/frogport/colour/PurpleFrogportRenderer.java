package net.dakotapride.createframed.block.frogport.colour;

import net.dakotapride.createframed.block.frogport.DyedFrogportRenderer;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class PurpleFrogportRenderer extends DyedFrogportRenderer {
    public PurpleFrogportRenderer(BlockEntityRendererProvider.Context context) {
        super(context, CreateFramedPartialModels.PURPLE_FROGPORT_BODY,
                CreateFramedPartialModels.PURPLE_FROGPORT_HEAD, CreateFramedPartialModels.PURPLE_FROGPORT_HEAD_GOGGLES);
    }
}
