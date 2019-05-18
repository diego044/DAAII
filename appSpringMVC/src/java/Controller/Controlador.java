package Controller;

import Entidad.Persona;
import Services.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(value="agregar.htm", method=RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Persona());
        mav.setViewName("agregar");
        return mav;
        
    }
    
    
    @RequestMapping(value="agregar.htm", method=RequestMethod.POST)
    public ModelAndView Agregar(Persona p){
        String sql="insert into persona(id,nombre,apellido,correo,direccion)values(null,?,?,?,?)";
        this.jdbcTemplate.update(sql,p.getNombre(),p.getApellido(),p.getCorreo(),p.getDireccion());
        
        return new ModelAndView("redirect:/index.htm");
        
        
    }
}
