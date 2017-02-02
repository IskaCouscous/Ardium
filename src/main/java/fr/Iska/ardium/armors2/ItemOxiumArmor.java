package fr.Iska.ardium.armors2;

import fr.Iska.ardium.References;
import fr.Iska.ardium.armors.OxiumArmor;
import fr.Iska.ardium.items.OxiumIngot;
import fr.Iska.ardium.items2.StackUntil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemOxiumArmor extends ItemArmor
{

	public ItemOxiumArmor(ArmorMaterial material, int p_i45325_3_) {
		super(material, 0, p_i45325_3_);
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(slot == 2)
		{
			return References.MODID + ":textures/models/armor/oxium_layer_2.png";
		}
		return References.MODID + ":textures/models/armor/oxium_layer_1.png";
	}
public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if(this.armorType == 0 )
		{
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, 1));
		}
		if(this.armorType == 1 )
		{
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 220, 0));
		}
		if(this.armorType == 2 )
		{
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 220, 1));
		}
		if(this.armorType == 3 )
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 220, 1));
		}
	}
public boolean getIsRepairable(ItemStack stack1, ItemStack stack2)
{
  return StackUntil.equalsWildcard(getRepairStack(), stack2) ? true : super.getIsRepairable(stack1, stack2);
}

		public  ItemStack getRepairStack()
		{
		  if ((getArmorMaterial() == OxiumArmor.Oxium)){
		    return new ItemStack(OxiumIngot.oxium, 1, 0);
		  }

		  return new ItemStack(getArmorMaterial().func_151685_b());
			
		}

	}
