package com.t10a.minedran.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes
{
    public static void register()
    {
        // Normal recipes go here. No load order issues here, I'm trying to keep things organised.
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.axe_tutorial), "tt ", "ts ", " s ", 't', "tutorial", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.hoe_tutorial), "tt ", " s ", " s ", 't', "tutorial", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.shovel_tutorial), " t ", " s ", " s ", 't', "tutorial", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.pickaxe_tutorial), "ttt", " s ", " s ", 't', "tutorial", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.sword_tutorial), " t ", " t ", " s ", 't', "tutorial", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mace_wood), "ww ", "ww ", " s ", 'w', "plankWood", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mace_stone), "rr ", "rr ", " s ", 'r', "cobblestone", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mace_iron), "ii ", "ii ", " s ", 'i', "ingotIron", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mace_gold), "gg ", "gg ", " s ", 'g', "ingotGold", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mace_diamond), "dd ", "dd ", " s ", 'd', "gemDiamond", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mace_tutorial), "tt ", "tt ", " s ", 't', "tutorial", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.shears_gold), "   ", " g ", "g  ", 'g', "ingotGold"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.shears_tutorial), "   ", " t ", "t  ", 't', "tutorial"));
        // Shapeless recipes go here.

        //Special recipes go down here.
    }
}
