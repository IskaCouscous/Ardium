package fr.Iska.ardium.BigPickaxe;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class AbilityHelper {
	 public static boolean onBlockChanged(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase player, Random random)
	  {
	    if (!stack.hasTagCompound()) {
	      return false;
	    }
	    int reinforced = 0;
	    NBTTagCompound tags = stack.getTagCompound();
	    if (tags.getCompoundTag("InfiTool").hasKey("Unbreaking")) {
	      reinforced = tags.getCompoundTag("InfiTool").getInteger("Unbreaking");
	    }
	    if (random.nextInt(10) < 10 - reinforced) {
	      damageTool(stack, 1, tags, player, false);
	    }
	    return true;
	  }
	  
	  public static void damageTool(ItemStack stack, int dam, NBTTagCompound tags, EntityLivingBase entity, boolean ignoreCharge)
	  {
	    if ((((entity instanceof EntityPlayer)) && (((EntityPlayer)entity).capabilities.isCreativeMode)) || (tags == null)) {
	      return;
	    }
	    boolean damagedTool = false;
	    for (ActiveToolMod mod : TConstructRegistry.activeModifiers) {
	      if (mod.damageTool(stack, dam, entity)) {
	        damagedTool = true;
	      }
	    }
	    if (damagedTool) {
	      return;
	    }
	    int damage = tags.getCompoundTag("InfiTool").getInteger("Damage");
	    int damageTrue = damage + dam;
	    int maxDamage = tags.getCompoundTag("InfiTool").getInteger("TotalDurability");
	    if (damageTrue <= 0)
	    {
	      tags.getCompoundTag("InfiTool").setInteger("Damage", 0);
	      
	      tags.getCompoundTag("InfiTool").setBoolean("Broken", false);
	    }
	    else if (damageTrue > maxDamage)
	    {
	      breakTool(stack, tags, entity);
	    }
	    else
	    {
	      tags.getCompoundTag("InfiTool").setInteger("Damage", damage + dam);
	      int toolDamage = damage * 100 / maxDamage + 1;
	      int stackDamage = stack.getItemDamage();
	      if (toolDamage == stackDamage) {}
	    }
	  }
	  
	  public static void breakTool(ItemStack stack, NBTTagCompound tags, Entity entity)
	  {
	    tags.getCompoundTag("InfiTool").setBoolean("Broken", true);
	    if (entity != null) {
	      entity.worldObj.playSound(entity.posX, entity.posY, entity.posZ, "random.break", 1.0F, 1.0F, true);
	    }
	  }
	  
	  public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean par3, double range)
	  {
	    float f = 1.0F;
	    float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
	    float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
	    double d0 = player.prevPosX + (player.posX - player.prevPosX) * f;
	    double d1 = player.prevPosY + (player.posY - player.prevPosY) * f;
	    if ((!world.isRemote) && ((player instanceof EntityPlayer))) {
	      d1 += 1.62D;
	    }
	    double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * f;
	    Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
	    float f3 = MathHelper.cos(-f2 * 0.017453292F - 3.1415927F);
	    float f4 = MathHelper.sin(-f2 * 0.017453292F - 3.1415927F);
	    float f5 = -MathHelper.cos(-f1 * 0.017453292F);
	    float f6 = MathHelper.sin(-f1 * 0.017453292F);
	    float f7 = f4 * f5;
	    float f8 = f3 * f5;
	    double d3 = range;
	    if ((player instanceof EntityPlayerMP)) {
	      d3 = ((EntityPlayerMP)player).theItemInWorldManager.getBlockReachDistance();
	    }
	    Vec3 vec31 = vec3.addVector(f7 * d3, f6 * d3, f8 * d3);
	    return world.func_147447_a(vec3, vec31, par3, !par3, par3);
	  }
}
