package com.t10a.minedran.init;

import com.t10a.minedran.item.tools.ItemCustomAxe;
import com.t10a.minedran.item.tools.ItemCustomHoe;
import com.t10a.minedran.item.tools.ItemCustomPickaxe;
import com.t10a.minedran.item.tools.ItemCustomShovel;
import com.t10a.minedran.item.weapons.ItemCustomSword;
import com.t10a.minedran.item.weapons.ItemMace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
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

    /*does the texture for items made of the tutorial material obliterate your eyes? Good news! This is a placeholder that will go once I finish up the stuff I want to add.
    * TODO MATERIALS: COPPER, BRONZE, SILVER, STEEL, maybe others
    * template:
    * public static Item.ToolMaterial <NAME OF MATERIAL> = EnumHelper.addToolMaterial("MaterialString", <mining level>, <durability>, <efficiency>, <damage>, <enchantability>);
    * If you want, add a special effect to the material in the MaterialEffects class! This helps spice up variety. I'm yet to test if this works with Vanilla materials.
    */
    public static Item.ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", 3, 1000, 15.0F, 4.0F, 30);

    public static void init()
    {
        /*<unlocalized name>=new Item<name>();
		 * NOTICE: Because of how Mojang coded axes, any future item that extends ItemAxe HAS to be registered as follows:
		 *<unlocalized name>=new Item<name>(MATERIAL,DAMAGE_FLOAT,ATTACKSPEED_FLOAT);
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

    }

    public static void register()
    {
        //GameRegistry.register(<unlocalized name>);
        //NOTICE: THIS IS VERY LIKELY TO CHANGE ONCE I FIGURE OUT HOW TO REGISTER STUFF PROPERLY
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
    }

    public static void registerRenders()
    {
        //registerRender(<unlocalized name>);
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
    }

    private static void registerRender(Item item)
    {
        //Is likely to change. It'll be a pain in the ass to fix though.
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }
}
