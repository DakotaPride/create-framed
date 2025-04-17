package net.dakotapride.createframed.mixin.access;

import com.simibubi.create.content.logistics.packagePort.PackagePortBlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = PackagePortBlockEntity.class, remap = false)
public interface PackagePortBlockEntityAccessor {
    @Accessor("itemHandler")
    IItemHandler getItemHandlerFromPort();
}
