package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OiumBlock 
{
	public static Block oxium_block;
	 
	public static void init()
	{
		oxium_block = new Blocks2(Material.rock, 2).setBlockName("oxium.block").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":oxium_block").setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(oxium_block, oxium_block.getUnlocalizedName().substring(5));
	}
}
