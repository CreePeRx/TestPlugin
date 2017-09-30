package xyz.Creeper.ImpTab;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ImpTab extends JavaPlugin{

    public void onEnable () {
        getLogger().info("[ImpBasic] A plugin elindult");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

    }


    public void onDisable () {
        getLogger().info("[Imp-Basic] A plugin stoppolva van.");

    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("impbasic")) {
            if (args.length == 0) {
                sender.sendMessage("§6[§bImplicite-Basic] parancsok!");
                sender.sendMessage("§c /impbasic changelog - Kimutatja a legújabb ujitásokat!");
                sender.sendMessage("§aPlugin by: xjk_");
                return true;
            }

            if (args[0].equalsIgnoreCase("helpadmin")){
                sender.sendMessage("§b[Implicite-Basic] Admin parancsok!");
                sender.sendMessage("&c /impbasic reload - Reloadolja a plugint! ");
                return false;
            }

            if (args[0].equalsIgnoreCase("changelog")){
                String changelogprefix = getConfig().getString("changelogprefix");
                String changelogsor1 = getConfig().getString("changelogsor1");
                String changelogsor2 = getConfig().getString("changelogsor2");
                String changelogsor3 = getConfig().getString("changelogsor3");
                String changelogsor4 = getConfig().getString("changelogsor4");
                String changelogsor5 = getConfig().getString("changelogsor5");
                String changelogsor6 = getConfig().getString("changelogsor6");
                String changelogsor7 = getConfig().getString("changelogsor7");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', changelogprefix));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', changelogsor1));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', changelogsor2));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', changelogsor3));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', changelogsor4));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', changelogsor5));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', changelogsor6));
                return false;
            } else if (args[0].equalsIgnoreCase("reload")){
                if(sender.hasPermission("impbasic.reload")) {
                    String reloadmessage = getConfig().getString("reloadmessage");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', reloadmessage));
                    reloadConfig();
                    return false;
                } else {
                    String nopermission = getConfig().getString("noperm");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermission));
                    return false;
                }

            }

        }
        return false;
    }}