package br.edu.imepac.repository;

import br.edu.imepac.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Passamos a Entidade (Cliente) e o tipo da Chave Primária (Long)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // O JpaRepository já nos dá todos os métodos básicos (save, findAll, findById, deleteById).
    // Não precisamos escrever mais nada aqui por enquanto.
}