package com.cyvack.crystal_clear.fabric;

import com.cyvack.crystal_clear.common.CrystalClear;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import java.nio.file.Paths;
import java.util.Set;

public class CrystalClearData implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        // fixme re-enable the existing file helper when porting lib's ResourcePackLoader.createPackForMod is fixed
        ExistingFileHelper helper = new ExistingFileHelper(
                Set.of(Paths.get(System.getProperty(ExistingFileHelper.EXISTING_RESOURCES))), Set.of("create"), false, null, null);

        CrystalClear.getRegistrate().setupDatagen(gen.createPack(), helper);
    }
}
