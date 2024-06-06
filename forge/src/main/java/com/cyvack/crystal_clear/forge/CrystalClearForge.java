package com.cyvack.crystal_clear.forge;

import com.cyvack.crystal_clear.common.CrystalClear;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.cyvack.crystal_clear.common.CrystalClear.*;

@Mod(MOD_ID)
public class CrystalClearForge {

    public static final CCCRegistrateForge REGISTRATE = new CCCRegistrateForge(CrystalClear.MOD_ID);
    private static IEventBus BUS;

    public CrystalClearForge() {
        BUS = FMLJavaModLoadingContext.get().getModEventBus();
        CrystalClear.init();
    }

    public static IEventBus getBUS() {
        return BUS;
    }
}
