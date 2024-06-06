package com.cyvack.crystal_clear.common;

import com.cyvack.crystal_clear.CCCTabPlatform;
import com.cyvack.crystal_clear.common.registry.CCCBlockEntities;
import com.cyvack.crystal_clear.common.registry.CCCBlocks;
import com.cyvack.crystal_clear.common.registry.CCSpriteShifts;

public class ModSetup {
    public static void register() {
        CCSpriteShifts.populateMaps();

        CCCTabPlatform.register();
        CCCBlocks.register();
        CCCBlockEntities.register();
    }
}
