package com.mentoria.integraInventories.gateways.outputs.mongodb.repositories;


import com.mentoria.integraInventories.gateways.outputs.mongodb.documents.SellerDocument;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SellersRepository extends PagingAndSortingRepository<SellerDocument, String> {}
