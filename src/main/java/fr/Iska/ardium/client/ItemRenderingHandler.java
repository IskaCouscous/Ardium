package fr.Iska.ardium.client;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.BigPickaxe.ItemArdiumMultiDrill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class ItemRenderingHandler
  implements IItemRenderer
{
  private Minecraft mc = Minecraft.getMinecraft();
  public ModelMultiDrill multidrill = new ModelMultiDrill();
  private final RenderItem renderItem = (RenderItem)RenderManager.instance.getEntityClassRenderObject(EntityItem.class);
  
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
  {
    return true;
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
  {
    return true;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
  {
    RenderBlocks renderBlocks = (RenderBlocks)data[0];
    if ((type == IItemRenderer.ItemRenderType.EQUIPPED) || (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) {
      GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }
    if ((item.getItem() instanceof ItemArdiumMultiDrill))
    {
      GL11.glPushMatrix();
      GL11.glScalef(1.4F, 1.4F, 1.4F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      if (type == IItemRenderer.ItemRenderType.EQUIPPED)
      {
        GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(50.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        GL11.glTranslatef(0.0F, -0.4F, 0.4F);
      }
      else if (type == IItemRenderer.ItemRenderType.INVENTORY)
      {
        GL11.glRotatef(225.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(45.0F, -1.0F, 0.0F, -1.0F);
        GL11.glScalef(0.6F, 0.6F, 0.6F);
        GL11.glTranslatef(0.0F, -0.2F, 0.0F);
      }
      else
      {
        GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, -0.7F, 0.0F);
      }
      this.mc.renderEngine.bindTexture(new ResourceLocation("ardium", "textures/render/multidrill.png"));
      this.multidrill.render(0.0625F);
      GL11.glPopMatrix();
    }
   
  }
}
