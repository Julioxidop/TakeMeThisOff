package net.pulga22.takemethisoff;

import net.fabricmc.api.ModInitializer;

import net.pulga22.takemethisoff.command.CommandRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TakeMeThisOff implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("takemethisoff");
    public static final String MOD_ID = "takemethisoff";

    @Override
    public void onInitialize() {
        //Register blind command
        CommandRegistries.register();
        LOGGER.info("Where the heck I am?");
    }
}