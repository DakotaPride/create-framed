package net.dakotapride.createframed.mixin;

import com.simibubi.create.infrastructure.item.CreateCreativeModeTab;
import net.dakotapride.createframed.event.FillCreateItemGroupEvent;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Credit to Create: Enchantment Industry
// Development Team
//
// CreateCreativeModeTabMixin.java

@Mixin(CreateCreativeModeTab.class)
public class CreateCreativeModeTabMixin {

    @Inject(method = "fillItemList", at = @At("TAIL"))
    private void postFillCreateItemGroupEvent(NonNullList<ItemStack> items, CallbackInfo ci) {
        var event = new FillCreateItemGroupEvent((CreateCreativeModeTab) (Object) this, items);
        MinecraftForge.EVENT_BUS.post(event);
        event.apply();
    }

}
