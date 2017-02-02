package fr.Iska.ardium.BigPickaxe;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.Iska.ardium.items.ArdiumTools;
import fr.Iska.ardium.items.OxiumTools;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.event.world.BlockEvent;

public class ItemArdiumBigPickaxe extends AOEHarvestTool
{
	  public ItemArdiumBigPickaxe(ToolMaterial material)
	  {
	    super(1, 1, 0);
	    this.setTextureName("ardium:Drill");
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public int getRenderPasses(int metadata)
	  {
	    return 10;
	  }
	  
	  public int getPartAmount()
	  {
	    return 4;
	  }
	  
	  public int durabilityTypeAccessory()
	  {
	    return 2;
	  }
	  
	  public int durabilityTypeExtra()
	  {
	    return 2;
	  }
	  
	  protected String getHarvestType()
	  {
	    return "pickaxe";
	  }
	  
	  protected Material[] getEffectiveMaterials()
	  {
	    return materials;
	  }
	  
	  static Material[] materials = { Material.rock, Material.iron, Material.ice, Material.glass, Material.piston, Material.anvil };
	  boolean hasSilkTouch;
	  
	  public float getDurabilityModifier()
	  {
	    return 7.0F;
	  }
	  
	  public String getEffectSuffix()
	  {
	    return "_bigpick_effect";
	  }
	  
	  public String getDefaultFolder()
	  {
	    return "bigpick";
	  }
	  
	  public float breakSpeedModifier()
	  {
	    return 254.0F;
	  }
	  
	  public float stoneboundModifier()
	  {
	    return 216.0F;
	  }
	  
	  public String[] getTraits()
	  {
	    return new String[] { "weapon", "harvest", "melee", "bludgeoning" };
	  }
	  
	  @SubscribeEvent
	  public void onEvent(BlockEvent.HarvestDropsEvent event)
	  {
	    Item breaker = null;
	    if ((event.harvester != null) && (event.harvester.getCurrentEquippedItem() != null) && (event.harvester.getCurrentEquippedItem().getItem() != null))
	    {
	      breaker = event.harvester.getCurrentEquippedItem().getItem();
	      this.hasSilkTouch = EnchantmentHelper.getSilkTouchModifier(event.harvester);
	    }
	    ItemStack a = new ItemStack(breaker);
	    if ((event.drops != null) && (event.drops.size() != 0))
	    {
	      String check = ((ItemStack)event.drops.get(0)).toString();
	      if ((!check.contains("sand")) && (!check.contains("stonebrick")) && (!check.contains("hellrock")) && (!check.contains("clay")) && (!check.contains("stonebricksmooth")) && (!check.contains("cactus")) && (!check.contains("stonebrick"))) {
	        for (int x = event.drops.size() - 1; x >= 0; x--) {
	          if (FurnaceRecipes.smelting().getSmeltingResult((ItemStack)event.drops.get(x)) != null)
	          {
	            ItemStack thisItem = FurnaceRecipes.smelting().getSmeltingResult((ItemStack)event.drops.get(x));
	            if ((breaker == OxiumTools.oxium_bigpick)  && (breaker != null) && (this.hasSilkTouch != true))
	            {
	              event.drops.remove(x);
	              event.drops.add(thisItem.copy());
	            }
	          }
	        }
	      }
	    }
	  }
	}