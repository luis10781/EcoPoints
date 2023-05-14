package pe.isil.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.isil.proyecto.model.Usuario;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
   boolean existsByEmail(String email);
   Optional<Usuario> findByEmail(String email);
}
