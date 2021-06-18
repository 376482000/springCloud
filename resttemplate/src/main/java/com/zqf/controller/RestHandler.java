package com.zqf.controller;



import com.zqf.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findeAll(){
        Collection body = restTemplate.getForEntity("http://localhost:8010/student/findAll", Collection.class).getBody();

        return body;
    }

    @GetMapping("/findAll2")
    public Collection<Student> findeAll2(){
        //Collection body = restTemplate.getForEntity("http://localhost:8010/student/findAll", Collection.class).getBody();
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id")long id){
        Student student = restTemplate.getForEntity("http://localhost:8010/student/findById/{id}", Student.class,id).getBody();
        return student;
    }

    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id")long id){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}", Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/student/save",student,null);

    }

    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/student/save",student,null);

    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/student/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id")long id){
        restTemplate.delete("http://localhost:8010/student/deleteById/{id}",id);
    }
}
