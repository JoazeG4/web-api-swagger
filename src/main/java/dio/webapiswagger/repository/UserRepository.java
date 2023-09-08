package dio.webapiswagger.repository;

import dio.webapiswagger.handler.BusinessException;
import dio.webapiswagger.model.User;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void save(User user){
        if(user.getLogin() == null){
            throw new BusinessException("O campo login é obrigatório!");
        }
        if(user.getId() == null){
            System.out.println("SAVE - Recebendo o usuario na camada repository");
        }
        else {
            System.out.println("UPDATE - Recebendo o usuario na camada repository");
        }

        System.out.println(user);
    }

    public void deleteById(Integer id){
        System.out.printf("DELETE/Id - Recebendo o id %d para excluir um usuario\n", id);
        System.out.println(id);
    }

    public List<User> findAll(){
        System.out.println("LIST - Listando os usúarios do sistema");
        List<User> user = new ArrayList<>();
        user.add(new User("joaze", "135246"));
        user.add(new User("lucas", "321654"));
        return user;
    }

    public User findById(Integer id){
        System.out.printf("FIND/Id - Recebendo o id: %d para localizar um usúario: \n", id);
        return new User("joaze", "135246");
    }

    public User findByUsername(String name){
        System.out.printf("FIND/Username - Recebendo o username: %s para localizar um usúario: \n", name);
        return new User("joaze", "135246");
    }
}
