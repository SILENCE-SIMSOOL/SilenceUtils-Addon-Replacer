package sua.simsool.replacer;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import silence.simsool.config.Config;

public class HittingPosition {
	static Minecraft mc = Minecraft.getMinecraft();
	public static boolean isHittingPosition(BlockPos pos, ItemStack item, BlockPos currentPos) {
		ItemStack itemstack = mc.thePlayer.getHeldItem(); if (itemstack == null) return false;
		String iName = itemstack.getDisplayName();
		boolean flag = item == null && itemstack == null;
		if (item != null && itemstack != null) {
			if (Config.Replacer && (iName.contains("Drill") || iName.contains("Gemstone Gauntlet") || iName.contains("Pickonimbus"))) return pos.equals(currentPos);
			flag = itemstack.getItem() == item.getItem() && ItemStack.areItemStackTagsEqual(itemstack, item) && ( itemstack.isItemStackDamageable() || itemstack.getMetadata() == item.getMetadata() );
		}
        return pos.equals(currentPos) && flag;
    }
}