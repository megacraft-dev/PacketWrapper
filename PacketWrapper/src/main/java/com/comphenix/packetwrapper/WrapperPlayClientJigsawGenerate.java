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

import com.comphenix.protocol.wrappers.BlockPosition;

public class WrapperPlayClientJigsawGenerate extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.JIGSAW_GENERATE;

    public WrapperPlayClientJigsawGenerate() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }

    public WrapperPlayClientJigsawGenerate(PacketContainer packet) {
        super(packet, TYPE);
    }

    public BlockPosition getLocation() {
        return this.handle.getBlockPositionModifier().read(0);
    }

    public void setLocation(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }

    public int getLevels() {
        return this.handle.getIntegers().read(0);
    }

    public void setLevels(int value) {
        this.handle.getIntegers().write(0, value);
    }

    public boolean isKeepJigsaws() {
        return this.handle.getBooleans().read(0);
    }

    public void setKeepJigsaws(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

}
