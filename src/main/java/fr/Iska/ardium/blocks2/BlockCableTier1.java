package fr.Iska.ardium.blocks2;

import fr.Iska.ardium.Tab;
import fr.Iska.ardium.tile.TileCableTier1;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCableTier1 extends BlockContainer{

	public BlockCableTier1(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setCreativeTab(Tab.tabArdium);
		this.setBlockTextureName("ardium:cabletier1");
		this.setBlockName("cabletier1");
		// TODO Auto-generated constructor stub
	}
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	  {
	    return new TileCableTier1();
	  }
	  
	  public boolean hasTileEntity()
	  {
	    return true;
	  }

}
