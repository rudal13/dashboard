package carSales;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name="SalesStatus_table")
public class SalesStatus {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long carId;
    private String carName;
    private Integer carYear;
    private Integer carAccidentCnt;
    private Integer buyAmount;
    private Integer drivingYear;
    private Integer salesAmount;
    private Integer insureRate;
    private Integer insureAmount;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }
    public Integer getCarAccidentCnt() {
        return carAccidentCnt;
    }

    public void setCarAccidentCnt(Integer carAccidentCnt) {
        this.carAccidentCnt = carAccidentCnt;
    }
    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }
    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Integer getDrivingYear() {
        return drivingYear;
    }

    public void setDrivingYear(Integer drivingYear) {
        this.drivingYear = drivingYear;
    }
    public Integer getInsureRate() {
        return insureRate;
    }

    public void setInsureRate(Integer insureRate) {
        this.insureRate = insureRate;
    }
    public Integer getInsureAmount() {
        return insureAmount;
    }

    public void setInsureAmount(Integer insureAmount) {
        this.insureAmount = insureAmount;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
