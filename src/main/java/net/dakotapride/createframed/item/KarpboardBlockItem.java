package net.dakotapride.createframed.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class KarpboardBlockItem extends BlockItem {
    boolean shiny;
    public KarpboardBlockItem(Block pBlock, boolean shiny, Properties pProperties) {
        super(pBlock, pProperties);
        this.shiny = shiny;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return shiny ? 8000 : 4000;
    }
}
