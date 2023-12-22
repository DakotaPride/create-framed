package net.dakotapride.createframed.registry;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.dakotapride.createframed.CreateFramedMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("unused")
public class CreateFramedTabs {
    public static final CreativeModeTab CREATE_FRAMED = new Tab();

    public static class Tab extends CreativeModeTab {
        public Tab() {
            super(CreateFramedMod.ID + ".create_framed");
        }

        @Override
        public @NotNull ItemStack makeIcon() {
            return CreateFramedBlocks.RED_STAINED_TILED_GLASS_PANE.asStack();
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> items) {
            addItems(items, true);
            addBlocks(items);
            addItems(items, false);
        }

        protected Collection<RegistryEntry<Item>> registeredItems() {
            return CreateFramedMod.REGISTRATE.getAll(ForgeRegistries.ITEMS.getRegistryKey());
        }

        public void addBlocks(NonNullList<ItemStack> items) {
            for (RegistryEntry<Item> entry : registeredItems())
                if (entry.get() instanceof BlockItem blockItem)
                    blockItem.fillItemCategory(this, items);
        }

        public void addItems(NonNullList<ItemStack> items, boolean specialItems) {
            ItemRenderer itemRenderer = Minecraft.getInstance()
                    .getItemRenderer();

            for (RegistryEntry<Item> entry : registeredItems()) {
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                ItemStack stack = new ItemStack(item);
                BakedModel model = itemRenderer.getModel(stack, null, null, 0);
                if (model.isGui3d() == specialItems)
                    item.fillItemCategory(this, items);
            }
        }
    }

    public static void register() {}

}
