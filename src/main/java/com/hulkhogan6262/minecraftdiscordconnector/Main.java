package com.hulkhogan6262.minecraftdiscordconnector;

import com.hulkhogan6262.minecraftdiscordconnector.config.Config;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("Plugin activé !");
        Server server = this.getServer();
        String token = getConfig().getString("BotToken");
        System.out.println(token);
        String server_name = getConfig().getString("ServerName", "Server");
        Integer channel_id = getConfig().getInt("ChannelID");
        try{
            JDA jda = new JDABuilder(token).build();
            System.out.println("Connecté à Discord !");
            TextChannel channel = jda.getTextChannelById(channel_id);
            channel.sendMessage("Nom du serveur : " + server_name);
        }  catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin désactivé !");
    }


}
