package fr.Iska.ardium.blocks2;

import java.util.Random;

import fr.Iska.ardium.Tab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class xpore
extends Block
{
public xpore(Material material)
{
  super(material);
  setCreativeTab(Tab.tabArdium);
  setHardness(2.0F);
  setResistance(2.0F);
}

private Random rand = new Random();

public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
{
  if (getItemDropped(p_149690_5_, this.rand, p_149690_7_) != null) {
    return 100;
  }
  return 0;
}

public int quantityDropped(Random random)
{
  return 0;
}
}
