package com.cyvack.crystal_clear.common;

import com.cyvack.crystal_clear.CCCPlatform;
import com.cyvack.crystal_clear.CCCTabPlatform;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class CrystalClear {

    public static final String MOD_ID = "crystal_clear";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        CCCTabPlatform.useBaseTab();
        ModSetup.register();
        finishRegistrate();
    }

    public static <T extends CCCRegistrate> T getRegistrate() {
        return CCCPlatform.getRegistrate();
    }

    public static void finishRegistrate() {
        CCCPlatform.finishRegistrate();
    }

    public static ResourceLocation path(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}