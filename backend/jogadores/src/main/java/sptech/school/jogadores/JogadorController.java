package sptech.school.jogadores;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JdbcTemplate jdbcTemplate;

    public JogadorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> listarJogadores() {
        String sql = "SELECT * FROM jogador";

        List<Jogador> jogadors = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Jogador.class));

        return ResponseEntity.status(200).body(jogadors);
    }

    @PostMapping
    public ResponseEntity<Jogador> criar(@RequestBody Jogador jogadorNovo) {

        System.out.println("CHEGOU NO POST DE JOGADOR");

    String sql = "INSERT INTO jogador (nome, numero, dtNasc, sexo, time, posicao, pe, caracteristicas) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

    jdbcTemplate.update(sql, jogadorNovo.getNome(), jogadorNovo.getNumero(), jogadorNovo.getDtNasc(), jogadorNovo.getSexo(), jogadorNovo.getTime(), jogadorNovo.getPosicao(), jogadorNovo.getPe(), jogadorNovo.getCaracteristicas());

    return ResponseEntity.status(201).body(jogadorNovo);
        }

        @PutMapping("/{id}")
    public ResponseEntity<Jogador> editar(@RequestBody Jogador jogadorEditado, @PathVariable Integer id) {
            String sqlExiste = "SELECT COUNT(*) FROM jogador WHERE id = ?";
            Integer idBanco = jdbcTemplate.queryForObject(sqlExiste, Integer.class, id);
            if(idBanco == 0) {
                return ResponseEntity.status(404).build();
            }

            String sql = "UPDATE jogador SET nome = ?, numero = ?, dtNasc = ?, sexo = ?, time = ?, posicao = ?, pe = ?, caracteristicas = ? WHERE id = ?";

            jdbcTemplate.update(sql, jogadorEditado.getNome(), jogadorEditado.getNumero(), jogadorEditado.getDtNasc(), jogadorEditado.getSexo(), jogadorEditado.getTime(), jogadorEditado.getPosicao(), jogadorEditado.getPe(), jogadorEditado.getCaracteristicas(), id);

            return ResponseEntity.status(200).body(jogadorEditado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        String sqlExiste = "SELECT COUNT(*) FROM jogador WHERE id = ?";
        Integer idBanco = jdbcTemplate.queryForObject(sqlExiste, Integer.class, id);
        if(idBanco == 0) {
            return ResponseEntity.status(404).build();
        }

        String sql = "DELETE FROM jogador WHERE id = ?;";

        jdbcTemplate.update(sql, id);

        return ResponseEntity.status(204).build();
    }


}
