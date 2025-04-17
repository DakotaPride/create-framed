package net.dakotapride.createframed.registry;

import com.simibubi.create.Create;
import com.simibubi.create.infrastructure.ponder.scenes.highLogistics.FrogAndConveyorScenes;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CreateFramedPonderScenes {

    public static class UtiliseBaseCreatePonderScenePlugin implements PonderPlugin {
        @Override
        public @NotNull String getModId() {
            return Create.ID;
        }

        @Override
        public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
            register(helper);
        }
    }

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        for (CreateFramedFrogports frogports : CreateFramedFrogports.values()) {
            HELPER.forComponents(frogports.getFrogport())
                    .addStoryBoard("high_logistics/package_frogport", FrogAndConveyorScenes::frogPort);
        }
    }
}
