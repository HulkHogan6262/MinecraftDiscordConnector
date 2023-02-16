package com.hulkhogan6262.minecraftdiscordconnector.config;

import com.hulkhogan6262.minecraftdiscordconnector.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private String servername;
    private String bottoken;
    private Integer guildid ;
    private Integer channelid;

    final private File configFile;

    private Main plugin;

    public Config(Main plugin) {
        configFile = new File(plugin.getDataFolder() + File.separator + "config.yml");

        if(!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }

        // Load config

    }

    public void load() {
        final YamlConfiguration conf = YamlConfiguration.loadConfiguration(configFile);
        this.initGeneralConfig(conf);
    }

    public void save() throws IOException {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(configFile);
    }

    private void initGeneralConfig(YamlConfiguration conf) {
        servername = conf.getString("ServerName", "Server");
        bottoken = conf.getString("BotToken");
        guildid = conf.getInt("GuildID");
        channelid = conf.getInt("ChannelID");
    }

    public String getServerName() {
        return servername;
    }

    public String getBotToken() {
        return bottoken;
    }

    public Integer getGuildId() {
        return guildid;
    }

    public Integer getChannelId() {
        return channelid;
    }

}
