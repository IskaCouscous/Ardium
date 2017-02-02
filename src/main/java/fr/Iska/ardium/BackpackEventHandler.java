package fr.Iska.ardium;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.Iska.ardium.ae2.MEPortableChest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class BackpackEventHandler {
	 @SubscribeEvent
	  public void onLiving(LivingEvent.LivingUpdateEvent paramLivingUpdateEvent)
	  {
	    if ((paramLivingUpdateEvent.entityLiving instanceof EntityPlayer))
	    {
	      EntityPlayer localEntityPlayer = (EntityPlayer)paramLivingUpdateEvent.entityLiving;
	      if (localEntityPlayer.worldObj.getWorldTime() % 100L == 0L)
	      {
	        int i = 0;
	        for (int j = 0; j < localEntityPlayer.inventory.getSizeInventory(); j++)
	        {
	          ItemStack localItemStack = localEntityPlayer.inventory.getStackInSlot(j);
	          if ((localItemStack != null) && ((localItemStack.getItem() instanceof MEPortableChest)))
	          {
	            i++;
	            if (i > 1)
	            {
	              localEntityPlayer.inventory.setInventorySlotContents(j, null);
	              EntityItem localEntityItem = new EntityItem(localEntityPlayer.worldObj, localEntityPlayer.posX, localEntityPlayer.posY, localEntityPlayer.posZ, localItemStack);
	              if (!localEntityPlayer.worldObj.isRemote) {
	                localEntityPlayer.worldObj.spawnEntityInWorld(localEntityItem);
	              }
	              if (localEntityPlayer.worldObj.isRemote) {
	                localEntityPlayer.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Vous ne pouvez pas avoir plus d'un backpack dans votre inventaire !", new Object[0]));
	              }
	            }
	          }
	        }
	      }
	    }
	  }
	  
	  @SubscribeEvent
	  public void onPickUp(EntityItemPickupEvent paramEntityItemPickupEvent)
	  {
	    if ((paramEntityItemPickupEvent.item.getEntityItem().getItem() instanceof MEPortableChest))
	    {
	      EntityPlayer localEntityPlayer = paramEntityItemPickupEvent.entityPlayer;
	      int i = 0;
	      for (int j = 0; j < localEntityPlayer.inventory.getSizeInventory(); j++)
	      {
	        ItemStack localItemStack = localEntityPlayer.inventory.getStackInSlot(j);
	        if ((localItemStack != null) && ((localItemStack.getItem() instanceof MEPortableChest)))
	        {
	          i++;
	          if (i >= 1) {
	            paramEntityItemPickupEvent.setCanceled(true);
	          }
	        }
	      }
	    }
	  }
	}
