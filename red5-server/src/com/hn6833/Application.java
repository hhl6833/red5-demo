package com.hn6833;

import org.red5.server.adapter.ApplicationAdapter;
import org.red5.server.api.IConnection;


public class Application extends ApplicationAdapter {
    @Override
    public boolean appConnect(IConnection conn, Object[] params) {
        return true;
    }

    public String change(String str) {
        return str.toUpperCase();
    }

}
