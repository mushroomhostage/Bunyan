package net.minecraft.server;

import bunyan.Bunyan;
import forge.NetworkMod;
import java.util.Random;

public class mod_Bunyan extends NetworkMod
{
    public boolean clientSideRequired()
    {
        return Bunyan.clientSideRequired();
    }

    public void generateSurface(World var1, Random var2, int var3, int var4)
    {
        Bunyan.onGenerateSurface(var1, var2, var3, var4);
    }

    public String getName()
    {
        return Bunyan.getName();
    }

    public String getVersion()
    {
        return Bunyan.getVersion();
    }

    public void load()
    {
        Bunyan.onLoad(this);
    }

    public void modsLoaded()
    {
        Bunyan.onModsLoaded();
    }
}
