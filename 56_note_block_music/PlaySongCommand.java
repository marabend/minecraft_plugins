package org.setup.minecraft;

import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class PlaySongCommand implements CommandExecutor {

    private Main main;

    public PlaySongCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            RadioSongPlayer rsp = new RadioSongPlayer(NBSDecoder.parse(new File(main.getDataFolder(), "All Star.nbs")));
            rsp.addPlayer(player);
            rsp.setPlaying(true);

            // Turn music off
            // rsp.setPlaying(false);
            // rsp.destroy();
        }

        return false;
    }
}
