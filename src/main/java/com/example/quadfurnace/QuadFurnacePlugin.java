package com.example.quadfurnace;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

/**
 * Double/Quad Furnace Plugin
 * 
 * Adds two new processing benches:
 * - Double Furnace: 4 input slots, 2 fuel slots, 8 output slots
 * - Quad Furnace: 6 input slots, 3 fuel slots, 12 output slots
 * 
 * This plugin bundles JSON assets that use Hytale's built-in ProcessingBench system.
 * The furnaces use the standard processingBench state and Open_Processing_Bench interaction.
 * 
 * Crafting recipes:
 * - 2x Furnace -> Double Furnace (at Workbench)
 * - 2x Double Furnace -> Quad Furnace (at Workbench)
 */
public class QuadFurnacePlugin extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public QuadFurnacePlugin(@Nonnull JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Double/Quad Furnace plugin loaded - version " + this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up Double/Quad Furnace plugin...");
        
        // Register the command for testing/info
        this.getCommandRegistry().registerCommand(new QuadFurnaceCommand());
        
        // Register fix command for old furnaces with metadata
        this.getCommandRegistry().registerCommand(new FixFurnacesCommand());
        
        // The item/block definitions are loaded automatically from the resources folder
        // They use Hytale's built-in ProcessingBench system, so no custom Java code needed
        
        LOGGER.atInfo().log("Double/Quad Furnace plugin setup complete!");
        LOGGER.atInfo().log("Craft: 2x Furnace -> Double Furnace, 2x Double Furnace -> Quad Furnace");
        LOGGER.atInfo().log("Use /fixfurnaces to fix old furnaces that won't work in recipes");
    }
}
