package fr.Iska.ardium.armors2;

import fr.Iska.ardium.References;
import fr.Iska.ardium.armors.ArdiumArmor;
import fr.Iska.ardium.armors.OxiumArmor;
import fr.Iska.ardium.items.ArdiumIngot;
import fr.Iska.ardium.items.ArdiumTools;
import fr.Iska.ardium.items.OxiumIngot;
import fr.Iska.ardium.items.OxiumTools;
import fr.Iska.ardium.items2.StackUntil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemArdiumArmor extends ItemArmor
{

	public ItemArdiumArmor(ArmorMaterial material, int p_i45325_3_) {
		super(material, 0, p_i45325_3_);
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(slot == 2)
		{
			return References.MODID + ":textures/models/armor/ardium_layer_2.png";
		}
		return References.MODID + ":textures/models/armor/ardium_layer_1.png";
	}

public boolean getIsRepairable(ItemStack stack1, ItemStack stack2)
{
  return StackUntil.equalsWildcard(getRepairStack(), stack2) ? true : super.getIsRepairable(stack1, stack2);
}

		public  ItemStack getRepairStack()
		{
		  if ((getArmorMaterial() == ArdiumArmor.Ardium)){
		    return new ItemStack(ArdiumIngot.ardium, 1, 0);
		  }

		  return new ItemStack(getArmorMaterial().func_151685_b());
			
		}

	}

