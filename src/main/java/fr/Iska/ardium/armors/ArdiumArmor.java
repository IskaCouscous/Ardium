package fr.Iska.ardium.armors;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.Iska.ardium.References;
import fr.Iska.ardium.Tab;
import fr.Iska.ardium.armors2.ItemArdiumArmor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ArdiumArmor
{
	public static ArmorMaterial Ardium = EnumHelper.addArmorMaterial("Ardium", 100, new int[]{4, 9, 7, 4 },20);
    
	 public static Item helmet_ardium, body_ardium, legs_ardium, boots_ardium;
	 public static void init()
	    {
	    	helmet_ardium = new ItemArdiumArmor(Ardium, 0).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":ardium.helmet").setUnlocalizedName("helmet.ardium");
	    	legs_ardium = new ItemArdiumArmor(Ardium, 2).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":ardium.legs").setUnlocalizedName("legs.ardium");
	    	body_ardium = new ItemArdiumArmor(Ardium, 1).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":ardium.body").setUnlocalizedName("body.ardium");
	    	boots_ardium = new ItemArdiumArmor(Ardium, 3).setCreativeTab(Tab.tabArdium).setTextureName(References.MODID + ":ardium.boots").setUnlocalizedName("boots.ardium");
	    }
	    	public static void register()
	    	{
	    		GameRegistry.registerItem(helmet_ardium,"helmet_ardium");
	    		GameRegistry.registerItem(body_ardium,"body_ardium");
	    		GameRegistry.registerItem(legs_ardium,"legs_ardium");
	    		GameRegistry.registerItem(boots_ardium,"boots_ardium");
}
	
				
			}
