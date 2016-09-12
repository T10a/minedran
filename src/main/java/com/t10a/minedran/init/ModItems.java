package com.t10a.minedran.init;

import com.t10a.minedran.item.material.ItemMiscMaterial;
import com.t10a.minedran.item.tools.*;
import com.t10a.minedran.item.weapons.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
    //public static Item <item name>
    public static Item mace_wood;
    public static Item mace_stone;
    public static Item mace_iron;
    public static Item mace_gold;
    public static Item mace_diamond;
    public static Item mace_tutorial;
    public static Item axe_tutorial;
    public static Item sword_tutorial;
    public static Item pickaxe_tutorial;
    public static Item shovel_tutorial;
    public static Item hoe_tutorial;
    public static Item item_tutorial;
    public static Item shears_gold;
    public static Item shears_diamond;
    public static Item shears_tutorial;
    public static Item scythe_wood;
    public static Item scythe_stone;
    public static Item scythe_iron;
    public static Item scythe_gold;
    public static Item scythe_diamond;
    public static Item scythe_tutorial;
    public static Item longbow;
    private static Item wood_dagger;
    private static Item stone_dagger;
    private static Item iron_dagger;
    private static Item gold_dagger;
    private static Item diamond_dagger;
    private static Item tutorial_dagger;
    private static Item wood_halberd;
    private static Item stone_halberd;
    private static Item iron_halberd;
    private static Item gold_halberd;
    private static Item diamond_halberd;
    private static Item tutorial_halberd;

    //public static Item.ToolMaterial <new toolmaterial name>
    public static Item.ToolMaterial TUTORIAL;



    public static void init()
    {
        /*<name listed above>=new Item<name>();
         * Material items go here. You can also register any item here too, just in case.
		 */
        item_tutorial=new ItemMiscMaterial("tutorial");

        /* Item.ToolMaterial <NAME OF MATERIAL> = EnumHelper.addToolMaterial("MaterialString", <mining level>, <durability>, <efficiency>, <damage>, <enchantability>);
        *  <NAME OF MATERIAL>.setRepairItem(new ItemStack(ModItems.<repair material name>
        *
        * Does the texture for items made of the tutorial material obliterate your eyes? Good news! This is a placeholder that will go once I finish up the stuff I want to add.
        * TODO MATERIALS: COPPER, BRONZE, SILVER, STEEL, maybe others
        * TODO for registry(?): Ore Dictionary support. That might come later, once I have to worry about materials that are likely to overlap with other mods.
        * If you want, add a special effect to the material in the MaterialEffects class! This helps spice up variety.
        */

        Item.ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", 3, 1000, 15.0F, 4.0F, 30);
        TUTORIAL.setRepairItem(new ItemStack(ModItems.item_tutorial));

        /* Tools get registered here. They go after ToolMaterials, due to load order.
         *NOTICE: Because of how Mojang implemented the attack speed & damage of axes, any future item that extends ItemAxe MUST to be registered as follows:
		 *<unlocalized name>=new Item<name>(MATERIAL,DAMAGE_FLOAT,ATTACKSPEED_FLOAT);
		 * Fortunately for the above, not much will use it.
         */
        mace_wood=new ItemMace(Item.ToolMaterial.WOOD);
        mace_stone=new ItemMace(Item.ToolMaterial.STONE);
        mace_iron=new ItemMace(Item.ToolMaterial.IRON);
        mace_diamond=new ItemMace(Item.ToolMaterial.DIAMOND);
        mace_gold=new ItemMace(Item.ToolMaterial.GOLD);
        mace_tutorial=new ItemMace(TUTORIAL);
        axe_tutorial=new ItemCustomAxe(TUTORIAL, 9F, -3.0F);
        sword_tutorial=new ItemCustomSword(TUTORIAL);
        pickaxe_tutorial=new ItemCustomPickaxe(TUTORIAL);
        shovel_tutorial=new ItemCustomShovel(TUTORIAL);
        hoe_tutorial=new ItemCustomHoe(TUTORIAL);
        shears_gold=new ItemCustomShears(Item.ToolMaterial.GOLD);
        shears_diamond=new ItemCustomShears(Item.ToolMaterial.DIAMOND);
        shears_tutorial=new ItemCustomShears(TUTORIAL);
        scythe_wood=new ItemScythe(Item.ToolMaterial.WOOD);
        scythe_stone=new ItemScythe(Item.ToolMaterial.STONE);
        scythe_iron=new ItemScythe(Item.ToolMaterial.IRON);
        scythe_gold=new ItemScythe(Item.ToolMaterial.GOLD);
        scythe_diamond=new ItemScythe(Item.ToolMaterial.DIAMOND);
        scythe_tutorial=new ItemScythe(TUTORIAL);
        longbow = new ItemLongbow();
        wood_dagger = new ItemDagger(Item.ToolMaterial.WOOD);
        stone_dagger = new ItemDagger(Item.ToolMaterial.STONE);
        iron_dagger = new ItemDagger(Item.ToolMaterial.IRON);
        gold_dagger = new ItemDagger(Item.ToolMaterial.GOLD);
        diamond_dagger = new ItemDagger(Item.ToolMaterial.DIAMOND);
        tutorial_dagger = new ItemDagger(TUTORIAL);
        wood_halberd = new ItemHalberd(Item.ToolMaterial.WOOD);
        stone_halberd = new ItemHalberd(Item.ToolMaterial.STONE);
        iron_halberd = new ItemHalberd(Item.ToolMaterial.IRON);
        gold_halberd = new ItemHalberd(Item.ToolMaterial.GOLD);
        diamond_halberd = new ItemHalberd(Item.ToolMaterial.DIAMOND);
        tutorial_halberd = new ItemHalberd(TUTORIAL);
    }

    public static void register()
    {
        //GameRegistry.register(<name listed above>);
        GameRegistry.register(item_tutorial);
        GameRegistry.register(mace_wood);
        GameRegistry.register(mace_stone);
        GameRegistry.register(mace_iron);
        GameRegistry.register(mace_diamond);
        GameRegistry.register(mace_gold);
        GameRegistry.register(mace_tutorial);
        GameRegistry.register(axe_tutorial);
        GameRegistry.register(sword_tutorial);
        GameRegistry.register(pickaxe_tutorial);
        GameRegistry.register(shovel_tutorial);
        GameRegistry.register(hoe_tutorial);
        GameRegistry.register(shears_diamond);
        GameRegistry.register(shears_gold);
        GameRegistry.register(shears_tutorial);
        GameRegistry.register(scythe_wood);
        GameRegistry.register(scythe_stone);
        GameRegistry.register(scythe_iron);
        GameRegistry.register(scythe_gold);
        GameRegistry.register(scythe_diamond);
        GameRegistry.register(scythe_tutorial);
        GameRegistry.register(longbow);
        GameRegistry.register(wood_dagger);
        GameRegistry.register(stone_dagger);
        GameRegistry.register(iron_dagger);
        GameRegistry.register(gold_dagger);
        GameRegistry.register(diamond_dagger);
        GameRegistry.register(tutorial_dagger);
        GameRegistry.register(wood_halberd);
        GameRegistry.register(stone_halberd);
        GameRegistry.register(iron_halberd);
        GameRegistry.register(gold_halberd);
        GameRegistry.register(diamond_halberd);
        GameRegistry.register(tutorial_halberd);
    }

    public static void registerRenders()
    {
        //registerRender(<name listed above>);
        //THIS SHOULD BE LOADED CLIENTSIDE. IF FOR SOME DUMB REASON YOU LOAD THIS SERVERSIDE, THINGS WILL BREAK. BADLY.
        registerRender(item_tutorial);
        registerRender(mace_wood);
        registerRender(mace_stone);
        registerRender(mace_iron);
        registerRender(mace_diamond);
        registerRender(mace_gold);
        registerRender(mace_tutorial);
        registerRender(axe_tutorial);
        registerRender(sword_tutorial);
        registerRender(pickaxe_tutorial);
        registerRender(shovel_tutorial);
        registerRender(hoe_tutorial);
        registerRender(shears_diamond);
        registerRender(shears_gold);
        registerRender(shears_tutorial);
        registerRender(scythe_wood);
        registerRender(scythe_stone);
        registerRender(scythe_iron);
        registerRender(scythe_gold);
        registerRender(scythe_diamond);
        registerRender(scythe_tutorial);
        registerRender(longbow);
        registerRender(wood_dagger);
        registerRender(stone_dagger);
        registerRender(iron_dagger);
        registerRender(gold_dagger);
        registerRender(diamond_dagger);
        registerRender(tutorial_dagger);
        registerRender(wood_halberd);
        registerRender(stone_halberd);
        registerRender(iron_halberd);
        registerRender(gold_halberd);
        registerRender(diamond_halberd);
        registerRender(tutorial_halberd);
    }

    public static void registerOreDictionary()
    {
        //OreDictionary.registerOre("<dictionary name>", new ItemStack(ModItems.<item you want to register>));
        OreDictionary.registerOre("tutorial", new ItemStack(ModItems.item_tutorial));
    }

    private static void registerRender(Item item)
    {
        //This is likely to change, for good practice. It'll be a pain in the ass to fix though.
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }
}
