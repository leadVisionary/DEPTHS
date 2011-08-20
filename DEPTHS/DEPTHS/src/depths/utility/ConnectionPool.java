// Decompiled by DJ v3.4.4.74 Copyright 2003 Atanas Neshkov  Date: 22.08.2004 13:01:50
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3)
// Source File Name:   ConnectionPool.java

package depths.utility;

import java.io.PrintStream;
import java.sql.*;
import java.util.*;

public class ConnectionPool
{

    public static ConnectionPool getConnectionPool()
    {
        return connectionPool;
    }

    protected ConnectionPool(String driver, String jdbcURL, String username, String password, int initialConnectionCount, int maxIdleConnections, int maxConnections)
        throws SQLException, ClassNotFoundException
    {

        freeConnections = new Vector();
        usedConnections = new Vector();

        this.driver = driver;
        this.jdbcURL = jdbcURL;
        this.username = username;
        this.password = password;

        this.initialConnectionCount = initialConnectionCount;
        this.maxIdleConnections = maxIdleConnections;
        this.maxConnections = maxConnections;

        Class.forName(driver);

        for(int i = 0; i < initialConnectionCount; i++)
        {

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            freeConnections.addElement(connection);

        }
    }

    public synchronized Connection getConnection()
        throws SQLException
    {

        Connection connection = null;
        if(freeConnections.size() > 0)
        {

            connection = (Connection)freeConnections.remove(0);
            usedConnections.addElement(connection);
        } else
        if(usedConnections.size() < maxConnections)
        {

            connection = DriverManager.getConnection(jdbcURL, username, password);
            usedConnections.addElement(connection);
        } else
        {
            try
            {

                wait();
                connection = (Connection)freeConnections.remove(0);
                usedConnections.addElement(connection);
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        return connection;
    }

    public synchronized void release(Connection connection)
    {
        if(connection == null)
            return;
        if(usedConnections.removeElement(connection))
        {
            freeConnections.addElement(connection);
            notify();
        }
    }

    private static ConnectionPool connectionPool;
    private String driver;
    private String jdbcURL;
    private String username;
    private String password;
    private int initialConnectionCount;
    private int maxIdleConnections;
    private int maxConnections;
    private Vector freeConnections;
    private Vector usedConnections;

    static
    {

        ResourceBundle bundle = PropertyResourceBundle.getBundle("depths/utility/connectionPool");
        String driver = bundle.getString("driver");


       String jdbcURL = bundle.getString("jdbcURL");


        String username = bundle.getString("username");



        String password = bundle.getString("password");


        int initialConnectionCount = 0;
        int maxIdleConnections = 10;
        int maxConnections = 10;
        try
        {

           initialConnectionCount = Integer.parseInt(bundle.getString("initialConnectionCount"));
            maxIdleConnections = Integer.parseInt(bundle.getString("maxIdleConnections"));
            maxConnections = Integer.parseInt(bundle.getString("maxConnections"));

        }
        catch(Exception ex)
        {
            throw new RuntimeException(""+ex);
        }
        try
        {

            connectionPool = new ConnectionPool(driver, jdbcURL, username, password, initialConnectionCount, maxIdleConnections, maxConnections);

        }
        catch(Exception ex)
        {
            throw new RuntimeException(""+ex);
        }

    }
}
