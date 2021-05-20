package com.vmatos.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmatos.dsvendas.entities.Sale;
import com.vmatos.dsvendas.dto.SaleSuccessDTO;
import com.vmatos.dsvendas.dto.SaleSumDTO;


public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.vmatos.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale As obj GROUP BY obj.seller")
	//jpql, obj = apelido para cada objeto sale que esta buscando no banco
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.vmatos.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " 
			+ " FROM Sale As obj GROUP BY obj.seller")
	//jpql, obj = apelido para cada objeto sale que esta buscando no banco
	List<SaleSuccessDTO> successGroupedBySeller();

}
