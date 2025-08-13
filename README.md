# 📢 ChatAnnouncementPlugin

**ChatAnnouncementPlugin** is a lightweight, customizable Minecraft plugin that automatically sends periodic chat announcements to all players. Perfect for welcoming players, sharing tips, or promoting server events.

---

## 📦 Features

- ✅ **Configurable Messages** — Add as many announcement lines as you want in `config.yml`.
- ⏱️ **Custom Delay** — Choose how often announcements are sent.
- 🔀 **Random or Sequential** — Send messages in order or pick them randomly.
- 🎨 **Color Code Support** — Use `&a`, `&b`, etc. for colored and formatted messages.
- 🔄 **Hot Reload** — Reload messages and settings without restarting the server using `/chapreload`.
- 🧩 **Highly Compatible** — Works with Bukkit 1.1-R5 and later, including Spigot, Paper, and forks.

---

## 🔧 Commands

| Command        | Description                              |
|----------------|------------------------------------------|
| `/chapreload`  | Reloads the plugin’s configuration file. |

---

## 🛡️ Permissions

| Permission           | Description                              | Default |
|----------------------|------------------------------------------|---------|
| `chap.reload`        | Allows the player to reload the config.  | `op`    |

---

## ⚙️ Configuration

```yaml
# ChatAnnouncementPlugin configuration
messages:
  - "&aWelcome to the server!"
  - "&bRemember to join our Discord!"
  - "&eVote daily for rewards!"

# Delay in seconds between announcements
delay: 60

# If true, messages are picked randomly; if false, they are in order
random: false