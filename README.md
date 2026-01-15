# QuadFurnace Plugin

A Hytale mod that adds Double and Quad Furnaces with faster smelting speeds and more slots.

## Features

### Double Furnace
- **2x smelting speed** (2.5x when upgraded)
- 4 input slots, 2 fuel slots, 8 output slots
- Crafted from 2x Furnace at a Workbench
- Upgrade cost: 10x each of Copper, Iron, Thorium, Cobalt bars

### Quad Furnace
- **4x smelting speed** (~6.7x when upgraded)
- 8 input slots, 3 fuel slots, 8 output slots
- Crafted from 2x Double Furnace at a Workbench
- Upgrade cost: 20x each of Copper, Iron, Thorium, Cobalt bars

## Installation

1. Download the latest `QuadFurnace-x.x.x.jar` from [Releases](https://github.com/Jordansbored/quad-furnace-plugin/releases)
2. Place the JAR in your Hytale mods folder:
   - **Linux (Flatpak)**: `~/.var/app/com.hypixel.HytaleLauncher/data/Hytale/UserData/Mods/`
   - **Windows**: `%APPDATA%/Hytale/UserData/Mods/`
3. Launch Hytale and start a server with mods enabled

## Commands

- `/quadfurnace` - Plugin info command

## Requirements

- Hytale (Early Access)
- Java 25

## Building from Source

```bash
./gradlew build
```

The JAR will be in `build/libs/`.

## License

MIT License - see [LICENSE](LICENSE) for details.
