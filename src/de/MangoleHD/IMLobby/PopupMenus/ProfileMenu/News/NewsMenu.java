package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.News;

import de.Iclipse.IMAPI.Database.News;
import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.executor.ThreadExecutor;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

import static de.Iclipse.IMAPI.Data.dsp;
import static de.Iclipse.IMAPI.Data.textcolor;
import static de.Iclipse.IMAPI.Util.UUIDFetcher.getUUID;

public class NewsMenu {
    public static void openNewsMenu(Player p, int page) {
        PopupMenu menu = ProfileMenu.createProfileMenu(Data.dsp.get("profile.news", p), p);
        ThreadExecutor.executeAsync(() -> {
            final boolean[] seen = new boolean[1];
            ArrayList<Integer> news = News.getNews();
            ArrayList<Integer> shownNews = IMAPI.getPage(news, 36, page);
            if (News.getNews().size() > 0) {
                for (int i = 0; i < shownNews.size(); i++) {
                    Integer id = shownNews.get(i);
                    seen[0] = User.getLastNewsRead(getUUID(p.getName())).isAfter(News.getCreated(id));
                    String name;
                    if (!seen[0]) {
                        name = dsp.get("news.new", p) + News.getTitle(id, User.getLanguage(getUUID(p.getName())));
                    } else {
                        name = textcolor + News.getTitle(id, User.getLanguage(getUUID(p.getName())));
                    }
                    menu.addMenuItem(new MenuItem(name, item(seen[0]), "§7vom §e" + News.getCreated(id).toLocalDate() + " §7(von §e" + UUIDFetcher.getName(News.getCreator(id)) + "§7)") {
                        @Override
                        public void onClick(Player player) {
                            p.openBook(book(id, User.getLanguage(getUUID(p.getName()))));
                        }
                    }, i);
                }
                if (IMAPI.hasPage(news, 36, page - 1)) {
                    menu.addMenuItem(NewsItems.previousNewsPageItem(p, page + 1, IMAPI.maxPage(news, 36)), 7, 5);
                }
                if (IMAPI.hasPage(news, 36, page + 1)) {
                    menu.addMenuItem(NewsItems.nextNewsPageItem(p, page - 1, IMAPI.maxPage(news, 36)), 8, 5);
                }
            } else {
                menu.addMenuItem(NewsItems.noNewsItem(p), 4, 2);
            }
        }).onDone(() -> {
            menu.openMenu(p);
            User.updateLastNewsRead(getUUID(p.getName()));
        });
    }

    public static ItemStack item(boolean seen) {
        ItemStack item;
        if (!seen) {
            item = new ItemStack(Material.ENCHANTED_BOOK);
        } else {
            item = new ItemStack(Material.BOOK);
        }
        return item;
    }

    public static ItemStack book(int news, String lang) {
        ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) item.getItemMeta();
        meta.setAuthor(UUIDFetcher.getName(News.getCreator(news)));
        meta.setTitle(News.getTitle(news, lang));
        meta.addPage(ChatColor.translateAlternateColorCodes('$', News.getText(news, lang)));
        item.setItemMeta(meta);
        return item;
    }
}
