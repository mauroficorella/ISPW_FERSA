package dao;

import entity.Annuncio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnnunciAppartamentiDao {
    private DataSource dataSource;

    public AnnunciAppartamentiDao() throws IOException {
        dataSource = new DataSource();
    }
    public ArrayList<Annuncio> allAnnunciAppartamenti() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Annuncio> a = new ArrayList<>();

        try {
            connection = this.dataSource.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM annunci";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Annuncio ann = new Annuncio(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("luogo"),
                        resultSet.getDate("data_min"), resultSet.getDate("data_max"), resultSet.getDouble("prezzo"),
                        resultSet.getBoolean("riscaldamento"), resultSet.getBoolean("aria"), resultSet.getBoolean("acqua"),
                        resultSet.getBoolean("elettricita"), resultSet.getBoolean("gas"), resultSet.getBoolean("condominio"),
                        resultSet.getBoolean("parcheggio"), resultSet.getBoolean("pulizie"), resultSet.getBoolean("wifi"),
                        resultSet.getBoolean("telefonia"), resultSet.getBoolean("sorveglianza"), resultSet.getBoolean("ascensore"),
                        resultSet.getBoolean("portierato"), resultSet.getInt("num_letti"), resultSet.getInt("num_stanze"), resultSet.getString("tipo_alloggio"),
                        resultSet.getInt("num_max_persone"), resultSet.getBoolean("animali"), resultSet.getBoolean("fumatori"),
                        resultSet.getString("sesso"), resultSet.getBoolean("paesi_conv"), resultSet.getBoolean("studente"),
                        resultSet.getBoolean("lavoratore"),  resultSet.getDouble("valutazione"));
                a.add(ann);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return a;
    }
}
