package pe.arq.bean;


import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;



@Entity(value="libros")
public class LibroBean {
    
    @Id
    private String _id;
    private String isbn;
    private String titulo;
    private String autor;
    private String paginas;
    private String estado;

    public LibroBean() {
    }

    public LibroBean(String _id, String isbn, String titulo, String autor, String paginas, String estado) {
        this._id = _id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.estado = estado;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    

    
    
}