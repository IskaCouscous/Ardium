package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.ConnectedTexturesBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CavernBlock 
{
	 public static Block cave;
	 
		public static void init()
		{
			cave = new ConnectedTexturesBlock("uingot", false).setBlockName("cave").setCreativeTab(Tab.tabArdium).setHardness(5.0F);		
		}
		
		public static void register()
		{
			GameRegistry.registerBlock(cave, cave.getUnlocalizedName().substring(5));
		}
}
