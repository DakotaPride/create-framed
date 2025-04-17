package net.dakotapride.createframed.block.frogport.colour;

import net.dakotapride.createframed.block.frogport.DyedFrogportRenderer;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class BlueFrogportRenderer extends DyedFrogportRenderer {
    public BlueFrogportRenderer(BlockEntityRendererProvider.Context context) {
        super(context, CreateFramedPartialModels.BLUE_FROGPORT_BODY,
                CreateFramedPartialModels.BLUE_FROGPORT_HEAD, CreateFramedPartialModels.BLUE_FROGPORT_HEAD_GOGGLES);
    }
}
