package com.phuocvh.service.Impl;

import com.phuocvh.dto.pmsProductFlashSale.PmsProductFlashSaleRequest;
import com.phuocvh.dto.pmsProductFlashSale.PmsProductFlashSaleResponse;
import com.phuocvh.entity.PmsProduct;
import com.phuocvh.entity.PmsProductFlashSale;
import com.phuocvh.entity.PmsProductPrice;
import com.phuocvh.repository.PmsProductFlashSaleRepository;
import com.phuocvh.repository.PmsProductRepository;
import com.phuocvh.service.PmsProductFlashSaleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class PmsProductFlashSaleServiceImpl implements PmsProductFlashSaleService {
    @Autowired
    private PmsProductFlashSaleRepository pmsProductFlashSaleRepository;
    @Autowired
    private PmsProductRepository pmsProductRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ModelMapper modelMapper;

    private static PmsProductFlashSaleResponse.FlashSaleProductDetail getFlashSaleProductDetail(PmsProductFlashSale pmsProductFlashSale) {
        PmsProduct pmsProduct = pmsProductFlashSale.getPmsProduct();
        PmsProductFlashSaleResponse.FlashSaleProductDetail flashSaleProductDetail = new PmsProductFlashSaleResponse.FlashSaleProductDetail();
        flashSaleProductDetail.setId(pmsProduct.getId());
        flashSaleProductDetail.setTitle(pmsProduct.getTitle());
        flashSaleProductDetail.setName(pmsProduct.getName());
        flashSaleProductDetail.setPic(pmsProduct.getPic());
        flashSaleProductDetail.setRating(pmsProduct.getRating());
        flashSaleProductDetail.setReviews(pmsProduct.getReviewNumber());
        flashSaleProductDetail.setSold(pmsProduct.getSoldNumber());
        flashSaleProductDetail.setSalePercentage(pmsProductFlashSale.getSalePercentage());

        List<PmsProductPrice> pmsProductPrices = pmsProduct.getPmsProductPrice();
        if (pmsProductPrices.isEmpty()) throw new EntityNotFoundException("Not exist product price");
        pmsProductPrices.sort(Comparator.comparing(PmsProductPrice::getPrice));

        flashSaleProductDetail.setPrice(pmsProductPrices.get(0).getPrice());
        flashSaleProductDetail.setPriceAfterSale(pmsProductPrices.get(0).getPrice() * (1 - pmsProductFlashSale.getSalePercentage()) / 100);
        return flashSaleProductDetail;
    }

    @Override
    public void create(PmsProductFlashSaleRequest pmsProductFlashSaleRequest) {
        List<PmsProductFlashSaleRequest.FlashSaleProduct> flashSaleProducts = pmsProductFlashSaleRequest.getFlashSaleProducts();
        List<PmsProductFlashSale> pmsProductFlashSales = new ArrayList<>();
        UUID flashSaleId = UUID.randomUUID();
        for (PmsProductFlashSaleRequest.FlashSaleProduct flashSaleProduct : flashSaleProducts) {
            PmsProductFlashSale pmsProductFlashSale = new PmsProductFlashSale();
            Optional<PmsProduct> pmsProductOptional = pmsProductRepository.findById(flashSaleProduct.getId());
            if (pmsProductOptional.isEmpty())
                throw new EntityNotFoundException("Not found product with ID: " + flashSaleProduct.getId());
            else {
                pmsProductFlashSale.setPmsProduct(pmsProductOptional.get());
            }
            pmsProductFlashSale.setSalePercentage(flashSaleProduct.getSalePercentage());
            pmsProductFlashSale.setValidFrom(pmsProductFlashSaleRequest.getValidFrom());
            pmsProductFlashSale.setValidTo(pmsProductFlashSaleRequest.getValidTo());
            pmsProductFlashSale.setFlashSaleId(flashSaleId);
            pmsProductFlashSales.add(pmsProductFlashSale);
        }
        pmsProductFlashSaleRepository.saveAll(pmsProductFlashSales);
    }

    @Override
    public PmsProductFlashSale get(String id) {
        return null;
    }

    @Override
    public int update(String id, PmsProductFlashSaleRequest pmsProductFlashSaleRequest) {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public PmsProductFlashSaleResponse getCurrentFlashSaleProducts() {
        Instant now = Instant.now();
        List<PmsProductFlashSale> pmsProductFlashSales = pmsProductFlashSaleRepository.getFlashSaleProducts(now);
        if (pmsProductFlashSales.isEmpty()) return null;
        PmsProductFlashSaleResponse pmsProductFlashSaleResponse = new PmsProductFlashSaleResponse();
        pmsProductFlashSaleResponse.setValidFrom(pmsProductFlashSales.get(0).getValidFrom());
        pmsProductFlashSaleResponse.setValidTo(pmsProductFlashSales.get(0).getValidTo());
        for (PmsProductFlashSale pmsProductFlashSale : pmsProductFlashSales) {
            PmsProductFlashSaleResponse.FlashSaleProductDetail flashSaleProductDetail = getFlashSaleProductDetail(pmsProductFlashSale);
            pmsProductFlashSaleResponse.getFlashSaleProductDetailList().add(flashSaleProductDetail);
        }
        return pmsProductFlashSaleResponse;
    }
}
