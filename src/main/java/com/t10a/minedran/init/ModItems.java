package com.t10a.minedran.init;

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

    /*does the texture for items made of this obliterate your eyes? Good news! This is a placeholder that will go once I add proper materials.
 * TODO MATERIALS: COPPER, BRONZE, SILVER, STEEL, maybe others
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
    }

    private static void registerRender(Item item)
    {
        //Is likely to change. It'll be a pain in the ass to fix though.
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }
}
