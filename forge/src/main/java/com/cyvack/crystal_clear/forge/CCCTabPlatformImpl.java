package com.cyvack.crystal_clear.forge;

import com.cyvack.crystal_clear.common.CrystalClear;
import com.cyvack.crystal_clear.common.creative_tab.ItemVisibilityHandler;
import com.cyvack.crystal_clear.common.registry.CCCBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CCCTabPlatformImpl {

    private static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalClear.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CRYSTAL_CLEAR = REGISTER.register("crystal_clear_tan", () ->
            CreativeModeTab.builder()
                    .title(Component.literal("Crystal Clear"))
                    .icon(() -> CCCBlocks.GLASS_CASINGS.getCasing("copper").asItem().getDefaultInstance())
                    .withTabsBefore(AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .displayItems(ItemVisibilityHandler.DISPLAY_INSTANCE)
                    .build());

    public static void useBaseTab() {
        CrystalClear.getRegistrate().setCreativeTab(CRYSTAL_CLEAR);
    }

    public static void register() {
        REGISTER.register(CrystalClearForge.getBUS());
    }
}