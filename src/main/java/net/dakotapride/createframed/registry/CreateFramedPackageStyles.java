package net.dakotapride.createframed.registry;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.Create;
import com.simibubi.create.content.logistics.box.PackageItem;
import com.simibubi.create.content.logistics.box.PackageStyles;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dakotapride.createframed.CreateFramedMod;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.loading.LoadingModList;

import java.util.Locale;

import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

public class CreateFramedPackageStyles {

    public enum Items {
        RED(false),
        ORANGE(false),
        YELLOW(false),
        GREEN(false),
        LIME(false),
        BLUE(false),
        LIGHT_BLUE(false),
        CYAN(false),
        PURPLE(false),
        MAGENTA(false),
        PINK(false),
        BLACK(false),
        GRAY(false),
        LIGHT_GRAY(false),
        WHITE(false),
        BROWN(false),
        KARPBOARD(12, 12, 23, true, false),
        FORDALELS(false),
        AXOLOTL_LUCY(false),

        MAROON(true),
        ROSE(true),
        CORAL(true),
        INDIGO(true),
        NAVY(true),
        SLATE(true),
        OLIVE(true),
        AMBER(true),
        BEIGE(true),
        TEAL(true),
        MINT(true),
        AQUA(true),
        VERDANT(true),
        FOREST(true),
        GINGER(true),
        TAN(true),



        ;

        public final ItemEntry<PackageItem> package_item;
        public final int width;
        public final int height;
        public final boolean fromDyeDepot;

        Items(int w, int h, float o, boolean r, boolean fromDyeDepot) {
            String name = name().toLowerCase(Locale.ROOT);
            width = w;
            height = h;
            if (fromDyeDepot) {
                if (LoadingModList.get().getModFileById("dye_depot") != null)
                    package_item = REGISTRATE
                            .item(name + "_package", prop -> new PackageItem(prop,
                                    new PackageStyles.PackageStyle(name, w, h, o, r)))
                            .properties(prop -> prop.stacksTo(1))
                            .register();
                else package_item = null;
            } else {
                package_item = REGISTRATE
                        .item(name + "_package", prop -> new PackageItem(prop,
                                new PackageStyles.PackageStyle(name, w, h, o, r)))
                        .properties(prop -> prop.stacksTo(1))
                        .register();
            }
            this.fromDyeDepot = fromDyeDepot;
        }

        Items(boolean fromDyeDepot) {
            String name = name().toLowerCase(Locale.ROOT);
            width = 10;
            height = 8;
            if (fromDyeDepot) {
                if (LoadingModList.get().getModFileById("dye_depot") != null)
                    package_item = REGISTRATE
                            .item(name + "_package", prop -> new PackageItem(prop,
                                    new PackageStyles.PackageStyle(name, width, height, 18, true)))
                            .properties(prop -> prop.stacksTo(1))
                            .register();
                else package_item = null;
            } else {
                package_item = REGISTRATE
                        .item(name + "_package", prop -> new PackageItem(prop,
                                new PackageStyles.PackageStyle(name, width, height, 18, true)))
                        .properties(prop -> prop.stacksTo(1))
                        .register();
            }
            this.fromDyeDepot = fromDyeDepot;
        }

        public boolean isFromDyeDepot() {
            return fromDyeDepot;
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
        for (Items items : Items.values()) {
            if (items.getPackageItem() != null) {
                if (items.isFromDyeDepot())
                    registerPackageModelFromDyeDepot(items.getPackageItem().getId(), items.width, items.height);
                else
                    registerPackageModel(items.getPackageItem().getId(), items.width, items.height);
            }
        }
    }

    public static void registerPackageModel(ResourceLocation id, int width, int height) {
        AllPartialModels.PACKAGES.put(id, PartialModel.of(id.withPrefix("item/")));
        AllPartialModels.PACKAGE_RIGGING.put(id, PartialModel.of(Create.asResource("item/package/rigging_" + width + "x" + height)));
    }

    public static void registerPackageModelFromDyeDepot(ResourceLocation id, int width, int height) {
        if (LoadingModList.get().getModFileById("dye_depot") != null) {
            AllPartialModels.PACKAGES.put(id, PartialModel.of(id.withPrefix("item/")));
            AllPartialModels.PACKAGE_RIGGING.put(id, PartialModel.of(Create.asResource("item/package/rigging_" + width + "x" + height)));
        }
    }
}
