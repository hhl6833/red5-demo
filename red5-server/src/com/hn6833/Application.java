package com.hn6833;

import org.red5.server.adapter.ApplicationAdapter;
import org.red5.server.api.IConnection;
import org.red5.server.api.service.IServiceCapableConnection;


public class Application extends ApplicationAdapter {
    @Override
    public boolean appConnect(IConnection conn, Object[] params) {
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
