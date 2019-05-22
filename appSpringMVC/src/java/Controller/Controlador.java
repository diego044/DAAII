package Controller;

import Entidad.Persona;
import Services.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
    int id;
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql = "select * from persona";
        List datos=jdbcTemplate.queryForList(sql);
        mav.addObject("Lista",datos);
        mav.setViewName("index");
        return mav;
        
    }
    
    //Muestra el registro recien agregado en el index
    @RequestMapping(value="agregar.htm", method=RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Persona());
        mav.setViewName("agregar");
        return mav;
        
    }
    //Agregar nuevo registro y te manda al index
    @RequestMapping(value="agregar.htm", method=RequestMethod.POST)
    public ModelAndView Agregar(Persona p){
        String sql="insert into persona(id,nombre,apellido,correo,direccion)values(null,?,?,?,?)";
        this.jdbcTemplate.update(sql,p.getNombre(),p.getApellido(),p.getCorreo(),p.getDireccion());
        return new ModelAndView("redirect:/index.htm");
        
    }
    
    //muestra los datos del registro seleccionado al editar.jsp mediante el id 
    @RequestMapping(value="editar.htm", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from persona where id="+id;
        List datos =this.jdbcTemplate.queryForList(sql);
        mav.addObject("Lista",datos);
        mav.setViewName("editar");
        return mav;
    }
    
    //edita el registro y te redirecciona al index
    @RequestMapping(value="editar.htm", method=RequestMethod.POST)
    public ModelAndView Editar(Persona p){
        String sql ="update persona set nombre=?, apellido=?, correo=?, direccion=? where id="+id;
        this.jdbcTemplate.update(sql, p.getNombre(), p.getApellido(), p.getCorreo(), p.getDireccion());
        return new ModelAndView("redirect:/index.htm");
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
    id=Integer.parseInt(request.getParameter("id"));
    String sql="delete from persona where id="+id;
    this.jdbcTemplate.update(sql);
    return new ModelAndView("redirect:/index.htm");  
    
    }
   
}
