package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.Ardium;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArdiumOre
{
	 public static Block ardium_ore;
	 
		public static void init()
		{
			ardium_ore = new Blocks2(Material.rock, 2).setBlockName("ardium.ore").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":ardium_ore").setHardness(5.0F);		
		}
		
		public static void register()
		{
			GameRegistry.registerBlock(ardium_ore, ardium_ore.getUnlocalizedName().substring(5));
		}
}
