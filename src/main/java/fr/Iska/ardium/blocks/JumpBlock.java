package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import fr.Iska.ardium.blocks2.umplock;

public class JumpBlock 
{
	public static Block jump_block;
	 
	public static void init()
	{
		jump_block = new umplock(Material.rock, 2).setBlockName("jump.block").setCreativeTab(Tab.tabArdium).setHardness(5.0F);		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(jump_block, jump_block.getUnlocalizedName().substring(5));
	}
}
