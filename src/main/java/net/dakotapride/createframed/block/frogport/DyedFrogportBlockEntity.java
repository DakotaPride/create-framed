package net.dakotapride.createframed.block.frogport;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlockEntity;
import net.dakotapride.createframed.mixin.access.PackagePortBlockEntityAccessor;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.dakotapride.createframed.registry.CreateFramedFrogports;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class DyedFrogportBlockEntity extends FrogportBlockEntity {
    public DyedFrogportBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        capability(event, CreateFramedEntityTypes.RED_FROGPORT.get());
        capability(event, CreateFramedEntityTypes.ORANGE_FROGPORT.get());
        capability(event, CreateFramedEntityTypes.YELLOW_FROGPORT.get());
        capability(event, CreateFramedEntityTypes.GREEN_FROGPORT.get());
        capability(event, CreateFramedEntityTypes.BLUE_FROGPORT.get());
        capability(event, CreateFramedEntityTypes.PURPLE_FROGPORT.get());
    }

    private static void capability(RegisterCapabilitiesEvent event, BlockEntityType<?> blockEntityType) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                blockEntityType,
                (be, context) -> ((PackagePortBlockEntityAccessor)be).getItemHandlerFromPort()
        );
    }
}
