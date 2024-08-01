package sua.simsool.replacer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "suareplacer", version = "2.1", useMetadata=true)
public class Main {
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("[Silence]: Loaded Silence Utils Addon (Replacer) - v2.1");
	}
}
