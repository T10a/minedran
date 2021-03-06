package com.t10a.minedran;

import com.t10a.minedran.creativetab.MinedranItemTab;
import com.t10a.minedran.event.ItemReapingEvent;
import com.t10a.minedran.init.ModItems;
import com.t10a.minedran.init.ModRecipes;
import com.t10a.minedran.proxy.ClientProxy;
import com.t10a.minedran.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class Minedran
{
    @Mod.Instance
    public static Minedran instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.SERVER_PROXY_CLASS)
    public static ClientProxy proxy;

    public static final CreativeTabs MINEDRAN_ITEMS = new MinedranItemTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("Pre Initialisation!");
        ModItems.init();
        ModItems.register();
        ModItems.registerOreDictionary();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        System.out.println("Initialisation!");
        ModRecipes.register();
        proxy.init();
        MinecraftForge.EVENT_BUS.register(new ItemReapingEvent());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("Post Initialisation!");
    }
}