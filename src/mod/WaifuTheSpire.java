package mod;

import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class WaifuTheSpire
        implements ISubscriber
{
    public static void initialize()
    {
        BaseMod.subscribe(new WaifuTheSpire());
    }
}
