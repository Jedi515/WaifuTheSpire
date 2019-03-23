package mod.waifuthespire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.exordium.LouseNormal;

import static mod.WaifuTheSpire.waifufy;

@SpirePatch(clz = LouseNormal.class, method = SpirePatch.CONSTRUCTOR)
public class LouseNormalPatch
{
    public static void Postfix(LouseNormal __instance, float x, float y)
    {
        waifufy(__instance, "resources/monsters/LouseNormal/Louse_Chan.png", 122, 324);
    }
}
