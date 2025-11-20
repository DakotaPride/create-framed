# Create: Framed (1.20.x)

This is the official port of Create: Framed for Forge 1.20.x.  
The current version is based on the upstream NeoForge 1.21.x version of Create: Framed.

## Specific info about this port

This port was originally created by tabbedDev and is now primarily maintained by him.  
Contributions from others are welcome at any time.

When reporting issues with this version, please ensure they relate specifically to the Forge 1.20.x branch.
Bugs from the upstream NeoForge version may also apply here, but need to be adapted before they can be fixed in this backport.

You may also note the following:

- This port aims to maintain full feature parity with the upstream NeoForge 1.21.x version.
- Worlds created with older versions of Create: Framed for Forge 1.20.x remain fully compatible.
- Only compatibility-related changes were made; no gameplay features were altered.

## Some thing to note while backporting

The following notes may be helpful for anyone contributing to this backport.

1. There's an `fix-recipes.ts` file inside the recipes folder. Its task is to convert NeoForge 1.21.1 recipes to Forge 1.20.1 recipes. It required Deno 2.x to run.

   So if any new recipes were added just drop them in the right folder and run the script from the recipes folder.

(Feel free to continue the list yourself)
