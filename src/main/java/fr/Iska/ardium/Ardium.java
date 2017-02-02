package fr.Iska.ardium;

import org.lwjgl.opengl.Display;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.Iska.ardium.admin.ItemAdminChest;
import fr.Iska.ardium.ae2.AE2BlocksRegister;
import fr.Iska.ardium.ae2.MEPortableChest;
import fr.Iska.ardium.armors.ArdiumArmor;
import fr.Iska.ardium.armors.OxiumArmor;
import fr.Iska.ardium.armors.TestArmor;
import fr.Iska.ardium.blocks.ArdiumBlock;
import fr.Iska.ardium.blocks.ArdiumLAntern;
import fr.Iska.ardium.blocks.ArdiumOre;
import fr.Iska.ardium.blocks.ArdiumPackedIce;
import fr.Iska.ardium.blocks.ArdiumPrismarine;
import fr.Iska.ardium.blocks.ArdiumPrismarineBrick;
import fr.Iska.ardium.blocks.BARRIER;
import fr.Iska.ardium.blocks.CavernBlock;
import fr.Iska.ardium.blocks.DarkArdPris;
import fr.Iska.ardium.blocks.IRDamageBlock;
import fr.Iska.ardium.blocks.JumpBlock;
import fr.Iska.ardium.blocks.OiumBlock;
import fr.Iska.ardium.blocks.OxiumOre;
import fr.Iska.ardium.blocks.RainbowLamp;
import fr.Iska.ardium.blocks.SeaLantern;
import fr.Iska.ardium.blocks.XPOre;
import fr.Iska.ardium.blocks2.BlockArmorStand;
import fr.Iska.ardium.blocks2.BlockCableTier1;
import fr.Iska.ardium.blocks2.BlockClearGlass;
import fr.Iska.ardium.blocks2.BlockCreativeEnergyCell;
import fr.Iska.ardium.blocks2.BlockFlowerMod;
import fr.Iska.ardium.blocks2.BlockHaloweenGrass;
import fr.Iska.ardium.blocks2.BlockRenforcedGlass;
import fr.Iska.ardium.blocks2.Blocks2;
import fr.Iska.ardium.blocks2.Blocks2Big;
import fr.Iska.ardium.blocks2.ConnectedTexturesBlock;
import fr.Iska.ardium.blocks2.FluidFakeWater;
import fr.Iska.ardium.blocks2.glassmoditem;
import fr.Iska.ardium.box.ArdiumBox;
import fr.Iska.ardium.bushes.ArdiumBush;
import fr.Iska.ardium.bushes.BushXP;
import fr.Iska.ardium.bushes.DiamondBush;
import fr.Iska.ardium.bushes.OxiumBush;
import fr.Iska.ardium.bushes.XPBerry;
import fr.Iska.ardium.cdblock.CDBlock;
import fr.Iska.ardium.crops.BlockOxiumCrops;
import fr.Iska.ardium.crops.magical.BlockCropAir;
import fr.Iska.ardium.crops.magical.BlockCropCertus;
import fr.Iska.ardium.crops.magical.BlockCropCoal;
import fr.Iska.ardium.crops.magical.BlockCropDiamond;
import fr.Iska.ardium.crops.magical.BlockCropEarth;
import fr.Iska.ardium.crops.magical.BlockCropEmerald;
import fr.Iska.ardium.crops.magical.BlockCropFertilized;
import fr.Iska.ardium.crops.magical.BlockCropFire;
import fr.Iska.ardium.crops.magical.BlockCropGold;
import fr.Iska.ardium.crops.magical.BlockCropInferium;
import fr.Iska.ardium.crops.magical.BlockCropIntermedium;
import fr.Iska.ardium.crops.magical.BlockCropIron;
import fr.Iska.ardium.crops.magical.BlockCropLapis;
import fr.Iska.ardium.crops.magical.BlockCropLvl2;
import fr.Iska.ardium.crops.magical.BlockCropRedstone;
import fr.Iska.ardium.crops.magical.BlockCropSuperium;
import fr.Iska.ardium.crops.magical.BlockCropSupremium;
import fr.Iska.ardium.crops.magical.BlockCropWater;
import fr.Iska.ardium.crops.magical.EventOnCropBroked;
import fr.Iska.ardium.crops.magical.ItemCropEssencesT1;
import fr.Iska.ardium.crops.magical.ItemCropEssencesT2;
import fr.Iska.ardium.crops.magical.ItemCropEssencesT3;
import fr.Iska.ardium.crops.magical.ItemElementEssences;
import fr.Iska.ardium.crops.magical.ItemInfusedFragment;
import fr.Iska.ardium.crops.magical.ItemMagicalEssences;
import fr.Iska.ardium.crops.magical.SeedAir;
import fr.Iska.ardium.crops.magical.SeedCertus;
import fr.Iska.ardium.crops.magical.SeedCoal;
import fr.Iska.ardium.crops.magical.SeedDiamond;
import fr.Iska.ardium.crops.magical.SeedEarth;
import fr.Iska.ardium.crops.magical.SeedEmerald;
import fr.Iska.ardium.crops.magical.SeedFertilized;
import fr.Iska.ardium.crops.magical.SeedFire;
import fr.Iska.ardium.crops.magical.SeedGold;
import fr.Iska.ardium.crops.magical.SeedInferium;
import fr.Iska.ardium.crops.magical.SeedIntermedium;
import fr.Iska.ardium.crops.magical.SeedIron;
import fr.Iska.ardium.crops.magical.SeedLapis;
import fr.Iska.ardium.crops.magical.SeedRedstone;
import fr.Iska.ardium.crops.magical.SeedWater;
import fr.Iska.ardium.crops.magical.SeedsSuperium;
import fr.Iska.ardium.crops.magical.SeedsSupremium;
import fr.Iska.ardium.dynamite.EntityRegister;
import fr.Iska.ardium.dynamite.ItemStickDynamite;
import fr.Iska.ardium.elytra.ItemElytra;
import fr.Iska.ardium.enchentements.EnchantmentPoison;
import fr.Iska.ardium.enchentements.PoisonEnchent;
import fr.Iska.ardium.food.Bigmac;
import fr.Iska.ardium.food.Frites;
import fr.Iska.ardium.food.SoupOfMrRainbow;
import fr.Iska.ardium.food2.ItemPotionMod;
import fr.Iska.ardium.furnace.ArdiumFurnace;
import fr.Iska.ardium.furnace.OxiumFurnace;
import fr.Iska.ardium.furnace.TileEntityArdiumFurnace;
import fr.Iska.ardium.furnace.TileEntityOxiumFurnace;
import fr.Iska.ardium.item2.ItemDynamite;
import fr.Iska.ardium.items.ArdiumCrystal;
import fr.Iska.ardium.items.ArdiumIngot;
import fr.Iska.ardium.items.ArdiumShard;
import fr.Iska.ardium.items.ArdiumTools;
import fr.Iska.ardium.items.Ardium_Apple;
import fr.Iska.ardium.items.DrillParts;
import fr.Iska.ardium.items.HealStick;
import fr.Iska.ardium.items.JumpStick;
import fr.Iska.ardium.items.ObsidianBreacker;
import fr.Iska.ardium.items.OxiumIngot;
import fr.Iska.ardium.items.OxiumTools;
import fr.Iska.ardium.items.Oxium_Apple;
import fr.Iska.ardium.items.SpeedStick;
import fr.Iska.ardium.items2.FlaskBase;
import fr.Iska.ardium.items2.ItemSwordLava;
import fr.Iska.ardium.items2.ModBucket;
import fr.Iska.ardium.packets.PacketPipeline;
import fr.Iska.ardium.proxy.CommonProxy;
import fr.Iska.ardium.radarexplorator.ItemRadarExplorator;
import fr.Iska.ardium.recipes.RecipesBasic;
import fr.Iska.ardium.recipes.recipesreloader;
import fr.Iska.ardium.recipes.recipesscientific;
import fr.Iska.ardium.records.Record;
import fr.Iska.ardium.reloader.BlockReloader;
import fr.Iska.ardium.reloader.ReloaderTileEntity;
import fr.Iska.ardium.scientificmachine.BlockScientificMachine;
import fr.Iska.ardium.scientificmachine.GUIhandler;
import fr.Iska.ardium.scientificmachine.ScientificMachineTileEntity;
import fr.Iska.ardium.seeds.OxiumSeed;
import fr.Iska.ardium.spikes.BlockSpike;
import fr.Iska.ardium.tile.TileCableTier1;
import fr.Iska.ardium.tile.TileCreativeEnergyCell;
import fr.Iska.ardium.tile.TileEntityArmorStand;
import fr.Iska.ardium.title.CommandTitle;
import fr.Iska.ardium.world.WorldRegister;
import fr.Iska.ardiumcards.items.DeathArmors;
import fr.Iska.ardiumcards.items.ItemsCard;
import fr.Iska.ardiumcards.items.LavaSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;



