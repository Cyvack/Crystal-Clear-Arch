package com.cyvack.crystal_clear.common;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.AbstractRegistrate;

/**
 * An abstraction for CreateRegistrate that allows for custom multiloader registration, gathering, etc
 */
public abstract class CCCRegistrate extends CreateRegistrate {
    /**
     * Construct a new Registrate for the given mod ID.
     *
     * @param modid The mod ID for which objects will be registered
     */
    public CCCRegistrate(String modid) {
        super(modid);
    }
}
