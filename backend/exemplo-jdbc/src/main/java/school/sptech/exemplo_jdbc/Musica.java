package school.sptech.exemplo_jdbc;

// Jackson utiliza dos getters e setters
// para fazer a serialização e desserialização
public class Musica {

    private Integer id;
    private String nome;
    private String artista;

    public Musica() {
    }

    public Musica(Integer id, String nome, String artista) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
