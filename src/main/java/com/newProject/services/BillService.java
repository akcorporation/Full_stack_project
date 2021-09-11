package com.newProject.services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.newProject.repositories.BillRepository;
import com.newProject.repositories.UserRepository;
import com.newProject.repositories.CartRepository;
import com.newProject.repositories.OfferRepository;
import com.newProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newProject.models.Bill;
import com.newProject.models.Cart;
import com.newProject.models.Offer;
import com.newProject.models.Product;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OfferRepository offerRepository;

    public String calculateBill(Long userId) {
        List<Cart> cartdetails = new ArrayList<>();
        List<Bill> resultList = new ArrayList<>();
        cartdetails = cartRepository.getCartDetailById(userId);
        if(cartdetails == null){
            return "Fail";
        }
        else{
            for(Cart cartdetail : cartdetails){
                Bill bill = new Bill();
                float totalAmt = 0;
                Optional<Product> productDetail = productRepository.findById(cartdetail.getPrdId());
                Product product = new Product();
                product = productDetail.get();
                Long prdCost = product.getPrdRate();
                Long prdCatId = (long) product.getPrdCatId();
                Optional<Offer> offerDetail = offerRepository.getOfferDetailsByCatid(prdCatId);
                Offer offer = new Offer();
                offer = offerDetail.get();
                int prdOffer = 100 - offer.getofferVal();
                totalAmt = totalAmt + (cartdetail.getPrdQuantity()*prdCost*prdOffer/100);
                bill.setUserId(userId);
                bill.setBillAmt(totalAmt);
                bill.setBillProductId(cartdetail.getPrdId());
                bill.setBillProductQuan(cartdetail.getPrdQuantity());
                bill.setBillDate(java.time.LocalDate.now());
                bill.setIsCancelled(false);
                resultList.add(bill);
            }
            billRepository.saveAll(resultList);
            return "Success";
        }
        
    }

    @Transactional
    public void deleteCartDetail(Long userId) {
        cartRepository.deleteCartByUserId(userId);
    }

    public String returnProductById(Long prdId) {
        LocalDate curDate = LocalDate.now();
        Optional<Bill> optional = billRepository.getByPrdId(prdId);
        if(optional.isEmpty()){
            return "Problem";
        }
        else{
            LocalDate billDate = optional.get().getBillDate();
            if(billDate.plusDays(7).isAfter(curDate)){
                return "Fail";
            }
            else{
                Bill bill = new Bill();
                bill = optional.get();
                bill.setIsCancelled(true);
                return "Success";
            }
        }
        
    }
    
}
