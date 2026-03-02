package net.dakotapride.createframed.registry;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.Create;
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
        public final int width;
        public final int height;

        Items(int w, int h, float o, boolean r) {
            String name = name().toLowerCase(Locale.ROOT);
            width = w;
            height = h;
            package_item = REGISTRATE
                    .item(name + "_package", prop -> new PackageItem(prop,
                            new PackageStyles.PackageStyle(name, w, h, o, r)))
                    .properties(prop -> prop.stacksTo(1))
                    .register();
        }

        Items() {
            String name = name().toLowerCase(Locale.ROOT);
            width = 10;
            height = 8;
            package_item = REGISTRATE
                    .item(name + "_package", prop -> new PackageItem(prop,
                            new PackageStyles.PackageStyle(name, width, height, 18, true)))
                    .properties(prop -> prop.stacksTo(1))
                    .register();
        }

        public ItemEntry<PackageItem> getPackageItem() {
            return package_item;
        }

        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }

        public static void register() {}
    }

    public static void register() {
        for (Items items : Items.values())
            registerPackageModel(items.getPackageItem().getId(), items.width, items.height);
    }

    public static void registerPackageModel(ResourceLocation id, int width, int height) {
        AllPartialModels.PACKAGES.put(id, PartialModel.of(id.withPrefix("item/")));
        AllPartialModels.PACKAGE_RIGGING.put(id, PartialModel.of(Create.asResource("item/package/rigging_" + width + "x" + height)));
    }
}
