package net.dakotapride.createframed.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.createframed.block.KarpboardBlock;
import net.dakotapride.createframed.item.KarpboardBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static net.dakotapride.createframed.CreateFramedMod.REGISTRATE;

public class MiscBlocks {

    public static BlockEntry<KarpboardBlock> KARPBOARD_BLOCK = REGISTRATE.block("karpboard_block", KarpboardBlock::new)
            .initialProperties(() -> Blocks.MUSHROOM_STEM)
            .properties(p -> p
                    .sound(SoundType.CHISELED_BOOKSHELF)
                    .ignitedByLava()
                    .mapColor(MapColor.COLOR_RED))
            .item((b, p) -> new KarpboardBlockItem(b, false, p))
            .build()
            .register();
    public static BlockEntry<KarpboardBlock> SHINY_KARPBOARD_BLOCK = REGISTRATE.block("shiny_karpboard_block", KarpboardBlock::new)
            .initialProperties(() -> Blocks.MUSHROOM_STEM)
            .properties(p -> p
                    .sound(SoundType.CHISELED_BOOKSHELF)
                    .ignitedByLava()
                    .mapColor(MapColor.COLOR_YELLOW))
            .item((b, p) -> new KarpboardBlockItem(b, true, p))
            .build()
            .register();

    public static void register() {}
}
