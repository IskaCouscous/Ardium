package fr.Iska.ardium.blocks2;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.BigPickaxe.TConstructRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSlabMod  extends Block
{
	  Block modelBlock;
	  int startingMeta;
	  int totalSize;
	  
	  public BlockSlabMod(Material material)
	  {
	    super(material);
	    setCreativeTab(Tab.tabArdium);
	  }
	  
	  public BlockSlabMod(Material material, Block model, int meta, int totalSize)
	  {
	    super(material);
	    setCreativeTab(Tab.tabArdium);
	    this.modelBlock = model;
	    this.startingMeta = meta;
	    this.totalSize = totalSize;
	  }
	  
	  public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisalignedbb, List arraylist, Entity entity)
	  {
	    setBlockBoundsBasedOnState(world, x, y, z);
	    super.addCollisionBoxesToList(world, x, y, z, axisalignedbb, arraylist, entity);
	  }
	  
	  public void setBlockBoundsForItemRender()
	  {
	    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	  }
	  
	  public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	  {
	    int meta = world.getBlockMetadata(x, y, z) / 8;
	    float minY = meta == 1 ? 0.5F : 0.0F;
	    float maxY = meta == 1 ? 1.0F : 0.5F;
	    setBlockBounds(0.0F, minY, 0.0F, 1.0F, maxY, 1.0F);
	  }
	  
	  public int onBlockPlaced(World par1World, int blockX, int blockY, int blockZ, int side, float clickX, float clickY, float clickZ, int metadata)
	  {
	    if (side == 1) {
	      return metadata;
	    }
	    if ((side == 0) || (clickY >= 0.5F)) {
	      return metadata | 0x8;
	    }
	    return metadata;
	  }
	  
	  public boolean isOpaqueCube()
	  {
	    return false;
	  }
	  
	  public boolean renderAsNormalBlock()
	  {
	    return false;
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister iconRegister) {}
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(int side, int meta)
	  {
	    meta = meta % 8 + this.startingMeta;
	    return this.modelBlock.getIcon(side, meta);
	  }
	  
	  public void getSubBlocks(Item id, CreativeTabs tab, List list)
	  {
	    for (int iter = 0; iter < this.totalSize; iter++) {
	      list.add(new ItemStack(id, 1, iter));
	    }
	  }
	  
	  public int damageDropped(int meta)
	  {
	    return meta % 8;
	  }
	}
