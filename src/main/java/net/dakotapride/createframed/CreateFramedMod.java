package net.dakotapride.createframed;

import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.dakotapride.createframed.event.FillCreateItemGroupEvent;
import net.dakotapride.createframed.registry.CreateFramedBlocks;
import net.dakotapride.createframed.registry.CreateFramedEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("createframed")
public class CreateFramedMod {
    // Directly reference a slf4j logger
    public static final String ID = "createframed";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }

    public CreateFramedMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        REGISTRATE.registerEventListeners(bus);

        CreateFramedBlocks.register();
        CreateFramedEntityTypes.register();
        forgeBus.addListener(this::fillCreativeItemGroup);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void fillCreativeItemGroup(FillCreateItemGroupEvent event) {
        if(event.getItemGroup() == AllCreativeModeTabs.PALETTES_CREATIVE_TAB) {
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.RED_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.RED_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.ORANGE_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.ORANGE_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.YELLOW_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.YELLOW_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.GREEN_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.GREEN_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.BLUE_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.BLUE_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.LIGHT_BLUE_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.LIGHT_BLUE_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.CYAN_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.CYAN_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.PURPLE_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.PURPLE_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.MAGENTA_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.MAGENTA_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.PINK_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.PINK_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.BLACK_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.BLACK_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.GRAY_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.GRAY_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.LIGHT_GRAY_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.LIGHT_GRAY_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.WHITE_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.WHITE_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.BROWN_STAINED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.BROWN_STAINED_FRAMED_GLASS_TRAPDOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_DOOR.get(), CreateFramedBlocks.TINTED_FRAMED_GLASS_DOOR.asStack());
            event.addInsertion(AllBlocks.FRAMED_GLASS_TRAPDOOR.get(), CreateFramedBlocks.TINTED_FRAMED_GLASS_TRAPDOOR.asStack());

            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.RED_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.RED_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.ORANGE_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.ORANGE_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.YELLOW_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.YELLOW_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.GREEN_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.GREEN_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.LIME_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.LIME_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.BLUE_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.BLUE_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.CYAN_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.CYAN_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.PURPLE_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.PURPLE_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.MAGENTA_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.PINK_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.PINK_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.BLACK_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.BLACK_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.GRAY_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.GRAY_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.WHITE_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.WHITE_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.BROWN_STAINED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.BROWN_STAINED_TILED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS.get(), CreateFramedBlocks.TINTED_TILED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.TILED_GLASS_PANE.get(), CreateFramedBlocks.TINTED_TILED_GLASS_PANE.asStack());

            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.RED_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.RED_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.ORANGE_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.ORANGE_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.YELLOW_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.YELLOW_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.GREEN_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.GREEN_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.LIME_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.LIME_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.BLUE_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.BLUE_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.LIGHT_BLUE_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.LIGHT_BLUE_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.CYAN_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.CYAN_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.PURPLE_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.PURPLE_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.MAGENTA_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.MAGENTA_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.PINK_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.PINK_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.BLACK_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.BLACK_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.GRAY_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.GRAY_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.LIGHT_GRAY_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.LIGHT_GRAY_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.WHITE_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.WHITE_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.BROWN_STAINED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.BROWN_STAINED_FRAMED_GLASS_PANE.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS.get(), CreateFramedBlocks.TINTED_FRAMED_GLASS.asStack());
            event.addInsertion(AllPaletteBlocks.FRAMED_GLASS_PANE.get(), CreateFramedBlocks.TINTED_FRAMED_GLASS_PANE.asStack());
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // Some example code to dispatch IMC to another mod
        // InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // Some example code to receive and process InterModComms from other mods
        // LOGGER.info("Got IMC {}", event.getIMCStream().
        //        map(m->m.messageSupplier().get()).
        //        collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
}
