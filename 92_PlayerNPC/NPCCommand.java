package org.setup.minecraft;

import jdk.internal.net.http.common.Pair;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.UUID;

public class NPCCommand implements CommandExecutor {

    private Main main;

    public NPCCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // MineSkin.org
        if (sender instanceof Player) {
            Player player = (Player) sender;
            CraftPlayer craftPlayer = (CraftPlayer) player;
            ServerPlayer serverPlayer = craftPlayer.getHandle();

            GameProfile profile = new GameProfile(UUID.randomUUID(), "Test NPC");
            profile.getProperties().put("textures", new Property("textures", "<skinid>", ""));

            ServerPlayer npc = new ServerPlayer(serverPlayer.getServer(), serverPlayer.getLevel(), profile, null);
            npc.setPos(50,50,50);

            ServerGamePacketListener connection = serverPlayer.connection;
            connection.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.ADD_PLAYER, npc));
            connection.send(new ClientboundAddPlayerPacket(npc));

            SynchedEntityData data = npc.getEntityData();
            byte bitmask = (byte) (0x01 | 0x04 | 0x08 | 0x10 | 0x20 | 0x40);
            data.set(new EntityDataAccessor<>(17, EntityDataSerializers.BYTE), bitmask);
            connection.send(new ClientboundSetEntityDataPacket(npc.getId(), data, true));

            float yaw = 1f;
            float pitch = 1f;
            connection.send(new ClientboundRotateHeadPacket(npc, (byte) ((yaw % 360) * 256 / 360)));
            connection.send(new ClientboundMoveEntityPacket.Rot(npc.getBukkitEntity().getEntityId(),
                    (byte) ((yaw % 360) * 256 / 360),
                    (byte) ((pitch % 360) * 256 / 360),
                    true));

            connection.send(new ClientboundSetEquipmentPacket(npc.getBukkitEntity().getEntityId(), Arrays.asList(new Pair<EqipmentSlot.MAINHAND, CraftItemStack.asNMSCopy(new ItemStack(Material.GOLDEN_APPLE)>)));

            Bukkit.getScheduler().runTaskLater(main, ()-> {
                connection.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.REMOVE_PLAYER, npc));
            }, 20);

        }
        return false;
    }
}
