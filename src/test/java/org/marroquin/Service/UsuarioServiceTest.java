package org.marroquin.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marroquin.UsuarioRepository.UsuarioRepository;
import org.marroquin.UsuarioService.UsuarioService;
import org.marroquin.modelo.Usuario;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks antes de cada test
    }

    @Test
    public void testObtenerUsuario() {

        //Simulamos un objeto en el repositorrio, que vamos a utilizar en el servicio
        Long id = 1L;
        Usuario usuarioMock = new Usuario(id, "Juan");
        when(usuarioRepository.findById(id)).thenReturn(usuarioMock);  // Devuelve un Usuario directamente

        // Act
        Usuario resultado = usuarioService.obtenerUsuario(1l);

        // Assert
        assertNotNull(resultado);  // Verifica que el resultado no sea null
        assertEquals("Juan", resultado.getNombre());  // Verifica que el nombre sea "Juan"
        verify(usuarioRepository).findById(id);  // Verifica que se llamó al método
    }
}
