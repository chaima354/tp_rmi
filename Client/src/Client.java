
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import serveur_de_banque.Interface_bancaire;


public class Client {

    public static void main(String[] args) {
        try {
            Interface_bancaire service1 = (Interface_bancaire) Naming.lookup("rmi://127.0.0.1:1250/Serveur_bancaire");
            
              Scanner scanner = new Scanner(System.in);
            
      
            
            System.out.println("Montant a débiter :");
            String str = scanner.nextLine();
            double d = Double.parseDouble(str);
            System.out.println("Votre nouveau solde :"); 
            service1.debiter(d);
            System.out.println(service1.lireSolde());
            
            System.out.println("Montant a créditer :");
            str = scanner.nextLine();
            double c = Double.parseDouble(str);
            System.out.println("Votre nouveau solde :");  
            service1.crediter(c);          
            System.out.println(service1.lireSolde());

        } catch (NumberFormatException | MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Erreur de connexion ");
            System.out.println(e.toString());
        }
    }

}
