package fr.Iska.ardium.blocks2;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import fr.Iska.ardium.Ardium;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.proxy.ClientProxy;
import fr.Iska.ardium.tile.TileEntityArmorStand;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockArmorStand extends BlockContainer
{
	  public int standAngle;
	  public boolean helm;
	  public boolean cuirass;
	  public boolean greaves;
	  public boolean boots;
	  
	  public BlockArmorStand()
	  {
	    super(Material.rock);
	    
	    setStepSound(Block.soundTypeStone);
	    setCreativeTab(Tab.tabArdium);
	  }
	  
	  public float getBlockHardness(World world, int i, int j, int k)
	  {
	    TileEntity tile = world.getTileEntity(i, j, k);
	    if ((tile != null) && ((tile instanceof TileEntityArmorStand)))
	    {
	      TileEntityArmorStand tilee = (TileEntityArmorStand)tile;
	      if (tilee.isLocked()) {
	        return -1.0F;
	      }
	    }
	    return 3.0F;
	  }
	  
	  public int getMobilityFlag()
	  {
	    return 2;
	  }
	  
	  public void registerBlockIcons(IIconRegister par1IconRegister)
	  {
	    this.blockIcon = par1IconRegister.registerIcon("stone");
	  }
	  
	  public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int i, int j, int k)
	  {
	    this.standAngle = blockAccess.getBlockMetadata(i, j, k);
	    switch (this.standAngle)
	    {
	    case 0: 
	      setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 1.0F, 1.0F); break;
	    case 1: 
	      setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 1.0F, 0.7F); break;
	    case 2: 
	      setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 1.0F, 1.0F); break;
	    case 3: 
	      setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 1.0F, 0.7F); break;
	    case 4: 
	      setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 1.0F, 1.0F); break;
	    case 5: 
	      setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 1.0F, 0.7F); break;
	    case 6: 
	      setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 1.0F, 1.0F); break;
	    case 7: 
	      setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 1.0F, 0.7F); break;
	    }
	  }
	  
	  public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	  {
	    setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	    super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
	  }
	  
	  public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	  {
	    setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	    return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	  }
	  
	  public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	  {
	    setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	    return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	  }
	  
	  public boolean renderAsNormalBlock()
	  {
	    return false;
	  }
	  
	  public boolean isOpaqueCube()
	  {
	    return false;
	  }
	  
	  public int getRenderType()
	  {
	    return ClientProxy.armorrenderID;
	  }
	  
	  public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int par6, float hitX, float hitY, float hitZ)
	  {
	    if (!world.isRemote)
	    {
	      int metaData = world.getBlockMetadata(i, j, k);
	      
	      String playername = player.getDisplayName();
	      TileEntityArmorStand tileArmorStand;
	      if (metaData < 4) {
	        tileArmorStand = (TileEntityArmorStand)world.getTileEntity(i, j, k);
	      } else {
	        tileArmorStand = (TileEntityArmorStand)world.getTileEntity(i, j - 1, k);
	      }
	      boolean islocked = false;
	      String lockeename = "";
	      if (tileArmorStand != null)
	      {
	        islocked = tileArmorStand.isLocked();
	        lockeename = tileArmorStand.getLockee();
	      }
	      ItemStack playerhand = player.getHeldItem();
	      if (playerhand != null) {
	        if (playerhand.getUnlocalizedName().contains("BiblioCreativeLock")) {
	          if (tileArmorStand != null)
	          {
	            if (islocked)
	            {
	              if (playername.contains(lockeename))
	              {
	                tileArmorStand.setLocked(false);
	                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("lock.unlocked")));
	              }
	              else
	              {
	                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("lock.notowner")));
	              }
	            }
	            else
	            {
	              tileArmorStand.setLocked(true);
	              tileArmorStand.setLockee(playername);
	              
	              player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("lock.locked")));
	            }
	            return true;
	          }
	        }
	      }
	      if ((!islocked) || (playername.contains(lockeename)))
	      {
	        if (metaData < 4)
	        {
	          boolean isPoweredBottom = world.isBlockIndirectlyGettingPowered(i, j, k);
	          boolean isPowerTop = world.isBlockIndirectlyGettingPowered(i, j + 1, k);
	          if (tileArmorStand == null) {
	            return false;
	          }
	          if (tileArmorStand != null)
	          {
	            int yCheck = (int)(hitY * 2.0F);
	            if (player.isSneaking())
	            {
	              if ((isPoweredBottom) || (isPowerTop))
	              {
	                handleArmorTransation(player, tileArmorStand, 0);
	                handleArmorTransation(player, tileArmorStand, 1);
	                handleArmorTransation(player, tileArmorStand, 2);
	                handleArmorTransation(player, tileArmorStand, 3);
	                return true;
	              }
	              if (yCheck == 0) {
	                handleArmorTransation(player, tileArmorStand, 0);
	              }
	              if (yCheck == 1) {
	                handleArmorTransation(player, tileArmorStand, 1);
	              }
	              return true;
	            }
	            if (playerhand != null)
	            {
	              Item stackItem = playerhand.getItem();
	              if ((stackItem instanceof ItemArmor))
	              {
	                ItemArmor armorItem = (ItemArmor)stackItem;
	                int armorType = armorItem.armorType;
	                if ((yCheck == 0) && (armorType == 3)) {
	                  if (tileArmorStand.addArmor(playerhand, 3))
	                  {
	                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
	                    return true;
	                  }
	                }
	                if ((yCheck == 1) && (armorType == 2)) {
	                  if (tileArmorStand.addArmor(playerhand, 2))
	                  {
	                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
	                    return true;
	                  }
	                }
	              }
	            }
	            player.openGui(Ardium.instance, 89, world, i, j, k);
	          }
	        }
	        else
	        {
	          if (tileArmorStand == null) {
	            return false;
	          }
	          int yCheck = (int)(hitY * 2.0F);
	          if (tileArmorStand != null)
	          {
	            boolean isPoweredBottom = world.isBlockIndirectlyGettingPowered(i, j, k);
	            boolean isPowerTop = world.isBlockIndirectlyGettingPowered(i, j - 1, k);
	            if (player.isSneaking())
	            {
	              if ((isPoweredBottom) || (isPowerTop))
	              {
	                handleArmorTransation(player, tileArmorStand, 0);
	                handleArmorTransation(player, tileArmorStand, 1);
	                handleArmorTransation(player, tileArmorStand, 2);
	                handleArmorTransation(player, tileArmorStand, 3);
	                return true;
	              }
	              if (yCheck == 0) {
	                handleArmorTransation(player, tileArmorStand, 2);
	              }
	              if (yCheck == 1) {
	                handleArmorTransation(player, tileArmorStand, 3);
	              }
	              return true;
	            }
	            if (playerhand != null)
	            {
	              Item stackItem = playerhand.getItem();
	              if ((stackItem instanceof ItemArmor))
	              {
	                ItemArmor armorItem = (ItemArmor)stackItem;
	                int armorType = armorItem.armorType;
	                if ((yCheck == 0) && (armorType == 1)) {
	                  if (tileArmorStand.addArmor(playerhand, 1))
	                  {
	                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
	                    return true;
	                  }
	                }
	                if ((yCheck == 1) && (armorType == 0)) {
	                  if (tileArmorStand.addArmor(playerhand, 0))
	                  {
	                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
	                    return true;
	                  }
	                }
	              }
	            }
	            player.openGui(Ardium.instance, 89, world, i, j - 1, k);
	          }
	        }
	      }
	      else {
	        player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("lock.notowner")));
	      }
	    }
	    return true;
	  }
	  
	  private void handleArmorTransation(EntityPlayer player, TileEntityArmorStand armorTile, int armortype)
	  {
	    ItemStack pleg = player.inventory.armorInventory[armortype];
	    int atilearmor = -1;
	    switch (armortype)
	    {
	    case 0: 
	      atilearmor = 3; break;
	    case 1: 
	      atilearmor = 2; break;
	    case 2: 
	      atilearmor = 1; break;
	    case 3: 
	      atilearmor = 0; break;
	    }
	    if ((atilearmor != -1) && (armortype >= 0) && (armortype < 4))
	    {
	      ItemStack aleg = armorTile.getArmor(atilearmor);
	      ItemStack plegcopy = null;
	      ItemStack alegcopy = null;
	      if (pleg != null) {
	        plegcopy = pleg.copy();
	      }
	      if (aleg != null) {
	        alegcopy = aleg.copy();
	      }
	      if (alegcopy != null)
	      {
	        player.inventory.armorInventory[armortype] = alegcopy;
	        sendPlayerArmorPacket(player, alegcopy, armortype);
	      }
	      if (plegcopy != null) {
	        armorTile.setInventorySlotContents(atilearmor, plegcopy);
	      }
	      if (alegcopy == null)
	      {
	        player.inventory.armorInventory[armortype] = null;
	        sendPlayerArmorPacket(player, alegcopy, armortype);
	      }
	      if (plegcopy == null) {
	        armorTile.setInventorySlotContents(atilearmor, null);
	      }
	    }
	  }
	  
	  private void sendPlayerArmorPacket(EntityPlayer player, ItemStack armor, int armorslot)
	  {
	    ByteBuf buffer = Unpooled.buffer();
	    try
	    {
	      ByteBufUtils.writeItemStack(buffer, armor);
	      buffer.writeInt(armorslot);
	      Ardium.ch_BiblioAStand.sendTo(new FMLProxyPacket(buffer, "BiblioAStand"), (EntityPlayerMP)player);
	    }
	    catch (Exception var6)
	    {
	      var6.printStackTrace();
	    }
	  }
	  
	  public boolean canPlaceBlockAt(World world, int i, int j, int k)
	  {
	    if (world.isAirBlock(i, j + 1, k)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase player, ItemStack itemStack)
	  {
	    int angle = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
	    angle++;
	    angle %= 4;
	    
	    this.standAngle = angle;
	    
	    world.setBlockMetadataWithNotify(i, j, k, this.standAngle, 0);
	    
	    world.setBlock(i, j + 1, k, Ardium.armorStand, this.standAngle + 4, 2);
	  }
	  
	  public void breakBlock(World world, int i, int j, int k, Block par5, int metaData)
	  {
	    if (metaData < 4)
	    {
	      dropItems(world, i, j, k);
	      world.setBlockToAir(i, j + 1, k);
	      
	      world.markBlockForUpdate(i, j + 1, k);
	    }
	    else
	    {
	      dropItems(world, i, j - 1, k);
	      world.setBlockToAir(i, j - 1, k);
	      
	      world.removeTileEntity(i, j - 1, k);
	      world.markBlockForUpdate(i, j - 1, k);
	    }
	    super.breakBlock(world, i, j, k, par5, metaData);
	  }
	  
	  private void dropItems(World world, int i, int j, int k)
	  {
	    Random rando = new Random();
	    
	    TileEntity tileEntity = world.getTileEntity(i, j, k);
	    if (!(tileEntity instanceof IInventory)) {
	      return;
	    }
	    IInventory inventory = (IInventory)tileEntity;
	    for (int x = 0; x < inventory.getSizeInventory(); x++)
	    {
	      ItemStack item = inventory.getStackInSlot(x);
	      if ((item != null) && (item.stackSize > 0))
	      {
	        float ri = rando.nextFloat() * 0.8F + 0.1F;
	        float rj = rando.nextFloat() * 0.8F + 0.1F;
	        float rk = rando.nextFloat() * 0.8F + 0.1F;
	        
	        EntityItem entityItem = new EntityItem(world, i + ri, j + rj, k + rk, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
	        if (item.hasTagCompound()) {
	          entityItem.getEntityItem().setTagCompound((NBTTagCompound)item.getTagCompound().copy());
	        }
	        float factor = 0.05F;
	        entityItem.motionX = (rando.nextGaussian() * factor);
	        entityItem.motionY = (rando.nextGaussian() * factor + 0.20000000298023224D);
	        entityItem.motionZ = (rando.nextGaussian() * factor);
	        world.spawnEntityInWorld(entityItem);
	        item.stackSize = 0;
	      }
	    }
	  }
	  
	  public boolean hasTileEntity(int metadata)
	  {
	    if (metadata < 4) {
	      return true;
	    }
	    return false;
	  }
	  
	  public TileEntity createNewTileEntity(World world, int meta)
	  {
	    try
	    {
	      return new TileEntityArmorStand();
	    }
	    catch (Exception ex)
	    {
	      throw new RuntimeException(ex);
	    }
	  }
	  
	  public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis)
	  {
	    TileEntity tile = world.getTileEntity(x, y, z);
	    if ((tile != null) && ((tile instanceof TileEntityArmorStand)))
	    {
	      TileEntityArmorStand te = (TileEntityArmorStand)tile;
	      ItemStack slot0 = te.getArmor(0);
	      ItemStack slot1 = te.getArmor(1);
	      ItemStack slot2 = te.getArmor(2);
	      ItemStack slot3 = te.getArmor(3);
	      int meta = te.blockMetadata;
	      int newmeta = 0;
	      switch (axis)
	      {
	      case DOWN: 
	        if (meta == 0) {
	          newmeta = 3;
	        } else if (meta == 4) {
	          newmeta = 7;
	        } else {
	          newmeta = meta - 1;
	        }
	        break;
	      case UP: 
	        if (meta == 3) {
	          newmeta = 0;
	        } else if (meta == 7) {
	          newmeta = 4;
	        } else {
	          newmeta = meta + 1;
	        }
	        break;
	      case UNKNOWN: 
	        return false;
	      default: 
	        return false;
	      }
	      world.setBlockMetadataWithNotify(x, y, z, newmeta, 0);
	      te.setInventorySlotContents(0, slot0);
	      te.setInventorySlotContents(1, slot1);
	      te.setInventorySlotContents(2, slot2);
	      te.setInventorySlotContents(3, slot3);
	      world.markBlockForUpdate(x, y, z);
	      return true;
	    }
	    return false;
	  }
	  
	  public ForgeDirection[] getValidRotations(World worldObj, int x, int y, int z)
	  {
	    ForgeDirection[] axises = { ForgeDirection.UP, ForgeDirection.DOWN };
	    return axises;
	  }
	}
