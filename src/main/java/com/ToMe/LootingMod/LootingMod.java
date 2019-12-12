package com.ToMe.LootingMod;

import java.io.File;

//import net.minecraft.client.Minecraft;
//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.Enchantment.Rarity;
//import net.minecraft.enchantment.EnumEnchantmentType;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.common.MinecraftForge;
//import net.minecraft.item.EnumRarity;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/*import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.swing.event.TableEvent;
import net.minecraft.command.CommandGive;
import net.minecraft.command.CommandKill;*/

//@Mod(modid = "lootingmod", name = "Looting VI MOD", version = "1.0")
@Mod(modid = LootingMod.MODID, name = LootingMod.NAME, version = LootingMod.VERSION, acceptedMinecraftVersions = LootingMod.MCVERSION)
public class LootingMod {
	
	@Instance
	public static LootingMod instance = new LootingMod();
	public static final String MODID = "lootingmod";
	public static final String NAME = "Looting VI Mod";
	public static final String VERSION = "1.0";
	public static final String MCVERSION = "[1.10,1.10.2]";
	
	public static final CreeperKill CreeperKill = new CreeperKill();
	//public static final Enchantment CreeperKill = new CreeperKill(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, null);
	//public static final Enchantment CreeperKill = new CreeperKill(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	//public static final Enchantment SharpnessVI = new SharpVI(Rarity.UNCOMMON, 0, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	//public static final Enchantment LootingVI = new LootingVI(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	//private int i = 0;
	//private int ii = 0;
	
