package fr.Iska.ardium.box;

import java.util.ArrayList;
import java.util.Random;

import fr.Iska.ardium.Ardium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArdiumBox extends Block
{
	  public ArdiumBox(Material p_i45394_1_, int i)
	  {
	    super(p_i45394_1_);
	  }
	  
	  public Item getItemDropped(int par1, Random par2Random, int par3)
	  {
	    return Item.getItemFromBlock(Blocks.air);
	  }
	  
	  public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	  {
	    ArrayList<ItemStack> stack = super.getDrops(world, x, y, z, metadata, fortune);
	    int randInt = world.rand.nextInt(14);
	    switch (randInt)
	    {
	    case 0: 
	      stack.add(new ItemStack(Ardium.oxiumnugget,1));
	      break;
	    case 1: 
	      stack.add(new ItemStack(Items.poisonous_potato, 1));
	      break;
	    case 2: 
	      stack.add(new ItemStack(Ardium.record_nevergonna, 1));
	      break;
	    case 3: 
	      stack.add(new ItemStack(Blocks.jukebox, 1));
	      break;
	    case 4: 
	      stack.add(new ItemStack(Ardium.oxiumnugget, 1));
	      break;
	    case 5: 
	      stack.add(new ItemStack(Blocks.coal_block, 1));
	      break;
	    case 6: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
	    case 7: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
	    case 8: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
	    case 9: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
	    case 10: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
	    case 11: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
	    case 12: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
	    case 13: 
		      stack.add(new ItemStack(Blocks.coal_block, 1));
		      break;
		      
	    
	  
	    }
	    return stack;
	  }
	}

