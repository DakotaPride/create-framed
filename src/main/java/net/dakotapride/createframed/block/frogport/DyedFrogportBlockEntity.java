package net.dakotapride.createframed.block.frogport;

import com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlockEntity;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class DyedFrogportBlockEntity extends FrogportBlockEntity {
    //protected IItemHandler itemHandler;
    public DyedFrogportBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void capabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                CreateFramedEntityTypes.RED_FROGPORT.get(),
                (be, context) -> be.itemHandler
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                CreateFramedEntityTypes.ORANGE_FROGPORT.get(),
                (be, context) -> be.itemHandler
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                CreateFramedEntityTypes.YELLOW_FROGPORT.get(),
                (be, context) -> be.itemHandler
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                CreateFramedEntityTypes.GREEN_FROGPORT.get(),
                (be, context) -> be.itemHandler
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                CreateFramedEntityTypes.BLUE_FROGPORT.get(),
                (be, context) -> be.itemHandler
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                CreateFramedEntityTypes.PURPLE_FROGPORT.get(),
                (be, context) -> be.itemHandler
        );
    }
}
