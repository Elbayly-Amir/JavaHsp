import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.SQLException;
import javafx.application.Platform;
import javafx.scene.control.Control;
import modele.User;

public class UserTest {

    @Test
    public void testAjoutUser() throws SQLException {
        User user = new User("John", "Doe", "john@example.com", "password121212", "medecin");

        // Test ajout avec email inexistant
        user.ajoutUser();
        // Vérification que l'utilisateur a été ajouté à la base de données
        // Ici, on vérifie simplement que la méthode ne lève pas d'exception
        // Mais vous pouvez ajouter d'autres vérifications selon vos besoins
        // Par exemple, vérifier que la méthode a affiché le bon message d'alerte
        // Ou vérifier que l'utilisateur a bien été ajouté en interrogeant la base de données directement
        // (en utilisant une autre méthode qui récupère les données depuis la base de données)

        // Test ajout avec email existant
        user.ajoutUser();
        // Vérification que l'utilisateur n'a pas été ajouté à la base de données
        // Ici, on vérifie simplement que la méthode ne lève pas d'exception
        // Mais vous pouvez ajouter d'autres vérifications selon vos besoins
        // Par exemple, vérifier que la méthode a affiché le bon message d'alerte
        // Ou vérifier que l'utilisateur n'a pas été ajouté en interrogeant la base de données directement
        // (en utilisant une autre méthode qui récupère les données depuis la base de données)
    }
}
