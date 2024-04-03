package ifsul.agileproject.rachadinha.controller;

import ifsul.agileproject.rachadinha.domain.entity.User;
import ifsul.agileproject.rachadinha.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Buscar user por ID
    @GetMapping("{id}")
    public User getUserByID(@PathVariable Integer id){
        return userRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.")
                );
    }

    //Cadastrar user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveCliente(@RequestBody User cliente){
        return userRepository.save(cliente);
    }

    //Deletar
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable Integer id){
        userRepository.deleteById(id);
    }



    //Atualizar
    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User usuario){
        return userRepository.save(usuario);
    }

}
