package mod.waifuthespire.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.FungiBeast;
import mod.waifuthespire.util.TextureLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FungiBeastPatch
{
    @SpirePatch(clz = FungiBeast.class, method = SpirePatch.CONSTRUCTOR)
    public static class FungiConstructorPatch
    {
        public static void Postfix(FungiBeast __instance, float x, float y)
        {
            try {
//                Method loadAnimationMethod = AbstractCreature.class.getDeclaredMethod("loadAnimation",String.class, String.class, float.class);
//                loadAnimationMethod.setAccessible(true);
//                loadAnimationMethod.invoke(__instance,"resources/monsters/FungiBeast/FungiBeast.atlas", "resources/monsters/FungiBeast/FungiBeast.json", 1.0F);
//                AnimationState.TrackEntry e = __instance.state.setAnimation(0, "Idle", true);
//                e.setTime(e.getEndTime() * MathUtils.random());
//                e.setTimeScale(MathUtils.random(0.7F, 1.0F));

                ReflectionHacks.setPrivate(__instance, AbstractCreature.class, "atlas", null);
                ReflectionHacks.setPrivate(__instance, AbstractMonster.class, "img", TextureLoader.getTexture("resources/monsters/FungiBeast/FungiBeast.png"));
                float hb_w = 196 * Settings.scale;
                float hb_h = 281 * Settings.scale;
                __instance.hb_w = hb_w;
                __instance.hb_h = hb_h;
                Hitbox hb = __instance.hb;
                hb.width = hb_w;
                hb.height = hb_h;
                hb.cX = hb.x + hb.width / 2.0F;
                hb.cY = hb.y + hb.height / 2.0F;
                Method refreshHbLoc = AbstractCreature.class.getDeclaredMethod("refreshHitboxLocation");
                refreshHbLoc.setAccessible(true);
                refreshHbLoc.invoke(__instance);
                __instance.refreshIntentHbLocation();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
