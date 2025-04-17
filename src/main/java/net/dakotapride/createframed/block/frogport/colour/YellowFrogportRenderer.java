package net.dakotapride.createframed.block.frogport.colour;

import net.dakotapride.createframed.block.frogport.DyedFrogportRenderer;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class YellowFrogportRenderer extends DyedFrogportRenderer {
    public YellowFrogportRenderer(BlockEntityRendererProvider.Context context) {
        super(context, CreateFramedPartialModels.YELLOW_FROGPORT_BODY,
                CreateFramedPartialModels.YELLOW_FROGPORT_HEAD, CreateFramedPartialModels.YELLOW_FROGPORT_HEAD_GOGGLES);
    }
}
