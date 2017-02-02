package fr.Iska.ardium.blocks2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.BigPickaxe.TConstructRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockClearGlass extends Block {
	 protected IIcon[] icons = new IIcon[16];
	  private boolean shouldRenderSelectionBox = true;
	  protected String folder;
	  private int renderPass;
	  
	  public BlockClearGlass(String location, boolean hasAlpha)
	  {
	    super(Material.rock);
	    this.stepSound = soundTypeStone;
	    this.folder = location;
	    this.renderPass = (hasAlpha ? 1 : 0);
	    setHardness(0.3F);
	    setCreativeTab(Tab.tabArdium);
	  }
	  public boolean isOpaqueCube()
	  {
	    return false;
	  }

	  public IIcon[] getIcons()
	  {
	    return this.icons;
	  }
	  

	  
	
	  public int getRenderBlockPass()
	  {
	    return this.renderPass;
	  }
	  
	  public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, Block par5, int par6)
	  {
	    return par5 == this;
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	  {
	    return par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 15 ? this.icons[0] : getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, this.icons);
	  }
	  
	  public IIcon getConnectedBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, IIcon[] icons)
	  {
	    
	    boolean isOpenUp = false;boolean isOpenDown = false;boolean isOpenLeft = false;boolean isOpenRight = false;
	    switch (par5)
	    {
	    case 0: 
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
	        isOpenDown = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
	        isOpenUp = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
	        isOpenLeft = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
	        isOpenRight = true;
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[15];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft)) {
	        return icons[11];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenRight)) {
	        return icons[12];
	      }
	      if ((isOpenUp) && (isOpenLeft) && (isOpenRight)) {
	        return icons[13];
	      }
	      if ((isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[14];
	      }
	      if ((isOpenDown) && (isOpenUp)) {
	        return icons[5];
	      }
	      if ((isOpenLeft) && (isOpenRight)) {
	        return icons[6];
	      }
	      if ((isOpenDown) && (isOpenLeft)) {
	        return icons[8];
	      }
	      if ((isOpenDown) && (isOpenRight)) {
	        return icons[10];
	      }
	      if ((isOpenUp) && (isOpenLeft)) {
	        return icons[7];
	      }
	      if ((isOpenUp) && (isOpenRight)) {
	        return icons[9];
	      }
	      if (isOpenDown) {
	        return icons[3];
	      }
	      if (isOpenUp) {
	        return icons[4];
	      }
	      if (isOpenLeft) {
	        return icons[2];
	      }
	      if (isOpenRight) {
	        return icons[1];
	      }
	      break;
	    case 1: 
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
	        isOpenDown = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
	        isOpenUp = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
	        isOpenLeft = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
	        isOpenRight = true;
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[15];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft)) {
	        return icons[11];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenRight)) {
	        return icons[12];
	      }
	      if ((isOpenUp) && (isOpenLeft) && (isOpenRight)) {
	        return icons[13];
	      }
	      if ((isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[14];
	      }
	      if ((isOpenDown) && (isOpenUp)) {
	        return icons[5];
	      }
	      if ((isOpenLeft) && (isOpenRight)) {
	        return icons[6];
	      }
	      if ((isOpenDown) && (isOpenLeft)) {
	        return icons[8];
	      }
	      if ((isOpenDown) && (isOpenRight)) {
	        return icons[10];
	      }
	      if ((isOpenUp) && (isOpenLeft)) {
	        return icons[7];
	      }
	      if ((isOpenUp) && (isOpenRight)) {
	        return icons[9];
	      }
	      if (isOpenDown) {
	        return icons[3];
	      }
	      if (isOpenUp) {
	        return icons[4];
	      }
	      if (isOpenLeft) {
	        return icons[2];
	      }
	      if (isOpenRight) {
	        return icons[1];
	      }
	      break;
	    case 2: 
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
	        isOpenDown = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
	        isOpenUp = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
	        isOpenLeft = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
	        isOpenRight = true;
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[15];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft)) {
	        return icons[13];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenRight)) {
	        return icons[14];
	      }
	      if ((isOpenUp) && (isOpenLeft) && (isOpenRight)) {
	        return icons[11];
	      }
	      if ((isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[12];
	      }
	      if ((isOpenDown) && (isOpenUp)) {
	        return icons[6];
	      }
	      if ((isOpenLeft) && (isOpenRight)) {
	        return icons[5];
	      }
	      if ((isOpenDown) && (isOpenLeft)) {
	        return icons[9];
	      }
	      if ((isOpenDown) && (isOpenRight)) {
	        return icons[10];
	      }
	      if ((isOpenUp) && (isOpenLeft)) {
	        return icons[7];
	      }
	      if ((isOpenUp) && (isOpenRight)) {
	        return icons[8];
	      }
	      if (isOpenDown) {
	        return icons[1];
	      }
	      if (isOpenUp) {
	        return icons[2];
	      }
	      if (isOpenLeft) {
	        return icons[4];
	      }
	      if (isOpenRight) {
	        return icons[3];
	      }
	      break;
	    case 3: 
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
	        isOpenDown = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
	        isOpenUp = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
	        isOpenLeft = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
	        isOpenRight = true;
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[15];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft)) {
	        return icons[14];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenRight)) {
	        return icons[13];
	      }
	      if ((isOpenUp) && (isOpenLeft) && (isOpenRight)) {
	        return icons[11];
	      }
	      if ((isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[12];
	      }
	      if ((isOpenDown) && (isOpenUp)) {
	        return icons[6];
	      }
	      if ((isOpenLeft) && (isOpenRight)) {
	        return icons[5];
	      }
	      if ((isOpenDown) && (isOpenLeft)) {
	        return icons[10];
	      }
	      if ((isOpenDown) && (isOpenRight)) {
	        return icons[9];
	      }
	      if ((isOpenUp) && (isOpenLeft)) {
	        return icons[8];
	      }
	      if ((isOpenUp) && (isOpenRight)) {
	        return icons[7];
	      }
	      if (isOpenDown) {
	        return icons[1];
	      }
	      if (isOpenUp) {
	        return icons[2];
	      }
	      if (isOpenLeft) {
	        return icons[3];
	      }
	      if (isOpenRight) {
	        return icons[4];
	      }
	      break;
	    case 4: 
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
	        isOpenDown = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
	        isOpenUp = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
	        isOpenLeft = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
	        isOpenRight = true;
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[15];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft)) {
	        return icons[14];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenRight)) {
	        return icons[13];
	      }
	      if ((isOpenUp) && (isOpenLeft) && (isOpenRight)) {
	        return icons[11];
	      }
	      if ((isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[12];
	      }
	      if ((isOpenDown) && (isOpenUp)) {
	        return icons[6];
	      }
	      if ((isOpenLeft) && (isOpenRight)) {
	        return icons[5];
	      }
	      if ((isOpenDown) && (isOpenLeft)) {
	        return icons[10];
	      }
	      if ((isOpenDown) && (isOpenRight)) {
	        return icons[9];
	      }
	      if ((isOpenUp) && (isOpenLeft)) {
	        return icons[8];
	      }
	      if ((isOpenUp) && (isOpenRight)) {
	        return icons[7];
	      }
	      if (isOpenDown) {
	        return icons[1];
	      }
	      if (isOpenUp) {
	        return icons[2];
	      }
	      if (isOpenLeft) {
	        return icons[3];
	      }
	      if (isOpenRight) {
	        return icons[4];
	      }
	      break;
	    case 5: 
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
	        isOpenDown = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
	        isOpenUp = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
	        isOpenLeft = true;
	      }
	      if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
	        isOpenRight = true;
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[15];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenLeft)) {
	        return icons[13];
	      }
	      if ((isOpenUp) && (isOpenDown) && (isOpenRight)) {
	        return icons[14];
	      }
	      if ((isOpenUp) && (isOpenLeft) && (isOpenRight)) {
	        return icons[11];
	      }
	      if ((isOpenDown) && (isOpenLeft) && (isOpenRight)) {
	        return icons[12];
	      }
	      if ((isOpenDown) && (isOpenUp)) {
	        return icons[6];
	      }
	      if ((isOpenLeft) && (isOpenRight)) {
	        return icons[5];
	      }
	      if ((isOpenDown) && (isOpenLeft)) {
	        return icons[9];
	      }
	      if ((isOpenDown) && (isOpenRight)) {
	        return icons[10];
	      }
	      if ((isOpenUp) && (isOpenLeft)) {
	        return icons[7];
	      }
	      if ((isOpenUp) && (isOpenRight)) {
	        return icons[8];
	      }
	      if (isOpenDown) {
	        return icons[1];
	      }
	      if (isOpenUp) {
	        return icons[2];
	      }
	      if (isOpenLeft) {
	        return icons[4];
	      }
	      if (isOpenRight) {
	        return icons[3];
	      }
	      break;
	    }
	    return icons[0];
	  }
	  
	  public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	  {
	    Block b = par1IBlockAccess.getBlock(par2, par3, par4);
	    return b == this ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(int par1, int par2)
	  {
	    return this.icons[0];
	  }
	  
	  public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	  {
	    if (this.shouldRenderSelectionBox) {
	      return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	    }
	    return AxisAlignedBB.getBoundingBox(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	  }
	  
	  public void registerBlockIcons(IIconRegister par1IconRegister)
	  {
	    this.icons[0] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass");
	    this.icons[1] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_1_d");
	    this.icons[2] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_1_u");
	    this.icons[3] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_1_l");
	    this.icons[4] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_1_r");
	    this.icons[5] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_2_h");
	    this.icons[6] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_2_v");
	    this.icons[7] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_2_dl");
	    this.icons[8] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_2_dr");
	    this.icons[9] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_2_ul");
	    this.icons[10] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_2_ur");
	    this.icons[11] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_3_d");
	    this.icons[12] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_3_u");
	    this.icons[13] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_3_l");
	    this.icons[14] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_3_r");
	    this.icons[15] = par1IconRegister.registerIcon("ardium:connected/" + this.folder + "/glass_4");
	  }
	  
	  public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
	  {
	    return true;
	  }
}
