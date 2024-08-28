package id.co.bca.intra.microservice.microservice_rest.service;

import id.co.bca.intra.microservice.microservice_rest.entity.Buku;
import id.co.bca.intra.microservice.microservice_rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Buku> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Buku> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Buku save(Buku book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
