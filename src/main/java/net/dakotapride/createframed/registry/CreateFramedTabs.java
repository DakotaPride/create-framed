package net.dakotapride.createframed.registry;

import net.dakotapride.createframed.CreateFramedMod;
import net.dakotapride.createframed.compat.AlexsCavesModule;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("unused")
public class CreateFramedTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateFramedMod.ID);

    public static final RegistryObject<CreativeModeTab> CREATE_FRAMED = REGISTER.register("createframed",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.createframed.create_framed"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(CreateFramedBlocks.RED.getTiledGlassPane()::asStack)
                    .displayItems(new ItemsGenerator())
                    .build());

    public static class ItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        @Override
        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters p, CreativeModeTab.Output o) {
            // Alex's Caves
            if (ModList.get().isLoaded("alexscaves") || !FMLLoader.isProduction()) {
                for (AlexsCavesModule module : AlexsCavesModule.values()) {
                    o.accept(module.getGlassBlock());
                }
            }

            for (CreateFramedWindows windows : CreateFramedWindows.values()) {
                o.accept(windows.getWindowBlock());
                o.accept(windows.getWindowPaneBlock());
            }

            for (CreateFramedBlocks blocks : CreateFramedBlocks.values()) {
                if (blocks != CreateFramedBlocks.TINTED) {
                    o.accept(blocks.getGlassDoorBlock());
                    o.accept(blocks.getGlassTrapdoorBlock());
                    o.accept(blocks.getTiledGlassBlock());
                    o.accept(blocks.getTiledGlassPane());
                    o.accept(blocks.getGlassBlock());
                    o.accept(blocks.getGlassPane());
                    o.accept(blocks.getHorizontalGlassBlock());
                    o.accept(blocks.getHorizontalGlassPane());
                    o.accept(blocks.getVerticalGlassBlock());
                    o.accept(blocks.getVerticalGlassPane());
                }
            }

            o.accept(CreateFramedBlocks.TINTED.getTintedGlassDoor());
            o.accept(CreateFramedBlocks.TINTED.getTintedGlassTrapoor());
            o.accept(CreateFramedBlocks.TINTED.getTintedTiledGlass());
            o.accept(CreateFramedBlocks.TINTED.getTintedTiledGlassPane());
            o.accept(CreateFramedBlocks.TINTED.getTintedGlass());
            o.accept(CreateFramedBlocks.TINTED.getTintedGlassPane());
            o.accept(CreateFramedBlocks.TINTED.getHorizontalTintedGlass());
            o.accept(CreateFramedBlocks.TINTED.getHorizontalTintedGlassPane());
            o.accept(CreateFramedBlocks.TINTED.getVerticalTintedGlass());
            o.accept(CreateFramedBlocks.TINTED.getVerticalTintedGlassPane());


            for (CreateFramedBlocks blocks : CreateFramedBlocks.values())
                if (blocks != CreateFramedBlocks.TINTED) {
                    o.accept(blocks.getCardboardBlock());
                    o.accept(blocks.getBoundCardboardBlock());
                }

            o.accept(MiscBlocks.KARPBOARD_BLOCK.asItem());
            o.accept(MiscBlocks.SHINY_KARPBOARD_BLOCK.asItem());
            for (CreateFramedPackageStyles.Items items : CreateFramedPackageStyles.Items.values())
                o.accept(items.getPackageItem());
        }
    }

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }
}
