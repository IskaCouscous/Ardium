package fr.Iska.ardium.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;

public class MekanismRenderer {
	 private static float lightmapLastX;
	  private static float lightmapLastY;
	  private static boolean optifineBreak = false;
	  
	  public static void glowOn()
	  {
	    glowOn(15);
	  }
	  
	  public static void glowOn(int glow)
	  {
	    GL11.glPushAttrib(64);
	    try
	    {
	      lightmapLastX = OpenGlHelper.lastBrightnessX;
	      lightmapLastY = OpenGlHelper.lastBrightnessY;
	    }
	    catch (NoSuchFieldError e)
	    {
	      optifineBreak = true;
	    }
	    RenderHelper.disableStandardItemLighting();
	    
	    float glowRatioX = Math.min(glow / 15.0F * 240.0F + lightmapLastX, 240.0F);
	    float glowRatioY = Math.min(glow / 15.0F * 240.0F + lightmapLastY, 240.0F);
	    if (!optifineBreak) {
	      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, glowRatioX, glowRatioY);
	    }
	  }
	  
	  public static void glowOff()
	  {
	    if (!optifineBreak) {
	      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightmapLastX, lightmapLastY);
	    }
	    GL11.glPopAttrib();
	  }
}
