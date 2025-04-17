package net.dakotapride.createframed.registry;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dakotapride.createframed.CreateFramedMod;

public class CreateFramedPartialModels {
    public static final PartialModel
            RED_FROGPORT_BODY = block("package_frogport/body/red"),
            RED_FROGPORT_HEAD = block("package_frogport/head/red"),
            RED_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/red");
    public static final PartialModel
            ORANGE_FROGPORT_BODY = block("package_frogport/body/orange"),
            ORANGE_FROGPORT_HEAD = block("package_frogport/head/orange"),
            ORANGE_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/orange");
    public static final PartialModel
            YELLOW_FROGPORT_BODY = block("package_frogport/body/yellow"),
            YELLOW_FROGPORT_HEAD = block("package_frogport/head/yellow"),
            YELLOW_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/yellow");
    public static final PartialModel
            GREEN_FROGPORT_BODY = block("package_frogport/body/green"),
            GREEN_FROGPORT_HEAD = block("package_frogport/head/green"),
            GREEN_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/green");
    public static final PartialModel
            LIME_FROGPORT_BODY = block("package_frogport/body/lime"),
            LIME_FROGPORT_HEAD = block("package_frogport/head/lime"),
            LIME_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/lime");
    public static final PartialModel
            BLUE_FROGPORT_BODY = block("package_frogport/body/blue"),
            BLUE_FROGPORT_HEAD = block("package_frogport/head/blue"),
            BLUE_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/blue");
    public static final PartialModel
            LIGHT_BLUE_FROGPORT_BODY = block("package_frogport/body/light_blue"),
            LIGHT_BLUE_FROGPORT_HEAD = block("package_frogport/head/light_blue"),
            LIGHT_BLUE_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/light_blue");
    public static final PartialModel
            CYAN_FROGPORT_BODY = block("package_frogport/body/cyan"),
            CYAN_FROGPORT_HEAD = block("package_frogport/head/cyan"),
            CYAN_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/cyan");
    public static final PartialModel
            PURPLE_FROGPORT_BODY = block("package_frogport/body/purple"),
            PURPLE_FROGPORT_HEAD = block("package_frogport/head/purple"),
            PURPLE_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/purple");
    public static final PartialModel
            MAGENTA_FROGPORT_BODY = block("package_frogport/body/magenta"),
            MAGENTA_FROGPORT_HEAD = block("package_frogport/head/magenta"),
            MAGENTA_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/magenta");
    public static final PartialModel
            PINK_FROGPORT_BODY = block("package_frogport/body/pink"),
            PINK_FROGPORT_HEAD = block("package_frogport/head/pink"),
            PINK_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/pink");
    public static final PartialModel
            BLACK_FROGPORT_BODY = block("package_frogport/body/black"),
            BLACK_FROGPORT_HEAD = block("package_frogport/head/black"),
            BLACK_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/black");
    public static final PartialModel
            GRAY_FROGPORT_BODY = block("package_frogport/body/gray"),
            GRAY_FROGPORT_HEAD = block("package_frogport/head/gray"),
            GRAY_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/gray");
    public static final PartialModel
            LIGHT_GRAY_FROGPORT_BODY = block("package_frogport/body/light_gray"),
            LIGHT_GRAY_FROGPORT_HEAD = block("package_frogport/head/light_gray"),
            LIGHT_GRAY_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/light_gray");
    public static final PartialModel
            WHITE_FROGPORT_BODY = block("package_frogport/body/white"),
            WHITE_FROGPORT_HEAD = block("package_frogport/head/white"),
            WHITE_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/white");
    public static final PartialModel
            BROWN_FROGPORT_BODY = block("package_frogport/body/brown"),
            BROWN_FROGPORT_HEAD = block("package_frogport/head/brown"),
            BROWN_FROGPORT_HEAD_GOGGLES = block("package_frogport/head_goggles/brown");

    private static PartialModel block(String path) {
        return PartialModel.of(CreateFramedMod.asResource("block/" + path));
    }

    public static void register() {}
}
