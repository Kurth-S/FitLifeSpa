package fit_life_Spa.cl.Usuario.Service;

import fit_life_Spa.cl.Usuario.model.UsuarioModel;
import fit_life_Spa.cl.Usuario.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> findAll(){
        return usuarioRepository.findAll();
    }
    public UsuarioModel findById(long id){
        return usuarioRepository.findById(id).get();
    }
    public UsuarioModel save(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }
    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

}
