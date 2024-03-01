package net.dakotapride.createframed.registry;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import net.dakotapride.createframed.CreateFramedMod;

public class CreateFramedSpriteShifts {
    public static final CTSpriteShiftEntry
        RED_STAINED_FRAMED_GLASS = omni("red_stained_framed_glass"),
        ORANGE_STAINED_FRAMED_GLASS = omni("orange_stained_framed_glass"),
        YELLOW_STAINED_FRAMED_GLASS = omni("yellow_stained_framed_glass"),
        GREEN_STAINED_FRAMED_GLASS = omni("green_stained_framed_glass"),
        LIME_STAINED_FRAMED_GLASS = omni("lime_stained_framed_glass"),
        BLUE_STAINED_FRAMED_GLASS = omni("blue_stained_framed_glass"),
        LIGHT_BLUE_STAINED_FRAMED_GLASS = omni("light_blue_stained_framed_glass"),
        CYAN_STAINED_FRAMED_GLASS = omni("cyan_stained_framed_glass"),
        PURPLE_STAINED_FRAMED_GLASS = omni("purple_stained_framed_glass"),
        MAGENTA_STAINED_FRAMED_GLASS = omni("magenta_stained_framed_glass"),
        PINK_STAINED_FRAMED_GLASS = omni("pink_stained_framed_glass"),
        BLACK_STAINED_FRAMED_GLASS = omni("black_stained_framed_glass"),
        GRAY_STAINED_FRAMED_GLASS = omni("gray_stained_framed_glass"),
        LIGHT_GRAY_STAINED_FRAMED_GLASS = omni("light_gray_stained_framed_glass"),
        WHITE_STAINED_FRAMED_GLASS = omni("white_stained_framed_glass"),
        BROWN_STAINED_FRAMED_GLASS = omni("brown_stained_framed_glass"),
        TINTED_FRAMED_GLASS = omni("tinted_framed_glass");
    public static final CTSpriteShiftEntry
            HORIZONTAL_RED_STAINED_FRAMED_GLASS = horizontal("red_stained_framed_glass"),
            HORIZONTAL_ORANGE_STAINED_FRAMED_GLASS = horizontal("orange_stained_framed_glass"),
            HORIZONTAL_YELLOW_STAINED_FRAMED_GLASS = horizontal("yellow_stained_framed_glass"),
            HORIZONTAL_GREEN_STAINED_FRAMED_GLASS = horizontal("green_stained_framed_glass"),
            HORIZONTAL_LIME_STAINED_FRAMED_GLASS = horizontal("lime_stained_framed_glass"),
            HORIZONTAL_BLUE_STAINED_FRAMED_GLASS = horizontal("blue_stained_framed_glass"),
            HORIZONTAL_LIGHT_BLUE_STAINED_FRAMED_GLASS = horizontal("light_blue_stained_framed_glass"),
            HORIZONTAL_CYAN_STAINED_FRAMED_GLASS = horizontal("cyan_stained_framed_glass"),
            HORIZONTAL_PURPLE_STAINED_FRAMED_GLASS = horizontal("purple_stained_framed_glass"),
            HORIZONTAL_MAGENTA_STAINED_FRAMED_GLASS = horizontal("magenta_stained_framed_glass"),
            HORIZONTAL_PINK_STAINED_FRAMED_GLASS = horizontal("pink_stained_framed_glass"),
            HORIZONTAL_BLACK_STAINED_FRAMED_GLASS = horizontal("black_stained_framed_glass"),
            HORIZONTAL_GRAY_STAINED_FRAMED_GLASS = horizontal("gray_stained_framed_glass"),
            HORIZONTAL_LIGHT_GRAY_STAINED_FRAMED_GLASS = horizontal("light_gray_stained_framed_glass"),
            HORIZONTAL_WHITE_STAINED_FRAMED_GLASS = horizontal("white_stained_framed_glass"),
            HORIZONTAL_BROWN_STAINED_FRAMED_GLASS = horizontal("brown_stained_framed_glass"),
            HORIZONTAL_TINTED_FRAMED_GLASS = horizontal("tinted_framed_glass");
    public static final CTSpriteShiftEntry
            VERTICAL_RED_STAINED_FRAMED_GLASS = vertical("red_stained_framed_glass"),
            VERTICAL_ORANGE_STAINED_FRAMED_GLASS = vertical("orange_stained_framed_glass"),
            VERTICAL_YELLOW_STAINED_FRAMED_GLASS = vertical("yellow_stained_framed_glass"),
            VERTICAL_GREEN_STAINED_FRAMED_GLASS = vertical("green_stained_framed_glass"),
            VERTICAL_LIME_STAINED_FRAMED_GLASS = vertical("lime_stained_framed_glass"),
            VERTICAL_BLUE_STAINED_FRAMED_GLASS = vertical("blue_stained_framed_glass"),
            VERTICAL_LIGHT_BLUE_STAINED_FRAMED_GLASS = vertical("light_blue_stained_framed_glass"),
            VERTICAL_CYAN_STAINED_FRAMED_GLASS = vertical("cyan_stained_framed_glass"),
            VERTICAL_PURPLE_STAINED_FRAMED_GLASS = vertical("purple_stained_framed_glass"),
            VERTICAL_MAGENTA_STAINED_FRAMED_GLASS = vertical("magenta_stained_framed_glass"),
            VERTICAL_PINK_STAINED_FRAMED_GLASS = vertical("pink_stained_framed_glass"),
            VERTICAL_BLACK_STAINED_FRAMED_GLASS = vertical("black_stained_framed_glass"),
            VERTICAL_GRAY_STAINED_FRAMED_GLASS = vertical("gray_stained_framed_glass"),
            VERTICAL_LIGHT_GRAY_STAINED_FRAMED_GLASS = vertical("light_gray_stained_framed_glass"),
            VERTICAL_WHITE_STAINED_FRAMED_GLASS = vertical("white_stained_framed_glass"),
            VERTICAL_BROWN_STAINED_FRAMED_GLASS = vertical("brown_stained_framed_glass"),
            VERTICAL_TINTED_FRAMED_GLASS = vertical("tinted_framed_glass");

    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name, name);
    }

    private static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL_KRYPPERS, name, "horizontal_" + name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name, "vertical_" + name);
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, CreateFramedMod.asResource("block/" + blockTextureName), CreateFramedMod.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }
}
