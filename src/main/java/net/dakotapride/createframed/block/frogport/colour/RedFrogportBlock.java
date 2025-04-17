package net.dakotapride.createframed.block.frogport.colour;

import net.dakotapride.createframed.block.frogport.DyedFrogportBlock;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class RedFrogportBlock extends DyedFrogportBlock {
    public RedFrogportBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockEntityType<? extends DyedFrogportBlockEntity> getBlockEntityType() {
        return CreateFramedEntityTypes.RED_FROGPORT.get();
    }
}
