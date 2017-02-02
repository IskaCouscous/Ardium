package fr.Iska.ardium.cdblock;

import java.util.ArrayList;
import java.util.Random;

import fr.Iska.ardium.Ardium;
import fr.Iska.ardium.items.ArdiumIngot;
import fr.Iska.ardium.items.Ardium_Apple;
import fr.Iska.ardium.items.OxiumIngot;
import fr.Iska.ardium.items.OxiumTools;
import fr.Iska.ardium.items.Oxium_Apple;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CDBlock extends Block
{
	  public CDBlock(Material p_i45394_1_, int i)
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
	    int randInt = world.rand.nextInt(11);
	    switch (randInt)
	    {
	    case 0: 
	      stack.add(new ItemStack(Ardium.record_copi,1));
	      break;
	    case 1: 
	      stack.add(new ItemStack(Ardium.record_imbad, 1));
	      break;
	    case 2: 
	      stack.add(new ItemStack(Ardium.record_nevergonna, 1));
	      break;
	    case 3: 
	      stack.add(new ItemStack(Ardium.recordzebre, 1));
	      break;
	    case 4: 
	      stack.add(new ItemStack(Ardium.rs, 1));
	      break;
	    case 5: 
	      stack.add(new ItemStack(Ardium.rs1, 1));
	      break;
	    case 6: 
		      stack.add(new ItemStack(Ardium.record_HEYEAH, 1));
		      break;
	    case 7: 
		      stack.add(new ItemStack(Ardium.record_demondelanuit, 1));
		      break;
	    case 8: 
		      stack.add(new ItemStack(Ardium.record_littlegirls, 1));
		      break;
	    case 9: 
		      stack.add(new ItemStack(Ardium.record_pokemongo, 1));
		      break;
	    case 10: 
		      stack.add(new ItemStack(Ardium.record_sandstorm, 1));
		      break;
	    case 11: 
		      stack.add(new ItemStack(Ardium.record_sweden, 1));
		      break;
		      
	    
	  
	    }
	    return stack;
	  }
	}
