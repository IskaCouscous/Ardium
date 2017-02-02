package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DarkArdPris 
{
	public static Block ardium_prismanireb;
	 
	public static void init()
	{
		ardium_prismanireb = new Blocks2(Material.rock, 2).setBlockName("ardium_prismanireb").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":prismarine_dark").setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(ardium_prismanireb, ardium_prismanireb.getUnlocalizedName().substring(5));
	}
}
