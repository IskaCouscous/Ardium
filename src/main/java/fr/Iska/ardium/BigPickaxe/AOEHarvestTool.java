package fr.Iska.ardium.BigPickaxe;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;

public abstract class AOEHarvestTool extends HarvestTools
{
	  public int breakRadius;
	  public int breakDepth;
	  
	  public AOEHarvestTool(int baseDamage, int breakRadius, int breakDepth)
	  {
	    super(baseDamage);
	    
	    this.breakRadius = breakRadius;
	    this.breakDepth = breakDepth;
	  }
	  
	  public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player)
	  {
	    stack.damageItem(9, player);
	    Block block = player.worldObj.getBlock(x, y, z);
	    int meta = player.worldObj.getBlockMetadata(x, y, z);
	    if ((block == null) || (!isEffective(block, meta))) {
	      return super.onBlockStartBreak(stack, x, y, z, player);
	    }
	    MovingObjectPosition mop = AbilityHelper.raytraceFromEntity(player.worldObj, player, false, 4.5D);
	    if (mop == null) {
	      return super.onBlockStartBreak(stack, x, y, z, player);
	    }
	    int sideHit = mop.sideHit;
	    
	    int xRange = this.breakRadius;
	    int yRange = this.breakRadius;
	    int zRange = this.breakDepth;
	    switch (sideHit)
	    {
	    case 0: 
	    case 1: 
	      yRange = this.breakDepth;
	      zRange = this.breakRadius;
	      break;
	    case 2: 
	    case 3: 
	      xRange = this.breakRadius;
	      zRange = this.breakDepth;
	      break;
	    case 4: 
	    case 5: 
	      xRange = this.breakDepth;
	      zRange = this.breakRadius;
	    }
	    for (int xPos = x - xRange; xPos <= x + xRange; xPos++) {
	      for (int yPos = y - yRange; yPos <= y + yRange; yPos++) {
	        for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
	          if ((xPos != x) || (yPos != y) || (zPos != z)) {
	            if (!super.onBlockStartBreak(stack, xPos, yPos, zPos, player)) {
	              breakExtraBlock(player.worldObj, xPos, yPos, zPos, sideHit, player, x, y, z);
	            }
	          }
	        }
	      }
	    }
	    return super.onBlockStartBreak(stack, x, y, z, player);
	  }
	}