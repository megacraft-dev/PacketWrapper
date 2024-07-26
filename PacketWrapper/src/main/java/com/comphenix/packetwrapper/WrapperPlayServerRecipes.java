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
import com.comphenix.protocol.wrappers.MinecraftKey;

import java.util.List;

public class WrapperPlayServerRecipes extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.RECIPES;
    
    public WrapperPlayServerRecipes() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayServerRecipes(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieve Action.
     * <p>
     * Notes: 0: init, 1: add, 2: remove
     * @return The current Action
     */
    public Action getAction() {
        return handle.getEnumModifier(Action.class, 0).readSafely(0);
    }

    /**
     * Set Action.
     * @param value - new value.
     */
    public void setAction(Action value) {
        handle.getEnumModifier(Action.class, 0).writeSafely(0, value);
    }

    /**
     * Retrieve Recipes.
     * @return The current Recipes
     */
    public List<MinecraftKey> getRecipes() {
        return this.handle.getLists(MinecraftKey.getConverter()).read(0);
    }

    /**
     * Set Recipes.
     * @param value - new value.
     */
    public void setRecipes(List<MinecraftKey> value) {
        this.handle.getLists(MinecraftKey.getConverter()).write(0, value);
    }

    /**
     * Retrieves To highlight.
     * @return The current To highlight
     */
    public List<MinecraftKey> getToHighlight() {
        return this.handle.getLists(MinecraftKey.getConverter()).read(1);
    }

    /**
     * Set To highlight.
     * @param value - new value.
     */
    public void setToHighlight(List<MinecraftKey> value) {
        this.handle.getLists(MinecraftKey.getConverter()).write(1, value);
    }
    
    /**
     * Retrieve Crafting Book Open.
     * <p>
     * Notes: if true, then the crafting book will be open when the player opens its inventory.
     * @return The current Crafting Book Open
     */
    public boolean getCraftingBookOpen() {
        return handle.getBooleans().read(0);
    }
    
    /**
     * Set Crafting Book Open.
     * @param value - new value.
     */
    public void setCraftingBookOpen(boolean value) {
        handle.getBooleans().write(0, value);
    }
    
    /**
     * Retrieve Crafting Filter Active.
     * <p>
     * Notes: if true, then the filtering option is active when the players opens its inventory.
     * @return The current Crafting Filter Active
     */
    public boolean getCraftingFilterActive() {
        return handle.getBooleans().read(1);
    }
    
    /**
     * Set Crafting Filter Active.
     * @param value - new value.
     */
    public void setCraftingFilterActive(boolean value) {
        handle.getBooleans().write(1, value);
    }

    /**
     * Retrieve Smelting Book Open.
     * <p>
     * Notes: if true, then the smelting recipe book will be open when the player opens its inventory.
     * @return The current Smelting Book Open
     */
    public boolean getSmeltingBookOpen() {
        return handle.getBooleans().read(2);
    }

    /**
     * Set Smelting Book Open.
     * @param value - new value.
     */
    public void setSmeltingBookOpen(boolean value) {
        handle.getBooleans().write(2, value);
    }

    /**
     * Retrieve Smelting Filter Active.
     * <p>
     * Notes: if true, then the filtering option is active when the players opens its inventory.
     * @return The current Smelting Filter Active
     */
    public boolean getSmeltingFilterActive() {
        return handle.getBooleans().read(3);
    }

    /**
     * Set Smelting Filter Active.
     * @param value - new value.
     */
    public void setSmeltingFilterActive(boolean value) {
        handle.getBooleans().write(3, value);
    }

    /**
     * Retrieve Blast Furnace Book Open.
     * <p>
     * Notes: if true, then the blast furnace recipe book will be open when the player opens its inventory.
     * @return The current Blast Furnace Book Open
     */
    public boolean getBlastFurnaceBookOpen() {
        return handle.getBooleans().read(4);
    }

    /**
     * Set Crafting Book Open.
     * @param value - new value.
     */
    public void setBlastFurnaceBookOpen(boolean value) {
        handle.getBooleans().write(4, value);
    }

    /**
     * Retrieve Blast Furnace Filter Active.
     * <p>
     * Notes: if true, then the filtering option is active when the players opens its inventory.
     * @return The current Blast Furnace Filter Active
     */
    public boolean getBlastFurnaceFilterActive() {
        return handle.getBooleans().read(5);
    }

    /**
     * Set Blast Furnace Filter Active.
     * @param value - new value.
     */
    public void setBlastFurnaceFilterActive(boolean value) {
        handle.getBooleans().write(5, value);
    }

    /**
     * Retrieve Smoker Book Open.
     * <p>
     * Notes: if true, then the smoker recipe book will be open when the player opens its inventory.
     * @return The current Smoker Book Open
     */
    public boolean getSmokerBookOpen() {
        return handle.getBooleans().read(6);
    }

    /**
     * Set Smoker Book Open.
     * @param value - new value.
     */
    public void setSmokerBookOpen(boolean value) {
        handle.getBooleans().write(6, value);
    }

    /**
     * Retrieve Smoker Filter Active.
     * <p>
     * Notes: if true, then the filtering option is active when the players opens its inventory.
     * @return The current Crafting Filter Active
     */
    public boolean getSmokerFilterActive() {
        return handle.getBooleans().read(7);
    }

    /**
     * Set Smoker Filter Active.
     * @param value - new value.
     */
    public void setSmokerFilterActive(boolean value) {
        handle.getBooleans().write(7, value);
    }

    public enum Action {
        INIT,
        ADD,
        REMOVE;
    }
}
