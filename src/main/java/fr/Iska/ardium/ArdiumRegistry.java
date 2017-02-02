package fr.Iska.ardium;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class ArdiumRegistry 
{
	 public static void removeCraft(ItemStack stack)
	    {
	        List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
	        for(int i = 0; i < recipeList.size(); i++)
	        {
	            ItemStack out = recipeList.get(i).getRecipeOutput();
	            if(out != null && stack.getItem() == out.getItem() && stack.getItemDamage() == stack.getItemDamage())
	            {
	                recipeList.remove(i);
	            }
	        }
	    }
	}

