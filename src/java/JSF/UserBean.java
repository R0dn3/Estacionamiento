package JSF;

/*import javax.faces.view.ViewScoped; */

import java.io.Serializable;
import java.util.List;
import jakarta.annotation.ManagedBean;

@ManagedBean
/*@ViewScoped */
public class UserBean implements Serializable {
    private User user = new User();
    private List<User> users;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        if (users == null) {
            loadUsers();
        }
        return users;
    }

    public void saveUser() {
        try {
            Userdao userdao = new Userdao();
            userdao.save(user);
            user = new User(); // Limpiar formulario
            loadUsers(); // Recargar lista de usuarios
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        try {
            Userdao userdao = new Userdao();
            users = userdao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
