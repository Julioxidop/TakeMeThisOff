package net.pulga22.takemethisoff.networking.packets;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.pulga22.takemethisoff.util.BlindedState;

public class SetBlindedStatusS2CPacket {
    public static void send(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf packetByteBuf, PacketSender sender) {

        //Set new blindedState read from the buf
        boolean newState = packetByteBuf.readBoolean();
        if (client.player != null){
            ((BlindedState)client.player).setBlindedState(newState);
        }

    }
}
