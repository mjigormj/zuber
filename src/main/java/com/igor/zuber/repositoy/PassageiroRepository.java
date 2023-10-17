package com.igor.zuber.repositoy;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.domain.Passageiro;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository {
    @SqlUpdate
    void cadastrar(String nome, String email, String dtNascimento, String cpf);

    @SqlUpdate
    void apagar(String email);

    @SqlQuery
    Passageiro get(String email);

    @SqlUpdate
    void atualizar(String nome, String email, String dtNascimento);

}