@Mod(modid = References.MODID , name = References.MODNAME , version = References.MODVERSION)

public class Ardium 
{
	
	@Instance(References.MODID)
	public static Ardium instance;
	
	public static Enchantment enchantPoison;
	  public static PacketPipeline packets = new PacketPipeline();
	
	@SidedProxy (clientSide = References.CLIENT_PROXY , serverSide = References.SERVER_PROXY)

	public static CommonProxy proxy;
	 public static FMLEventChannel ch_BiblioAStand;
    public static Item ardiumstoragecell,ardiumpotion,oxiumpotion,east,west,sud,nord;
	public static Item dynamite, dynamitestick,pistilleflower,admintool;
	public static Block glassmod,reloader;
	public static XPBerry xpBerry;
	public static Item CropEssencesT1,CropEssencesT3,CropEssencesT2;
	public static Item fertilized_seed,gold_seed,emerald_seed,redstone_seed,inferium_seed,intermidium_seed,superium_seed,supremium_seed,iron_seed,coal_seed,lapis_seed;
	public static Block fertilized_crop,diamond_crop,certus_crop,certuslvl2_crop,gold_crop,redstone_crop,emerald_crop,inferium_crop,intermidium_crop,superium_crops,supremium_crops,iron_crop,coal_crop,lapis_crop;
	public static BushXP xpBush;
	public static DiamondBush dbush;
	public static ArdiumBush abush;
	public static OxiumBush obush;
	public static Item lightsaber;
	public static Block regen,scientificmachine,cdblock,blockflowerardium,lblock,burnedquartz,ardium_big_block,ardiumfurnace;
	public static BlockOxiumCrops OxiumPlant;
	public static Item OxiumSeeds,diamond_seed,certus_seed,certuslvl2_seed;
	public static Block ardiumenergycell,ardiumcabletier1;
	public static Item OxiumSeedsFragment;
	public static Item recordzebre,record_imbad,record_nevergonna,record_copi,rs,rs1,oxiumnugget,radar,dollar,record_nyan,record_HEYEAH,record_littlegirls,record_pokemongo,record_demondelanuit,record_sandstorm,record_sweden;
	public static Block andesite,smooth_andesite,fire_crop,water_crop,OxiumFurnace,air_crop,earth_crop,diorite,haloweendirt,smooth_diorite,granite,smooth_granite,purple_lapis_block,clearglass;
	public static Item elytra,flask_heal;
	public static Item PortableMEChest,fakewaterbucket,infused_fragment,element_essences,magical_essences,air_seed,earth_seed,water_seed,fire_seed;
	public static BlockSpike spikeIron;
	  public static BlockSpike spikeWood;
	  public static BlockSpike spikeDiamond;
	  public static BlockSpike spikeGold,spikeardium,spikeoxium;
	  public static FluidFakeWater fakewater;
	  public static Fluid fluidfakewater;
	public static Block armorStand ;

