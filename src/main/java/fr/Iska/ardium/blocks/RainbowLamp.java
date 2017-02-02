package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RainbowLamp 
{
	public static Block RainbowLamp;
	 
	public static void init()
	{
		RainbowLamp = new Blocks2(Material.rock, 2).setBlockName("RainbowLamp").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":rainbowlamp").setLightLevel(1.0F).setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(RainbowLamp, RainbowLamp.getUnlocalizedName().substring(5));
	}
}
