/*
 * This file is part of the public ComputerCraft API - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2022. This API may be redistributed unmodified and in full only.
 * For help using the API, and posting your mods, visit the forums at computercraft.info.
 */
package dan200.computercraft.api;

import dan200.computercraft.api.lua.GenericSource;
import dan200.computercraft.api.network.wired.IWiredElement;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import dan200.computercraft.impl.ComputerCraftAPIService;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

/**
 * The forge-specific entrypoint for ComputerCraft's API.
 */
public final class ForgeComputerCraftAPI {
    private ForgeComputerCraftAPI() {
    }

    /**
     * Registers a peripheral provider to convert blocks into {@link IPeripheral} implementations.
     *
     * @param provider The peripheral provider to register.
     * @see IPeripheral
     * @see IPeripheralProvider
     */
    public static void registerPeripheralProvider(@Nonnull IPeripheralProvider provider) {
        getInstance().registerPeripheralProvider(provider);
    }

    /**
     * Registers a capability that can be used by generic peripherals.
     *
     * @param capability The capability to register.
     * @see GenericSource
     */
    public static void registerGenericCapability(@Nonnull Capability<?> capability) {
        getInstance().registerGenericCapability(capability);
    }

    /**
     * Get the wired network element for a block in world.
     *
     * @param world The world the block exists in
     * @param pos   The position the block exists in
     * @param side  The side to extract the network element from
     * @return The element's node
     * @see IWiredElement#getNode()
     */
    @Nonnull
    public static LazyOptional<IWiredElement> getWiredElementAt(@Nonnull BlockGetter world, @Nonnull BlockPos pos, @Nonnull Direction side) {
        return getInstance().getWiredElementAt(world, pos, side);
    }

    @Nonnull
    private static ComputerCraftAPIService getInstance() {
        return ComputerCraftAPIService.get();
    }
}
