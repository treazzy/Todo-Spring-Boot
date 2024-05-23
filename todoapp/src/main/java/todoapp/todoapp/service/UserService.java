package todoapp.todoapp.service;

import todoapp.todoapp.entity.UserEntity;
import org.apache.catalina.User;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoapp.todoapp.repositories.UserRepository;

//import javax.persistence.NonUniqueResultException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserRepository getUser(UserEntity user) {
        System.out.println("Service GET *****");
        return (UserRepository) userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    //checking if a user exists by validating if their username
    // AND password exists in the database
    public  boolean getUserByUsername(String username, String password){
        boolean username_present;
        boolean password_present;

        try{
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username present: " + userRepository);
            password_present = userRepository.findTopByPassword(password) != null ? true : false;
            System.out.println("Password present: " + password_present);
        }
        catch (NonUniqueResultException nre)
        {
            return  true;
        }
        return  username_present && password_present;
    }

    //is there to see if a specific username already exists on the database. We need
    // this method to make sure we don’t have users with the same username
    public boolean findUserByUsername(String username)
    {
        boolean username_present;

        try{
            username_present = userRepository.findTopByUsername(username) != null ? true:false;
            System.out.println("Username present: " + username_present);
        }
        catch (NonUniqueResultException nre)
        {
            return  true;
        }
        return username_present;
    }

    public void saveUser(UserEntity user)
    {
        userRepository.save(user);
    }
}
