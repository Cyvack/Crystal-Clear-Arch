package com.cyvack.crystal_clear.common.creative_tab;

import com.cyvack.crystal_clear.common.CrystalClear;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static net.minecraft.world.item.CreativeModeTab.*;

/**
 * A class for easy invisibility marking
 *
 * @author Cyvack
 */
public class ItemVisibilityHandler {

    private static final Set<Item> INVISIBLE_ITEMS = new HashSet<>();

    public static final CrystalClearDisplay DISPLAY_INSTANCE = new CrystalClearDisplay();

    public static boolean isInvisible(Item item) {
        return INVISIBLE_ITEMS.contains(item);
    }

    public static <B extends Block, R> NonNullUnaryOperator<BlockBuilder<B, R>> makeInvisible() {
        return builder -> builder.onRegisterAfter(Registries.ITEM, b -> INVISIBLE_ITEMS.add(b.asItem()));
    }

    public static <B extends Item, R> NonNullUnaryOperator<ItemBuilder<B, R>> makeItemInvisible() {
        return builder -> builder.onRegisterAfter(Registries.ITEM, b -> INVISIBLE_ITEMS.add(b.asItem()));
    }

    public static <B extends Block, R> NonNullUnaryOperator<BlockBuilder<B, R>> makeInvisible(Supplier<Boolean> visibiltySup) {
        return builder -> builder.onRegisterAfter(Registries.ITEM, b -> {
            if (visibiltySup.get())
                INVISIBLE_ITEMS.add(b.asItem());
        });
    }

    public static class CrystalClearDisplay implements DisplayItemsGenerator {
        @Override
        public void accept(@NotNull ItemDisplayParameters parameters, @NotNull Output out) {
            List<ItemStack> visibleItems = new ArrayList<>();
            for (RegistryEntry<Item> registeredItem : CrystalClear.getRegistrate().getAll(Registries.ITEM)) {
                if (!isInvisible(registeredItem.get()))
                    visibleItems.add(registeredItem.get().getDefaultInstance());
            }

            out.acceptAll(visibleItems);
        }
    }
}
