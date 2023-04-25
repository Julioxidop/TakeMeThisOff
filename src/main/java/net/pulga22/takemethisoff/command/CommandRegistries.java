package net.pulga22.takemethisoff.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class CommandRegistries {
    public static void register(){
        CommandRegistrationCallback.EVENT.register(BlindPlayerCommand::register);
    }
}
