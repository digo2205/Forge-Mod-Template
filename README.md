# Example Mod

A minimal Minecraft Forge mod for version 1.20.1, meant to be read rather than played. It adds exactly one thing, a custom item called the Ruby, and uses that single item to show every piece of the puzzle a Forge mod normally needs: registration, textures and models, a crafting recipe, an advancement, and the metadata files that let Forge find the mod at all.

The goal here is not to make an interesting item. It is to have a working, buildable project small enough to read start to finish in a single sitting, with comments explaining what each file is doing and why it exists, for anyone learning Forge modding for the first time.

## What is in this mod

- A custom item, the Ruby, registered through Forge's deferred registry system
- A texture and item model for that Ruby
- A shapeless crafting recipe (3 amethyst shards produce 1 ruby, chosen arbitrarily just to demonstrate the recipe format)
- An advancement that triggers the first time a player obtains a ruby
- The item added into the vanilla "Ingredients" creative tab

## Project structure

```
build.gradle                          Gradle build configuration
settings.gradle                       tells Gradle where to find ForgeGradle
gradle.properties                     mod id, version, and Minecraft/Forge versions

src/main/java/com/example/examplemod/
  ExampleMod.java                     the mod's entry point
  item/ModItems.java                  where the Ruby item is registered

src/main/resources/
  META-INF/mods.toml                  mod metadata Forge reads on startup
  pack.mcmeta                         resource pack metadata (required even for mods)
  assets/examplemod/
    lang/en_us.json                   English translations for item names, etc.
    textures/item/ruby.png            the item's texture
    models/item/ruby.json             the item's model, pointing at that texture
  data/examplemod/
    recipes/ruby_from_amethyst.json   the crafting recipe
    advancements/root.json            the advancement for obtaining a ruby
```

This split between `java/` and `resources/` is standard for any Forge mod: Java code defines behavior and registers things, while JSON files under `resources/` (Minecraft calls these "data" and "assets") define content like recipes, models, textures, loot tables, and translations. A large part of modding, especially early on, is writing these JSON files rather than Java.

## Requirements

- Java Development Kit 17 (Minecraft 1.20.1 specifically requires this version, not newer or older)
- No separate Gradle installation is needed; the project uses the Gradle Wrapper, which downloads the correct Gradle version automatically the first time you run it

## Getting started

1. Clone or download this repository.
2. Open a terminal in the project's root folder (the one containing `build.gradle`).
3. Run the Gradle wrapper's setup task to generate IDE run configurations:

   ```
   ./gradlew genEclipseRuns
   ```

   or, if you use IntelliJ IDEA:

   ```
   ./gradlew genIntellijRuns
   ```

   On Windows, use `gradlew.bat` instead of `./gradlew`.

4. Open the project in your IDE (IntelliJ IDEA or Eclipse both work well with Forge). The first import will take a while, since Gradle needs to download Minecraft itself, deobfuscate it, and patch in Forge.
5. Run the generated "runClient" configuration. This launches a normal Minecraft client with the mod already loaded. Once it is running, open a creative inventory and look in the Ingredients tab, the Ruby should be there.

## Where to go from here

This template deliberately stops at one item so the whole thing stays readable. Natural next steps for extending it, each following the same registration pattern already shown for items, include:

- A custom block, registered the same way as the Ruby item but through a `DeferredRegister<Block>` instead
- A creative tab of the mod's own, instead of adding into vanilla's Ingredients tab
- Custom sounds, particles, or a simple entity
- A loot table, so the item can drop from a mob or a chest instead of only being craftable

The official Forge documentation and the Forge community Discord are the best places to look up the specifics for any of these, once you understand the registration and resource file pattern this template demonstrates.
