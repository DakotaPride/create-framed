package net.dakotapride.createframed.mixin;

import com.simibubi.create.content.logistics.packagePort.PackagePortTarget;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PackagePortTarget.ChainConveyorFrogportTarget.class, remap = false)
public class ChainConveyorFrogportTargetMixin {
    @Inject(method = "canSupport", at = @At("HEAD"), cancellable = true)
    private void canSupport(BlockEntity be, CallbackInfoReturnable<Boolean> cir) {
        if (CreateFramedEntityTypes.RED_FROGPORT.is(be))
            cir.setReturnValue(true);
        if (CreateFramedEntityTypes.ORANGE_FROGPORT.is(be))
            cir.setReturnValue(true);
        if (CreateFramedEntityTypes.YELLOW_FROGPORT.is(be))
            cir.setReturnValue(true);
        if (CreateFramedEntityTypes.GREEN_FROGPORT.is(be))
            cir.setReturnValue(true);
        if (CreateFramedEntityTypes.BLUE_FROGPORT.is(be))
            cir.setReturnValue(true);
        if (CreateFramedEntityTypes.PURPLE_FROGPORT.is(be))
            cir.setReturnValue(true);
    }
}
