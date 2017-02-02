package fr.Iska.ardium.BigPickaxe;

import java.util.ArrayList;

public class TConstructRegistry {
	public static ArrayList<ActiveToolMod> activeModifiers = new ArrayList();
	  
	  public static void registerActiveToolMod(ActiveToolMod mod)
	  {
	    activeModifiers.add(mod);
	  }
}
