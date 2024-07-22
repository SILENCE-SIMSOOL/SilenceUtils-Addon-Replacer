package sua.simsool.replacer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "suareplacer", version = "1.2", useMetadata=true)
public class Main {
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("[Silence]: Loaded Silence Utils Addon (Replacer) - v1.0");
	}
}
