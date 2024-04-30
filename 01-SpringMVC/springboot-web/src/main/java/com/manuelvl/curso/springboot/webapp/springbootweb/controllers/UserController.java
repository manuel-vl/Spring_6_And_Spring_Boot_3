package com.manuelvl.curso.springboot.webapp.springbootweb.controllers;

import com.manuelvl.curso.springboot.webapp.springbootweb.models.User;
import com.manuelvl.curso.springboot.webapp.springbootweb.models.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    // Inyectando valores que definimos en el values.properties (Este debe estar configurado en la clase ValuesConfig
    // de tipo @Configuration)
    @Value("${config.username}")
    private String username;
    @Value("${config.list}")
    private List<String> values;
    @Value("${config.code}")
    private Integer code;
    @Value("${config.message}")
    private String message;
    // De esta forma accedemos a la config y podemos manipular la data con lenguaje de Java
    @Value("#{'${config.list}'.split(',')}")
    private List<String> valueList;
    @Value("#{'${config.list}'.toUpperCase()}")
    private List<String> valuesUppercase;
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Value("#{${config.valuesMap}.price}")
    private Long price;

    // Inyectando Environment
    @Autowired
    private Environment environment;

    @GetMapping("/details")
    public static UserDto helloWorld(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, name = "lastname", defaultValue = "") String lastName
    ){
        UserDto userDto=new UserDto();
        User user=new User(name, lastName);

        userDto.setUser(user);
        userDto.setTitle("Hello World!!");

        return userDto;
    }

    @GetMapping("/users")
    public static List<User> getAllUsers(){
        User user1=new User("Manuel","Valencia");
        User user2=new User("Jaime","Lopez");
        User user3=new User("Pepito", "Perez");

        List<User> users= Arrays.asList(user1, user2, user3);

        return users;
    }

    @GetMapping("/users/{userName}/{userLastname}")
    public static Object getUserByName(
            @PathVariable(required = false) String userName,
            @PathVariable(required = false) String userLastname
    ){
        User user=new User("Manuel","Valencia");

        if(user.getName().toLowerCase().contains(userName.toLowerCase()) ||
            user.getLastName().toLowerCase().contains(userLastname.toLowerCase())
        ){
            return user;
        }

        return null;
    }

    @PostMapping("/users")
    public static UserDto createUser(@RequestBody User user){
        UserDto userDto=new UserDto("Hola", user);

        return userDto;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.secret}") String secret){
        Map<String, Object> listValues=new HashMap<>();

        listValues.put("username", this.username);
        listValues.put("list", this.values);
        listValues.put("code", this.code);
        listValues.put("secret", secret);
        listValues.put("message", this.message);
        listValues.put("value_list", this.valueList);
        listValues.put("value_list_uppercase", this.valuesUppercase);
        listValues.put("object", this.valuesMap);
        listValues.put("product", this.product);
        listValues.put("price", this.price);
        // Utilizando environment
        listValues.put("message2", environment.getProperty("config.message"));
        listValues.put("username2", environment.getProperty("config.username"));
        listValues.put("code2", environment.getProperty("config.code", Long.class));


        return listValues;
    }
}
