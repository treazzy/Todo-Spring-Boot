package todoapp.todoapp.repositories;

//import com.todoapp.todoproject.entity.CourseEntity;
import todoapp.todoapp.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

import  java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    CourseEntity findByName(String name);

    List<CourseEntity> findAllByUsername(String username);
}
