package com.example.examplemod;

import com.example.examplemod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

/**
 * This class is the entry point of the mod. Forge finds it because of the
 * {@code @Mod} annotation below, whose value must exactly match the mod id
 * declared in mods.toml (see src/main/resources/META-INF/mods.toml).
 *
 * Nothing about how Minecraft actually works is defined in this file itself;
 * its job is just to wire together the deferred registers in the item
 * package and hook into the events Forge fires during startup. This is the
 * standard shape almost every Forge mod's main class takes.
 */
@Mod(ExampleMod.MOD_ID)
public class ExampleMod {

    // Using a constant here means every other class that needs the mod id
    // (for building resource locations, log messages, and so on) can
    // reference ExampleMod.MOD_ID instead of retyping the string, which
    // avoids typos silently breaking registrations.
    public static final String MOD_ID = "examplemod";

    public ExampleMod() {
        // FMLJavaModLoadingContext gives access to this mod's own event bus,
        // which is different from Minecraft's general game event bus. Mod
        // setup, registry events, and similar mod-lifecycle events are fired
        // on this mod-specific bus.
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // DeferredRegister.register(bus) is what actually schedules every
        // item queued up in ModItems (see that class) to be registered at
        // the correct point during startup. Forge requires registration to
        // happen through this deferred mechanism rather than immediately,
        // since registries are not fully open yet while mods are still
        // being constructed.
        ModItems.ITEMS.register(modEventBus);

        // Registers this class's own methods (like addCreative below) to
        // listen for events on the mod event bus.
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
    }

    /**
     * Fired once, after all mods have finished registering their content.
     * This is the correct place for setup work that needs every registry to
     * already be populated, such as building crafting-related caches. This
     * template does not need any such work, but the method is kept here
     * since almost every real mod ends up needing this hook eventually.
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Intentionally empty for this template.
    }

    /**
     * Fired once for every creative mode tab that exists, letting mods add
     * their own items into vanilla tabs (or their own custom tabs). Here,
     * the Ruby item is added into the vanilla "Ingredients" tab so players
     * can find it in the creative inventory without needing a custom tab.
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RUBY);
        }
    }
}
