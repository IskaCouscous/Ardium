package fr.Iska.ardium.blocks2;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BlockFlowerMod  extends BlockBush
{
	  public BlockFlowerMod()
	  {
	    float var3 = 0.4F;
	    setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.9F, 0.5F + var3);
	  }
	  
	  protected boolean canPlaceBlockOn(Block par1)
	  {
	    return (par1 == Blocks.grass);
	  }
	  
	  public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
	  {
	    return (super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)) && (canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_));
	  }
	  
	
	}