import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modalidade {
	private int id;
	private String nome; 
	private int ouro;
	private int prata; 
	private int bronze;
	
	
	public Modalidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Modalidade(int id, String nome, int ouro, int prata, int bronze) {
		super();
		this.id = id;
		this.nome = nome;
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getOuro() {
		return ouro;
	}
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
	public int getPrata() {
		return prata;
	}
	public void setPrata(int prata) {
		this.prata = prata;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

	@Override
	public String toString() {
		return "Modalidade [id=" + id + ", nome=" + nome + ", ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modalidade other = (Modalidade) obj;
		if (bronze != other.bronze)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ouro != other.ouro)
			return false;
		if (prata != other.prata)
			return false;
		return true;
	}
	
	static {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
		}
	}
	
	// Obtém conexão com o banco de dados
    public Connection obtemConexao() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost/BdOlimpiadas?user=root&password=");
        
    }
    public Modalidade criar(Modalidade modalidade, Olimpiada olimpiada) {
        String sqlInsert = "INSERT INTO modalidade(nome, tipo) VALUES ( ?, ?)";
        try (Connection conn = obtemConexao();
                PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlInsert);) {
            stm.setString(1, modalidade.getNome());
            stm.setString(2, olimpiada.getTipo());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = (PreparedStatement) conn.prepareStatement(sqlQuery);
                    ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    modalidade.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modalidade;
    }
}