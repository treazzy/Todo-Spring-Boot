package todoapp.todoapp.service;

import todoapp.todoapp.entity.CourseEntity;
import todoapp.todoapp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //post
    // methods allow us to add something, in our case a tod.o.
    public CourseEntity savedCourse(CourseEntity course){
        System.out.println(course.toString());
        return courseRepository.save(course);
    }

    //optional but still a POST
    public List<CourseEntity> savedCourses(List<CourseEntity> courses){
        return courseRepository.saveAll(courses);
    }

    //GET methods
    //allow us to actually retrieve our info/todos
    public List<CourseEntity> getCourses(){
        return courseRepository.findAll();
    }

    public CourseEntity getCourseById(int id){
        return  courseRepository.findById(id).orElse(null);
    }

    public CourseEntity getCourseByName(String name){
        return courseRepository.findByName(name);
    }

    public List<CourseEntity> getCoursesForUser(String username){
        return courseRepository.findAllByUsername(username);
    }

    //PUT methods
    //allow us to update something, in our case a tod.o
    public CourseEntity updateCourse(CourseEntity course){
        System.out.println("updates");
        CourseEntity existing_course = courseRepository.findById(course.getId()).orElse(null);
        existing_course.setName(course.getName());
        existing_course.setDescription(course.getDescription());
        existing_course.setStatus(course.getStatus());

        return courseRepository.save(existing_course);
    }

    //DELETE
    //allow us to delete our entities, in our case a tod.o
    public String deleteCourses(int id){
        courseRepository.deleteById(id);
        return id + "id -> course removed/completed";
    }
}