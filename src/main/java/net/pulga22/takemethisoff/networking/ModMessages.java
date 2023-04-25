package net.pulga22.takemethisoff.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.pulga22.takemethisoff.TakeMeThisOff;
import net.pulga22.takemethisoff.networking.packets.SetBlindedStatusS2CPacket;

public class ModMessages {
    //Packet used to change blindedState of a ClientPlayerEntity
    public static final Identifier SET_BLINDED_STATE = new Identifier(TakeMeThisOff.MOD_ID, "set_blinded_status");

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(SET_BLINDED_STATE, SetBlindedStatusS2CPacket::send);
    }

}
