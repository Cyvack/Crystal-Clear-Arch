package com.cyvack.crystal_clear.fabric.events;

import com.cyvack.crystal_clear.common.CrystalClear;
import com.cyvack.crystal_clear.fabric.mixin.EncasingRegistryAccessor;
import com.simibubi.create.content.decoration.encasing.EncasableBlock;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncasingRegistryFixerEvent implements RegistryEntryAddedCallback<Block> {

    public static final EncasingRegistryFixerEvent INSTANCE = new EncasingRegistryFixerEvent();

    public static Map<ResourceLocation, List<Block>> DEFERRED = new HashMap<>();

    public static <B extends Block & EncasedBlock, P, E extends Block & EncasableBlock> NonNullUnaryOperator<BlockBuilder<B, P>> addVariantTo(ResourceLocation loc, NonNullSupplier<E> sup) {
        return b -> b.onRegisterAfter(Registries.BLOCK, (block) -> {
            E tester = sup.get();
            if (Blocks.AIR == tester) {
//                CrystalClear.LOGGER.info("Adding " + block.getName().getString() + " to deferred encasing registry");
                DEFERRED.computeIfAbsent(loc, ($) -> new ArrayList<>()).add(block);
            } else {
//                CrystalClear.LOGGER.info("Adding " + block.getName().getString() + " to encasing registry");
                EncasingRegistry.addVariant(tester, block);
            }
        });
    }

    @Override
    public void onEntryAdded(int rawId, ResourceLocation id, Block object) {
        if (!(object instanceof EncasableBlock))
            return;

        if (DEFERRED.containsKey(id)) {
            List<Block> directEncasingList = EncasingRegistryAccessor.getENCASED_VARIANTS().computeIfAbsent(object, ($) -> new ArrayList<>());

            DEFERRED.get(id).forEach((block) -> {
                CrystalClear.LOGGER.info("Fixing Encasement for: " + id + ". Adding: " + block.getName().getString());
                directEncasingList.add(block);
            });
        }
    }

    public static void register(DefaultedRegistry<Block> block) {
        RegistryEntryAddedCallback.event(block).register(INSTANCE);
    }
}
