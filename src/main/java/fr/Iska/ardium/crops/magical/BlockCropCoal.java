package fr.Iska.ardium.crops.magical;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.Ardium;
import fr.Iska.ardium.crops.BlockCropsMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockCropCoal extends BlockCropsMod
{
	  @SideOnly(Side.CLIENT)
	  private IIcon[] iconArray;
	  
	  public BlockCropCoal(int par1)
	  {
	    setBlockName("CoalCrop");
	
	  }
	  
	  public int getRenderType()
	  {
	    return 1;
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(int par1, int par2)
	  {
	    if (par2 < 7)
	    {
	      if (par2 == 6) {
	        par2 = 5;
	      }
	      return this.iconArray[(par2 >> 1)];
	    }
	    return this.iconArray[3];
	  }
	 
	  protected Item func_149866_i()
	  {
	    return Ardium.coal_seed;
	  }
	  
	 
	  
	  protected Item func_149865_P()
	  {
	    return Ardium.CropEssencesT1;
	  }
	  
	  public int damageDropped(int i)
	  {
	    return 1;
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister p_149651_1_)
	  {
	    this.iconArray = new IIcon[4];
	    for (int i = 0; i < this.iconArray.length; i++) {
	      this.iconArray[i] = p_149651_1_.registerIcon("ardium:crops/coal/Crop_" + i);
	    }
	  }
	}

