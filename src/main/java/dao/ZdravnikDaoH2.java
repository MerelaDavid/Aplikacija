package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 	H2 DB
 */
public class ZdravnikDaoH2 extends ZdravnikDao {

    Logger log=LoggerFactory.getLogger(ZdravnikDaoH2.class);

    DataSource baza;

    public ZdravnikDaoH2() throws Exception {
        baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");
        kreirajTabele();
    }

    public void kreirajTabele() throws Exception {
        Connection conn = null;
        try {
            conn = baza.getConnection();
            String sql="create table if not exists oseba(id int auto_increment, ime varchar, priimek varchar, email varchar, kvotaPacientov int, stPacientov int)";
            log.info(sql);
            conn.createStatement().execute(sql);
        } finally {
            if (conn != null)
                conn.close();
        }
    }

    @Override
    public void izbrisi(Zdravnik zdravnik){
        Connection conn = null;
        log.info("Brisem");
        try {
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from oseba where id=?");
            ps.setInt(1, zdravnik.getId());
            ps.executeUpdate();
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Zdravnik najdiOsebo(int id) throws Exception {
        Zdravnik ret = null;
        Connection conn = null;
        log.info("Iscem osebo "+id);
        try {
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from oseba where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ret = new Zdravnik(rs.getInt("id"),rs.getString("ime"), rs.getString("priimek"),rs.getString("email"),rs.getInt("kvotaPacientov"), rs.getInt("stPacientov"));
                break;
            }
        } finally {
            conn.close();
        }
        return ret;
    }

    @Override
    public void posodobi(Zdravnik zdravnik){
        Connection conn = null;
        log.info("Posodobi "+zdravnik);
        try{
            conn = baza.getConnection();
            PreparedStatement ps = conn.prepareStatement("update oseba set ime=? , priimek=?,email=?,kvotaPacientov=?,stPacientov=? where id=?");
            ps.setString(1, zdravnik.getIme());
            ps.setString(2, zdravnik.getPriimek());
            ps.setString(3,zdravnik.getEmail());
            ps.setInt(4, zdravnik.getKvotaPacientov());
            ps.setInt(5,zdravnik.getStPacientov());
            ps.setInt(6, zdravnik.getId());
            ps.executeUpdate();
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void shrani(Zdravnik o) throws Exception {
        Connection conn = null;
        log.info("Shranjujem "+o);
        try {
            conn = baza.getConnection();
            if (najdiOsebo(o.getId()) != null) {
                PreparedStatement ps = conn.prepareStatement("update oseba set ime=? , priimek=?,email=?,kvotaPacientov=?,stPacientov where id=?");
                ps.setString(1, o.getIme());
                ps.setString(2, o.getPriimek());
                ps.setString(3,o.getEmail());
                ps.setInt(4, o.getKvotaPacientov());
                ps.setInt(5,o.getStPacientov());
                ps.setInt(6, o.getId());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = conn.prepareStatement("insert into oseba(ime , priimek, email, kvotaPacientov, stPacientov ) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, o.getIme());
                ps.setString(2, o.getPriimek());
                ps.setString(3,o.getEmail());
                ps.setInt(4,o.getKvotaPacientov());
                ps.setInt(5,o.getStPacientov());
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
    public List<Zdravnik> vrniVse() throws Exception {
        List<Zdravnik> ret = new ArrayList<Zdravnik>();
        Connection conn = null;
        log.info("Vraèam vse osebe.");
        try {
            conn = baza.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from oseba");
            while (rs.next()) {
                Zdravnik o = new Zdravnik(rs.getInt("id"), rs.getString("ime"), rs.getString("priimek"),rs.getString("email"),rs.getInt("kvotaPacientov"), rs.getInt("stPacientov"));
                ret.add(o);
            }
            rs.close();
        } finally {
            conn.close();
        }
        return ret;
    }
}