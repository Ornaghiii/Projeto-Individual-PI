package school.sptech.exemplo_jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//
//    // /musicas -> lista todas as musicas
//    // /musicas/3
//
//    // /musicas
    @GetMapping
    public ResponseEntity<List<Musica>> listar() {
        String sql = "SELECT * FROM musica";
        List<Musica> musicadoBanco = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Musica.class));
        return ResponseEntity.status(200).body(musicadoBanco);
    }
//
//    // /musicas/1
//    @GetMapping("/{id}")
//    public ResponseEntity<Musica> listarPorId(@PathVariable Integer id) {
//        for (Musica musica : musicas) {
//            if(musica.getId().equals(id)) {
//                return ResponseEntity.status(200).body(musica);
//            } else {
//                return ResponseEntity.status(404).build();
//            }
//        }
//        return null;
//    }
//
//    @PostMapping
//    public ResponseEntity<Musica> criar(@RequestBody Musica musica) {
//        musica.setId(contador++);
//        musicas.add(musica);
//        return ResponseEntity.status(201).body(musica);
//    }
//
//    // DELETE /musicas/5
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
//        for (Musica musica : musicas) {
//            if(musica.getId().equals(id)) {
//                musicas.remove(musica);
//                return ResponseEntity.status(204).build();
//            }
//        }
//        return ResponseEntity.status(404).build();
//    }
//
//    // ATUALIZAR - ?
//    @PutMapping("/{id}")
//    public ResponseEntity<Musica> atualizar(@RequestBody Musica novaMusica, @PathVariable Integer id) {
//        novaMusica.setId(id);
//        for (Musica musica : musicas) {
//            if(musica.getId().equals(id)){
//                musica.setArtista(novaMusica.getArtista());
//                musica.setNome(novaMusica.getNome());
//                return ResponseEntity.status(200).body(novaMusica);
//            }
//        }
//        return ResponseEntity.status(404).build();
//    }
//

}
