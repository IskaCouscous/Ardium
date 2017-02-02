package fr.Iska.ardium.blocks2;

import fr.Iska.ardium.blocks.MultiItemBlock;
import net.minecraft.block.Block;

public class glassmoditem extends MultiItemBlock
{
	  public static final String[] blockTypes = { "white", "orange", "magenta", "lightblue", "yellow", "lime", "pink", "gray", "lightgray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
	  
	  public glassmoditem(Block b)
	  {
	    super(b, "block.stainedglass", blockTypes);
	    setMaxDamage(0);
	    setHasSubtypes(true);
	  }
	}