	  public static boolean enableElytra = true;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
	   
		 if (event.getSide() == Side.CLIENT)
		    {
		      FMLCommonHandler.instance().bus().register(new ItemRadarExplorator());
		      MinecraftForge.EVENT_BUS.register(new ItemRadarExplorator());
		    }
		
		 if (event.getSide() == Side.CLIENT)
		    {

			 Display.setTitle("Ardium - v.5");
		    }
		

	
		 ArdiumBlock.init();
		 ArdiumBlock.register();
		 OiumBlock.init();
		 OiumBlock.register();
		 OxiumOre.init();
		 OxiumOre.register();
		 SeaLantern.init();
		 SeaLantern.register();
		 ArdiumLAntern.init();
		 ArdiumLAntern.register();
		 XPOre.init();
		 XPOre.register();
		 IRDamageBlock.init();
		 IRDamageBlock.register();
		 CavernBlock.init();
		 CavernBlock.register();
		 ArdiumPackedIce.init();
		 ArdiumPackedIce.register();
		 ArdiumPrismarine.init();
		 ArdiumPrismarine.register();
		 ArdiumPrismarineBrick.init();
		 ArdiumPrismarineBrick.register();
		 AE2BlocksRegister.init();
		 DarkArdPris.init();
		 DarkArdPris.register();
		 RainbowLamp.init();
		 RainbowLamp.register();
		 enchantPoison = new EnchantmentPoison(120, 0, EnumEnchantmentType.weapon).setName("enchantPoison");
		 	MinecraftForge.EVENT_BUS.register(new PoisonEnchent());
		 JumpBlock.init();
		 JumpBlock.register();
		 BARRIER.init();
		 BARRIER.register();
		 Ardium_Apple.init();
		 Ardium_Apple.register();
		 Oxium_Apple.init();
		 Oxium_Apple.register();
		 Bigmac.init();
		 Bigmac.register();
		 Frites.init();
		 Frites.register();
	     ArdiumOre.init();
	     ArdiumOre.register();
	     ArdiumIngot.init();
	     ArdiumIngot.register();
	     OxiumIngot.init();
	     OxiumIngot.register();
	     HealStick.init();
	     HealStick.register();
	     JumpStick.init();
	     JumpStick.register();
	     SpeedStick.init();
	     SpeedStick.register();
	     SoupOfMrRainbow.init();
	     SoupOfMrRainbow.register();
	     WorldRegister.mainRegistry();
	     ArdiumTools.init();
	     ArdiumTools.register();
	     OxiumTools.init();
	     OxiumTools.register();
	     OxiumArmor.init();
	     OxiumArmor.register();
	     ArdiumArmor.init();
	     ArdiumArmor.register();
	     ArdiumCrystal.init();
	     ArdiumCrystal.register();
	     ArdiumShard.init();
	     ArdiumShard.register();
	     ObsidianBreacker.init();
	     ObsidianBreacker.register();
	     DrillParts.init();
	     DrillParts.register();
	     DeathArmors.init();
	     ItemsCard.init();
	     LavaSword.init();
	     TestArmor.init();
	     TestArmor.register();
	     fertilized_crop = new BlockCropFertilized(0);
	     inferium_crop = new BlockCropInferium(0);
	     superium_crops = new BlockCropSuperium(0);
         supremium_crops = new BlockCropSupremium(0);
         intermidium_crop = new BlockCropIntermedium(0);
         inferium_seed = new SeedInferium(inferium_crop, inferium_crop).setUnlocalizedName("inferium_seed");
         intermidium_seed = new SeedIntermedium(intermidium_crop,intermidium_crop).setUnlocalizedName("intermedium_seed");
         superium_seed = new SeedsSuperium(superium_crops,superium_crops).setUnlocalizedName("superium_seed");
         supremium_seed = new SeedsSupremium(supremium_crops,supremium_crops).setUnlocalizedName("supremium_seed");
         fertilized_seed = new SeedFertilized(fertilized_crop, fertilized_crop).setUnlocalizedName("fertilized_seed");
         
         
	     burnedquartz = new ConnectedTexturesBlock("dark", false).setBlockName("burnedquartz").setHardness(4.0F);
	     oxiumnugget = new Item().setTextureName("ardium:oxiumnuget").setUnlocalizedName("oxiumnugget").setCreativeTab(Tab.tabArdium);
	     recordzebre = new Record("shuffle").setUnlocalizedName("recordshuffle").setTextureName("ardium:recordshuffle");
	     pistilleflower = new Item().setCreativeTab(Tab.tabArdium).setTextureName(References.MODID +":ardiumpistille").setUnlocalizedName("ardiumpistille");
	     scientificmachine = new BlockScientificMachine().setBlockName("scientificmachine");
	     dynamite = new ItemDynamite("Dynamite");
         dynamitestick = new ItemStickDynamite("DynamiteStick").setTextureName("Ardium:stick_dynamite").setUnlocalizedName("dynamite").setCreativeTab(Tab.tabArdium);
         xpBerry = new XPBerry();
         lblock = new ArdiumBox(Material.rock,2).setCreativeTab(Tab.tabArdium).setBlockTextureName("ardium:ardium_box1").setBlockName("ardium_box").setHardness(4.0F);
         lightsaber = new ItemSwordLava(LavaSword.admin).setUnlocalizedName("lightsaber").setCreativeTab(Tab.tabArdium);
         OxiumPlant = new BlockOxiumCrops(0);
         OxiumSeeds = new OxiumSeed(OxiumPlant, OxiumPlant).setUnlocalizedName("oxiumseed");
         OxiumSeedsFragment = new Item().setUnlocalizedName("oxiumfragment").setTextureName("ardium:oxiumfragment").setCreativeTab(Tab.tabArdium);
         record_imbad = new Record("Ardium - I'm bad").setUnlocalizedName("Ardium - I'm bad").setTextureName("ardium:Ardium - I'm bad");
         record_nevergonna = new Record("Ardium - Never gonna give you up").setUnlocalizedName("Ardium - Never gonna give you up").setTextureName("ardium:Ardium - Never gonna give you up");
         record_copi = new Record("Ardium - No Copiright").setUnlocalizedName("Ardium - No Copiright").setTextureName("ardium:Ardium - No Copiright");
         record_nyan = new Record("Ardium - Nyan Cat").setUnlocalizedName("Ardium - Nyan Cat").setTextureName("ardium:Ardium - Sweeters");
         rs = new Record("Ardium - Spooky Scary Skeletons").setUnlocalizedName("Ardium - Spooky Scary Skeletons").setTextureName("ardium:Ardium - Spooky Scary Skeletons");
         rs1 = new Record("Ardium - Sweeters").setUnlocalizedName("Ardium - Sweeters").setTextureName("ardium:Ardium - Sweeters");
         cdblock = new CDBlock(Material.rock,2).setCreativeTab(Tab.tabArdium).setHardness(5.0F).setBlockTextureName(References.MODID + ":ardium_box").setBlockName("ardiumcdbox");
         blockflowerardium = new BlockFlowerMod().setBlockTextureName("ardium:flower1").setCreativeTab(Tab.tabArdium).setBlockName("flower1");
         radar = new ItemRadarExplorator().setTextureName("ardium:detector").setUnlocalizedName("wandexplorator").setCreativeTab(Tab.tabArdium);
         dollar = new Item().setCreativeTab(Tab.tabArdium).setTextureName("ardium:dolar").setUnlocalizedName("dolar1");
         ardium_big_block = new Blocks2Big(Material.rock, 2).setCreativeTab(Tab.tabArdium).setBlockName("ardium_big_block").setBlockTextureName(References.MODID +":ardium_big_block").setHardness(4.0F);
         andesite = new Blocks2(Material.rock, 2).setCreativeTab(Tab.tabArdium).setBlockName("andesite").setBlockTextureName("stone_andesite").setHardness(4.0F);
         smooth_andesite = new Blocks2(Material.rock, 2).setCreativeTab(Tab.tabArdium).setBlockName("andesite_smooth").setBlockTextureName("stone_andesite_smooth").setHardness(4.0F);
         diorite = new Blocks2(Material.rock, 2).setCreativeTab(Tab.tabArdium).setBlockName("diorite").setBlockTextureName("stone_diorite").setHardness(4.0F);
         smooth_diorite = new Blocks2(Material.rock, 2).setCreativeTab(Tab.tabArdium).setBlockName("diorite_smooth").setBlockTextureName("stone_diorite_smooth").setHardness(4.0F);
         granite = new Blocks2(Material.rock, 2).setCreativeTab(Tab.tabArdium).setBlockName("granite").setBlockTextureName("stone_granite").setHardness(4.0F);
         smooth_granite = new Blocks2(Material.rock, 2).setCreativeTab(Tab.tabArdium).setBlockName("granite_smooth").setBlockTextureName("stone_granite_smooth").setHardness(4.0F);
         purple_lapis_block = new Blocks2(Material.rock, 1).setCreativeTab(Tab.tabArdium).setBlockName("purplelapisblock").setBlockTextureName("ardium:purple_lapis_block").setHardness(2.0F);
         clearglass = new BlockClearGlass("clearglass", false).setBlockName("clearglass");
         record_HEYEAH = new Record("HEYYEYAAEYAAAEYAEYAA").setUnlocalizedName("HEYYEYAAEYAAAEYAEYAA").setTextureName("ardium:Ardium - HEAYYEYEYEYAYEYAYY");
         elytra = new ItemElytra();
         record_littlegirls = new Record("I love little girls").setUnlocalizedName("I love little girls").setTextureName("ardium:Ardium - I love little girls");
         flask_heal = new FlaskBase(0,"heal").setTextureName("ardium:flask_heal");
         PortableMEChest = new MEPortableChest();
         fluidfakewater = new Fluid("fluidfakewater").setDensity(200);
         ardiumpotion = new ItemPotionMod(20, 1.2F, false).setAlwaysEdible().setUnlocalizedName("ardiumpotion").setCreativeTab(Tab.tabArdium).setTextureName("ardium:ardiumpotion");
         oxiumpotion = new ItemPotionMod(20, 1.2F, false).setAlwaysEdible().setUnlocalizedName("oxiumpotion").setCreativeTab(Tab.tabArdium).setTextureName("ardium:oxiumpotion");
         FluidRegistry.registerFluid(fluidfakewater);
         fakewater = new FluidFakeWater(fluidfakewater, Material.water);
         fakewaterbucket = new ModBucket(Ardium.fakewater, "fakewaterbucket", "fakewaterbucket");
         record_pokemongo = new Record("I play Pokemon Go").setUnlocalizedName("I play Pokemon Go").setTextureName("ardium:Ardium - I play Pokémon Go");
         record_demondelanuit = new Record("Les Demons de Minuit").setUnlocalizedName("Les Demons de Minuit").setTextureName("ardium:Ardium - Les Demons de Minuit");
         record_sandstorm = new Record("Sandstorm").setUnlocalizedName("Sandstorm").setTextureName("ardium:Sandstorm");
         record_sweden = new Record("Sweden").setUnlocalizedName("Sweden").setTextureName("ardium:Sweden");
         ardiumenergycell = new BlockCreativeEnergyCell(Material.rock);
         ardiumcabletier1 = new BlockCableTier1(Material.rock);
         ardiumfurnace = new ArdiumFurnace(true, "ardium_furnace_off").setBlockName("ArdiumFurnace").setCreativeTab(Tab.tabArdium);
         spikeIron = new BlockSpike(Material.iron, "spikeiron", "iron_block", "iron_block", 5.0F);
         OxiumFurnace = new OxiumFurnace(true, "oxium_furnace_off").setBlockName("OxiumFurnace").setCreativeTab(Tab.tabArdium);
         spikeWood = new BlockSpike(Material.iron, "spikewood", "planks_oak", "planks_oak", 4.0F);
         spikeDiamond = new BlockSpike(Material.iron, "spikediamond", "diamond_block", "diamond_block", 7.0F);
         spikeGold = new BlockSpike(Material.iron, "spikegold", "gold_block", "gold_block", 6.0F);
         
