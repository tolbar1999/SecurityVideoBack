package com.tolbar.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolbar.modelo.Video;
import com.tolbar.repository.IVideoRepository;
import com.tolbar.service.IVideoService;

@Service
public class VideoServiceImpl implements IVideoService {

	@Autowired
	private IVideoRepository repositorioVideo;

	
	@Override
	public List<Video> listarTodos() {
		return repositorioVideo.findAll();
	}

	@Override
	public Video listarPorId(int id) {
		return repositorioVideo.findOne(id);
	}

	@Override
	public void registrar(Video entidad) {
		repositorioVideo.save(entidad);
	}

	@Override
	public void actualizar(Video entidad) {
		repositorioVideo.save(entidad);
	}

	@Override
	public void eliminar(int id) {
		repositorioVideo.delete(id);
	}

	@Override
	public Video buscarClave(String clave) {

		return repositorioVideo.buscarClave(clave);
	}
}
