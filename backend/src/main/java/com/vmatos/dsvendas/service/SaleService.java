package com.vmatos.dsvendas.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmatos.dsvendas.dto.SaleDTO;
import com.vmatos.dsvendas.dto.SaleSuccessDTO;
import com.vmatos.dsvendas.dto.SaleSumDTO;
import com.vmatos.dsvendas.entities.Sale;
import com.vmatos.dsvendas.repositories.SaleRepository;
import com.vmatos.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();//resolvendo problema de voltar no banco a cada vendedor
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
	
	
}
