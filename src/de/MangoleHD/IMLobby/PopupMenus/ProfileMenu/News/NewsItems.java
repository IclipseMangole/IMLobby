package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.News;

import de.Iclipse.IMAPI.Util.ItemStackBuilder;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class NewsItems {
    public static MenuItem noNewsItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("news.empty", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem previousNewsPageItem(Player p, int page, int maxPage) {
        return new MenuItem(ProfileItems.previousPage(p, page, maxPage)) {
            @Override
            public void onClick(Player player) {
                NewsMenu.openNewsMenu(player, page - 1);
            }
        };
    }

    public static MenuItem nextNewsPageItem(Player p, int page, int maxPage) {
        return new MenuItem(ProfileItems.nextPage(p, page, maxPage)) {
            @Override
            public void onClick(Player player) {
                NewsMenu.openNewsMenu(player, page + 1);
            }
        };
    }
}
