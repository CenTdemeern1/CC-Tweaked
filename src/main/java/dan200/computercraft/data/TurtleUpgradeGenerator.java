/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2022. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */
package dan200.computercraft.data;

import dan200.computercraft.ComputerCraft;
import dan200.computercraft.api.ComputerCraftTags.Blocks;
import dan200.computercraft.api.turtle.TurtleUpgradeDataProvider;
import dan200.computercraft.api.turtle.TurtleUpgradeSerialiser;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static dan200.computercraft.shared.ModRegistry.Items;
import static dan200.computercraft.shared.ModRegistry.TurtleSerialisers;

class TurtleUpgradeGenerator extends TurtleUpgradeDataProvider {
    TurtleUpgradeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addUpgrades(@Nonnull Consumer<Upgrade<TurtleUpgradeSerialiser<?>>> addUpgrade) {
        simpleWithCustomItem(id("speaker"), TurtleSerialisers.SPEAKER.get(), Items.SPEAKER.get()).add(addUpgrade);
        simpleWithCustomItem(vanilla("crafting_table"), TurtleSerialisers.WORKBENCH.get(), net.minecraft.world.item.Items.CRAFTING_TABLE).add(addUpgrade);
        simpleWithCustomItem(id("wireless_modem_normal"), TurtleSerialisers.WIRELESS_MODEM_NORMAL.get(), Items.WIRELESS_MODEM_NORMAL.get()).add(addUpgrade);
        simpleWithCustomItem(id("wireless_modem_advanced"), TurtleSerialisers.WIRELESS_MODEM_ADVANCED.get(), Items.WIRELESS_MODEM_ADVANCED.get()).add(addUpgrade);

        tool(vanilla("diamond_axe"), net.minecraft.world.item.Items.DIAMOND_AXE).damageMultiplier(6.0f).add(addUpgrade);
        tool(vanilla("diamond_pickaxe"), net.minecraft.world.item.Items.DIAMOND_PICKAXE).add(addUpgrade);
        tool(vanilla("diamond_hoe"), net.minecraft.world.item.Items.DIAMOND_HOE).breakable(Blocks.TURTLE_HOE_BREAKABLE).add(addUpgrade);
        tool(vanilla("diamond_shovel"), net.minecraft.world.item.Items.DIAMOND_SHOVEL).breakable(Blocks.TURTLE_SHOVEL_BREAKABLE).add(addUpgrade);
        tool(vanilla("diamond_sword"), net.minecraft.world.item.Items.DIAMOND_SWORD).breakable(Blocks.TURTLE_SWORD_BREAKABLE).damageMultiplier(9.0f).add(addUpgrade);
    }

    @Nonnull
    private static ResourceLocation id(@Nonnull String id) {
        return new ResourceLocation(ComputerCraft.MOD_ID, id);
    }

    @Nonnull
    private static ResourceLocation vanilla(@Nonnull String id) {
        // Naughty, please don't do this. Mostly here for some semblance of backwards compatibility.
        return new ResourceLocation("minecraft", id);
    }
}