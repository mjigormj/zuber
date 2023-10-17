package com.igor.zuber.repositoy;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.domain.mapper.MotoristaMapper;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class MotoristaRepositoryImpl implements MotoristaRepository {

    private final Jdbi jdbi;
    @Autowired
    MotoristaRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {

        this.jdbi = Jdbi.create(url, username, password);
    }

    @Override
    public void cadastrar(String nome,String veiculo, Long cnh) {
        try (Handle handle = jdbi.open()) {
            Update update = handle.createUpdate("INSERT INTO motoristas(nome, cnh, veiculo) VALUES (:nome, :cnh, :veiculo)")
                    .bind("nome", nome)
                    .bind("cnh", cnh)
                    .bind("veiculo", veiculo);
            update.execute();
        }
    }

    @Override
    public void apagar(Long cnh) {
        try (Handle handle = jdbi.open()) {
            Update update = handle.createUpdate("DELETE FROM motoristas WHERE CNH = :cnh")
                    .bind("cnh", cnh);
            update.execute();
        }
    }

    @Override
    public Motorista get(Long cnh) {
        try (Handle handle = jdbi.open()) {
            Query query = handle.createQuery("SELECT * FROM motoristas WHERE cnh = :cnh")
                    .bind("cnh", cnh);
            var result = query.mapToMap().findFirst().get();
            return MotoristaMapper.toDomain(result);
        }
    }

    @Override
    public void atualizar(String nome, String veiculo, Long cnh) {
        try (Handle handle = jdbi.open()) {
            Update update = handle.createUpdate("UPDATE motoristas SET nome=:nome, veiculo=:veiculo WHERE cnh = :cnh")
                    .bind("nome", nome)
                    .bind("cnh", cnh)
                    .bind("veiculo", veiculo);
            update.execute();
        }
    }
}
