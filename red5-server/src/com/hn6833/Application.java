package com.hn6833;

import org.red5.server.adapter.ApplicationAdapter;
import org.red5.server.api.IConnection;
import org.red5.server.api.service.IServiceCapableConnection;
import org.red5.logging.Red5LoggerFactory;
import org.slf4j.Logger;


public class Application extends ApplicationAdapter {
    private static Logger logger = Red5LoggerFactory.getLogger(Application.class);

    @Override
    public boolean appConnect(IConnection conn, Object[] params) {
        logger.info("create connection");
        logger.debug("create connection");
        callClient(conn);
        return true;
    }

    private void callClient(IConnection conn) {
        if (conn instanceof IServiceCapableConnection) {
            IServiceCapableConnection sc = (IServiceCapableConnection) conn;
            sc.invoke("clientMethod", new Object[]{"one", 1});
        }
    }

    public String change(String str) {
        return str.toUpperCase();
    }

}
