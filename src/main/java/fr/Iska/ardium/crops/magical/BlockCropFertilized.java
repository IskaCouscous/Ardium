package fr.Iska.ardium.crops.magical;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.Ardium;
import fr.Iska.ardium.crops.BlockCropsMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockCropFertilized extends BlockCropsMod
{
	  @SideOnly(Side.CLIENT)
	  private IIcon[] iconArray;
	  
	  public BlockCropFertilized(int par1)
	  {
	    setBlockName("FertilizedCrop");
	
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
	    return Ardium.fertilized_seed;
	  }
	  
	 
	  
	  protected Item func_149865_P()
	  {
	    return Ardium.magical_essences;
	  }
	  
	  public int damageDropped(int i)
	  {
	    return 4;
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister p_149651_1_)
	  {
	    this.iconArray = new IIcon[4];
	    for (int i = 0; i < this.iconArray.length; i++) {
	      this.iconArray[i] = p_149651_1_.registerIcon("ardium:crops/fertilized/Crop_" + i);
	    }
	  }
	}

