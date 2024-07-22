package sua.simsool.replacer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import silence.simsool.config.Config;
import sua.simsool.replacer.HittingPosition;

@Mixin(PlayerControllerMP.class)
public class MixinPlayerControllerMP {

	@Shadow private ItemStack currentItemHittingBlock;
	@Shadow private BlockPos currentBlock;
	@Shadow private int blockHitDelay;

	@Overwrite
	private boolean isHittingPosition(BlockPos pos) {
		return HittingPosition.isHittingPosition(pos, currentItemHittingBlock, currentBlock);
	}

	@Inject(method = "onPlayerDamageBlock", at = @At("HEAD"))
	private void tweakHitDelay(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
		if (Config.Replacer) this.blockHitDelay = 0;
	}
}