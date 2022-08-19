package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.model.SampleHair;

public interface SampleHairRepository extends JpaRepository<SampleHair, Long>{
	@Query("SELECT s FROM SampleHair s ORDER BY s.countView DESC")
	List<SampleHair> findByTop();
}
