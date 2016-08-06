package com.t10a.minedran.proxy;

import com.t10a.minedran.init.ModItems;

public class ClientProxy implements ICommonProxy
{
    @Override
    public void init()
    {
        ModItems.registerRenders();
    }
}