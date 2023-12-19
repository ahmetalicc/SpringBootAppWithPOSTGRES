package sau.demo.Core.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import sau.demo.Core.Entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
