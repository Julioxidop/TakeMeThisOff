package net.pulga22.takemethisoff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.pulga22.takemethisoff.hud.BlindedHud;
import net.pulga22.takemethisoff.networking.ModMessages;

public class TakeMeThisOffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //Register listening of S2C packets
        ModMessages.registerS2CPackets();
        //Register BlindedHud
        HudRenderCallback.EVENT.register(new BlindedHud());
    }
}
