package carSales;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SalesStatusRepository extends PagingAndSortingRepository<SalesStatus, Long>{
	
	SalesStatus findByCarId(Long carId);
    
}