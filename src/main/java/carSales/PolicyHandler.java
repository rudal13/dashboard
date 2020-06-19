package carSales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import carSales.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler{
	
	@Autowired
    private SalesStatusRepository salesStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBought_then_CREATE (@Payload Bought bought) {
        try {
            if (bought.isMe()) {
            	SalesStatus salesStatus = new SalesStatus();
            	salesStatus.setCarId(bought.getId());
            	salesStatus.setCarName(bought.getCarName());
            	salesStatus.setCarYear(bought.getCarYear());
            	salesStatus.setCarAccidentCnt(bought.getCarAccidentCnt());
            	salesStatus.setBuyAmount(bought.getBuyAmount());
            	salesStatus.setStatus("bought");
            	salesStatusRepository.save(salesStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSold_then_UPDATE (@Payload Sold sold) {
        try {
            if (sold.isMe()) {

            	SalesStatus salesStatus = salesStatusRepository.findByCarId(sold.getId());
                salesStatus.setDrivingYear(sold.getDrivingYear());
            	salesStatus.setSalesAmount(sold.getSalesAmount());
            	salesStatus.setStatus("sold");
            	salesStatusRepository.save(salesStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenInsured_then_UPDATE (@Payload Insured insured) {
        try {
            if (insured.isMe()) {

            	SalesStatus salesStatus = salesStatusRepository.findByCarId(insured.getCarId());
            	salesStatus.setInsureRate(insured.getInsureRate());
            	salesStatus.setInsureAmount(insured.getInsureAmount());
            	salesStatus.setStatus("insured");
            	salesStatusRepository.save(salesStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
