package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.xpore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class XPOre 
{
	public static Block XPOre ;
	 
	public static void init()
	{
		XPOre  = new xpore(Material.rock).setBlockName("XPOre").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":XPOre").setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(XPOre , XPOre .getUnlocalizedName().substring(5));
	}
}
