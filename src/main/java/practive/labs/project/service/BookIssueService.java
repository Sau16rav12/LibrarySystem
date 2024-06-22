package practive.labs.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practive.labs.project.entity.Book;
import practive.labs.project.entity.BookIssue;
import practive.labs.project.repository.BookIssueRepository;

import java.util.List;

@Service
public class BookIssueService {

    @Autowired
    private BookIssueRepository bookIssueRepository;

    public List<BookIssue> findAll() {
        return bookIssueRepository.findAll();
    }

    public BookIssue save(BookIssue bookIssue) {
        return bookIssueRepository.save(bookIssue);
    }

    public BookIssue findById(Long id) {
        return bookIssueRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        bookIssueRepository.deleteById(id);
    }

    public Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId);
        Student user = userRepository.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
    }
//
//    public Book returnBook(Long bookId) {
//        Book book = findById(bookId);
//        if (book != null && book.isBorrowed()) {
//            book.setBorrowedBy(null);
//            book.setBorrowed(false);
//            return save(book);
//        }
//        // Handle errors (e.g., book not found, book not borrowed)
//        return null;
//    }
}
