package net.dakotapride.createframed.registry;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.logistics.box.PackageItem;
import com.simibubi.create.content.logistics.box.PackageStyles;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dakotapride.createframed.CreateFramedMod;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;

import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

public class CreateFramedPackageStyles {

    public enum Items {
        RED(),
        ORANGE(),
        YELLOW(),
        GREEN(),
        LIME(),
        BLUE(),
        LIGHT_BLUE(),
        CYAN(),
        PURPLE(),
        MAGENTA(),
        PINK(),
        BLACK(),
        GRAY(),
        LIGHT_GRAY(),
        WHITE(),
        BROWN(),
        KARPBOARD(12, 12, 23, true),
        FORDALELS(),
        AXOLOTL_LUCY(),



        ;

        public final ItemEntry<PackageItem> package_item;
        public int width;
        public int height;
        public float offset;
        public boolean rare;

        Items(int w, int h, float o, boolean r) {
            String name = name().toLowerCase(Locale.ROOT);
            package_item = REGISTRATE
                    .item(name + "_package", prop -> new PackageItem(prop,
                            new PackageStyles.PackageStyle(name, w, h, o, r)))
                    .properties(prop -> prop.stacksTo(1))
                    .register();
        }

        Items() {
            String name = name().toLowerCase(Locale.ROOT);
            package_item = REGISTRATE
                    .item(name + "_package", prop -> new PackageItem(prop,
                            new PackageStyles.PackageStyle(name, 10, 8, 18, true)))
                    .properties(prop -> prop.stacksTo(1))
                    .register();
        }

        public ItemEntry<PackageItem> getPackageItem() {
            return package_item;
        }

        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }

        public static void register() {
            CreateFramedPackageStyles.register();
        }
    }

    public static void register() {
        for (Items items : Items.values())
            registerPackageModel(items.getPackageItem().getId(), CreateFramedMod.asResource(items.getName()), items.width, items.height);
    }

    public static void registerPackageModel(ResourceLocation id, ResourceLocation id2, int width, int height) {
        AllPartialModels.PACKAGES.put(id, PartialModel.of(id2.withPrefix("item/package/")));
        AllPartialModels.PACKAGE_RIGGING.put(id, PartialModel.of(id2.withPrefix("item/package/rigging/")));
    }
}
