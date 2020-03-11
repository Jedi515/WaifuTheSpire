package mod.waifuthespire.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.*;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.NewExpr;
import mod.waifuthespire.util.TextureLoader;

import static mod.WaifuTheSpire.*;

public class WaifuficationPatches
{
    @SpirePatch(clz = FungiBeast.class, method = SpirePatch.CONSTRUCTOR)
    public static class FungiConstructorPatch
    {
        public static void Postfix(FungiBeast __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/FungiBeast/FungiBeast.png", 240, 300);
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
            waifufy(__instance, "resources/monsters/LouseDefensive/Louse_Chan.png", 165, 345);
        }
    }

    @SpirePatch(clz = LouseNormal.class, method = SpirePatch.CONSTRUCTOR)
    public static class LouseNormalPatch
    {
        public static void Postfix(LouseNormal __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/LouseNormal/Louse_Chan.png", 165, 345);
        }
    }

    @SpirePatch(clz = AcidSlime_S.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class})
    public static class SlimeAcidS
    {
        public static void Postfix(AcidSlime_S __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Acid_S.png", 155, 160);
        }
    }

    @SpirePatch(clz = SpikeSlime_S.class, method =  SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class})
    public static class SlimeSpikeS
    {
        public static void Postfix(SpikeSlime_S __instance, float x, float y, int poisonAmount)
        {
            ResetHitboxOffset(__instance, true,false);
            waifufy(__instance, "resources/monsters/Slimes/Spike_S.png", 190, 160);
        }
    }

    @SpirePatch(clz = AcidSlime_M.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeAcidM
    {
        public static void Postfix(AcidSlime_M __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Acid_M.png", 220, 245);
        }
    }

    @SpirePatch(clz = SpikeSlime_M.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeSpikeM
    {
        public static void Postfix(SpikeSlime_M __instance, float x, float y, int poisonAmount)
        {
            ResetHitboxOffset(__instance, true,false);
            waifufy(__instance, "resources/monsters/Slimes/Spike_M.png", 280, 245);
        }
    }

    @SpirePatch(clz = AcidSlime_L.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeAcidL
    {
        public static void Postfix(AcidSlime_L __instance, float x, float y, int poisonAmount)
        {
            waifufy(__instance, "resources/monsters/Slimes/Acid_L.png", 345, 315);
        }
    }

    @SpirePatch(clz = SpikeSlime_L.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {float.class, float.class, int.class, int.class})
    public static class SlimeSpikeML
    {
        public static void Postfix(SpikeSlime_L __instance, float x, float y, int poisonAmount)
        {
            ResetHitboxOffset(__instance, true,false);
            waifufy(__instance, "resources/monsters/Slimes/Spike_L.png", 250, 295);
        }
    }

    //GREMLIN GANG
    @SpirePatch(clz = GremlinWizard.class, method = "takeTurn")
    public static class Explosion
    {
        public static String explosion = "Explosion!";
        public static ExprEditor Instrument()
        {
            return new ExprEditor()
            {
                public void edit(NewExpr newExpr)
                {
                    if (newExpr.getClassName().equals(TalkAction.class.getName()))
                    {
                        System.out.println("JEDI MOD: PATCHED INTO GREMBO WIZ");
                        try {
                            newExpr.replace("{$2 = \"" + Explosion.explosion + "\";  $_ = $proceed($$);}");
                        } catch (CannotCompileException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        }
    }

    @SpirePatch(clz = GremlinWizard.class, method = SpirePatch.CONSTRUCTOR)
    public static class GremlinWizardPatch
    {
        public static void Postfix(GremlinWizard __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/Gremlins/GremlinWizard.png", 120, 180);
        }
    }

    @SpirePatch(clz = GremlinFat.class, method = SpirePatch.CONSTRUCTOR)
    public static class GremlinFatPatch
    {
        public static void Postfix(GremlinFat __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/Gremlins/GremlinFat.png", 120, 300);
        }
    }

    @SpirePatch(clz = GremlinWarrior.class, method = SpirePatch.CONSTRUCTOR)
    public static class GremlinAngryPatch
    {
        public static void Postfix(GremlinWarrior __instance, float x, float y)
        {
            ResetHitboxOffset(__instance, false, true);
            __instance.hb_x -= 4;
            waifufy(__instance, "resources/monsters/Gremlins/GremlinAngry.png", 130, 220);
        }
    }

    @SpirePatch(clz = GremlinThief.class, method = SpirePatch.CONSTRUCTOR)
    public static class GremlinSneakyPatch
    {
        public static void Postfix(GremlinThief __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/Gremlins/GremlinSneaky.png", 140, 170);
        }
    }

    @SpirePatch(clz = GremlinTsundere.class, method = SpirePatch.CONSTRUCTOR)
    public static class GremlinTsunderePatch
    {
        public static void Postfix(GremlinTsundere __instance, float x, float y)
        {
            waifufy(__instance, "resources/monsters/Gremlins/GremlinTsundere.png", 130, 170);
        }
    }

    @SpirePatch(clz = TheGuardian.class, method = SpirePatch.CONSTRUCTOR)
    public static class GuardianPatch
    {
        public static void Postfix(TheGuardian __instance)
        {
            instantWaifu(__instance, "resources/monsters/Guardian/Guardian.atlas", "resources/monsters/Guardian/Guardian.json", 2.0F);
            System.out.println("JEDI MOD: SUCCESSFUL WAIFU GUARDIAN");
        }
    }
}
