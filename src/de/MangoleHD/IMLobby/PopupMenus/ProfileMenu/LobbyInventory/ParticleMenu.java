package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.LobbyInventory;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

public class ParticleMenu {

    public static void openParticleMenu(Player p, PopupMenu old) {
        //Menu
        PopupMenu particles = ProfileMenu.createSubProfileMenu(Data.dsp.get("particle.title", p), p, 3, new BackAction() {
            @Override
            public void onBack(Player player) {
                InventoryMenu.openInventoryMenu(p);
            }
        });


        //Menu with Items
        particles.addMenuItem(ParticleItems.flamesItem(p, old), 18);
        particles.addMenuItem(ParticleItems.waterItem(p, old), 19);
        particles.addMenuItem(ParticleItems.lavaItem(p, old), 20);
        particles.addMenuItem(ParticleItems.loveItem(p, old), 21);
        particles.addMenuItem(ParticleItems.musicItem(p, old), 22);
        particles.addMenuItem(ParticleItems.boomItem(p, old), 23);
        particles.addMenuItem(ParticleItems.smokeItem(p, old), 24);
        particles.addMenuItem(ParticleItems.slimeItem(p, old), 25);
        particles.addMenuItem(ParticleItems.offItem(p, old), 26);

        particles.openMenu(p);
    }
}
