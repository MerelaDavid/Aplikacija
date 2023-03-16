package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PacientDaoH2 extends PacientDao {
    Logger log= LoggerFactory.getLogger(PacientDaoH2.class);

    DataSource baza;

    public PacientDaoH2() throws Exception {
        baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");
        kreirajTabele();
    }

    public void kreirajTabele() throws Exception {
        Connection conn = null;
        try {
            conn = baza.getConnection();
            String sql="create table if not exists pacient(id int auto_increment, ime varchar, priimek varchar, email varchar, rojstniDatum varchar, posebnosti varchar, idZdravnika int, isZdravnik boolean)";
            log.info(sql);
            conn.createStatement().execute(sql);
        } finally {
            if (conn != null)
                conn.close();
        }
    }

    @Override
    public Pacient najdiPacienta(int id) throws Exception {
        Pacient ret = null;
        Connection conn = null;
        log.info("Iscem pacienta "+id);
        ZdravnikDao zdravnikDao = new ZdravnikDaoH2();
        try {
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from pacient where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ret = new Pacient(rs.getInt("id"),rs.getString("ime"), rs.getString("priimek"),rs.getString("email"),rs.getString("rojstniDatum"),rs.getString("posebnosti"),zdravnikDao.najdiOsebo(rs.getInt("idZdravnika")),rs.getBoolean("isZdravnik"));
                break;
            }
        } finally {
            conn.close();
        }
        return ret;
    }

    @Override
    public int najdiIdZdravnika(Pacient pacient) throws Exception {
        Connection conn = null;
        int idZdravnika = 0;
        try {
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from pacient where id=?");
            ps.setInt(1, pacient.getId());
            ResultSet rs = ps.executeQuery();
            idZdravnika= rs.getInt("idZdravnika");

        } finally {
            conn.close();
        }
        return idZdravnika;
    }


    @Override
    public void posodobi(Pacient pacient){
        Connection conn = null;
        log.info("Posodabljam ");
        try {
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("update pacient set ime=? , priimek=?, email=?, rojstniDatum=?, posebnosti=?  where id=?");
            ps.setString(1, pacient.getIme());
            ps.setString(2, pacient.getPriimek());
            ps.setString(3, pacient.getEmail());
            ps.setString(4, pacient.getRojstniDatum().toString());
            ps.setString(5, pacient.getPosebnosti());
            ps.setInt(6,pacient.getId());
            ps.executeUpdate();
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dodajZdravnika(Pacient pacient){
        Connection conn = null;
        log.info("Posodabljam "+ pacient.getIme()+" "+pacient.getId()+" "+pacient.getOsebniZdravnik().getIme());
        try {
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("update pacient set ime=? , priimek=?, email=?, rojstniDatum=?, posebnosti=?, idZdravnika=?,isZdravnik=?  where id=?");
            ps.setString(1, pacient.getIme());
            ps.setString(2, pacient.getPriimek());
            ps.setString(3, pacient.getEmail());
            ps.setString(4, pacient.getRojstniDatum().toString());
            ps.setString(5, pacient.getPosebnosti());
            ps.setInt(6,pacient.getOsebniZdravnik().getId());
            ps.setBoolean(7,true);
            ps.setInt(8,pacient.getId());
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void shrani(Pacient o) throws Exception {
        Connection conn = null;
        log.info("Shranjujem "+o);
        try {
            conn = baza.getConnection();
            if (najdiPacienta(o.getId()) != null) {
                PreparedStatement ps = conn.prepareStatement("update pacient set ime=? , priimek=?, email=?, rojstniDatum=?, posebnosti=?,isZdravnik=?  where id=?");
                ps.setString(1, o.getIme());
                ps.setString(2, o.getPriimek());
                ps.setString(3, o.getEmail());
                ps.setString(4, o.getRojstniDatum().toString());
                ps.setString(5, o.getPosebnosti());
                ps.setBoolean(6,o.isZdravnik());
                ps.setInt(7,o.getId());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = conn.prepareStatement("insert into pacient(ime , priimek, email, rojstniDatum, posebnosti,isZdravnik) values (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, o.getIme());
                ps.setString(2, o.getPriimek());
                ps.setString(3, o.getEmail());
                ps.setString(4, o.getRojstniDatum().toString());
                ps.setBoolean(6,o.isZdravnik());
                ps.setString(5, o.getPosebnosti());
                ps.executeUpdate();
                // get generated ID
                ResultSet res = ps.getGeneratedKeys();
                while (res.next())
                    o.setId(res.getInt(1));
                res.close();
            }
        } finally {
            conn.close();
        }
    }

    @Override
    public void izbrisi(Pacient pacient) {
        Connection conn = null;
        log.info("Shranjujem ");
        try {
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from pacient where id=?");
            ps.setInt(1, pacient.getId());
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Pacient> vrniVse() throws Exception {
        List<Pacient> ret = new ArrayList<Pacient>();
        Connection conn = null;
        log.info("Vracam vse paciente.");
        try {
            ZdravnikDao zdravnikDao = new ZdravnikDaoH2();
            conn = baza.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from pacient");
            while (rs.next()) {
                Pacient o = new Pacient(rs.getInt("id"), rs.getString("ime"), rs.getString("priimek"),rs.getString("email"),rs.getString("rojstniDatum"),rs.getString("posebnosti"),zdravnikDao.najdiOsebo(rs.getInt("idZdravnika")),rs.getBoolean("isZdravnik"));
                ret.add(o);
            }
            rs.close();
        } finally {
            conn.close();
        }
        return ret;
    }
}
