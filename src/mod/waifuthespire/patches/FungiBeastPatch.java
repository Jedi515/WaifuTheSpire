package mod.waifuthespire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.exordium.FungiBeast;

import static mod.WaifuTheSpire.waifufy;

public class FungiBeastPatch
{
    @SpirePatch(clz = FungiBeast.class, method = SpirePatch.CONSTRUCTOR)
    public static class FungiConstructorPatch
    {
        public static void Postfix(FungiBeast __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/FungiBeast/FungiBeast.png", 196, 281);
        }
    }
}
