package com.example.SpringCrud.controller;

import com.example.SpringCrud.config.RestTemplateConfig;
import com.example.SpringCrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/call-api")
public class CallAPiController {

    @Autowired
    RestTemplateConfig restTemplateConfig;

    @Value("${other.api.base-url}")
    private String otherApiBaseUrl;

    @GetMapping("/get-all-employee")
    @ResponseBody
    public Iterable<Employee> callApiGetAllEmployee(){
        String url = otherApiBaseUrl+"/api/employee/get-all-employees";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Iterable<Employee>> entity = new HttpEntity<Iterable<Employee>>(headers);
        return restTemplateConfig.restTemplate().exchange(url, HttpMethod.GET, entity, Iterable.class).getBody();
    }

    @GetMapping("/get-employee")
    @ResponseBody
    public List<Employee> callApiGetEmployeeById(@RequestParam int id){
        String url = otherApiBaseUrl+"/api/employee/get-employee?id="+id;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Employee>> entity = new HttpEntity<List<Employee>>(headers);

        return restTemplateConfig.restTemplate().exchange(url, HttpMethod.GET, entity, List.class).getBody();
    }

    @PostMapping("/add-employee")
    @ResponseBody
    public Void callApiAddEmployee(@RequestBody Employee employee){
        String url = otherApiBaseUrl+"/api/employee/add-employee";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        return restTemplateConfig.restTemplate().exchange(url, HttpMethod.POST, entity, Void.class).getBody();
    }
}
