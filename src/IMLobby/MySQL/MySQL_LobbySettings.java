package IMLobby.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySQL_LobbySettings {

    public static void createLobbyTable(){
        MySQL.update("CREATE TABLE IF NOT EXISTS lobbySettings (uuid VARCHAR(60), particles VARCHAR(60), playerVisibility INT(1), clothing VARCHAR(100))");
    }

    public static void createUser(UUID uuid){
        MySQL.update("INSERT INTO lobbySettings VALUES ('" + uuid.toString() + "', 'keine', '0', 'keine')");
    }

    public static void deleteUser(UUID uuid) {
       MySQL.update("DELETE FROM lobbySettings WHERE uuid = '" + uuid + "'");
    }

    public static String getParticles(UUID uuid){
        try {
            ResultSet rs = MySQL.querry("SELECT particles FROM lobbySettings WHERE uuid = '" + uuid + "'");
            while (rs.next()) {
                return rs.getString("particles");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "keine";
    }

    public static Integer getPlayerVisibility(UUID uuid){
        try {
            ResultSet rs = MySQL.querry("SELECT playerVisibility FROM lobbySettings WHERE uuid = '" + uuid + "'");
            while (rs.next()) {
                return rs.getInt("playerVisibility");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String getClothing(UUID uuid){
        try {
            ResultSet rs = MySQL.querry("SELECT clothing FROM lobbySettings WHERE uuid = '" + uuid + "'");
            while (rs.next()) {
                return rs.getString("clothing");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "keine";
    }

    public static void setParticles(UUID uuid, String particles){
        MySQL.update("UPDATE lobbySettings SET particles = '" + particles + "' WHERE uuid = '" + uuid + "'");
    }

    //bei Sichtbarkeit steht 0 für Alle, 1 für Freunde und Teammitglieder, 2 für niemanden
    public static void setPlayerVisibilty(UUID uuid, Integer playerVisibility){
        MySQL.update("UPDATE lobbySettings SET playerVisibility = '" + playerVisibility + "' WHERE uuid = '" + uuid + "'");
    }

    public static void setClothing(UUID uuid, String clothing){
        MySQL.update("UPDATE lobbySettings SET clothing = '" + clothing + "' WHERE uuid = '" + uuid + "'");
    }
}
