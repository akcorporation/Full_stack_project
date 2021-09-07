package com.newProject.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.newProject.models.Offer;
import com.newProject.repositories.OfferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    OfferRepository offerRepository;

    public String saveOfferDetails(long catId,Date offerSDate,Date offerEDate, int offerVal) {

        Offer offerdetail = new Offer();
        offerdetail.setCatId(catId);
        offerdetail.setOfferSDate(offerSDate);
        offerdetail.setOfferEDate(offerEDate);
        offerdetail.setofferVal(offerVal);
        try {
            offerRepository.save(offerdetail);
            return "Data Saved Successfully ........";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getAllOffer(){

        String result = "";
        List<Offer> offerDetails = offerRepository.getAllOffers();
        if (offerDetails.size()==0) {
            return "No Data Found ......";
        } else {
            for(Offer offerDetail : offerDetails) {
                result = result + "Id :"+offerDetail.getOfferId() +" on Category :"+offerDetail.getCatId()+" Offer Detail :"+offerDetail.getofferVal()+" % Discount"+"  Offer Start Date :" 
                + offerDetail.getOfferSDate() +" Offer End Date :"+ offerDetail.getOfferEDate() +"\n";
            }
            return result;
        }
    }

    public String updateOfferDetails(Long Id,Long catId,Date offerSDate,Date offerEDate, int offerVal) {

        Optional<Offer> optional = offerRepository.findById(Id);
        if(optional.isPresent()){
            Offer offerdetail = optional.get();
            offerdetail.setCatId(catId);
            offerdetail.setOfferSDate(offerSDate);
            offerdetail.setOfferEDate(offerEDate);
            offerdetail.setofferVal(offerVal);
            try {
                offerRepository.save(offerdetail);
                return "Data Updated Successfully ........";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        else{
            return "No Data Found with Id :"+Id;
        }    
    }

    public String deleteOfferById(Long Id){
        Optional<Offer> optional = offerRepository.check(Id);
        if(optional.isPresent()){
            offerRepository.deleteById(Id);
            return "Offer Deleted Successfully .......";
        }
        else{
            return "No Data Found with Id : "+Id;
        }
        
    }
    
}
