package net.dakotapride.createframed.mixin;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorInteractionHandler;
import com.simibubi.create.content.logistics.box.PackageItem;
import com.simibubi.create.content.logistics.packagePort.PackagePortTarget;
import com.simibubi.create.content.logistics.packagePort.PackagePortTargetSelectionHandler;
import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.registry.CreateFramedFrogports;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorInteractionHandler.*;

@Mixin(value = ChainConveyorInteractionHandler.class, remap = false)
public abstract class ChainConveyorInteractionHandlerMixin {
    @Inject(method = "isActive", at = @At("HEAD"), cancellable = true)
    private static void isActive(CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getInstance();
        ItemStack mainHandItem = mc.player.getMainHandItem();

        for (CreateFramedFrogports frogports : CreateFramedFrogports.values()) {
            if (frogports.getFrogport().is(mainHandItem))
                cir.setReturnValue(frogports.getFrogport().is(mainHandItem));
        }
    }

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private static void onUse(CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getInstance();
        ItemStack mainHandItem = mc.player.getMainHandItem();

        for (CreateFramedFrogports frogports : CreateFramedFrogports.values()) {
            if (frogports.getFrogport().isIn(mainHandItem)) {
                PackagePortTargetSelectionHandler.exactPositionOfTarget = selectedBakedPosition;
                PackagePortTargetSelectionHandler.activePackageTarget =
                        new PackagePortTarget.ChainConveyorFrogportTarget(selectedLift, selectedChainPosition, selectedConnection, false);
                cir.setReturnValue(true);
            }
        }
    }
}
