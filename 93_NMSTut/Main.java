package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;


public class Main extends JavaPlugin  {

    // nms.scramingsandals.org

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ConnectionListener(this), this);
    }

    public void inject(Player player) {
        ChannelDuplexHandler channelHandler = new ChannelDupleyHandler() {

            @Override
            public void channelRead(ChannelHandlerContext ctx, Object rawPacket) throws Exception {
                if (rawPacket instanceof ServerboundInteratPacket) {
                    ServerboundInteractPacket packet = (ServerboundInteractPacket) rawPacket;

                    Field type = packet.getClass().getDeclaredField("b");
                    type.setAccessible(true);

                    Object typeData = type.get(packet);
                    System.out.println(data.toString());

                    if (typeData.toString().split("\\$")[1].charAt(0) == 'e')  {
                        return;
                    }

                    try {
                        Field hand = typeData.getClass().getDeclaredField("a");
                        hand.setAccessible(true);
                        if (!hand.get(typeData).toString().equals("MAIN_HAND")) {
                            return;
                        }
                    }catch(NoSuchFieldException e) {

                    }

                    Field id = packet.getClass().getDeclaredField("a"); // Obfuscated one
                    id.setAccessible(true);
                    int entityId = id.getInt(packet);
                    System.out.println(entityId);
                }
                super.channelRead(ctx, rawPacket);
            }
        };

        ChannelPipeline pipeline = ((CraftPlayer) player).getHandle().connection.getConnection().channel.pipeline();
        pipeline.addBefore("packet_handler", player.getName(), channelHandler);
    }

    public void stop(Player player) {
        Channel channel = ((CraftPlayer) player).getHandle().connection.getConnection().channel;
        channel.eventLoop().submit(() -> {
            channel.pipeline().remove(player.getName());
            return null;
        });
    }

}
