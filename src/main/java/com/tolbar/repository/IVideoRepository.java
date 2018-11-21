package com.tolbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tolbar.modelo.Video;

@Repository
public interface IVideoRepository extends JpaRepository<Video, Integer>{

	@Query("from Video v where v.clave = :clave")
	public Video buscarClave(@Param("clave") String clave);
}
