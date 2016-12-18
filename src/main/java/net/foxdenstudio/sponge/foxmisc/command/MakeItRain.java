package net.foxdenstudio.sponge.foxmisc.command;

import com.flowpowered.math.vector.Vector3d;
import net.foxdenstudio.sponge.foxcore.plugin.command.FCCommandBase;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.Optional;
import java.util.Random;

public class MakeItRain extends FCCommandBase {

    private Random random = new Random();

    @Override
    public CommandResult process(CommandSource source, String arguments) throws CommandException {
        if (!testPermission(source)) {
            source.sendMessage(Text.of(TextColors.RED, "You don't have permission to use this command!"));
            return CommandResult.empty();
        }
        if (source instanceof Player) {
            Player p = (Player) source;
            for (int i = 0; i < 1000; i++) {
                Optional<Arrow> projectile = p.launchProjectile(Arrow.class,
                        new Vector3d(random.nextDouble() * 2 - 1, random.nextDouble() / 2 + 0.5, random.nextDouble() * 2 - 1));
            }

        }
        return CommandResult.empty();
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return source.hasPermission("foxmisc.command.makeitrain");
    }

    @Override
    public Text getUsage(CommandSource source) {
        return Text.of("/fm rain");
    }
}
