package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ArdiumPrismarine 
{
	public static Block ardium_prismanire;
	 
	public static void init()
	{
		ardium_prismanire = new Blocks2(Material.rock, 2).setBlockName("ardium_prismanire").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":prismarine_rough").setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(ardium_prismanire, ardium_prismanire.getUnlocalizedName().substring(5));
	}
}
