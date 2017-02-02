package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ArdiumLAntern 
{
	public static Block ardium_lantern;
	 
	public static void init()
	{
		ardium_lantern = new Blocks2(Material.rock, 2).setBlockName("ardium_lantern").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":ardium_lantern").setLightLevel(1.0F).setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(ardium_lantern, ardium_lantern.getUnlocalizedName().substring(5));
	}
}
