package com.cyvack.crystal_clear.forge;

import com.cyvack.crystal_clear.common.CCCRegistrate;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;

public class CCCRegistrateForge extends CCCRegistrate {
    /**
     * Construct a new Registrate for the given mod ID.
     *
     * @param modid The mod ID for which objects will be registered
     */
    public CCCRegistrateForge(String modid) {
        super(modid);
    }

    public CreateRegistrate registerEventListeners(IEventBus bus) {
        return super.registerEventListeners(bus);
    }
}
