package net.dakotapride.createframed.mixin;

import com.simibubi.create.content.logistics.packager.PackagerBlock;
import net.dakotapride.createframed.registry.CreateFramedFrogports;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PackagerBlock.class, remap = false)
public abstract class PackagerBlockMixin {
    @Inject(method = "useItemOn", at = @At("HEAD"), cancellable = true)
    private void useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                           Player player, InteractionHand hand, BlockHitResult hitResult,
                           CallbackInfoReturnable<ItemInteractionResult> cir) {
        for (CreateFramedFrogports frogports : CreateFramedFrogports.values()) {
            if (frogports.getFrogport().is(stack))
                cir.setReturnValue(ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION);
        }
    }
}
