package fr.Iska.ardium.BigPickaxe;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ToolCore  extends Item
{
	  protected Random random = new Random();
	  protected int damageVsEntity;
	  public static IIcon blankSprite;
	  public static IIcon emptyIcon;
	  
	  public ToolCore(int baseDamage)
	  {
	    this.maxStackSize = 1;
	    setMaxDamage(3000);
	    
	    this.damageVsEntity = baseDamage;
	    this.canRepair = true;
	  }
	  
	  public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player)
	  {
	    boolean cancelHarvest = false;
	    for (ActiveToolMod mod : TConstructRegistry.activeModifiers) {
	      if (mod.beforeBlockBreak(this, stack, x, y, z, player)) {
	        cancelHarvest = true;
	      }
	    }
	    return cancelHarvest;
	  }
	  
	  public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase player)
	  {
	    if ((block != null) && (block.getBlockHardness(world, x, y, z) != 0.0D)) {
	      return AbilityHelper.onBlockChanged(itemstack, world, block, x, y, z, player, this.random);
	    }
	    return true;
	  }
	}
