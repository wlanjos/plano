package br.com.ekan.plano.repository;

import br.com.ekan.plano.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Usuario findByLogin(String usuario);
}

