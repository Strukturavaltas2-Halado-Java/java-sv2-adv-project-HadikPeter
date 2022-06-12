package vizsgaremek.user;

import org.springframework.data.jpa.repository.JpaRepository;
import vizsgaremek.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
