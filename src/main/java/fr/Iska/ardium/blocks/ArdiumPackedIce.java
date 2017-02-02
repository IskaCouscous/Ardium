package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ArdiumPackedIce 
{
	public static Block ardium_ice;
	 
	public static void init()
	{
		ardium_ice = new Blocks2(Material.packedIce, 2).setBlockName("ardium.ice").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":ardium_ice").setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(ardium_ice, ardium_ice.getUnlocalizedName().substring(5));
	}
}
