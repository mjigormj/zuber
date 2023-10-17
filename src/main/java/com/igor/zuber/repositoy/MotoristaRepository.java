package com.igor.zuber.repositoy;

import com.igor.zuber.domain.Motorista;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository {

    @SqlUpdate
    void cadastrar(String nome,String veiculo, Long cnh);

    @SqlUpdate
    void apagar(Long cnh);

    @SqlQuery
    Motorista get(Long cnh);

    @SqlUpdate
    void atualizar(String nome, String veiculo, Long cnh);
}
