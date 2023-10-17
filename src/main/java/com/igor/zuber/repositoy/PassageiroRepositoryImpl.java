package com.igor.zuber.repositoy;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.domain.Passageiro;
import com.igor.zuber.domain.mapper.MotoristaMapper;
import com.igor.zuber.domain.mapper.PassageiroMapper;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class PassageiroRepositoryImpl implements PassageiroRepository {

    private final Jdbi jdbi;
    @Autowired
    PassageiroRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {

        this.jdbi = Jdbi.create(url, username, password);
    }

    @Override
    public void cadastrar(String nome, String email, String dtNascimento, String cpf) {
        try (Handle handle = jdbi.open()) {
            Update update = handle.createUpdate("INSERT INTO passageiros(nome, email, DT_NASCIMENTO, cpf) VALUES (:nome, :email, :dtNascimento, :cpf)")
                    .bind("nome", nome)
                    .bind("email", email)
                    .bind("dtNascimento", dtNascimento)
                    .bind("cpf", cpf);
            update.execute();
        }
    }

    @Override
    public void apagar(String email) {
        try (Handle handle = jdbi.open()) {
            Update update = handle.createUpdate("DELETE FROM passageiros WHERE email = :email")
                    .bind("email", email);
            update.execute();
        }
    }

    @Override
    public Passageiro get(String email) {
        try (Handle handle = jdbi.open()) {
            Query query = handle.createQuery("SELECT * FROM passageiros WHERE email = :email")
                    .bind("email", email);
            var result = query.mapToMap().findFirst().get();
            return PassageiroMapper.toDomain(result);
        }
    }

    @Override
    public void atualizar(String nome, String email, String dtNascimento) {
        try (Handle handle = jdbi.open()) {
            Update update = handle.createUpdate("UPDATE passageiros SET nome=:nome, dt_nascimento=:dtNascimento WHERE email = :email")
                    .bind("nome", nome)
                    .bind("email", email)
                    .bind("dtNascimento", dtNascimento);
            update.execute();
        }
    }
}
