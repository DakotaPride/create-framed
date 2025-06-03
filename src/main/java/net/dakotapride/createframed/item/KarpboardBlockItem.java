package net.dakotapride.createframed.item;

import com.simibubi.create.content.decoration.CardboardBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class KarpboardBlockItem extends CardboardBlockItem {
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
