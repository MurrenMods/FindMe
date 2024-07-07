# FindMe
A minecraft plugin to find your friends or entities!

## Features
The plugin features 2 different commands to find either other players or other entities. It also has the possibility to allow players to hide themselves, in which case the command will return a random location when a player tries to find them.

## Commands
### /find <player>
Retrieves the world and location of the online player, or a random location and world when they are hidden.
### /hideme
Toggles your hidden state. This is not persistent, so leaving/joining, server reloads and server restarts will reset your state to visible. The server console will bypass your hidden state.
### /findentity <entity> \[compact]
Retrieves the world and location of all loaded entities of that type, and the total amount of them. Using the compact parameter will only display the count.

## Config
- find: Toggles if /find should be enabled.
- hide: Toggles if /hideme should be enabled.
- entityfind: Toggles if /findentity should be enabled.

## Permissions
- findme.find: Allow player to use /find
- findme.hide: Allow player to use /hideme
- findme.findentity: Allow player to use /findentity
