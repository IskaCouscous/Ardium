package fr.Iska.ardium.ae2;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.Ardium;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;

public class MEPortableChest extends Item
{
	public static final String NAME = "meportbablechest";

	public MEPortableChest() {
		this.setUnlocalizedName(References.MODID + "_" + NAME);
		this.setTextureName(References.MODID + ":" + NAME);
		this.setCreativeTab(Tab.tabArdium);
		this.setTextureName("ardium:backpack");
		this.maxStackSize = 1; // N'oubliez pas ceci, çà empêche l'item d'être stackable

	}

	
	/**
	 * Used to open the gui
	 */
	 public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	  {
	    if (!world.isRemote)
	    {
	      player.openGui(Ardium.instance, 1, world, 0, 0, 0);
	      NBTTagCompound nbt = player.getHeldItem().getTagCompound();
	      nbt.setBoolean("Open", true);
	    }
	    return stack;
	  }
	  
	  public void onUpdate(ItemStack stack, World world, Entity e, int in, boolean b)
	  {
	    if ((stack.hasTagCompound()) && (stack.getTagCompound().hasKey("Open")) && 
	      (!b)) {
	      stack.getTagCompound().setBoolean("Open", false);
	    }
	    super.onUpdate(stack, world, e, in, b);
	  }
	}

