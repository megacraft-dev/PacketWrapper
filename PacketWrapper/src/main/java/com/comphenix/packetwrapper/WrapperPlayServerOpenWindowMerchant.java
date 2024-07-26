/**
 * This file is part of PacketWrapper.
 * Copyright (C) 2012-2015 Kristian S. Strangeland
 * Copyright (C) 2015 dmulloy2
 *
 * PacketWrapper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PacketWrapper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with PacketWrapper.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.inventory.MerchantRecipe;

import java.util.List;

public class WrapperPlayServerOpenWindowMerchant extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.OPEN_WINDOW_MERCHANT;

    public WrapperPlayServerOpenWindowMerchant() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }

    public WrapperPlayServerOpenWindowMerchant(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieve Window ID.
     *
     * @return The current Window ID?
     */
    public int getWindowId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Set Window ID.
     *
     * @param value - new value.
     */
    public void setWindowId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieve Trades.
     *
     * @return The current Trades
     */
    public List<MerchantRecipe> getTrades() {
        return this.handle.getMerchantRecipeLists().read(0);
    }

    /**
     * Set Trades.
     *
     * @param value - new value.
     */
    public void setTrades(List<MerchantRecipe> value) {
        this.handle.getMerchantRecipeLists().write(0, value);
    }

    /**
     * Retrieve Villager level.
     *
     * @return The current Villager level
     */
    public int getVillagerLevel() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Set Villager level.
     *
     * @param value - new value.
     */
    public void setVillagerLevel(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieve Experience.
     *
     * @return The current Experience
     */
    public int getExperience() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Set Experience.
     *
     * @param value - new value.
     */
    public void setExperience(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieve Show progress.
     *
     * @return The current Show progress
     */
    public boolean getShowProgress() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Set Show progress.
     *
     * @param value - new value.
     */
    public void setShowProgress(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieve Can restock.
     *
     * @return The current Can restock
     */
    public boolean getCanRestock() {
        return this.handle.getBooleans().read(1);
    }

    /**
     * Set Can restock.
     *
     * @param value - new value.
     */
    public void setCanRestock(boolean value) {
        this.handle.getBooleans().write(1, value);
    }
}
