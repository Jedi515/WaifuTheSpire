package mod.waifuthespire.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.*;
import mod.waifuthespire.util.TextureLoader;

import static mod.WaifuTheSpire.waifufy;

public class WaifuficationPatches
{
    @SpirePatch(clz = FungiBeast.class, method = SpirePatch.CONSTRUCTOR)
    public static class FungiConstructorPatch
    {
        public static void Postfix(FungiBeast __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/FungiBeast/FungiBeast.png", 196, 281);
        }
    }

    @SpirePatch(clz = Hexaghost.class, method = "takeTurn")
    public static class HexaghostPatch
    {
        public static void Postfix(Hexaghost __instance)
        {
            if (__instance.nextMove == 5)
            {
                ReflectionHacks.setPrivate(__instance, AbstractMonster.class, "img", TextureLoader.getTexture("resources/monsters/Hexaghost/core4.png"));
            }
        }
    }

    @SpirePatch(clz = LouseDefensive.class, method = SpirePatch.CONSTRUCTOR)
    public static class LouseDefensivePatch
    {
        public static void Postfix(LouseDefensive __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/LouseDefensive/Louse_Chan.png", 122, 324);
        }
    }

    @SpirePatch(clz = LouseNormal.class, method = SpirePatch.CONSTRUCTOR)
    public static class LouseNormalPatch
    {
        public static void Postfix(LouseNormal __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/LouseNormal/Louse_Chan.png", 122, 324);
        }
    }

    @SpirePatch(clz = AcidSlime_S.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class})
    public static class SlimeAcidS
    {
        public static void Postfix(AcidSlime_S __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Acid_S.png", 114, 140);
        }
    }

    @SpirePatch(clz = SpikeSlime_S.class, method =  SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class})
    public static class SlimeSpikeS
    {
        public static void Postfix(SpikeSlime_S __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Spike_S.png", 150, 140);
        }
    }

    @SpirePatch(clz = AcidSlime_M.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeAcidM
    {
        public static void Postfix(AcidSlime_M __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Acid_M.png", 180, 225);
        }
    }

    @SpirePatch(clz = SpikeSlime_M.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeSpikeM
    {
        public static void Postfix(SpikeSlime_M __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Spike_M.png", 240, 225);
        }
    }

    @SpirePatch(clz = AcidSlime_L.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeAcidL
    {
        public static void Postfix(AcidSlime_L __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Acid_L.png", 305, 295);
        }
    }

    @SpirePatch(clz = SpikeSlime_L.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeSpikeML
    {
        public static void Postfix(SpikeSlime_L __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Spike_L.png", 285, 275);
        }
    }
}
