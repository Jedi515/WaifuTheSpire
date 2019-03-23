package mod.waifuthespire.patches;


import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.exordium.LouseDefensive;

import static mod.WaifuTheSpire.waifufy;

@SpirePatch(clz = LouseDefensive.class, method = SpirePatch.CONSTRUCTOR)
public class LouseDefensivePatch
{
    public static void Postfix(LouseDefensive __instance, float x, float y)
    {
        waifufy(__instance, "resources/monsters/LouseDefensive/Louse_Chan.png", 122, 324);
    }
}
