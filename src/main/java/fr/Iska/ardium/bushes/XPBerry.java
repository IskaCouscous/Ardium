package fr.Iska.ardium.bushes;

import fr.Iska.ardium.Tab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class XPBerry  extends Item
{
	  public XPBerry()
	  {
	    setMaxStackSize(64);
	    setUnlocalizedName("experienceberry");
	    setCreativeTab(Tab.tabArdium);
	    setTextureName("Ardium:xpberry");
	  }
	  
	  public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	  {
	    stack.stackSize -= 1;
	    player.addExperience(20);
	    return stack;
	  }
	}
