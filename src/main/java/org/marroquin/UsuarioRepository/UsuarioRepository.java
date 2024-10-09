package org.marroquin.UsuarioRepository;

import org.marroquin.modelo.Usuario;

public interface UsuarioRepository {
    Usuario findById(Long id);
}

