package practive.labs.project.controller;

import practive.labs.project.entity.Book;
import practive.labs.project.entity.BookIssue;
import practive.labs.project.service.BookIssueService;
import practive.labs.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookIssues")
public class BookIssueController {

    @Autowired
    private BookIssueService bookIssueService;

    @GetMapping
    public List<BookIssue> getAllBookIssues() {
        return bookIssueService.findAll();
    }

    @GetMapping("/{id}")
    public BookIssue getBookIssue(@PathVariable Long id) {
        return bookIssueService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookIssueService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
//
//    @PostMapping("/{bookId}/return")
//    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
//        Book returnedBook = bookService.returnBook(bookId);
//        if (returnedBook != null) {
//            return ResponseEntity.ok(returnedBook);
//        } else {
//            return ResponseEntity.badRequest().build(); // or a more descriptive error response
//        }
//    }
}
