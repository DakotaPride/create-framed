package net.dakotapride.createframed.registry;

import com.simibubi.create.content.logistics.packagePort.PackagePortItem;
import com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlock;
import com.simibubi.create.content.logistics.packagePort.frogport.FrogportVisual;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.dakotapride.createframed.block.frogport.colour.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

public enum CreateFramedFrogports {
    RED(MapColor.COLOR_RED, RedFrogportBlock::new),
    ORANGE(MapColor.COLOR_ORANGE, OrangeFrogportBlock::new),
    YELLOW(MapColor.COLOR_YELLOW, YellowFrogportBlock::new),
    GREEN(MapColor.COLOR_GREEN, GreenFrogportBlock::new),
    BLUE(MapColor.COLOR_BLUE, BlueFrogportBlock::new),
    PURPLE(MapColor.COLOR_PURPLE, PurpleFrogportBlock::new),


    ;

    public final BlockEntry<FrogportBlock> frogport;

    CreateFramedFrogports(MapColor color, NonNullFunction<BlockBehaviour.Properties, FrogportBlock> block) {
        String id = name().toLowerCase(Locale.ROOT);

        frogport = REGISTRATE.block(id + "_package_frogport", block)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.mapColor(color).sound(SoundType.NETHERITE_BLOCK).noOcclusion())
                .addLayer(() -> RenderType::cutoutMipped)
                .item(PackagePortItem::new).build()
                .register();
    }

    public BlockEntry<FrogportBlock> getFrogport() {
        return frogport;
    }

    public static void register() {}
}
