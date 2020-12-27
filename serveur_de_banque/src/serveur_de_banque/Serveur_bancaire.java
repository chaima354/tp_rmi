
package serveur_de_banque;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


 public class Serveur_bancaire extends UnicastRemoteObject implements Interface_bancaire {
     double solde =0;

    public Serveur_bancaire () throws RemoteException {}

   

   
    @Override
    public void debiter(double x) {
         solde=solde-x;
          
    }


    @Override
    public void crediter(double x) {
        solde=solde+x;
    }
    
    @Override
   public double lireSolde(){
        return solde;
    }
     public static void main(String[] args) throws RemoteException, MalformedURLException {
        Serveur_bancaire s = new Serveur_bancaire();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/Serveur_bancaire", s);
    }

}