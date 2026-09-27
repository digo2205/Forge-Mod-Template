package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Central place where every item this mod adds is declared. Keeping all
 * item registration in one file (rather than scattering it across the mod)
 * makes it easy to see, at a glance, everything the mod adds to the game.
 *
 * Larger mods usually split this into several classes (ModItems, ModBlocks,
 * ModSounds, and so on), but the pattern shown here, a DeferredRegister per
 * registry type, stays the same regardless of how many files you use.
 */
public class ModItems {

    // A DeferredRegister does not register anything by itself. It collects
    // RegistryObject entries (created via .register(...) below) and then,
    // once ExampleMod calls ITEMS.register(modEventBus), Forge fires the
    // actual registration at the correct point during mod loading.
    //
    // ForgeRegistries.ITEMS tells this DeferredRegister that everything
    // added to it is an Item, as opposed to a Block, SoundEvent, and so on.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    // RegistryObject<Item> is a lazy handle: the real Item instance does not
    // exist yet at this point in the code, it is only created and assigned
    // once Forge processes the registry event. Referring to RUBY elsewhere
    // in the mod (for example in the creative tab or a recipe) is always
    // safe because RegistryObject resolves to the real item once it exists.
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
}
