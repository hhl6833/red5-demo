package com.hn6833;

import org.red5.server.adapter.ApplicationAdapter;
import org.red5.server.api.IConnection;
import org.red5.server.api.scope.IScope;
import org.red5.server.api.service.IPendingServiceCall;
import org.red5.server.api.service.IPendingServiceCallback;
import org.red5.server.api.service.IServiceCapableConnection;

import java.util.Set;

public class Application extends ApplicationAdapter implements IPendingServiceCallback {
    @Override
    public boolean appConnect(IConnection conn, Object[] params) {
        this.callEvery(conn.getScope());
        return true;
    }

    private void callEvery(IScope scope) {
        for (Set<IConnection> set : scope.getConnections()) {
            for (IConnection iConnection : set) {
                this.callClient(iConnection);
            }
        }
    }

    private void callClient(IConnection conn) {
        if (conn instanceof IServiceCapableConnection) {
            IServiceCapableConnection sc = (IServiceCapableConnection) conn;
            sc.invoke("clientMethod", new Object[]{conn.getSessionId(), 1}, this);
        }
    }

    public void resultReceived(IPendingServiceCall arg0) {
        log.info("from client:" + arg0.getResult());
    }
}
