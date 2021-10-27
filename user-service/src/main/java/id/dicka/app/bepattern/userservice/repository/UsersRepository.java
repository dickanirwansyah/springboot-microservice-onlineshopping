package id.dicka.app.bepattern.userservice.repository;

import id.dicka.app.bepattern.userservice.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
