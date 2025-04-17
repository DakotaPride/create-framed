package net.dakotapride.createframed.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlock;
import net.dakotapride.createframed.CreateFramedMod;
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

@Mixin(value = ChainConveyorBlock.class, remap = false)
public abstract class ChainConveyorBlockMixin {

    @Inject(method = "useItemOn", at = @At("HEAD"), cancellable = true)
    private void useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                           Player player, InteractionHand hand, BlockHitResult hitResult,
                           CallbackInfoReturnable<ItemInteractionResult> cir) {
        for (CreateFramedFrogports frogports : CreateFramedFrogports.values()) {
            if (frogports.getFrogport().isIn(stack))
                cir.setReturnValue(ItemInteractionResult.SUCCESS);
        }
    }
}
