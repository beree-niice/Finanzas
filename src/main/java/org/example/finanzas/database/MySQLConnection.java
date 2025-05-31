package org.example.aerolinea.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author niluxer
 */
public class MySQLConnection {
    private static String hostname = "localhost";
    private static String dbname = "aerolinea";
    private static String dbport = "3306";
    private static String dbuser = "topicos";
    private static String dbpass = "TopicosProgra#$";
    private static String url = "jdbc:mysql://" + hostname + ":" + dbport + "/" + dbname + "?serverTimezone=UTC";

    static {
        try {
            // Cargar el driver una sola vez al inici
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver loaded successfully.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, "Error loading MySQL Driver", ex);
        }
    }

    /**
     * Obtiene una nueva conexión a la base de datos
     * @return Connection nueva conexión
     * @throws SQLException si hay error al conectar
     */
    public static Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, dbuser, dbpass);
            System.out.println("Successful database connection.");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, "Error connecting to database", ex);
            throw ex;
        }
    }

    /**
     * Método legacy para compatibilidad (deprecated)
     * @deprecated Usar getConnection() en su lugar
     */
    @Deprecated
    public static void Connect() {
        System.out.println("Connect() method is deprecated. Use getConnection() instead.");
    }

    /**
     * Método para cerrar una conexión específica
     * @param conn la conexión a cerrar
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection has been terminated.");
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, "Error closing connection", ex);
            }
        }
    }

    /**
     * Método legacy para compatibilidad (deprecated)
     * @deprecated Usar closeConnection(Connection) en su lugar
     */
    @Deprecated
    public static void Disconnect() {
        System.out.println("Disconnect() method is deprecated. Use closeConnection(Connection) instead.");
    }
}
