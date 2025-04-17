package net.dakotapride.createframed.block.frogport.colour;

import com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlock;
import net.dakotapride.createframed.block.frogport.DyedFrogportBlockEntity;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PurpleFrogportBlock extends FrogportBlock {
    public PurpleFrogportBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockEntityType<? extends DyedFrogportBlockEntity> getBlockEntityType() {
        return CreateFramedEntityTypes.PURPLE_FROGPORT.get();
    }
}
