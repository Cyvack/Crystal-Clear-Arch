package com.cyvack.crystal_clear.common.registry;

import com.cyvack.crystal_clear.common.CCCRegistrate;
import com.cyvack.crystal_clear.common.CrystalClear;
import com.cyvack.crystal_clear.common.util.CasingTypes;
import com.cyvack.crystal_clear.common.util.GlassBlockList;
import com.cyvack.crystal_clear.common.content.blocks.GlassCasing;
import com.cyvack.crystal_clear.common.content.blocks.GlassEncasedCogwheel;
import com.cyvack.crystal_clear.common.content.blocks.GlassEncasedShaft;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.cyvack.crystal_clear.common.generation.RegistrateGenHelper.*;

public class CCCBlocks {

    //redo all of this
    public static CCCRegistrate REGISTRATE = CrystalClear.getRegistrate();

    public static final GlassBlockList<GlassCasing>
            GLASS_CASINGS = new GlassBlockList<>(CasingTypes.NORMAL_CASINGS.holders,
            (holder) -> glassCasing(REGISTRATE, holder, false)),
            CLEAR_GLASS = new GlassBlockList<>(CasingTypes.NORMAL_CASINGS.holders,
                    (holder) -> glassCasing(REGISTRATE, holder, true));

    public static GlassBlockList<GlassEncasedShaft>
            GLASS_ENCASED_SHAFTS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
            (holder) -> glassEncasedShaft(REGISTRATE, CrystalClear.MOD_ID, holder.name(), false, (p -> new GlassEncasedShaft(p, () -> GLASS_CASINGS.getCasing(holder.name()))))),

    CLEAR_GLASS_ENCASED_SHAFTS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
            (holder) -> glassEncasedShaft(REGISTRATE, CrystalClear.MOD_ID, holder.name(), true, (p -> new GlassEncasedShaft(p, () -> CLEAR_GLASS.getCasing(holder.name())))));

    public static final GlassBlockList<GlassEncasedCogwheel>
            SMALL_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
            (holder) -> glassEncasedCogwheel(REGISTRATE, CrystalClear.MOD_ID, holder.name(), false, false, (p -> new GlassEncasedCogwheel(p, false, () -> GLASS_CASINGS.getCasing(holder.name()))))),

    SMALL_CLEAR_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
            (holder) -> glassEncasedCogwheel(REGISTRATE, CrystalClear.MOD_ID, holder.name(), false, true, (p -> new GlassEncasedCogwheel(p, false, () -> CLEAR_GLASS.getCasing(holder.name()))))),

    LARGE_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
            (holder) -> glassEncasedCogwheel(REGISTRATE, CrystalClear.MOD_ID, holder.name(), true, false, (p -> new GlassEncasedCogwheel(p, true, () -> GLASS_CASINGS.getCasing(holder.name()))))),

    LARGE_CLEAR_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
            (holder) -> glassEncasedCogwheel(REGISTRATE, CrystalClear.MOD_ID, holder.name(), true, true, (p -> new GlassEncasedCogwheel(p, true, () -> CLEAR_GLASS.getCasing(holder.name())))));


    public static final BlockEntry<MetalScaffoldingBlock> ANDESITE_SCAFFOLD =
            glassScaffolding(REGISTRATE, CrystalClear.MOD_ID, "andesite", false, AllSpriteShifts.ANDESITE_SCAFFOLD, AllSpriteShifts.ANDESITE_SCAFFOLD_INSIDE, () -> AllBlocks.ANDESITE_SCAFFOLD, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> BRASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, CrystalClear.MOD_ID, "brass", false, AllSpriteShifts.BRASS_SCAFFOLD, AllSpriteShifts.BRASS_SCAFFOLD_INSIDE, () -> AllBlocks.BRASS_SCAFFOLD, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> COPPER_SCAFFOLD =
            glassScaffolding(REGISTRATE, CrystalClear.MOD_ID, "copper", false, AllSpriteShifts.COPPER_SCAFFOLD_INSIDE, AllSpriteShifts.COPPER_SCAFFOLD_INSIDE, () -> AllBlocks.COPPER_SCAFFOLD, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> CLEAR_ANDESITE_SCAFFOLD =
            glassScaffolding(REGISTRATE, CrystalClear.MOD_ID, "andesite", true, AllSpriteShifts.ANDESITE_SCAFFOLD, AllSpriteShifts.ANDESITE_SCAFFOLD_INSIDE, () -> ANDESITE_SCAFFOLD, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> CLEAR_BRASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, CrystalClear.MOD_ID, "brass", true, AllSpriteShifts.BRASS_SCAFFOLD, AllSpriteShifts.BRASS_SCAFFOLD_INSIDE, () -> BRASS_SCAFFOLD, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> CLEAR_COPPER_SCAFFOLD =
            glassScaffolding(REGISTRATE, CrystalClear.MOD_ID, "copper", true, AllSpriteShifts.COPPER_SCAFFOLD_INSIDE, AllSpriteShifts.COPPER_SCAFFOLD_INSIDE, () -> COPPER_SCAFFOLD, MetalScaffoldingBlock::new);

    public static void register() {
    }
}
