package fr.Iska.ardium.blocks2;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Opaque extends Block
{

	public Opaque(Material p_i45394_1_, int i) {
		super(p_i45394_1_);
	}
  public boolean isOpaqueCube()
  {
	  return false;
  }
}
