package fr.Iska.ardium.blocks2;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RegenBlock extends Block
{
	 public RegenBlock(Material material)
	  {
	    super(material);
	    setHardness(2.0F);
	    setResistance(2.0F);
	}

	
	  
	 public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	  {
	    for (int i = 0; i < 5; i++) {
	      ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
	    }
	  }
	}

