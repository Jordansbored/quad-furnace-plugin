package com.example.quadfurnace;

import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

import javax.annotation.Nonnull;

/**
 * Info command for the Double/Quad Furnace plugin.
 */
public class QuadFurnaceCommand extends CommandBase {

    public QuadFurnaceCommand() {
        super("furnaces", "Info about Double/Quad Furnace plugin");
        this.setPermissionGroup(GameMode.Adventure);
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        ctx.sendMessage(Message.raw("=== Double/Quad Furnace Plugin ==="));
        ctx.sendMessage(Message.raw("Double Furnace: 4 input, 2 fuel, 8 output slots"));
        ctx.sendMessage(Message.raw("Quad Furnace: 6 input, 3 fuel, 12 output slots"));
        ctx.sendMessage(Message.raw("Craft: 2x Furnace -> Double, 2x Double -> Quad"));
    }
}
