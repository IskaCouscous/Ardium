package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public class OxiumOre
{
	 public static Block oxium_ore;
	 
		public static void init()
		{
			oxium_ore = new Blocks2(Material.rock, 2).setBlockName("oxium.ore").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":oxium_ore").setLightLevel(1000).setHardness(5.0F);		
		}
		
		public static void register()
		{
			GameRegistry.registerBlock(oxium_ore, oxium_ore.getUnlocalizedName().substring(5));
		}
}
