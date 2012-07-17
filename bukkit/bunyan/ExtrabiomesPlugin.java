package bunyan;

import bunyan.blocks.BunyanBlock;
import bunyan.trees.GenFirTree;
import bunyan.trees.GenFirTreeHuge;
import bunyan.trees.GenRedwood;
import extrabiomes.api.IPlugin;
import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;

public enum ExtrabiomesPlugin implements IPlugin
{
    INSTANCE;
    private static boolean isActive = false;

    public static boolean isActive()
    {
        return isActive;
    }

    private static void replaceExtrabiomesTrees()
    {
        TerrainGenManager.treeFactory.registerTreeGen(ITreeFactory.TreeType.FIR, new GenFirTree(false), false);
        TerrainGenManager.treeFactory.registerTreeGen(ITreeFactory.TreeType.FIR, new GenFirTree(true), true);
        TerrainGenManager.treeFactory.registerTreeGen(ITreeFactory.TreeType.FIR_HUGE, new GenFirTreeHuge(false), false);
        TerrainGenManager.treeFactory.registerTreeGen(ITreeFactory.TreeType.FIR_HUGE, new GenFirTreeHuge(true), true);
        TerrainGenManager.treeFactory.registerTreeGen(ITreeFactory.TreeType.REDWOOD, new GenRedwood(false), false);
        TerrainGenManager.treeFactory.registerTreeGen(ITreeFactory.TreeType.REDWOOD, new GenRedwood(true), true);
    }

    private static void useBunyanWoodInExtrabiomes()
    {
        TerrainGenManager.blockRedwoodWood = BunyanBlock.widewood;
        TerrainGenManager.metaRedwoodWood = 0;
        TerrainGenManager.blockFirWood = BunyanBlock.wood;
        TerrainGenManager.metaFirWood = 1;
        TerrainGenManager.blockAcaciaWood = BunyanBlock.wood;
        TerrainGenManager.metaAcaciaWood = 2;
    }

    public String getName()
    {
        return Bunyan.getName();
    }

    public void inject()
    {
        isActive = true;
        useBunyanWoodInExtrabiomes();
        replaceExtrabiomesTrees();
    }

    public boolean isEnabled()
    {
        return true;
    }
}
