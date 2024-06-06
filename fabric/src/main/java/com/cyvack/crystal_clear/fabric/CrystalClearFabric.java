package com.cyvack.crystal_clear.fabric;

import com.cyvack.crystal_clear.common.CrystalClear;
import com.cyvack.crystal_clear.fabric.events.EncasingRegistryFixerEvent;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;

public class CrystalClearFabric implements ModInitializer {
    public static final CCCRegistrateFabric REGISTRATE = new CCCRegistrateFabric(CrystalClear.MOD_ID);

    @Override
    public void onInitialize() {
        CrystalClear.init();

        EncasingRegistryFixerEvent.register(BuiltInRegistries.BLOCK);
    }
}
