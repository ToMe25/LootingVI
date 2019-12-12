package com.ToMe.LootingMod;

import java.util.Map;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;


//@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.TransformerExclusions("com.ToMe.LootingMod")
public class LoadingPlugin implements IFMLLoadingPlugin {

	@Override
	public String[] getASMTransformerClass() {
		// TODO Auto-generated method stub
		//System.out.println("Hallo Welt!");
		//System.out.println(ClassTransformer.class.getName());
		return new String[] { ClassTransformer.class.getName() };
		//return null;
	}

	@Override
	public String getModContainerClass() {
		// TODO Auto-generated method stub
		//System.out.println("Hallo Welt!");
		//System.out.println(ModContainer.class.getName());
		//return ModContainer.class.getName();
		return null;
		//return "net.minecraftforge.common.ForgeModContainer";
		//return ModContainer.class.getName();
	}
	
	/*@EventHandler
	public void Init(FMLInitializationEvent e){
		
		MinecraftForge.EVENT_BUS.register(this);
		LootingMod.instance.LoadEnchants();
		
	}*/

	@Override
	public String getSetupClass() {
		// TODO Auto-generated method stub
		//System.out.println("Hallo Welt!");
		//MinecraftForge.EVENT_BUS.register(LootingMod.instance);
		return null;
		//return LootingMod.class.getName();
	}

	@Override
	public void injectData(Map<String, Object> data) {
		// TODO Auto-generated method stub
		//System.out.println("Hallo Welt!");
		
	}

	@Override
	public String getAccessTransformerClass() {
		// TODO Auto-generated method stub
		//System.out.println("Hallo Welt!");
		return null;
	}
	
}