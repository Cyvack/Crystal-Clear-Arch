package com.cyvack.crystal_clear.fabric;

import com.cyvack.crystal_clear.common.CrystalClear;
import com.cyvack.crystal_clear.common.creative_tab.ItemVisibilityHandler;
import com.cyvack.crystal_clear.common.registry.CCCBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class CCCTabPlatformImpl {

    private static final ResourceKey<CreativeModeTab> MAIN_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, CrystalClear.path("crystal_clear"));

    private static final CreativeModeTab MAIN_TAB = registerTab(FabricItemGroup.builder()
            .title(Component.literal("Crystal Clear"))
            .icon(() -> CCCBlocks.GLASS_CASINGS.getCasing("copper").asItem().getDefaultInstance())
            .displayItems(ItemVisibilityHandler.DISPLAY_INSTANCE)
            .build());

    public static CreativeModeTab registerTab(CreativeModeTab tab) {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MAIN_KEY, tab);
        return tab;
    }

    public static void useBaseTab() {
        CrystalClear.getRegistrate().setCreativeTab(MAIN_KEY);
    }

    public static void register() {
    }
}
