package fr.Iska.ardium.admin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerAdminChest extends Container
{
	  IInventory inventory;
	  
	  public ContainerAdminChest(TileEntity tile)
	  {
	    this.inventory = ((IInventory)tile);
	    
	    int i = 0;
	    int j = 0;
	    for (i = 0; i < 108; i++)
	    {
	      if (i % 12 == 0) {
	        j++;
	      }
	      int u = i % 12 + 1;
	      if (i < this.inventory.getSizeInventory()) {
	        addSlotToContainer(new SlotAdminChest(this.inventory, i, u * 18 - 6, j * 18 - 10));
	      } else {
	        addSlotToContainer(new SlotAdminChest(new InventoryAdminChest(), 0, u * 18 - 6, j * 18 - 10));
	      }
	    }
	  }
	  
	  public boolean canInteractWith(EntityPlayer player)
	  {
	    return this.inventory.isUseableByPlayer(player);
	  }
	  
	  public ItemStack slotClick(int slotIndex, int buttonPressed, int flag, EntityPlayer player)
	  {
	    return null;
	  }
	  
	  public ItemStack transferStackInSlot(EntityPlayer player, int quantity)
	  {
	    return null;
	  }
	}
