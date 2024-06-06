package com.cyvack.crystal_clear;

import com.cyvack.crystal_clear.common.content.blocks.GlassEncasedCogwheel;
import com.cyvack.crystal_clear.common.content.blocks.GlassEncasedShaft;
import com.cyvack.crystal_clear.common.generation.RegistrateGenHelper;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.encasing.EncasableBlock;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class RegistrationGenPlatform {

    @NotNull
    public static <B extends Block & EncasedBlock, P, E extends Block & EncasableBlock> NonNullUnaryOperator<BlockBuilder<B, P>> baseAdd(Supplier<E> sup) {
        return b -> b.transform(EncasingRegistry.addVariantTo(sup));
    }

    @ExpectPlatform
    public static <B extends Block & EncasedBlock, P, E extends Block & EncasableBlock> NonNullUnaryOperator<BlockBuilder<B, P>> addVariant(@Nullable ResourceLocation loc, NonNullSupplier<E> sup) {
        return baseAdd(sup);
    }

    @ExpectPlatform
    public static <B extends MetalScaffoldingBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassScaffolding(String modId, String casing, Boolean clear, RegistrateGenHelper.IDArrayHolder<ResourceLocation> holder) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <B extends GlassEncasedShaft, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedshaft(String modId, String casing, Boolean clear) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <B extends GlassEncasedCogwheel, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedCog(String modId, String casing, boolean large, String name, String blockFolder) {
        throw new AssertionError();
    }
}
