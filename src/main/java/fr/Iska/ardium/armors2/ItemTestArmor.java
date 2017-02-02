package fr.Iska.ardium.armors2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.References;
import fr.Iska.ardium.armors.TestArmor;
import fr.Iska.ardium.elytra.ModelElytra;
import fr.Iska.ardium.items2.StackUntil;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemTestArmor extends ItemArmor
{

	public ItemTestArmor(ArmorMaterial material, int p_i45325_3_) {
		super(material, 0, p_i45325_3_);
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	
		return References.MODID + ":textures/models/armor/Test.png";
	}
public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if(this.armorType == 0 )
		{
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, 0));
		}
		if(this.armorType == 1 )
		{
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 220, 0));
		}
		if(this.armorType == 2 )
		{
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 220, 0));
		}
		if(this.armorType == 3 )
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 220, 0));
		}
		
	}
@SideOnly(Side.CLIENT)
public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
{
  return new ModelTest(armorSlot);
}


	}

