package net.foxdenstudio.sponge.foxmisc;

import com.google.inject.Inject;
import net.foxdenstudio.sponge.foxcore.plugin.command.FCCommandDispatcher;
import net.foxdenstudio.sponge.foxmisc.command.MakeItRain;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;

@Plugin(id = "foxmisc", name = "FoxMisc", version = FoxMiscMain.PLUGIN_VERSION, dependencies = "required-after:foxcore")
public class FoxMiscMain {

    public static final String PLUGIN_VERSION = "0.1.0-SNAPSHOT";//VERSION

    @Inject
    private Logger logger;
    @Inject
    private Game game;
    @Inject
    private EventManager eventManager;
    @Inject
    @ConfigDir(sharedRoot = true)
    private File configDirectory;

    @Listener
    public void gameInit(GameInitializationEvent event){
        registerCommands();
    }

    private void registerCommands() {
        FCCommandDispatcher dispatcher = new FCCommandDispatcher("/foxmisc", "Miscellaneous commands for fun.");
        dispatcher.register(new MakeItRain(), "rain", "makeitrain");
        game.getCommandManager().register(this, dispatcher, "foxmisc", "fmisc", "foxm", "fm");
    }

}
