package net.foxdenstudio.sponge.foxmisc.command;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import java.util.List;
import java.util.Optional;

public class MakeItRain implements CommandCallable {
    @Override
    public CommandResult process(CommandSource source, String arguments) throws CommandException {
        if (source instanceof Player) {
            Player p = (Player) source;
            for (double i = -1; i <= 1; i += 0.1) {
                for (double j = -1; j <= 1; j += 0.1) {
                    Optional<Arrow> potionOpt = p.launchProjectile(Arrow.class, new Vector3d(i / 2, 1, j / 2));
                    if (potionOpt.isPresent()) {
                        //ThrownPotion pot = potionOpt.get();
                        //PotionEffectData data = Sponge.getDataManager().getManipulatorBuilder(PotionEffectData.class).get().create();
                        //data.effects().add(PotionEffect.of(PotionEffectTypes.INSTANT_HEALTH, 10, 5));
                        //pot.offer(data);
                        //System.out.println(pot);
                    }
                }
            }

        }
        return CommandResult.empty();
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        return ImmutableList.of();
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return source.hasPermission("foxmisc.command.makeitrain");
    }

    @Override
    public Optional<? extends Text> getShortDescription(CommandSource source) {
        return Optional.empty();
    }

    @Override
    public Optional<? extends Text> getHelp(CommandSource source) {
        return Optional.empty();
    }

    @Override
    public Text getUsage(CommandSource source) {
        return Texts.of("/fm rain");
    }
}
