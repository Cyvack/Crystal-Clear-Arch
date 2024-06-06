package com.cyvack.crystal_clear.forge;

import com.cyvack.crystal_clear.RegistrationGenPlatform;
import com.cyvack.crystal_clear.common.content.blocks.GlassEncasedCogwheel;
import com.cyvack.crystal_clear.common.content.blocks.GlassEncasedShaft;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.MetalScaffoldingBlockItem;
import com.simibubi.create.content.decoration.encasing.EncasableBlock;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ScaffoldingBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import org.jetbrains.annotations.Nullable;

import static com.cyvack.crystal_clear.common.generation.RegistrateGenHelper.*;
import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;

public class RegistrationGenPlatformImpl {

    public static <B extends Block & EncasedBlock, P, E extends Block & EncasableBlock> NonNullUnaryOperator<BlockBuilder<B, P>> addVariant(@Nullable ResourceLocation loc, NonNullSupplier<E> sup) {
        return RegistrationGenPlatform.baseAdd(sup);
    }

    public static <B extends MetalScaffoldingBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassScaffolding(String modId, String casing, Boolean clear, IDArrayHolder<ResourceLocation> holder) {
        return b -> b.blockstate(((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept(s -> {
                            String suffix = s.getValue(MetalScaffoldingBlock.BOTTOM) ? "_horizontal" : "";
                            return ConfiguredModel.builder()
                                    .modelFile(p.models()
                                            .withExistingParent(c.getName() + suffix, holder.get("main") + suffix)
                                            .texture("top", holder.get("top"))
                                            .texture("inside", holder.get("inside"))
                                            .texture("side", holder.get("side"))
                                            .texture("casing", holder.get("casing"))
                                            .texture("particle", holder.get("particle")))
                                    .build();
                        }, MetalScaffoldingBlock.WATERLOGGED, MetalScaffoldingBlock.DISTANCE)))
                .item(MetalScaffoldingBlockItem::new)
                .model((c, p) -> p.withExistingParent(c.getName(), holder.get("item_main"))
                        .texture("top", holder.get("top"))
                        .texture("inside", holder.get("inside"))
                        .texture("side", holder.get("side"))
                        .texture("casing", holder.get("casing"))
                        .texture("particle", holder.get("particle")))
                .build();
    }

    public static <B extends GlassEncasedShaft, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedshaft(String modId, String casing, Boolean clear) {
        return b -> b
                .blockstate((ctx, prov) -> axisBlock(ctx, prov, state -> prov.models().withExistingParent(ctx.getName(), new ResourceLocation(modId, "block/glass_encased_shaft/block"))
                        .texture("casing", new ResourceLocation(modId, "block/" + casing + (clear ? "_clear_glass" : "_glass") + "_casing"))
                        .texture("opening", getOpening(modId, casing)), true))
                .item().model((ctx, prov) -> prov.withExistingParent(ctx.getName(), new ResourceLocation(modId, "block/glass_encased_shaft/block"))
                        .texture("casing", new ResourceLocation(modId, "block/" + casing + (clear ? "_clear_glass" : "_glass") + "_casing"))
                        .texture("opening", getOpening(modId, casing)))
                .build();
    }

    public static <B extends GlassEncasedCogwheel, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedCog(String modId, String casing, boolean large, String name, String blockFolder) {
        return b -> b
                .blockstate((ctx, prov) -> axisBlock(ctx, prov, blockState -> {
                    String suffix = (blockState.getValue(GlassEncasedCogwheel.TOP_SHAFT) ? "_top" : "")
                            + (blockState.getValue(GlassEncasedCogwheel.BOTTOM_SHAFT) ? "_bottom" : "");
                    String modelName = ctx.getName() + suffix;
                    return prov.models()
                            .withExistingParent(modelName, prov.modLoc("block/" + blockFolder + "/block" + suffix))
                            //Particle
                            .texture("particle", new ResourceLocation(modId, "block/" + name + "_casing"))
                            //Casing
                            .texture("casing", new ResourceLocation(modId, "block/" + name + "_casing"))
                            //Backing
                            .texture("backing", getBacking(modId, casing))
                            //Opening
                            .texture("opening", getOpening(modId, casing))
                            //Side Casing
                            .texture("siding", getSiding(modId, casing, large));
                }, false))
                .item()
                .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/" + blockFolder + "/item"))
                        .texture("casing", new ResourceLocation(modId, "block/" + name + "_casing"))
                        //Backing
                        .texture("backing", getBacking(modId, casing))
                        //Gearbox
                        .texture("opening", getOpening(modId, casing))
                        //Side Casing
                        .texture("siding", getSiding(modId, casing, large)))
                .build();
    }
}
