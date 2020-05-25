package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Language;

import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.ItemStackBuilder;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import org.bukkit.entity.Player;

import static de.Iclipse.IMAPI.Data.heads;
import static de.MangoleHD.IMLobby.Data.dsp;

public class LanguageItems {

    public static MenuItem languageItem(Player p, String language) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get(language));
        if (User.getLanguage(UUIDFetcher.getUUID(p.getName())).equals(language)) {
            builder.withName("§e" + dsp.get("language." + language + ".name", p));
            return new MenuItem(builder.buildStack()) {
                @Override
                public void onClick(Player player) {
                }
            };
        } else {
            builder.withName("§e" + dsp.get("language." + language + ".name", p) + "(" + dsp.get("language." + language + ".name", dsp.getLanguages().get(language)) + ")");
            return new MenuItem(builder.buildStack()) {
                @Override
                public void onClick(Player player) {
                    player.chat("/lang " + language);
                    LanguageMenu.openLanguageMenu(p);
                }
            };
        }
    }
}
