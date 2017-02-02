package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.blocks2.BlockSlabMod;
import fr.Iska.ardium.blocks2.BlockStairsMod;
import fr.Iska.ardium.blocks2.Blocks2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ArdiumBlock 
{
	public static Block ardium_block,ardium_stairs,ardium_fences,ardium_fence_gate;
	 
	public static void init()
	{
		ardium_block = new Blocks2(Material.rock, 2).setBlockName("ardium.block").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":ardium_block").setHardness(5.0F);	
		ardium_stairs = new BlockStairsMod(ardium_block, 0).setBlockName("ardium_stairs").setCreativeTab(Tab.tabArdium);
		ardium_fences = new BlockFenceMod("ardium:ardium_block", Material.rock).setBlockName("ardium_fences").setCreativeTab(Tab.tabArdium);

		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(ardium_block, ardium_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ardium_stairs, ardium_stairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ardium_fences, ardium_fences.getUnlocalizedName().substring(5));
		
	}
}
