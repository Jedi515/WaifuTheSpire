package mod;

import basemod.BaseMod;
import basemod.ReflectionHacks;
import basemod.interfaces.ISubscriber;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mod.waifuthespire.util.TextureLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpireInitializer
public class WaifuTheSpire
        implements ISubscriber
{
    public static void initialize()
    {
        BaseMod.subscribe(new WaifuTheSpire());
    }

    public static void waifufy(AbstractMonster waifuTarget, String imagePath, int imageWidth, int imageHeight)
    {
        try {
            ReflectionHacks.setPrivate(waifuTarget, AbstractCreature.class, "atlas", null);
            ReflectionHacks.setPrivate(waifuTarget, AbstractMonster.class, "img", TextureLoader.getTexture(imagePath));
            float hb_w = imageWidth * Settings.scale;
            float hb_h = imageHeight * Settings.scale;
            waifuTarget.hb_w = hb_w;
            waifuTarget.hb_h = hb_h;
            Hitbox hb = waifuTarget.hb;
            hb.width = hb_w;
            hb.height = hb_h;
            hb.cX = hb.x + hb.width / 2.0F;
            hb.cY = hb.y + hb.height / 2.0F;
            Method refreshHbLoc = AbstractCreature.class.getDeclaredMethod("refreshHitboxLocation");
            refreshHbLoc.setAccessible(true);
            refreshHbLoc.invoke(waifuTarget);
            waifuTarget.refreshIntentHbLocation();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void waifufy(AbstractMonster waifuTarget, String atlasPath, String jsonPath, int imageWidth, int imageHeight)
    {
        try {
        Method loadAnimationMethod = AbstractCreature.class.getDeclaredMethod("loadAnimation",String.class, String.class, float.class);
        loadAnimationMethod.setAccessible(true);
        loadAnimationMethod.invoke(waifuTarget,atlasPath, jsonPath, 1.0F);
        AnimationState.TrackEntry e = waifuTarget.state.setAnimation(0, "Idle", true);
        e.setTime(e.getEndTime() * MathUtils.random());
        e.setTimeScale(MathUtils.random(0.7F, 1.0F));
        float hb_w = imageWidth * Settings.scale;
        float hb_h = imageHeight * Settings.scale;
        waifuTarget.hb_w = hb_w;
        waifuTarget.hb_h = hb_h;
        Hitbox hb = waifuTarget.hb;
        hb.width = hb_w;
        hb.height = hb_h;
        hb.cX = hb.x + hb.width / 2.0F;
        hb.cY = hb.y + hb.height / 2.0F;
        Method refreshHbLoc = AbstractCreature.class.getDeclaredMethod("refreshHitboxLocation");
        refreshHbLoc.setAccessible(true);
        refreshHbLoc.invoke(waifuTarget);
        waifuTarget.refreshIntentHbLocation();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
