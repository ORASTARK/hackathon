package com.bosch.s4t.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bosch.s4t.hackathon.entity.CurrentEntity;

@Repository
public interface CurrentRepository extends JpaRepository<CurrentEntity, Long> {
/*
	void saveAll(List<CurrentEntity> currentEntityList);
	
	
	//public List<MasterEntity> findAllByIMac();
	
	@Query(
			value = "select i_num from master m where m.i_mac like ?1",
			nativeQuery =true)
	public List<MasterEntity> findINumByIMac (String iMac);

	List<PurchaseRequisitionItemEntity> findAllByOrderByIdAsc(Pageable page);
	
	//List<PurchaseRequisitionItemEntity> findAllByOrderByIdAsc(Pageable page);
	
	
	@Query(value = "select count(*) from purchase_requisition_item pri where pri.id >= ?1", nativeQuery = true)
    public Long findActualRecords(Long startCaseNum);
	
	@Query(value = "select * from purchase_requisition_item pri where pri.id >= ?1 order by pri.id asc limit ?2", nativeQuery = true)
    public List<PurchaseRequisitionItemEntity> findRequiredRecords(Long startCaseNum, Long requiredNum);

	
	@Query(
			value = "select * from purchase_requisition_result prResult where prResult.id>?1 limit ?2",
			nativeQuery =true)
	List<PurchaseRequisitionItemEntity> getPagePRItemRecord (Long start, Long limit);
	
	List<PurchaseReqItemData> findByPlant(String plant);
	
	@Query("select p from PercentageConfiguration p where p.plant=?1 and (p.salesOrganisation=?2 or p.salesOrganisation is null or p.salesOrganisation='') and (p.materialNo=?3 or p.materialNo is null or p.materialNo='')and (p.profitCenter=?4 or p.profitCenter is null or p.profitCenter='') and (p.productHierarchy=?5 or p.productHierarchy is null or p.productHierarchy='')and (p.overHeadGroup=?6 or p.overHeadGroup is null or p.overHeadGroup='') and p.validFrom <= ?7 and p.validTo >= ?8")
	List<PurchaseReqItemData> getPerConfigByAtrributes(String plant, String salesOrg, String meterialNo, String profitCenter, String prodHierarchy, String overheadGroup, LocalDate validFrom, LocalDate validTo); 
	
	@Query("select p from PercentageConfiguration p where p.plant=?1 and p.validFrom <= ?2 and p.validTo >= ?3")
	List<PurchaseReqItemData> getPerConfigByPlant(String plant, LocalDate validFrom, LocalDate validTo);
*/
	
}
