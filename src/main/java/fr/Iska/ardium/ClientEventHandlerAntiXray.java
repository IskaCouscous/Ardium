package fr.Iska.ardium;

import java.io.IOException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

public class ClientEventHandlerAntiXray
{
  private Minecraft mc;
  private int cheatTimer;
  private int timer = 1;
  
  public ClientEventHandlerAntiXray(Minecraft mc)
  {
    this.mc = mc;
  }
  
  @SubscribeEvent
  public void onRenderTick(TickEvent.RenderTickEvent event)
  {
    if (event.phase == TickEvent.Phase.START) {
      checkTexture();
    }
  }
  
  private void checkTexture()
  {
    if (this.cheatTimer <= 0)
    {
      if ((hasIllegalTexture()) && (this.mc.theWorld != null))
      {
        this.mc.getMinecraft().shutdown();
        System.out.println("Le cheat c'est mal !");
      }
      this.cheatTimer = (this.timer * 20);
    }
    else
    {
      this.cheatTimer -= 1;
    }
  }
  
  public static boolean hasIllegalTexture()
  {
    ResourceLocation r = new ResourceLocation("minecraft:textures/blocks/stone.png");
    ITextureObject textureObject = Minecraft.getMinecraft().getTextureManager().getTexture(r);
    if (textureObject == null)
    {
      textureObject = new SimpleTexture(r);
      Minecraft.getMinecraft().getTextureManager().loadTexture(r, textureObject);
    }
    int id = textureObject.getGlTextureId();
    try
    {
      int[] textureData = TextureUtil.readImageData(Minecraft.getMinecraft().getResourceManager(), r);
      for (int color : textureData)
      {
        int alpha = color >> 24 & 0xFF;
        if (alpha != 255) {
          return true;
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return false;
  }
}
