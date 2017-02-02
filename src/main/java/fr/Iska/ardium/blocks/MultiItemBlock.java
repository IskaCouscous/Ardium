package fr.Iska.ardium.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class MultiItemBlock extends ItemBlock
{
	  private String[] blockType;
	  private String unlocalizedName;
	  private String append;
	  private int[] specialIndex = { -1, -1 };
	  
	  public MultiItemBlock(Block b, String itemBlockUnlocalizedName, String[] blockTypes)
	  {
	    super(b);
	    if (itemBlockUnlocalizedName.isEmpty()) {
	      this.unlocalizedName = super.getUnlocalizedName();
	    } else {
	      this.unlocalizedName = itemBlockUnlocalizedName;
	    }
	    this.blockType = blockTypes;
	    this.append = "";
	  }
	  
	  public MultiItemBlock(Block b, String itemBlockUnlocalizedName, String appendToEnd, String[] blockTypes)
	  {
	    super(b);
	    this.unlocalizedName = itemBlockUnlocalizedName;
	    this.blockType = blockTypes;
	    this.append = ("." + appendToEnd);
	  }
	  
	  public void setSpecialIndex(int clampIndex, int stringBuilderIndex)
	  {
	    this.specialIndex[0] = clampIndex;
	    this.specialIndex[1] = stringBuilderIndex;
	  }
	  
	  public int getMetadata(int meta)
	  {
	    return meta;
	  }
	  
	  public String getUnlocalizedName(ItemStack itemstack)
	  {
	    int pos = MathHelper.clamp_int(itemstack.getItemDamage(), 0, this.specialIndex[0] > -1 ? this.specialIndex[0] : this.blockType.length - 1);
	    int sbIndex = this.specialIndex[1] > -1 ? pos : this.specialIndex[1] - pos;
	    if (sbIndex < 0) {
	      sbIndex = -1 * sbIndex;
	    }
	    try
	    {
	      return this.unlocalizedName + "." + this.blockType[(sbIndex - 1)] + this.append;
	    }
	    catch (ArrayIndexOutOfBoundsException ex)
	    {
	    
	    }
	    return getUnlocalizedName();
	  }
	}

