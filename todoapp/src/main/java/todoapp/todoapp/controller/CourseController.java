package todoapp.todoapp.controller;

import todoapp.todoapp.entity.CourseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todoapp.todoapp.service.CourseService    ;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController

public class CourseController {

    @Autowired
    private CourseService courseService;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    //POST
    @PostMapping("/addCourse")
    public CourseEntity addCourse(@RequestBody CourseEntity course){
        logger.info("Course object{}",course.toString());
        return courseService.savedCourse(course);
    }

    @PostMapping("/addcourses")
    public List<CourseEntity> addCourses(@RequestBody List<CourseEntity> courses){
        return courseService.savedCourses(courses);
    }

    //GET
    @GetMapping("/courses")
    public List<CourseEntity> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/courseByID{id}")
    public CourseEntity findCourseById(@ PathVariable int id){
        return courseService.getCourseById(id);
    }

    @GetMapping ("/courseByName{name}")
    public CourseEntity findCourseByName(@PathVariable String name){
        return courseService.getCourseByName(name);
    }

    @GetMapping("/listCourseByUsername{username}")
    public List<CourseEntity> findCourseByUsername(@PathVariable String username){
        return courseService.getCoursesForUser(username);
    }

    //PUT
    @PutMapping("/update")
    public CourseEntity updateCourse(@RequestBody CourseEntity course){
        System.out.println("UPDATED");
        return courseService.updateCourse(course);
    }

    //DELETE
    @DeleteMapping("/delete{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourses(id);
    }
}
