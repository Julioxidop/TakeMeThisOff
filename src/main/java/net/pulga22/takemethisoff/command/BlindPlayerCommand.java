package net.pulga22.takemethisoff.command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.pulga22.takemethisoff.networking.ModMessages;

import java.util.Collection;
import java.util.Objects;

public class BlindPlayerCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("blind").requires((source) -> source.hasPermissionLevel(2))
                .then(
                    CommandManager.literal("set")
                        .then(
                            CommandManager.argument("targets", EntityArgumentType.players()).executes((ctx) ->
                                set(ctx.getSource(), EntityArgumentType.getPlayers(ctx, "targets"))
                            )
                        )
                )
                .then(
                    CommandManager.literal("unset")
                        .then(
                            CommandManager.argument("targets", EntityArgumentType.players()).executes((ctx) ->
                                unset(ctx.getSource(), EntityArgumentType.getPlayers(ctx, "targets"))
                            )
                        )
                )

        );
    }

    private static int set(ServerCommandSource source, Collection<ServerPlayerEntity> targets) {
        //send a SET_BLINDED_STATE to all targets, the buf contains true, so it changes the targets
        //blindedState to true
        targets.forEach(player -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBoolean(true);
            ServerPlayNetworking.send(player, ModMessages.SET_BLINDED_STATE, buf);
        });
        Objects.requireNonNull(source.getPlayer()).sendMessage(Text.literal("Blinded..."));
        return 1;
    }

    private static int unset(ServerCommandSource source, Collection<ServerPlayerEntity> targets) {
        //send a SET_BLINDED_STATE to all targets, the buf contains false, so it changes the targets
        //blindedState to false
        targets.forEach(player -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBoolean(false);
            ServerPlayNetworking.send(player, ModMessages.SET_BLINDED_STATE, buf);
        });
        Objects.requireNonNull(source.getPlayer()).sendMessage(Text.literal("Un-Blinded..."));
        return 1;
    }

}
