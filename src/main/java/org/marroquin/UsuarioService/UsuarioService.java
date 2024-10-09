package org.marroquin.UsuarioService;

import org.marroquin.UsuarioRepository.UsuarioRepository;
import org.marroquin.modelo.Usuario;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id);
    }
}
