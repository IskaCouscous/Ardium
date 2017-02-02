package fr.Iska.ardium.blocks2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.Tab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidFakeWater  extends BlockFluidClassic
{
	  @SideOnly(Side.CLIENT)
	  protected IIcon stillIcon;
	  @SideOnly(Side.CLIENT)
	  protected IIcon flowingIcon;
	  
	  public FluidFakeWater(Fluid fluid, Material material)
	  {
	    super(fluid, material);
	    setHardness(100.0F);
	    setBlockName("fakewater");
	    setCreativeTab(Tab.tabArdium);
	  }
	  
	  public IIcon getIcon(int side, int meta)
	  {
	    return (side == 0) || (side == 1) ? this.stillIcon : this.flowingIcon;
	  }
	  
	  
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister register)
	  {
	    this.stillIcon = register.registerIcon("minecraft:water_still");
	    this.flowingIcon = register.registerIcon("minecraft:water_flow");
	  }
	  
	  public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	  {
	    if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
	      return false;
	    }
	    return super.canDisplace(world, x, y, z);
	  }
	  
	  public boolean displaceIfPossible(World world, int x, int y, int z)
	  {
	    if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
	      return false;
	    }
	    return super.displaceIfPossible(world, x, y, z);
	  }
	  
	  public void onEntityCollidedWithBlock(World wolrd, int x, int y, int z, Entity entity)
	  {
	    super.onEntityCollidedWithBlock(wolrd, x, y, z, entity);
	    if (!(entity instanceof EntityPlayer)) {
	      return;
	    }
	    EntityLivingBase livingBase = (EntityLivingBase)entity;
	    
	    livingBase.attackEntityFrom(DamageSource.magic, 3.0F);
	  }
	}
