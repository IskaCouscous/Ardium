package fr.Iska.ardium.admin;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAdminChest extends Slot
{
	  public SlotAdminChest(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_)
	  {
	    super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
	  }
	  
	  public boolean isItemValid(ItemStack p_75214_1_)
	  {
	    return true;
	  }
	  
	  public ItemStack decrStackSize(int p_75209_1_)
	  {
	    return null;
	  }
	}
