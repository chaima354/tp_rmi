package serveur_de_banque;
import java.rmi.Remote;
import java.rmi.RemoteException;




public interface Interface_bancaire extends Remote {

            void debiter(double x) throws RemoteException;
            void crediter( double x)throws RemoteException; 
            double lireSolde()throws RemoteException;
}