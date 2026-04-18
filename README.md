# TeleportBow 🏹

A Spigot plugin that gives you a bow that teleports you to where the arrow lands.

## Installation

1. Download the `.jar`
2. Put it in your `plugins` folder
3. Restart the server
4. Done!

## How to Use

Shoot an arrow → Get teleported to where it lands. That's it.

## Configuration

Edit `config.yml` to customize:

```yaml
teleport-bow:
  name: "&b&lTeleport Bow"
  lore:
    - "&7Teleport to where arrows land"
  slot: 0
  unbreakable: true

arrow:
  name: "&cTeleport Arrow"
  slot: 1
```

Restart the server or use `/teleportbow reload` to apply changes.

## Status

First plugin, work in progress. Feedback welcome!
