package Java8编程官方参考教程;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Page1014_RMI {
    
    public static void main(String[] args) throws Exception {
        if (type == TYPE.Server) {
            server();
        } else {
            client();
        }
    }
    
    static final String SERVER_IP = "192.168.15.210";
    static final String NAMING_NAME = "AddServer";
    
    static enum TYPE {
        Client, Server
    }
    
    static final TYPE type = TYPE.Server;
    
    static void client() throws Exception {
        String address = "rmi://" + SERVER_IP + "/" + NAMING_NAME;
        AddServer addServer = (AddServer) Naming.lookup(address);
        System.out.println(addServer.add(199.0, 200.0));
    }
    
    static void server() throws Exception {
        AddServerImpl addServer = new AddServerImpl();
        Naming.rebind(NAMING_NAME, addServer);
    }
    
    static interface AddServer {
        double add(double d1, double d2);
    }
    static class AddServerImpl extends UnicastRemoteObject 
            implements AddServer {

        protected AddServerImpl() throws RemoteException {
            super();
        }

        private static final long serialVersionUID = 1L;

        @Override
        public double add(double d1, double d2) {
            return d1 + d2;
        }
        
    }
}
