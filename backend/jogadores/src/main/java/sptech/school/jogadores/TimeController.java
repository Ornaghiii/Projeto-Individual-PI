package sptech.school.jogadores;


import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/times")
public class TimeController {
    private final JdbcTemplate jdbcTemplate;

    public TimeController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Time>> listarTimes() {
        String sql = "SELECT * FROM times";

        List<Time> times = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Time.class));

        return ResponseEntity.status(200).body(times);
    }
}
