package com.ToMe.LootingMod;

//import net.minecraftforge.common.ForgeModContainer;

//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Collections;
//import com.google.common.eventbus.EventBus;
//import net.minecraftforge.fml.common.DummyModContainer;
//import net.minecraftforge.fml.common.LoadController;
//import net.minecraftforge.fml.common.ModMetadata;
//import net.minecraftforge.fml.common.versioning.InvalidVersionSpecificationException;
//import net.minecraftforge.fml.common.versioning.VersionRange;

/*public class ModContainer extends ForgeModContainer {
	
}*/

/**
 * This class is currently unused.
 */
public class ModContainer /*extends DummyModContainer*/ {
	
	/*@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		System.out.println("Hallo Welt!");
		return true;
	}*/
	
}

/*public class ModContainer extends DummyModContainer{
	
	private URL updateJSONUrl = null;

	public ModContainer()
	{
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "lootingmod";
		meta.name = "Looting VI Mod";
		meta.version = "1.0";
		meta.description = "...";
		meta.url = "";
		meta.updateJSON = ";
		meta.authorList = Collections.singletonList("ToMe25");

		try { updateJSONUrl = new URL(meta.updateJSON); } catch (MalformedURLException e) {}
		System.out.println("Hallo Welt!");
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		System.out.println("Hallo Welt!");
		return true;
	}

	@Override
	public URL getUpdateUrl()
	{
		System.out.println("Hallo Welt!");
		return updateJSONUrl;
	}
	
	/*private URL updateJSONUrl = null;

	public ModContainer()
	{
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "lootingmod";
		meta.name = "Looting VI Mod";
		meta.version = "1.0";
		meta.description = "...";
		meta.url = "";
		meta.updateJSON = ";
		meta.authorList = Collections.singletonList("ToMe25");
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		return true;
	}

	@Override
	public URL getUpdateUrl()
	{
		try { return new URL(getMetadata().updateJSON); } catch (MalformedURLException e) { return null; }
	}

    @Override
    public VersionRange acceptableMinecraftVersionRange()
    {
        try
		{
			return VersionRange.createFromVersionSpec("[1.12,1.12.2]");
		}
		catch (InvalidVersionSpecificationException ex)
		{
			return super.acceptableMinecraftVersionRange();
		}
	}*/
	
	/*public ModContainer()
	{
		super(new ModMetadata());
		/*ModMetadata meta = getMetadata();
		meta.modId = "lootingmod";
		meta.name = "Looting VI Mod";
		meta.version = "1.0";
		meta.description = "...";
		meta.url = "";
		meta.updateJSON = ";
		meta.authorList = Collections.singletonList("ToMe25");*//*
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		return true;
	}

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        try{
			return VersionRange.createFromVersionSpec("[1.12,1.12.2]");
		}
		catch (Exception ex) {
			return super.acceptableMinecraftVersionRange();
		}
    }*//*

}*/