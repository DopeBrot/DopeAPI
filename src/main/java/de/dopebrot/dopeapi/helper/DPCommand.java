package de.dopebrot.dopeapi.helper;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

/**
 * this class adds CommandExecutor and TabCompleter in one implementation
 * @since 1.0
 * @author DopeBrot
 */
public interface DPCommand extends CommandExecutor, TabCompleter {}