         haloweendirt = new BlockHaloweenGrass(Material.grass).setHardness(1.0F).setBlockName("0").setBlockTextureName("ardium:haloweendirt");
         infused_fragment = new ItemInfusedFragment().setUnlocalizedName("InfusedFragment");
         element_essences = new ItemElementEssences().setUnlocalizedName("ElementEssence");
         magical_essences = new ItemMagicalEssences().setUnlocalizedName("MagicalEssences");
         CropEssencesT1 = new ItemCropEssencesT1().setUnlocalizedName("CropEssences");
         CropEssencesT2 = new ItemCropEssencesT2().setUnlocalizedName("CropEssences");
         CropEssencesT3  = new ItemCropEssencesT3().setUnlocalizedName("CropEssences");
         air_crop = new BlockCropAir(0);
         earth_crop = new BlockCropEarth(0);
         fire_crop = new BlockCropFire(0);
         water_crop = new BlockCropWater(0);
         air_seed = new SeedAir(air_crop, air_crop).setUnlocalizedName("air_seed");
         earth_seed = new SeedEarth(earth_crop,earth_crop).setUnlocalizedName("earth_seed");
         fire_seed = new SeedFire(fire_crop,fire_crop).setUnlocalizedName("fire_seed");
         water_seed = new SeedWater(water_crop,water_crop).setUnlocalizedName("water_seed");
         iron_crop = new BlockCropIron(0);
         lapis_crop = new BlockCropLapis(0);
         coal_crop = new BlockCropCoal(0);
         iron_seed = new SeedIron(iron_crop, iron_crop).setUnlocalizedName("iron_seed");
         coal_seed = new SeedCoal(coal_crop,coal_crop).setUnlocalizedName("coal_seed");
         lapis_seed = new SeedLapis(lapis_crop,lapis_crop).setUnlocalizedName("lapis_seed");
        
