package id.dicka.app.bepattern.userservice.base.repository;

import id.dicka.app.bepattern.userservice.base.view.UserView;
import id.dicka.app.bepattern.userservice.model.entity.MstUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MstUsersRepository extends JpaRepository<MstUser, String> {

    @Query(value = "select user_id as userId, name from mst_user where user_id like %:userId% and name like %:name% ",
            countQuery = "select user_id as userId, name from mst_user where user_id like %:userId% and name like %:name% ",
            nativeQuery = true)
    Page<UserView> fetchingUsersByUserIdAndName(@Param("userId")String userId,
                                                @Param("name")String name,
                                                Pageable pageable);

    @Query(value = "select user_id as userId, name from mst_user",
            countQuery = "select user_id as userId, name from mst_user",
            nativeQuery = true)
    Page<UserView> fetchingUserAll(Pageable pageable);
}
