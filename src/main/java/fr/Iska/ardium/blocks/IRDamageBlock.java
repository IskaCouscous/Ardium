package fr.Iska.ardium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class IRDamageBlock {
	public static Block DamageBlock;
	 
	public static void init()
	{
		  DamageBlock = new fr.Iska.ardium.blocks2.DamageBlock(Material.rock).setBlockName("damageblock").setCreativeTab(Tab.tabArdium).setBlockTextureName(References.MODID + ":damage_block").setHardness(5.0F);		
	}
	
	

	public static void register()
	{
		GameRegistry.registerBlock(DamageBlock, DamageBlock.getUnlocalizedName().substring(5));
	}
}
