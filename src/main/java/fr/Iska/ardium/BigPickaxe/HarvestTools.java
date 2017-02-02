package fr.Iska.ardium.BigPickaxe;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public abstract class HarvestTools extends ToolCore
{
	  public HarvestTools(int baseDamage)
	  {
	    super(baseDamage);
	  }
	  
	  public float breakSpeedModifier()
	  {
	    return 1.0F;
	  }
	  
	  public float stoneboundModifier()
	  {
	    return 72.0F;
	  }
	  
	  public float getDigSpeed(ItemStack stack, Block block, int meta)
	  {
	    if (!stack.hasTagCompound()) {
	      return 5.0F;
	    }
	    NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
	    if (tags.getBoolean("Broken")) {
	      return 0.1F;
	    }
	    return super.getDigSpeed(stack, block, meta);
	  }
	  
	  public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player)
	  {
	    return super.onBlockStartBreak(stack, x, y, z, player);
	  }
	  
	  public int getHarvestLevel(ItemStack stack, String toolClass)
	  {
	    if ((stack == null) || (!(stack.getItem() instanceof HarvestTools))) {
	      return -1;
	    }
	    if ((toolClass == null) || (!getHarvestType().equals(toolClass))) {
	      return -1;
	    }
	    if (!stack.hasTagCompound()) {
	      return -1;
	    }
	    NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
	    if (tags.getBoolean("Broken")) {
	      return -1;
	    }
	    return tags.getInteger("HarvestLevel");
	  }
	  
	  public boolean func_150897_b(Block block)
	  {
	    if (block.getMaterial().isToolNotRequired()) {
	      return true;
	    }
	    return isEffective(block.getMaterial());
	  }
	  
	  public boolean canHarvestBlock(Block block, ItemStack itemStack)
	  {
	    return func_150897_b(block);
	  }
	  
	  public String[] getTraits()
	  {
	    return new String[] { "harvest" };
	  }
	  
	  protected abstract Material[] getEffectiveMaterials();
	  
	  protected abstract String getHarvestType();
	  
	  public boolean isEffective(Block block, int meta)
	  {
	    if (getHarvestType().equals(block.getHarvestTool(meta))) {
	      return true;
	    }
	    return isEffective(block.getMaterial());
	  }
	  
	  public boolean isEffective(Material material)
	  {
	    for (Material m : getEffectiveMaterials()) {
	      if (m == material) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
	  {
	    boolean used = false;
	    int hotbarSlot = player.inventory.currentItem;
	    int itemSlot = hotbarSlot == 0 ? 8 : hotbarSlot + 1;
	    ItemStack nearbyStack = null;
	    if (hotbarSlot < 8)
	    {
	      nearbyStack = player.inventory.getStackInSlot(itemSlot);
	      if (nearbyStack != null)
	      {
	        Item item = nearbyStack.getItem();
	        if ((item instanceof ItemBlock))
	        {
	          int posX = x;
	          int posY = y;
	          int posZ = z;
	          int playerPosX = (int)Math.floor(player.posX);
	          int playerPosY = (int)Math.floor(player.posY);
	          int playerPosZ = (int)Math.floor(player.posZ);
	          if (side == 0) {
	            posY--;
	          }
	          if (side == 1) {
	            posY++;
	          }
	          if (side == 2) {
	            posZ--;
	          }
	          if (side == 3) {
	            posZ++;
	          }
	          if (side == 4) {
	            posX--;
	          }
	          if (side == 5) {
	            posX++;
	          }
	          if ((posX == playerPosX) && ((posY == playerPosY) || (posY == playerPosY + 1) || (posY == playerPosY - 1)) && (posZ == playerPosZ)) {
	            return false;
	          }
	          int dmg = nearbyStack.getItemDamage();
	          int count = nearbyStack.stackSize;
	          
	          used = item.onItemUse(nearbyStack, player, world, x, y, z, side, clickX, clickY, clickZ);
	          if (player.capabilities.isCreativeMode)
	          {
	            nearbyStack.setItemDamage(dmg);
	            nearbyStack.stackSize = count;
	          }
	          if (nearbyStack.stackSize < 1)
	          {
	            nearbyStack = null;
	            player.inventory.setInventorySlotContents(itemSlot, null);
	          }
	        }
	      }
	    }
	    return used;
	  }
	  
	  protected void breakExtraBlock(World world, int x, int y, int z, int sidehit, EntityPlayer player, int refX, int refY, int refZ)
	  {
	    if (world.isAirBlock(x, y, z)) {
	      return;
	    }
	    Block block = world.getBlock(x, y, z);
	    int meta = world.getBlockMetadata(x, y, z);
	    if (!isEffective(block, meta)) {
	      return;
	    }
	    Block refBlock = world.getBlock(refX, refY, refZ);
	    float refStrength = ForgeHooks.blockStrength(refBlock, player, world, refX, refY, refZ);
	    float strength = ForgeHooks.blockStrength(block, player, world, x, y, z);
	    if ((!ForgeHooks.canHarvestBlock(block, player, meta)) || (refStrength / strength > 10.0F)) {
	      return;
	    }
	    if (player.capabilities.isCreativeMode)
	    {
	      block.onBlockHarvested(world, x, y, z, meta, player);
	      if (block.removedByPlayer(world, player, x, y, z, false)) {
	        block.onBlockDestroyedByPlayer(world, x, y, z, meta);
	      }
	      if (!world.isRemote) {
	        ((EntityPlayerMP)player).playerNetServerHandler.sendPacket(new S23PacketBlockChange(x, y, z, world));
	      }
	      return;
	    }
	    player.getCurrentEquippedItem().func_150999_a(world, block, x, y, z, player);
	    if (!world.isRemote)
	    {
	      block.onBlockHarvested(world, x, y, z, meta, player);
	      if (block.removedByPlayer(world, player, x, y, z, true))
	      {
	        block.onBlockDestroyedByPlayer(world, x, y, z, meta);
	        block.harvestBlock(world, player, x, y, z, meta);
	      }
	      EntityPlayerMP mpPlayer = (EntityPlayerMP)player;
	      mpPlayer.playerNetServerHandler.sendPacket(new S23PacketBlockChange(x, y, z, world));
	    }
	    else
	    {
	      PlayerControllerMP pcmp = Minecraft.getMinecraft().playerController;
	      
	      world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
	      if (block.removedByPlayer(world, player, x, y, z)) {
	        block.onBlockDestroyedByPlayer(world, x, y, z, meta);
	      }
	      pcmp.onPlayerDestroyBlock(x, y, z, sidehit);
	      
	      Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C07PacketPlayerDigging(2, x, y, z, Minecraft.getMinecraft().objectMouseOver.sideHit));
	    }
	  }
	}
