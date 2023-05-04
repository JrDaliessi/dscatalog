package com.devsuperior.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.backend.dto.CategoryDTO;
import com.devsuperior.backend.services.CategoryService;

//Controlodor REST
// O resource é o conceito e o controller REST é a implementação

@RestController //Anotação para indicar que a classe é um recurso web
@RequestMapping (value = "/categories") //Anotação para indicar o caminho do recurso
public class CategoryResources {

    //Metodos
    @Autowired
    private CategoryService service;

    @GetMapping //Anotação para indicar que o método responde a requisição do tipo GET do HTTP
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Anotação para indicar que o método responde a requisição do tipo GET do HTTP
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {

        //Poderiamos usar um try catch para tratar a exceção, mas vamos usar o ControllerAdvice (ExceptionHandler)
        /*try {
            CategoryDTO dto = service.findById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.ok().body(dto);*/
        CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    
}