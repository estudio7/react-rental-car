package com.DH.PI.repository;

import com.DH.PI.model.ProdutoModel;
import com.DH.PI.model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    List<ProdutoModel> findByNomeProdutoIgnoreCase(String nomeProduto);


    List<ProdutoModel> findByCidadeNomeCidadeIgnoreCaseOrCategoriaCategoriaIgnoreCase(String cidade, String categoria);
    @Query("SELECT p FROM ProdutoModel p JOIN ReservaModel r JOIN p.cidade c " +
            "WHERE c.nomeCidade = :cidade AND r.dataInicioReserva >= :dataInicial AND r.dataFinalReserva <= :dataFinal")
    List<ProdutoModel> findByCidadeAndDatas(@Param("cidade") String cidade,
                                            @Param("dataInicial") Date dataInicial,
                                            @Param("dataFinal") Date dataFinal);
//    @Query("SELECT p FROM ProdutoModel p JOIN p.cidade c JOIN p.reserva r " +
//            "WHERE c.nomeCidade = :cidade AND r.dataInicioReserva >= :dataInicial AND r.dataFinalReserva <= :dataFinal")
//    List<ProdutoModel> findByCidadeAndDatas(@Param("cidade") String cidade,
//                                            @Param("dataInicial") Date dataInicial,
//                                            @Param("dataFinal") Date dataFinal);
//@Query("SELECT p FROM ProdutoModel p   WHERE p.reserva.produto.idProduto = :idProduto AND p.reserva.dataInicioReserva BETWEEN :dataInicial AND :dataFinal")
//List<ReservaModel> findByConsulta(@Param("idProduto") Long idProduto,
//                                         @Param("dataInicial") Date dataInicial,
//                                         @Param("dataFinal") Date dataFinal);
//    @Query("SELECT p FROM ProdutoModel p  WHERE p.reserva.produto.idProduto = :idProduto AND p.reserva.dataFinalReserva BETWEEN :dataInicial AND :dataFinal")
//    List<ReservaModel> findByConsulta1(@Param("idProduto") Long idProduto,
//                                              @Param("dataInicial") Date dataInicial,
//                                              @Param("dataFinal") Date dataFinal);

}
