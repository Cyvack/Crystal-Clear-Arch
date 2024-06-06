package com.cyvack.crystal_clear.fabric.mixin;

import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import java.util.Map;

@Mixin(EncasingRegistry.class)
public interface EncasingRegistryAccessor {

    @Accessor
    static Map<Block, List<Block>> getENCASED_VARIANTS(){
        return null;
    }

}
