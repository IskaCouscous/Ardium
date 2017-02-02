package fr.Iska.ardium.armors;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.armors2.ItemTestArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class TestArmor {
	public static ArmorMaterial Test = EnumHelper.addArmorMaterial("Test", 100, new int[]{ 5, 8, 6, 5 }, 20);
    
	 public static Item helmet_Test, body_Test, legs_Test, boots_Test;
	 public static void init()
	    {
	    	helmet_Test = new ItemTestArmor(Test, 0).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":Test.helmet").setUnlocalizedName("helmet.Test");
	    	legs_Test = new ItemTestArmor(Test, 2).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":Test.legs").setUnlocalizedName("legs.Test");
	    	body_Test = new ItemTestArmor(Test, 1).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":Test.body").setUnlocalizedName("body.Test");
	    	boots_Test = new ItemTestArmor(Test, 3).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":Test.boots").setUnlocalizedName("boots.Test");
	    }
	    	public static void register()
	    	{
	    		GameRegistry.registerItem(helmet_Test,"helmet_Test");
	    		GameRegistry.registerItem(body_Test,"body_Test");
	    		GameRegistry.registerItem(legs_Test,"legs_Test");
	    		GameRegistry.registerItem(boots_Test,"boots_Test");
}
	
}
