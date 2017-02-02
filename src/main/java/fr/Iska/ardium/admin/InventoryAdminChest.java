package fr.Iska.ardium.admin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryAdminChest implements IInventory
{
	  public int getSizeInventory()
	  {
	    return 1;
	  }
	  
	  public ItemStack getStackInSlot(int slot)
	  {
	    return null;
	  }
	  
	  public ItemStack decrStackSize(int slotIndex, int amount)
	  {
	    return null;
	  }
	  
	  public ItemStack getStackInSlotOnClosing(int slotIndex)
	  {
	    return null;
	  }
	  
	  public void setInventorySlotContents(int slotIndex, ItemStack stack) {}
	  
	  public String getInventoryName()
	  {
	    return "Inventory.AdmiNTool";
	  }
	  
	  public boolean hasCustomInventoryName()
	  {
	    return false;
	  }
	  
	  public int getInventoryStackLimit()
	  {
	    return 64;
	  }
	  
	  public void markDirty() {}
	  
	  public boolean isUseableByPlayer(EntityPlayer player)
	  {
	    return true;
	  }
	  
	  public void openInventory() {}
	  
	  public void closeInventory() {}
	  
	  public boolean isItemValidForSlot(int slot, ItemStack stack)
	  {
	    return true;
	  }
	}
