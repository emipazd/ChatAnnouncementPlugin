package my.epic.chatannouncementplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public final class ChatAnnouncementPlugin extends JavaPlugin {

    private List<String> messages;
    private int delay;
    private boolean random;
    private int currentIndex = 0;
    private Random rng = new Random();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfigValues();

        getLogger().info("[ChatAnnouncementPlugin] Made with love by Emilia");
        getLogger().info("[ChatAnnouncementPlugin] Trans lives matter! :3");

        // Schedule repeating task
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if (messages.isEmpty()) return;

            String messageToSend;
            if (random) {
                messageToSend = messages.get(rng.nextInt(messages.size()));
            } else {
                messageToSend = messages.get(currentIndex);
                currentIndex = (currentIndex + 1) % messages.size();
            }

            Bukkit.broadcastMessage(messageToSend);

        }, delay * 20L, delay * 20L); // convert seconds to ticks
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
}