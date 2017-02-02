package fr.Iska.ardium.admin;

import fr.Iska.ardium.Ardium;
import fr.Iska.ardium.Tab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemAdminChest extends Item
{
	  public ItemAdminChest()
	  {
	    setMaxStackSize(1);
	    setUnlocalizedName("admintool");
	    setCreativeTab(Tab.tabArdium);
	    setTextureName("ardium:admintool");
	  }
	  
	  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	  {
	    if (!world.isRemote)
	    {
	      TileEntity tile = world.getTileEntity(x, y, z);
	      if (tile == null) {
	        return false;
	      }
	      if (((tile instanceof IInventory)) && (tile.getClass().toString().contains("Chest")))
	        
	      {
	        player.openGui(Ardium.instance, 50, world, x, y, z);
	        return true;
	      }
	    }
	    return true;
	  }
	}
