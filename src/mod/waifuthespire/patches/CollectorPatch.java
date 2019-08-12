package mod.waifuthespire.patches;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.city.TheCollector;
import com.megacrit.cardcrawl.scenes.TheCityScene;
import mod.WaifuTheSpire;


public class CollectorPatch
{
    @SpirePatch(clz = TheCollector.class, method = SpirePatch.CONSTRUCTOR)
    public static class CollectorItself
    {
        public static void Postfix(TheCollector __instance)
        {
            WaifuTheSpire.waifufy(__instance, "resources/monsters/Collector/CollectorT.png",322, 467);
        }
    }

    @SpirePatch(clz = TheCityScene.class, method = SpirePatch.CONSTRUCTOR)
    public static class CollectorsThrone
    {
        public static void Postfix(TheCityScene __instance)
        {
            TextureAtlas throne = new TextureAtlas();
        }
    }
}
