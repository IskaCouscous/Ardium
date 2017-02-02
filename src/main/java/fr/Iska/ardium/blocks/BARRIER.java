package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import fr.Iska.ardium.blocks2.Invisible;
import fr.Iska.ardium.blocks2.Opaque;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BARRIER 
{
	public static Block barrier;
	 
	public static void init()
	{
		barrier = new Invisible().setResistance(10000000000000000000000.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(barrier, barrier.getUnlocalizedName().substring(5));
	}
}
