package my.epic.chatannouncementplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public final class ChatAnnouncementPlugin extends JavaPlugin {

    private List<String> messages;
    private int delay;
    private boolean random;
    private int currentIndex = 0;
    private final Random rng = new Random();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfigValues();

        getLogger().info("[ChatAnnouncementPlugin] Made with love by Emilia");
        getLogger().info("[ChatAnnouncementPlugin] Trans lives matter! :3");

        // Schedule repeating announcements
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if (messages.isEmpty()) return;

                String messageToSend;
                if (random) {
                    messageToSend = messages.get(rng.nextInt(messages.size()));
                } else {
                    messageToSend = messages.get(currentIndex);
                    currentIndex = (currentIndex + 1) % messages.size();
                }

                // Translate & color codes
                messageToSend = ChatColor.translateAlternateColorCodes('&', messageToSend);

                Bukkit.broadcastMessage(messageToSend);
            }
        }, delay * 20L, delay * 20L); // delay and period in ticks
    }

    @Override
    public void onDisable() {
        getLogger().info("[ChatAnnouncementPlugin] Thanks for using ChAP <3");
    }

    private void loadConfigValues() {
        messages = getConfig().getStringList("messages");
        delay = getConfig().getInt("delay", 60);
        random = getConfig().getBoolean("random", false);
    }

    // Command for reloading config
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("chapreload")) {
            if (!sender.hasPermission("chap.reload")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                return true;
            }

            reloadConfig();
            loadConfigValues();
            sender.sendMessage(ChatColor.GREEN + "[ChatAnnouncementPlugin] Config reloaded!");
            return true;
        }
        return false;
    }
}
