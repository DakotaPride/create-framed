package net.dakotapride.createframed.block.frogport.colour;

import net.dakotapride.createframed.block.frogport.DyedFrogportRenderer;
import net.dakotapride.createframed.registry.CreateFramedPartialModels;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class OrangeFrogportRenderer extends DyedFrogportRenderer {
    public OrangeFrogportRenderer(BlockEntityRendererProvider.Context context) {
        super(context, CreateFramedPartialModels.ORANGE_FROGPORT_BODY,
                CreateFramedPartialModels.ORANGE_FROGPORT_HEAD, CreateFramedPartialModels.ORANGE_FROGPORT_HEAD_GOGGLES);
    }
}
