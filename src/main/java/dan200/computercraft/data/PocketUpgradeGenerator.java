/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2022. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */
package dan200.computercraft.data;

import dan200.computercraft.ComputerCraft;
import dan200.computercraft.api.pocket.PocketUpgradeDataProvider;
import dan200.computercraft.api.pocket.PocketUpgradeSerialiser;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static dan200.computercraft.shared.ModRegistry.Items;
import static dan200.computercraft.shared.ModRegistry.PocketUpgradeSerialisers;

class PocketUpgradeGenerator extends PocketUpgradeDataProvider {
    PocketUpgradeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addUpgrades(@Nonnull Consumer<Upgrade<PocketUpgradeSerialiser<?>>> addUpgrade) {
        addUpgrade.accept(simpleWithCustomItem(id("speaker"), PocketUpgradeSerialisers.SPEAKER.get(), Items.SPEAKER.get()));
        simpleWithCustomItem(id("wireless_modem_normal"), PocketUpgradeSerialisers.WIRELESS_MODEM_NORMAL.get(), Items.WIRELESS_MODEM_NORMAL.get()).add(addUpgrade);
        simpleWithCustomItem(id("wireless_modem_advanced"), PocketUpgradeSerialisers.WIRELESS_MODEM_ADVANCED.get(), Items.WIRELESS_MODEM_ADVANCED.get()).add(addUpgrade);
    }

    @Nonnull
    private static ResourceLocation id(@Nonnull String id) {
        return new ResourceLocation(ComputerCraft.MOD_ID, id);
    }
}