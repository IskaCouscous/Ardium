package fr.Iska.ardium.blocks;

public class IconConnectedTextureFlipped extends IconConnectedTexture
{
	  public IconConnectedTextureFlipped(IconConnectedTexture icon)
	  {
	    super(icon.icons[3], icon.icons[1], icon.icons[2], icon.icons[0], icon.icons[4]);
	  }
	  
	  public float getMinV()
	  {
	    return super.getMaxV();
	  }
	  
	  public float getMaxV()
	  {
	    return super.getMinV();
	  }
	}
