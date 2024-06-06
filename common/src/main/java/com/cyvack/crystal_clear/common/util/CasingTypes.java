package com.cyvack.crystal_clear.common.util;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.CasingBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.cyvack.crystal_clear.common.util.CasingHolder.of;

public enum CasingTypes {

    NORMAL_CASINGS( of("andesite", AllBlocks.ANDESITE_CASING), of("brass", AllBlocks.BRASS_CASING), of("copper", AllBlocks.COPPER_CASING), of("train", AllBlocks.RAILWAY_CASING)),

    SCAFFOLDING(of("andesite", AllBlocks.ANDESITE_CASING), of("brass", AllBlocks.BRASS_CASING), of("copper", AllBlocks.COPPER_CASING)),

    GENERAL_ENCASED(of("andesite", AllBlocks.ANDESITE_CASING), of("brass", AllBlocks.BRASS_CASING), of("train", AllBlocks.RAILWAY_CASING));

    public final List<String> names = new ArrayList<>();

    public final List<Supplier<CasingBlock>> casings = new ArrayList<>();

    public final List<CasingHolder> holders = new ArrayList<>();

    CasingTypes(CasingHolder... names) {
        for (CasingHolder holder : names) {
            casings.add(holder.casing());
            this.names.add(holder.name());
        }

        holders.addAll(List.of(names));
    }
}
