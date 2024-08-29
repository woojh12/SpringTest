package com.dnjh.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dnjh.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer>{
	// id = 8인 행 조회
	public Recruit findById(int id);
	
	// 복합 조건 조회1
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// 복합 조건 조회2
	public List<Recruit> findByTypeOrSalary(String type, int salary);
	
	// 정렬 제한 조건
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 범위 조회
	public List<Recruit> findByRegionAndSalaryBetweenOrderByIdAsc(String region, int start, int end);
	
	// Native query
	@Query(value="SELECT * FROM `recruit` WHERE `deadline` >=:deadline And `salary` >=:salary And `type` >=:type ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectBydeadLine(@Param("deadline") String deadLine, @Param("salary") int salary, @Param("type") String type);
}
