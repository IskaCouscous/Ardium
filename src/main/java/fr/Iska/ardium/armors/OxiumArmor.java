package fr.Iska.ardium.armors;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.armors2.ItemArdiumArmor;
import fr.Iska.ardium.armors2.ItemOxiumArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class OxiumArmor
{
	public static ArmorMaterial Oxium = EnumHelper.addArmorMaterial("Oxium", 350, new int[]{5, 10, 8, 5},30);
    
	 public static Item helmet_oxium, body_oxium, legs_oxium, boots_oxium;
	 public static void init()
	    {
	    	helmet_oxium = new ItemOxiumArmor(Oxium, 0).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":oxium.helmet").setUnlocalizedName("helmet.oxium");
	    	legs_oxium = new ItemOxiumArmor(Oxium, 2).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":oxium.legs").setUnlocalizedName("legs.oxium");
	    	body_oxium = new ItemOxiumArmor(Oxium, 1).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":oxium.body").setUnlocalizedName("body.oxium");
	    	boots_oxium = new ItemOxiumArmor(Oxium, 3).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":oxium.boots").setUnlocalizedName("boots.oxium");
	    }
	    	public static void register()
	    	{
	    		GameRegistry.registerItem(helmet_oxium,"helmet_oxium");
	    		GameRegistry.registerItem(body_oxium,"body_oxium");
	    		GameRegistry.registerItem(legs_oxium,"legs_oxium");
	    		GameRegistry.registerItem(boots_oxium,"boots_oxium");
}
}
