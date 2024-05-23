package todoapp.todoapp.repositories;

import org.apache.catalina.User;
import  org.springframework.data.jpa.repository.JpaRepository;
import todoapp.todoapp.entity.UserEntity;
import  org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findTopByUsername(String Username);

    UserEntity findTopByPassword(String password);

    //String getUsername();
}