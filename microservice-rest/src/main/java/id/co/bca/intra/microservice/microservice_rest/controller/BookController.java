package id.co.bca.intra.microservice.microservice_rest.controller;

import ch.qos.logback.core.util.StringUtil;
import id.co.bca.intra.microservice.microservice_rest.entity.Buku;
import id.co.bca.intra.microservice.microservice_rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Book;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/buku")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Buku> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buku> getBookById(@PathVariable Long id) {
        Optional<Buku> book = bookService.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Buku createBook(@RequestBody Buku book) {
        if (StringUtil.isNullOrEmpty(book.getJudul())||StringUtil.isNullOrEmpty(book.getPenulis())||book.getTahunTerbit() <=0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buku> updateBook(@PathVariable Long id, @RequestBody Buku bookDetails) {
        Optional<Buku> book = bookService.findById(id);
        if (book.isPresent()) {
            if (StringUtil.isNullOrEmpty(bookDetails.getJudul())||StringUtil.isNullOrEmpty(bookDetails.getPenulis())||bookDetails.getTahunTerbit() <=0) {
                return ResponseEntity.badRequest().build();
            }
            Buku updatedBook = book.get();
            updatedBook.setJudul(bookDetails.getJudul());
            updatedBook.setPenulis(bookDetails.getPenulis());
            updatedBook.setTahunTerbit(bookDetails.getTahunTerbit());
            bookService.save(updatedBook);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Buku> book = bookService.findById(id);
        if (book.isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
