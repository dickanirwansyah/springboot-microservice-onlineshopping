package id.dicka.app.bepattern.userservice.repository;

import id.dicka.app.bepattern.userservice.model.entity.MstUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MstUserRepository extends JpaRepository<MstUser, String> {
}
