package net.dakotapride.createframed;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.dakotapride.createframed.registry.CreateFramedBlocks;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.dakotapride.createframed.registry.CreateFramedPackageStyles;
import net.dakotapride.createframed.registry.CreateFramedTabs;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateFramedMod.ID)
public class CreateFramedMod {
    // Directly reference a slf4j logger
    public static final String ID = "createframed";
    public static final Logger LOGGER = LogUtils.getLogger();
    //public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }

    public static boolean matches(ItemStack stack, TagKey<Item> tag) {
        return stack.is(tag);
    }

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                .andThen(TooltipModifier.mapNull(KineticStats.create(item))));
    }

    public CreateFramedMod(IEventBus bus, ModContainer modContainer) {
        //ModLoadingContext modLoadingContext = ModLoadingContext.get();

        //IEventBus bus = NeoForge.EVENT_BUS;

        REGISTRATE.registerEventListeners(bus);

        CreateFramedBlocks.register();
        CreateFramedPackageStyles.Items.register();
        CreateFramedEntityTypes.register();
        CreateFramedTabs.register(bus);

        // Register ourselves for server and other game events we are interested in
        //NeoForge.EVENT_BUS.register(this);
    }

    @EventBusSubscriber(modid = CreateFramedMod.ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientEvents {
        @SubscribeEvent
        public static void client(FMLClientSetupEvent event) {
            CreateFramedPackageStyles.register();
        }
    }

}
