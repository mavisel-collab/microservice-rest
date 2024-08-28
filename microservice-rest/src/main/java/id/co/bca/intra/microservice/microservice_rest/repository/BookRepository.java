package id.co.bca.intra.microservice.microservice_rest.repository;

import id.co.bca.intra.microservice.microservice_rest.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Buku, Long> {
}
