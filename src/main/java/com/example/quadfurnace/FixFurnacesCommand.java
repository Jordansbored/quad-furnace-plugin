package com.example.quadfurnace;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.inventory.Inventory;
import com.hypixel.hytale.server.core.inventory.ItemStack;
import com.hypixel.hytale.server.core.inventory.container.ItemContainer;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;

/**
 * Command to fix old furnaces that have metadata attached.
 * Removes metadata from Bench_Furnace and Bench_DoubleFurnace items
 * so they can be used in crafting recipes.
 */
public class FixFurnacesCommand extends AbstractPlayerCommand {

    private static final String FURNACE_ID = "Bench_Furnace";
    private static final String DOUBLE_FURNACE_ID = "Bench_DoubleFurnace";

    public FixFurnacesCommand() {
        super("fixfurnaces", "Remove metadata from furnaces so they work in crafting recipes");
        this.setPermissionGroup(GameMode.Adventure);
    }

    @Override
    protected void execute(@Nonnull CommandContext context, @Nonnull Store<EntityStore> store, 
                          @Nonnull Ref<EntityStore> ref, @Nonnull PlayerRef playerRef, @Nonnull World world) {
        
        Player player = store.getComponent(ref, Player.getComponentType());
        if (player == null) {
            context.sendMessage(Message.raw("Could not get player!"));
            return;
        }

        Inventory inventory = player.getInventory();
        int fixedCount = 0;

        // Fix items in hotbar
        fixedCount += fixContainer(inventory.getHotbar());
        
        // Fix items in backpack storage
        fixedCount += fixContainer(inventory.getCombinedBackpackStorageHotbar());

        if (fixedCount > 0) {
            context.sendMessage(Message.raw("Fixed " + fixedCount + " furnace(s)! They can now be used for crafting."));
        } else {
            context.sendMessage(Message.raw("No furnaces with metadata found. Your furnaces are already good to go!"));
        }
    }

    private int fixContainer(ItemContainer container) {
        int fixed = 0;
        
        for (short i = 0; i < container.getCapacity(); i++) {
            ItemStack itemStack = container.getItemStack(i);
            
            if (itemStack == null || itemStack.isEmpty()) {
                continue;
            }
            
            String itemId = itemStack.getItemId();
            
            // Check if it's a furnace or double furnace with metadata
            if ((FURNACE_ID.equals(itemId) || DOUBLE_FURNACE_ID.equals(itemId)) 
                    && itemStack.getMetadata() != null) {
                
                // Create new itemstack without metadata
                ItemStack fixedStack = itemStack.withMetadata(null);
                
                // Replace in inventory
                container.setItemStackForSlot(i, fixedStack);
                fixed++;
            }
        }
        
        return fixed;
    }
}
