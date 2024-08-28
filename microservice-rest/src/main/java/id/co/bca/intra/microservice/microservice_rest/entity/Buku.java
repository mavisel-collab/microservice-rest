package id.co.bca.intra.microservice.microservice_rest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String judul;
    private String penulis;
    @JsonProperty(value="tahun_terbit")
    private int tahunTerbit;
}
