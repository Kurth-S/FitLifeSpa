package fit_life_Spa.cl.Usuario.Controller;

import fit_life_Spa.cl.Usuario.model.UsuarioModel;
import fit_life_Spa.cl.Usuario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<UsuarioModel>> listar(){
        List<UsuarioModel> usuarioModels = usuarioService.findAll();
        if (usuarioModels.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioModels);
    }
    @PostMapping
    public ResponseEntity<UsuarioModel> guardar(@RequestBody UsuarioModel usuarioModel){
        UsuarioModel usuarioNuevo = usuarioService.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscar(@PathVariable Integer id){
        try{
            UsuarioModel usuarioModel = usuarioService.findById(id);
            return ResponseEntity.ok(usuarioModel);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        }
        @PutMapping("/{id}")
        public ResponseEntity<UsuarioModel> actualizar (@PathVariable Integer id, @RequestBody UsuarioModel usuarioModel){
            try{
                UsuarioModel usu = usuarioService.findById(id);
                usu.setId(id);
                usu.setRun(usuarioModel.getRun());
                usu.setNombre(usuarioModel.getNombre());
                usu.setContraseña(usuarioModel.getContraseña());

                usuarioService.save(usu);
                return ResponseEntity.ok(usuarioModel);
            }catch (Exception e){
                return ResponseEntity.notFound().build();
    
            }
            }
            @DeleteMapping("/{id}")
            public ResponseEntity<?> eliminar(@PathVariable Long id){
                try{
                    usuarioService.deleteById(id);
                    return ResponseEntity.noContent().build();
                }catch (Exception e){
                    return ResponseEntity.notFound().build();
                }
                
                }
            }

