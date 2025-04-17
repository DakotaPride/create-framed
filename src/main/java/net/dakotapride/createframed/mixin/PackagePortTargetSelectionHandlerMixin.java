package net.dakotapride.createframed.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.logistics.packagePort.PackagePortTargetSelectionHandler;
import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.registry.CreateFramedFrogports;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.simibubi.create.content.logistics.packagePort.PackagePortTargetSelectionHandler.activePackageTarget;

@Mixin(value = PackagePortTargetSelectionHandler.class, remap = false)
public abstract class PackagePortTargetSelectionHandlerMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private static void tick(CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        boolean isPostbox = AllTags.AllItemTags.POSTBOXES.matches(player.getMainHandItem());
        boolean isWrench = AllTags.AllItemTags.WRENCH.matches(player.getMainHandItem());

        if (CreateFramedMod.matches(player.getMainHandItem(), CreateFramedMod.FROGPORTS)) {
            if (!isWrench) {
                if (activePackageTarget == null)
                    return;
                for (CreateFramedFrogports frogports : CreateFramedFrogports.values()) {
                    if (!frogports.getFrogport().isIn(player.getMainHandItem()) && !isPostbox)
                        return;
                }
            }
        }

    }
}
