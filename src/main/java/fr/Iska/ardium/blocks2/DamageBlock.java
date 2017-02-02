package fr.Iska.ardium.blocks2;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DamageBlock  extends Block
{
	   private static final Logger logger = LogManager.getLogger();
	    @SideOnly(Side.CLIENT)
	    private IIcon field_149991_b;
	    @SideOnly(Side.CLIENT)
	    private IIcon field_149993_M;
	    @SideOnly(Side.CLIENT)
	    private IIcon field_149994_N;
	    private static final String __OBFID = "CL_00000251";
	    
	 public DamageBlock(Material material)
	  {
	    super(material);
	    setHardness(2.0F);
	    setResistance(2.0F);
	}

	
	  
	 public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	  {
	    for (int i = 0; i < 5; i++) {
	      ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 220, 1));
	      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 220, 1));
	    
	    }
	  }
	 /**
	     * Gets the block's texture. Args: side, meta
	     */
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	    {
	        return p_149691_1_ == 1 ? this.field_149991_b : (p_149691_1_ == 0 ? Blocks.dirt.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
	    }

	    /**
	     * Ticks the block if it's been scheduled
	     */
	    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
	    {
	        if (!p_149674_1_.isRemote)
	        {
	            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2)
	            {
	                p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.dirt);
	            }
	            else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
	            {
	                for (int l = 0; l < 4; ++l)
	                {
	                    int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
	                    int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
	                    int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
	                    Block block = p_149674_1_.getBlock(i1, j1 + 1, k1);

	                    if (p_149674_1_.getBlock(i1, j1, k1) == Blocks.dirt && p_149674_1_.getBlockMetadata(i1, j1, k1) == 0 && p_149674_1_.getBlockLightValue(i1, j1 + 1, k1) >= 4 && p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
	                    {
	                        p_149674_1_.setBlock(i1, j1, k1, Blocks.grass);
	                    }
	                }
	            }
	        }
	    }

	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return Blocks.dirt.getItemDropped(0, p_149650_2_, p_149650_3_);
	    }

	    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
	    {
	        return true;
	    }

	    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
	    {
	        return true;
	    }

	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
	    {
	        if (p_149673_5_ == 1)
	        {
	            return this.field_149991_b;
	        }
	        else if (p_149673_5_ == 0)
	        {
	            return Blocks.dirt.getBlockTextureFromSide(p_149673_5_);
	        }
	        else
	        {
	            Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
	            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.field_149993_M;
	        }
	    }

	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister p_149651_1_)
	    {
	        this.blockIcon = p_149651_1_.registerIcon("grass"+ "_side");
	        this.field_149991_b = p_149651_1_.registerIcon("grass"+ "_top");
	        this.field_149993_M = p_149651_1_.registerIcon("grass"+ "_side_snowed");
	        this.field_149994_N = p_149651_1_.registerIcon("grass"+ "_side_overlay");
	    }

	    @SideOnly(Side.CLIENT)
	    public int getBlockColor()
	    {
	        double d0 = 0.5D;
	        double d1 = 1.0D;
	        return ColorizerGrass.getGrassColor(d0, d1);
	    }

	    /**
	     * Returns the color this block should be rendered. Used by leaves.
	     */
	    @SideOnly(Side.CLIENT)
	    public int getRenderColor(int p_149741_1_)
	    {
	        return this.getBlockColor();
	    }

	    /**
	     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
	     * when first determining what to render.
	     */
	    @SideOnly(Side.CLIENT)
	    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
	    {
	        int l = 0;
	        int i1 = 0;
	        int j1 = 0;

	        for (int k1 = -1; k1 <= 1; ++k1)
	        {
	            for (int l1 = -1; l1 <= 1; ++l1)
	            {
	                int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1, p_149720_4_ + k1).getBiomeGrassColor(p_149720_2_ + l1, p_149720_3_, p_149720_4_ + k1);
	                l += (i2 & 16711680) >> 16;
	                i1 += (i2 & 65280) >> 8;
	                j1 += i2 & 255;
	            }
	        }

	        return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	    }

	   

	           
	        
	    
	}
