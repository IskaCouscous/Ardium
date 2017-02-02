package fr.Iska.ardium.admin;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiAdminChest  extends GuiContainer
{
	  TileEntity tile;
	  ResourceLocation bg = new ResourceLocation("ardium:textures/gui/AdminChest.png");
	  
	  public GuiAdminChest(TileEntity te)
	  {
	    super(new ContainerAdminChest(te));
	    this.xSize = 256;
	    this.ySize = 177;
	  }
	  
	  protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	  {
	    this.mc.renderEngine.bindTexture(this.bg);
	    
	    drawDefaultBackground();
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    int x = (this.width - this.xSize) / 2;
	    int y = (this.height - this.ySize) / 2;
	    drawTexturedModalRect(x, y, 0, 0, 256, 256);
	  }
	}