	public static ConfigHandler cfg;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		if(cfg == null) {
			File cfg = e.getSuggestedConfigurationFile();
			this.cfg = new ConfigHandler(cfg);
		}
		//LoadEnchants();
		//System.out.println("PreInit");
		//cfg = new ConfigHandler(e);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		
		//FMLCommonHandler.instance().bus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
		LoadEnchants();
		
	}
	
	@EventHandler
	public void getPostInit(FMLPostInitializationEvent e){
		//LoadEnchants();
	}
	
	public void LoadEnchants() {
		
		if(cfg.EnableCreeperKill) {
			//GameRegistry.register(CreeperKill.setRegistryName("CreeperKill"));
			GameRegistry.register(CreeperKill);
		}
		//System.out.println("Loading Enchant!");
		//GameRegistry.register(CreeperKill.setRegistryName("CreeperKill"));
		//Registry.registerEnchantments();
		//GameRegistry.register(LootingVI, new ResourceLocation("minecraft:looting"));
		//GameRegistry.register(LootingVI, new ResourceLocation("minecraft:Looting"));
		//GameRegistry.register(new SharpVI(EnumRarity.RARE, 0, slots), name)
		//GameRegistry.register(new Loot, name)
		//Registry.registerEnchantments();
		
	}
	
	/**@SubscribeEvent
	public void onTick(PlayerTickEvent e) {
		EntityPlayer player = e.player;
		//player.setFire(12);
		if(player.getHeldItemMainhand() != null) {
			ItemStack Tool;
			Tool = player.getHeldItemMainhand();//.getEnchantmentTagList();
			if(Tool.isItemEnchanted()) {
				//System.out.println(Tool.getEnchantmentTagList().toString());
				if(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI))) {
					if(Tool.getEnchantmentTagList().get(i).toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI))) {
						NBTTagList list = Tool.getEnchantmentTagList();
						player.inventory.deleteStack(Tool);
						ItemStack Tool2 = new ItemStack(Tool.getItem(), 1, Tool.getItemDamage());
						Tool2.addEnchantment(Enchantment.getEnchantmentByID(16), 6);
						int iii = 0;
						while(iii<100) {
							//i++;
							if(list.toString().contains("id:"+iii+"s") && iii != Enchantment.getEnchantmentID(Registry.SharpVI) && iii != 16) {
								int iiii = 0;
								while(iiii<11) {
									//ii++;
									if(list.toString().contains("lvl:"+iiii+"s,id:"+iii)) {
										//System.out.println("Klappt");
										Tool2.addEnchantment(Enchantment.getEnchantmentByID(iii), iiii);
									}
									//else
										//System.err.println(list.toString());
									iiii++;
								}
							}
							iii++;
						}
						player.inventory.setInventorySlotContents(player.inventory.currentItem, Tool2);
						//System.out.println(Tool2.getEnchantmentTagList().toString());
					//if(Tool.getEnchantmentTagList().get(i).toString().contains("id:11")) {
						/**if(Tool.getEnchantmentTagList().toString().contains("id:16")) {
							while(Tool.getEnchantmentTagList().toString().contains("id:16")) {
								if(Tool.getEnchantmentTagList().get(ii).toString().contains("id:16")) {
									NBTTagCompound list = (NBTTagCompound) Tool.getEnchantmentTagList().removeTag(ii);
									player.replaceItemInInventory(1, new ItemStack(Tool.getItem(), 1, Tool.getMetadata(), list));
									//Tool.addEnchantment(Enchantments.SHARPNESS, 6);
									ii=0;
								}
								else
									ii++;
							}
							//Tool.addEnchantment(Enchantments.SHARPNESS, 6);
						}
						else {
							//NBTTagCompound list = (NBTTagCompound) Tool.getEnchantmentTagList().removeTag(i);
							//Tool.getEnchantmentTagList().removeTag(i);
							ItemStack Tool2 = new ItemStack(Tool.getItem(), 1, Tool.getItemDamage());
							//player.replaceItemInInventory(InventoryPlayer.getHotbarSize(), new ItemStack(Items.ACACIA_BOAT));//Tool.getItem(), 1, Tool.getMetadata(), list));
							//player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
							//player.replaceItemInInventory(37, Tool2);
							//player.inventory.addItemStackToInventory(Tool2);
							//player.inventory.addItemStackToInventory(new ItemStack(Items.ACACIA_BOAT));
							Tool2.addEnchantment(Enchantments.SHARPNESS, 6);
							//player.inventory.setInventorySlotContents(player.inventory.currentItem, Tool2);
							System.out.println(Tool2.getEnchantmentTagList().toString());
							player.inventory.deleteStack(Tool);
							//player.inventory.removeStackFromSlot(player.inventory.currentItem);
							//player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
							player.inventory.addItemStackToInventory(Tool2);
							i=0;
						}*/
					/**}
					else
						i++;
				}
				else {
					//System.out.println(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI)));
					//System.out.println("id:"+Enchantment.getEnchantmentID(Registry.SharpVI));
				}
				if(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.LootingIV))) {
					NBTTagList list = Tool.getEnchantmentTagList();
					player.inventory.deleteStack(Tool);
					ItemStack Tool2 = new ItemStack(Tool.getItem(), 1, Tool.getItemDamage());
					if(Tool.getEnchantmentTagList().toString().contains("lvl:1s,id:"+Enchantment.getEnchantmentID(Registry.LootingIV))) {
						Tool2.addEnchantment(Enchantment.getEnchantmentByID(21), 4);
					}
					if(Tool.getEnchantmentTagList().toString().contains("lvl:2s,id:"+Enchantment.getEnchantmentID(Registry.LootingIV))) {
						Tool2.addEnchantment(Enchantment.getEnchantmentByID(21), 5);
					}
					if(Tool.getEnchantmentTagList().toString().contains("lvl:3s,id:"+Enchantment.getEnchantmentID(Registry.LootingIV))) {
						Tool2.addEnchantment(Enchantment.getEnchantmentByID(21), 6);
					}
					int iii = 0;
					while(iii<100) {
						//i++;
						if(list.toString().contains("id:"+iii+"s") && iii != Enchantment.getEnchantmentID(Registry.LootingIV) && iii != 21) {
							int iiii = 0;
							while(iiii<11) {
								//ii++;
								if(list.toString().contains("lvl:"+iiii+"s,id:"+iii)) {
									//System.out.println("Klappt");
									Tool2.addEnchantment(Enchantment.getEnchantmentByID(iii), iiii);
								}
								//else
									//System.err.println(list.toString());
								iiii++;
							}
						}
						iii++;
					}
					player.inventory.setInventorySlotContents(player.inventory.currentItem, Tool2);
					//System.out.println(Tool2.getEnchantmentTagList().toString());
				}
			}
		}
	}*/
	
	/**@SubscribeEvent
	public void onTick(ServerTickEvent e) {
		
		EntityPlayer player;
		if(FMLClientHandler.instance().getClient().thePlayer != null) {
			player = FMLClientHandler.instance().getClientPlayerEntity();
			System.out.println(player.toString());
			//player.inventory.addItemStackToInventory(new ItemStack(Items.ACACIA_BOAT, 1));
			//if(player.inventory.getCurrentItem() != null) {
				//System.out.println(player.inventory.getCurrentItem().toString());
			//}
			//player.inventory.setItemStack(new ItemStack(Items.ACACIA_BOAT, 1));
			player.inventory
		}
		
	}
	
	/**@SubscribeEvent
	public void onTick(ClientTickEvent e) {
		
		
		//if(FMLClientHandler.instance().getClientPlayerEntity() != null) {
			//EntityPlayer player = FMLClientHandler.instance().getClientPlayerEntity();
			//player.setFire(1234);
			
		//}
		
	}*/
	
	/**@SubscribeEvent
	//public void onTick(WorldTickEvent e) {
	public void onTick(ClientTickEvent e){
		
		EntityPlayer player;
		if(FMLClientHandler.instance().getClient().theWorld != null){
			
			player = FMLClientHandler.instance().getClient().thePlayer;
			if(player.getHeldItemMainhand() != null) {
				ItemStack Tool;
				Tool = player.getHeldItemMainhand();//.getEnchantmentTagList();
				if(Tool.isItemEnchanted()) {
					//System.out.println(Tool.getEnchantmentTagList().toString());
					if(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI))) {
						//if(Tool.getEnchantmentTagList().get(i).toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI))) {
						if(Tool.getEnchantmentTagList().get(i).toString().contains("id:11")) {
							if(Tool.getEnchantmentTagList().toString().contains("id:16")) {
								while(Tool.getEnchantmentTagList().toString().contains("id:16")) {
									if(Tool.getEnchantmentTagList().get(ii).toString().contains("id:16")) {
										NBTTagCompound list = (NBTTagCompound) Tool.getEnchantmentTagList().removeTag(ii);
										player.replaceItemInInventory(1, new ItemStack(Tool.getItem(), 1, Tool.getMetadata(), list));
										//Tool.addEnchantment(Enchantments.SHARPNESS, 6);
										ii=0;
									}
									else
										ii++;
								}
								Tool.addEnchantment(Enchantments.SHARPNESS, 6);
							}
							else {
								//NBTTagCompound list = (NBTTagCompound) Tool.getEnchantmentTagList().removeTag(i);
								//Tool.getEnchantmentTagList().removeTag(i);
								ItemStack Tool2 = new ItemStack(Tool.getItem(), 1, Tool.getItemDamage());
								//player.replaceItemInInventory(InventoryPlayer.getHotbarSize(), new ItemStack(Items.ACACIA_BOAT));//Tool.getItem(), 1, Tool.getMetadata(), list));
								//player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
								//player.replaceItemInInventory(37, Tool2);
								//player.inventory.addItemStackToInventory(Tool2);
								//player.inventory.addItemStackToInventory(new ItemStack(Items.ACACIA_BOAT));
								Tool2.addEnchantment(Enchantments.SHARPNESS, 6);
								//player.inventory.setInventorySlotContents(player.inventory.currentItem, Tool2);
								System.out.println(Tool2.getEnchantmentTagList().toString());
								player.inventory.deleteStack(Tool);
								player.inventory.removeStackFromSlot(player.inventory.currentItem);
								player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
								//player.inventory.addItemStackToInventory(Tool2);
								i=0;
							}
						}
						else
							i++;
					}
					else {
						//System.out.println(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI)));
						//System.out.println("id:"+Enchantment.getEnchantmentID(Registry.SharpVI));
					}
				}
				else {
					//System.out.println(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI)));
					//System.out.println("id:"+Enchantment.getEnchantmentID(Registry.SharpVI));
				}
			}
			
		}
	}*/
	
	/**@SubscribeEvent
	public void onTick(WorldTickEvent e) {
		
		EntityPlayer player;
		if(FMLClientHandler.instance().getClient().theWorld != null){
			if(FMLClientHandler.instance().getClient().thePlayer != null) {
				player = FMLClientHandler.instance().getClient().thePlayer;
				if(player.getHeldItemMainhand() != null) {
					ItemStack Tool;
					Tool = player.getHeldItemMainhand();//.getEnchantmentTagList();
					if(Tool.isItemEnchanted()) {
						if(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI))) {
							//if(Tool.getEnchantmentTagList().get(i).toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI))) {
							if(Tool.getEnchantmentTagList().get(i).toString().contains("id:11")) {
								if(Tool.getEnchantmentTagList().toString().contains("id:16")) {
									while(Tool.getEnchantmentTagList().toString().contains("id:16")) {
										if(Tool.getEnchantmentTagList().get(ii).toString().contains("id:16")) {
											NBTTagCompound list = (NBTTagCompound) Tool.getEnchantmentTagList().removeTag(ii);
											player.replaceItemInInventory(1, new ItemStack(Tool.getItem(), 1, Tool.getMetadata(), list));
											//Tool.addEnchantment(Enchantments.SHARPNESS, 6);
											ii=0;
										}
										else
											ii++;
									}
									Tool.addEnchantment(Enchantments.SHARPNESS, 6);
								}
								else {
									//NBTTagCompound list = (NBTTagCompound) Tool.getEnchantmentTagList().removeTag(i);
									//Tool.getEnchantmentTagList().removeTag(i);
									ItemStack Tool2 = new ItemStack(Tool.getItem(), 1, Tool.getItemDamage());
									//player.replaceItemInInventory(InventoryPlayer.getHotbarSize(), new ItemStack(Items.ACACIA_BOAT));//Tool.getItem(), 1, Tool.getMetadata(), list));
									//player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
									//player.replaceItemInInventory(37, Tool2);
									//player.inventory.addItemStackToInventory(Tool2);
									//player.inventory.addItemStackToInventory(new ItemStack(Items.ACACIA_BOAT));
									Tool2.addEnchantment(Enchantments.SHARPNESS, 6);
									//player.inventory.setInventorySlotContents(player.inventory.currentItem, Tool2);
									System.out.println(Tool2.getEnchantmentTagList().toString());
									player.inventory.deleteStack(Tool);
									player.inventory.removeStackFromSlot(player.inventory.currentItem);
									player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
									//player.inventory.addItemStackToInventory(Tool2);
									i=0;
								}
							}
							else
								i++;
						}
						else {
							//System.out.println(Tool.getEnchantmentTagList().toString().contains("id:"+Enchantment.getEnchantmentID(Registry.SharpVI)));
							//System.out.println("id:"+Enchantment.getEnchantmentID(Registry.SharpVI));
						}
					}
				}
			}
			
		}
		
	}*/
	
}
