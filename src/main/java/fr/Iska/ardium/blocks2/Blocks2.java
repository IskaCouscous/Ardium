package fr.Iska.ardium.blocks2;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks2 extends Block
{
	public Blocks2(Material p_i45394_1_, int level) 
	{
		super(p_i45394_1_);
		this.setHarvestLevel("pickaxe", level);
	}

}