         gold_crop = new BlockCropGold(0);
         redstone_crop = new BlockCropRedstone(0);
         emerald_crop = new BlockCropEmerald(0);
         gold_seed = new SeedGold(gold_crop, gold_crop).setUnlocalizedName("gold_seed");
         redstone_seed = new SeedRedstone(redstone_crop,redstone_crop).setUnlocalizedName("redstone_seed");
         emerald_seed = new SeedEmerald(emerald_crop,emerald_crop).setUnlocalizedName("emerald_seed");
         armorStand = new BlockArmorStand();
         GameRegistry.registerBlock(armorStand, armorStand.getUnlocalizedName().substring(5));
         
         diamond_crop = new BlockCropDiamond(0);
         certus_crop = new BlockCropCertus(0);
         certuslvl2_crop = new BlockCropLvl2(0);
         diamond_seed = new SeedDiamond(diamond_crop, diamond_crop).setUnlocalizedName("diamond_seed");
         certus_seed = new SeedCertus(certus_crop,certus_crop, "certusquartzseed").setUnlocalizedName("certus_seed");
         certuslvl2_seed = new SeedCertus(certuslvl2_crop,certuslvl2_crop, "chargedcertusquartzseed").setUnlocalizedName("certuslvl2_seed");
        east = new Item().setUnlocalizedName("east").setTextureName("ardium:directions/est").setCreativeTab(Tab.tabArdium);
        nord = new Item().setUnlocalizedName("nord").setTextureName("ardium:directions/nord").setCreativeTab(Tab.tabArdium);
        sud = new Item().setUnlocalizedName("sud").setTextureName("ardium:directions/sud").setCreativeTab(Tab.tabArdium);
        west = new Item().setUnlocalizedName("west").setTextureName("ardium:directions/west").setCreativeTab(Tab.tabArdium);
        glassmod = new BlockRenforcedGlass("stained", true, new String[] { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" }).setBlockName("GlassBlock.StainedClear");
        glassmod.stepSound = Block.soundTypeGlass;
        reloader = new BlockReloader().setBlockName("reloader");
        admintool = new ItemAdminChest();
        GameRegistry.registerBlock(glassmod, glassmoditem.class, "GlassBlock.StainedClear");
         GameRegistry.registerItem(PortableMEChest, "PortableMEChest");
         GameRegistry.registerItem(admintool, "admintool");
         
         GameRegistry.registerItem(east, "east");
         GameRegistry.registerItem(nord, "nord");
         GameRegistry.registerItem(sud, "sud");
         GameRegistry.registerItem(west, "west");
         
         GameRegistry.registerItem(dynamite, "dynamite");
         GameRegistry.registerItem(dynamitestick, "dynamitestick");
         GameRegistry.registerItem(CropEssencesT1, "CropEssencesT1");
         GameRegistry.registerItem(CropEssencesT2, "CropEssencesT2");
         GameRegistry.registerItem(CropEssencesT3, "CropEssencesT3");
         GameRegistry.registerItem(xpBerry, "xpBerry");
         GameRegistry.registerBlock(reloader, reloader.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(earth_crop, earth_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(fire_crop, fire_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(water_crop, water_crop.getUnlocalizedName().substring(5));
         
         GameRegistry.registerBlock(iron_crop, iron_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(coal_crop, coal_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(lapis_crop, lapis_crop.getUnlocalizedName().substring(5));
         
         GameRegistry.registerBlock(gold_crop, gold_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(emerald_crop, emerald_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(redstone_crop, redstone_crop.getUnlocalizedName().substring(5));
         
         GameRegistry.registerItem(lightsaber, "lightsaber");
         GameRegistry.registerItem(earth_seed, "earth_seed");
         GameRegistry.registerItem(ardiumpotion, "ardiumpotion");
         GameRegistry.registerItem(oxiumpotion, "oxiumpotion");
         
         GameRegistry.registerItem(OxiumSeeds, "OxiumSeeds");
         GameRegistry.registerItem(OxiumSeedsFragment, "OxiumSeedsFragment");
         GameRegistry.registerItem(oxiumnugget, "oxiumnugget");
         GameRegistry.registerItem(recordzebre, "recordzebre");
         GameRegistry.registerItem(record_littlegirls, "record_littlegirls");
         GameRegistry.registerItem(record_pokemongo, "record_pokemongo");
         GameRegistry.registerItem(record_sandstorm, "record_sandstorm");
         GameRegistry.registerItem(record_sweden, "record_sweden");
         GameRegistry.registerItem(record_demondelanuit, "record_demondelanuit");
         GameRegistry.registerItem(pistilleflower, "pistilleflower");
         GameRegistry.registerItem(radar, "radar");
         GameRegistry.registerItem(dollar, "dollar");
         GameRegistry.registerItem(elytra, "elytra");
         GameRegistry.registerItem(infused_fragment, "infused_fragment");
         GameRegistry.registerItem(element_essences, "element_essences");
         GameRegistry.registerItem(magical_essences, "magical_essences");
         GameRegistry.registerItem(air_seed, "air_seed");
         GameRegistry.registerItem(fire_seed, "fire_seed");
         GameRegistry.registerItem(water_seed, "water_seed");
         GameRegistry.registerItem(iron_seed, "iron_seed");
         GameRegistry.registerItem(lapis_seed, "lapis_seed");
         GameRegistry.registerItem(coal_seed, "coal_seed");
         
         GameRegistry.registerItem(gold_seed, "gold_seed");
         GameRegistry.registerItem(emerald_seed, "emerald_seed");
         GameRegistry.registerItem(redstone_seed, "redstone_seed");
         
         GameRegistry.registerItem(diamond_seed, "diamond_seed");
         GameRegistry.registerItem(certus_seed, "certus_seed");
         GameRegistry.registerItem(certuslvl2_seed, "certuslvl2_seed");
         
         
        
	     EntityRegister.init();
	     
	     
	   
	     xpBush = new BushXP(Ardium.xpBerry);
	     dbush = new DiamondBush(Items.diamond);
	     abush = new ArdiumBush(ArdiumIngot.ardium);
	     obush = new OxiumBush(OxiumIngot.oxium);
         GameRegistry.registerBlock(cdblock, cdblock.getUnlocalizedName().substring(5));
         
         GameRegistry.registerBlock(haloweendirt, haloweendirt.getUnlocalizedName().substring(5));
    
         GameRegistry.registerBlock(air_crop, air_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(scientificmachine, scientificmachine.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(purple_lapis_block, purple_lapis_block.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(clearglass, clearglass.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(andesite, andesite.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(smooth_andesite, smooth_andesite.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(diorite, diorite.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(smooth_diorite, smooth_diorite.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(granite, granite.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(smooth_granite, smooth_granite.getUnlocalizedName().substring(5));
      
         
         GameRegistry.registerBlock(spikeIron, "spikeIron");
         GameRegistry.registerBlock(spikeDiamond, "spikeDiamond");
         GameRegistry.registerBlock(spikeGold, "spikeGold");
         GameRegistry.registerBlock(spikeWood, "spikeWood");

       
         GameRegistry.registerBlock(xpBush, xpBush.getUnlocalizedName().substring(5));
         
         GameRegistry.registerBlock(abush, abush.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(obush, obush.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(dbush, dbush.getUnlocalizedName().substring(5));
         
         GameRegistry.registerBlock(OxiumPlant, OxiumPlant.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(blockflowerardium, blockflowerardium.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(lblock, lblock.getUnlocalizedName().substring(5));
         GameRegistry.registerItem(flask_heal, "flask_heal");
         GameRegistry.registerItem(record_imbad,"Ardium - I'm bad");
         GameRegistry.registerItem(record_nevergonna, "record_nevergonna");
         GameRegistry.registerItem(record_copi, "record_copi");
         GameRegistry.registerItem(record_nyan, "record_nyan");
         GameRegistry.registerItem(record_HEYEAH, " record_HEYEAH");
         GameRegistry.registerItem(rs, "rs");
         GameRegistry.registerItem(rs1, "rs1");
         GameRegistry.registerItem(fakewaterbucket, "fakewaterbucket");
         GameRegistry.registerBlock(burnedquartz, burnedquartz.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(ardium_big_block, ardium_big_block.getUnlocalizedName().substring(5));
         
         GameRegistry.registerBlock(ardiumenergycell, ardiumenergycell.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(ardiumcabletier1, ardiumcabletier1.getUnlocalizedName().substring(5));
 
         
         GameRegistry.registerBlock(ardiumfurnace, ardiumfurnace.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(OxiumFurnace, OxiumFurnace.getUnlocalizedName().substring(5));
         
     
         
         FluidContainerRegistry.registerFluidContainer(Ardium.fluidfakewater, new ItemStack(Ardium.fakewaterbucket), new ItemStack(Items.bucket));

         GameRegistry.registerBlock(fakewater, "fakewater");
         
         GameRegistry.registerBlock(fertilized_crop, fertilized_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(superium_crops, superium_crops.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(supremium_crops, supremium_crops.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(inferium_crop, inferium_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(intermidium_crop, intermidium_crop.getUnlocalizedName().substring(5));
         
         GameRegistry.registerItem(fertilized_seed, "fertilized_seed");
         GameRegistry.registerItem(superium_seed, "superium_seed");
         GameRegistry.registerItem(supremium_seed, "supremium_seed");
         GameRegistry.registerItem(inferium_seed, "inferium_seed");
         GameRegistry.registerItem(intermidium_seed, "intermidium_seed");

         GameRegistry.registerBlock(diamond_crop, diamond_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(certus_crop, certus_crop.getUnlocalizedName().substring(5));
         GameRegistry.registerBlock(certuslvl2_crop, certuslvl2_crop.getUnlocalizedName().substring(5));
         
         ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(this.OxiumSeeds, 0, 1, 3, 10));
         ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(this.OxiumSeeds, 0, 1, 3, 10));
		 }
	    
    
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new EventOnCropBroked());
	   
		proxy.registerRenders();
	    MinecraftForge.EVENT_BUS.register(new BackpackEventHandler());
		RecipesBasic.register();
		GameRegistry.registerTileEntity(ReloaderTileEntity.class, "ardium:reloadertile");
		  GameRegistry.registerTileEntity(ScientificMachineTileEntity.class, "ardium:scientificmachinetile");
		  GameRegistry.registerTileEntity(TileCableTier1.class, "ardium:tilecabletier1");
		  GameRegistry.registerTileEntity(TileCreativeEnergyCell.class, "ardium:creativeenergycelltile");
		  GameRegistry.registerTileEntity(TileEntityArdiumFurnace.class, "ardium:tileardiumfurnace");
		  GameRegistry.registerTileEntity(TileEntityOxiumFurnace.class, "ardium:tileoxiumfurnace");
		  GameRegistry.registerTileEntity(TileEntityArmorStand.class, "ardium:tilearmorstand");
		  ch_BiblioAStand = NetworkRegistry.INSTANCE.newEventDrivenChannel("BiblioAStand");
		  NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIhandler());
		  GameRegistry.addRecipe(new recipesscientific());
		  GameRegistry.addRecipe(new recipesreloader());
		  GameRegistry.addRecipe(new ItemStack (ardiumpotion, 1), new Object[]{"AAA" , "MNM" , "AAA" ,'A' , ArdiumIngot.ardium,'M' , new ItemStack (magical_essences,1,4),'N' , Items.nether_wart}); 
		  GameRegistry.addRecipe(new ItemStack (oxiumpotion, 1), new Object[]{"AAA" , "MNM" , "AAA" ,'A' , OxiumIngot.oxium,'M' , new ItemStack (magical_essences,1,4),'N' , Items.nether_wart});
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
}
	
	   
	    
	
	 
	  @Mod.EventHandler
	  public void serverLoad(FMLServerStartingEvent event)
	  {
	    event.registerServerCommand(new CommandTitle());
	  }
	}

