package mod.waifuthespire.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.Hexaghost;
import mod.waifuthespire.util.TextureLoader;

@SpirePatch(clz = Hexaghost.class, method = "takeTurn")
public class HexaghostPatch
{
    public static void Postfix(Hexaghost __instance)
    {
        if (__instance.nextMove == 5)
        {
            ReflectionHacks.setPrivate(__instance, AbstractMonster.class, "img", TextureLoader.getTexture("resources/monsters/Hexaghost/core4.png"));
        }
    }
}
