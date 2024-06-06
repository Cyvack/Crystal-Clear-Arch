package com.cyvack.crystal_clear.common.util;

import com.simibubi.create.content.decoration.encasing.CasingBlock;

import java.util.function.Supplier;

public record CasingHolder(String name, Supplier<CasingBlock> casing) {
    public static CasingHolder of(String name, Supplier<CasingBlock> casing) {
        return new CasingHolder(name, casing);
    }
}
