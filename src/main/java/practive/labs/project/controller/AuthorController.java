package practive.labs.project.controller;

import practive.labs.project.entity.Author;
import practive.labs.project.entity.Student;
import practive.labs.project.service.AuthorService;
import practive.labs.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }
}
