package com.mentoria.integraInventories.gateways.outputs.mongodb.repositories;


import com.mentoria.integraInventories.gateways.outputs.mongodb.documents.SellerDocument;
import org.ff4j.aop.Flip;
import org.springframework.data.repository.PagingAndSortingRepository;

@Flip(name = "find-seller-on-http", alterBean = "sellersDataGatewayHttpImpl")
public interface SellersRepository extends PagingAndSortingRepository<SellerDocument, String> {}
