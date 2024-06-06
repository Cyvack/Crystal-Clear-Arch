package com.cyvack.crystal_clear;

import com.cyvack.crystal_clear.common.CCCRegistrate;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class CCCPlatform {
    @ExpectPlatform
    public static <T extends CCCRegistrate> T getRegistrate() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void finishRegistrate() {
        throw new AssertionError();
    }
}
