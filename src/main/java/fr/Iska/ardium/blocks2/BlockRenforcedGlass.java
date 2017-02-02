package fr.Iska.ardium.blocks2;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.Tab;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRenforcedGlass   extends BlockClearGlass
{
	  public String[] textures;
	  public IIcon[][] icons;
	  
	  public BlockRenforcedGlass(String location, boolean hasAlpha, String... textures)
	  {
	    super(location, hasAlpha);
	    this.textures = textures;
	    this.icons = new IIcon[textures.length][16];
	    this.setCreativeTab(Tab.tabArdium);
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	  {
	    int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
	    if (meta < this.icons.length) {
	      return getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, this.icons[meta]);
	    }
	    return getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, this.icons[0]);
	  }
	  
	  public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, Block par5, int par6)
	  {
	    return (par5 == this) && ((par6 == par1IBlockAccess.getBlockMetadata(par2, par3, par4)));
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(int par1, int par2)
	  {
	    return this.icons[par2][0];
	  }
	  
	  public void getSubBlocks(Item b, CreativeTabs par2CreativeTabs, List par3List)
	  {
	    for (int i = 0; i < this.textures.length; i++) {
	      par3List.add(new ItemStack(b, 1, i));
	    }
	  }
	  
	  public void registerBlockIcons(IIconRegister par1IconRegister)
	  {
	    for (int i = 0; i < this.textures.length; i++)
	    {
	      this.icons[i][0] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass");
	      this.icons[i][1] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_1_d");
	      this.icons[i][2] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_1_u");
	      this.icons[i][3] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_1_l");
	      this.icons[i][4] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_1_r");
	      this.icons[i][5] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_2_h");
	      this.icons[i][6] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_2_v");
	      this.icons[i][7] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_2_dl");
	      this.icons[i][8] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_2_dr");
	      this.icons[i][9] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_2_ul");
	      this.icons[i][10] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_2_ur");
	      this.icons[i][11] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_3_d");
	      this.icons[i][12] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_3_u");
	      this.icons[i][13] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_3_l");
	      this.icons[i][14] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_3_r");
	      this.icons[i][15] = par1IconRegister.registerIcon("tinker:glass/" + this.folder + "/" + this.textures[i] + "/glass_4");
	    }
	  }
	  
	  public int damageDropped(int par1)
	  {
	    return par1;
	  }
	  
	  public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
	  {
	    return true;
	  }
	}
