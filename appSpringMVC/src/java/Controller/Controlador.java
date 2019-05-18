package Controller;

import Services.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {
    //Crear método listar:
    Conexion cnn = new Conexion();
    JdbcTemplate jdbcTemplate= new JdbcTemplate(cnn.Conectar());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql = "select * from persona";
        List datos=jdbcTemplate.queryForList(sql);
        mav.addObject("Lista",datos);
        mav.setViewName("index");
        return mav;
        
        
    }
    
    
}
