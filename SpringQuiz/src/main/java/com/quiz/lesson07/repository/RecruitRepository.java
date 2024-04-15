package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	public RecruitEntity findById(int id);
	
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salery);
	
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	public List<RecruitEntity> findBySalaryBetween(int start, int end);
	
//	@Query(value = "select * from recruit where deadline >:deadline and salary >= :salary and type = :type order by salary desc", nativeQuery = true)
//	public List<RecruitEntity>  findByDeadlineAndSalaryGre
}
