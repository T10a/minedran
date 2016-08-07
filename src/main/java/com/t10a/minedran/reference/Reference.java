package com.t10a.minedran.reference;

public class Reference
{
    public static final String MOD_ID = "minedran";
    public static final String NAME = "Minedran";
    public static final String VERSION = "1.10.2-1.0";
    public static final String ACCEPTED_VERSION = "[1.10.2]";

    public static final String CLIENT_PROXY_CLASS = "com.t10a.minedran.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.t10a.minedran.proxy.ServerProxy";

    public enum ItemBase
    {
        TUTORIAL("tutorial", "ItemTutorial"),
        MACE("mace", "ItemMace"),
        SHEARS("shears", "ItemShears"),
        MODSWORD("modsword","ItemModSword"),
        MODAXE("modaxe","ItemModAxe"),
        MODPICKAXE("modpickaxe", "ItemModPickaxe"),
        MODSHOVEL("modshovel", "ItemModShovel"),
        MODHOE("modhoe", "ItemModHoe"),
        SCYTHE("scythe", "ItemScythe");

        private String unlocalizedName;
        private String registryName;

        ItemBase(String unlocalizedName, String registryName)
        {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getRegistryName()
        {
            return registryName;
        }

        public String getUnlocalizedName()
        {
            return unlocalizedName;
        }
    }
}

