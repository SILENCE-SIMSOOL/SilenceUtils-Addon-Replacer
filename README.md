# SilenceUtils-Addon-Replacer

Select Language: [한국어](https://github.com/SILENCE-SIMSOOL/SilenceUtils-Addon-Replacer/blob/main/Korean.md)

# ⚠ Do not use this!
This mod is no longer used in Mod Silence Utils.  
It has been merged with Silence Utils.  
The code is left here for those who are interested.  
In SilenceUtils, the problem has been solved in a completely different way.  

# What is mod?
This mod helps high ping players in Hypixel SkyBlock by updating the held item when breaking blocks, alleviating the disadvantages they face.
Additionally, it eliminates the delay that occurs before breaking blocks, providing a better experience.

# Requirements
This mod is an addon for the SilenceUtils mod.
You need version 1.4.2 or higher of the SilenceUtils mod to use this mod.

## Vanilla Code
```java
private boolean isHittingPosition(BlockPos pos)
{
    ItemStack itemstack = this.mc.thePlayer.getHeldItem();
    boolean flag = this.currentItemHittingBlock == null && itemstack == null;
    if (this.currentItemHittingBlock != null && itemstack != null)
    {
        flag = itemstack.getItem() == this.currentItemHittingBlock.getItem() && ItemStack.areItemStackTagsEqual(itemstack, this.currentItemHittingBlock) && (itemstack.isItemStackDamageable() || itemstack.getMetadata() == this.currentItemHittingBlock.getMetadata());
    }
    return pos.equals(this.currentBlock) && flag;
}
```

## Replacer Code
```java
public static boolean isNewHittingPosition(BlockPos pos, ItemStack item, BlockPos currentPos) {
    ItemStack itemstack = mc.thePlayer.getHeldItem(); if (itemstack == null) return false;
    String iName = itemstack.getDisplayName();
    boolean flag = item == null && itemstack == null;
    if (item != null && itemstack != null) {
        if (Main.isEnable() && (iName.contains("Drill") || iName.contains("Gemstone Gauntlet") || iName.contains("Pickonimbus"))) return pos.equals(currentPos);
        flag = itemstack.getItem() == item.getItem() && ItemStack.areItemStackTagsEqual(itemstack, item) && ( itemstack.isItemStackDamageable() || itemstack.getMetadata() == item.getMetadata() );
    }
    return pos.equals(currentPos) && flag;
}
```

# How to Download
You can [Download](https://github.com/SILENCE-SIMSOOL/SilenceUtils-Addon-Replacer/releases/download/2.1/SUAddon_Replacer-2.1.jar) Here.

This mod was inspired by and created with reference to the [Hot-Shirtless-Men](https://github.com/Rekteiru/Hot-Shirtless-Men)
