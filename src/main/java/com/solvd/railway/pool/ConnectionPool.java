package com.solvd.railway.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final int POOL_SIZE = 5;
    private final BlockingQueue<Connection> pool = new LinkedBlockingQueue<>(POOL_SIZE);

    private ConnectionPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.offer(new Connection());
        }
    }

    private static class Holder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return Holder.INSTANCE;
    }

    public Connection acquireConnection() throws InterruptedException {
        Connection connection = pool.take();
        connection.open();
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        connection.close();
        pool.offer(connection);
    }

    public static class Connection {
        private boolean opened;

        public void open() {
            opened = true;
        }

        public void close() {
            opened = false;
        }

        public boolean isOpened() {
            return opened;
        }
    }
}

